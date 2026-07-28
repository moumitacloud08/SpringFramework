package com.family.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.family.model.Family;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender mailSender;
	

    public void sendEmail(String to, String name) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(to);
        message.setSubject("Family Notification");
        message.setText("Hello " + name +
                ",\n\nThis email was sent using Spring Batch.\n\nThank you!");

        mailSender.send(message);
    }
    
    public void sendEmail(Family family) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(family.getEmail());
        message.setSubject("Family Notification");

        message.setText(
                "Hello " + family.getName() + ",\n\n" +
                "Relation : " + family.getRelation() + "\n" +
                "Phone    : " + family.getPhone() + "\n\n" +
                "This email was sent using Spring Batch.");

        mailSender.send(message);

        System.out.println("Mail Sent to : " + family.getEmail());
    }
}
