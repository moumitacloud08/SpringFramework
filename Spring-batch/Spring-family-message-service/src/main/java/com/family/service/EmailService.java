package com.family.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.family.model.Family;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private PdfService pdfService;

	public void sendEmail(String to, String name) {

		SimpleMailMessage message = new SimpleMailMessage();

		message.setTo(to);
		message.setSubject("Family Notification");
		message.setText("Hello " + name + ",\n\nThis email was sent using Spring Batch.\n\nThank you!");

		mailSender.send(message);
	}

	public void sendEmail(Family family) {

		SimpleMailMessage message = new SimpleMailMessage();

		message.setTo(family.getEmail());
		message.setSubject("Family Notification");

		message.setText("Hello " + family.getName() + ",\n\n" + "Relation : " + family.getRelation() + "\n"
				+ "Phone    : " + family.getPhone() + "\n\n" + "This email was sent using Spring Batch.");

		mailSender.send(message);

		System.out.println("Mail Sent to : " + family.getEmail());
	}

	public void sendEmail(Family family,boolean fileAttached) throws Exception {

		// Create encrypted PDF
		File encryptedPdf = pdfService.createEncryptedPdf(family);

		MimeMessage message = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setTo(family.getEmail());

		helper.setSubject("Encrypted Family Details");

		helper.setText("""
				Hello %s,

				Please find your encrypted family details attached.

				The PDF password is the last 4 digits of your registered phone number.

				Regards,
				Family Service
				""".formatted(family.getName()));

		// Attach encrypted PDF
		FileSystemResource fileResource = new FileSystemResource(encryptedPdf);

		helper.addAttachment(encryptedPdf.getName(), fileResource);

		mailSender.send(message);

		System.out.println("Email sent successfully to : " + family.getEmail());

		// Optional cleanup
		if (encryptedPdf.exists()) {
			encryptedPdf.delete();
		}
	}
}
