package com.family.service;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
import org.springframework.stereotype.Service;

import com.family.model.Family;

@Service
public class PdfService {

    public File createEncryptedPdf(Family family) throws IOException {

        // PDF file name
        String fileName = "Family_" + family.getId() + ".pdf";

        File pdfFile = new File(System.getProperty("java.io.tmpdir"), fileName);

        try (PDDocument document = new PDDocument()) {

            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream =
                    new PDPageContentStream(document, page);

            contentStream.beginText();
            contentStream.setFont(
                    new PDType1Font(Standard14Fonts.FontName.HELVETICA),
                    12
            );
            contentStream.setLeading(18);
            contentStream.newLineAtOffset(50, 700);

            contentStream.showText("Family Details");
            contentStream.newLine();

            contentStream.showText("-------------------------");
            contentStream.newLine();

            contentStream.showText(
                    "Name       : " + family.getName());

            contentStream.newLine();

            contentStream.showText(
                    "Relation   : " + family.getRelation());

            contentStream.newLine();

            contentStream.showText(
                    "Phone      : " + family.getPhone());

            contentStream.newLine();

            contentStream.showText(
                    "Email      : " + family.getEmail());

            contentStream.endText();

            contentStream.close();


            /*
             * PDF Password Protection
             *
             * User password:
             * Required to open the PDF
             *
             * Owner password:
             * Allows changing PDF permissions
             */

            AccessPermission permission =
                    new AccessPermission();

            String pdfPassword =
                    generatePassword(family);


            StandardProtectionPolicy policy =
                    new StandardProtectionPolicy(
                            "OWNER_PASSWORD_123",
                            pdfPassword,
                            permission);


            policy.setEncryptionKeyLength(256);

            document.protect(policy);


            PDDocumentInformation info =
                    document.getDocumentInformation();

            info.setTitle("Encrypted Family Details");


            document.save(pdfFile);
        }

        return pdfFile;
    }


    /**
     * Generates password for each person.
     *
     * Example:
     * Phone number last 4 digits
     *
     * For phone: 9876543210
     * Password: 3210
     */
    private String generatePassword(Family family) {

        int randomNumber = 1000 + 
                (int)(Math.random() * 9000);

        return String.valueOf(randomNumber);
    }
}
