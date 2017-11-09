package utils;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.testng.annotations.Test;

public class SendEmail {
	Properties pro = new Properties();
	public void sendEmailTo(final String senderEmail ,final String senderPassword , String toEmail , String emailSubject ,String emailBody , String attachmentPath){
		
		pro.put("mail.smtp.host", "smtp.gmail.com");
		
		// set the port of socket factory 
				pro.put("mail.smtp.socketFactory.port", "465");
				
		// set socket factory
				pro.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
				
		// set the authentication to true
				pro.put("mail.smtp.auth", "true");
				
		// set the port of SMTP server
				pro.put("mail.smtp.port", "465");
				
				// This will handle the complete authentication
				Session session = Session.getInstance(pro,
		 
						new javax.mail.Authenticator() {
		 
							protected PasswordAuthentication getPasswordAuthentication() {
		 
							return new PasswordAuthentication(senderEmail, senderPassword);
		 
							}
		 
						});
				

				try {
		 
					// Create object of MimeMessage class
					Message message = new MimeMessage(session);
		 
					// Set the from address
					message.setFrom(new InternetAddress(senderEmail));
		 
					// Set the recipient address
					message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(toEmail));
		            
		                        // Add the subject link
					message.setSubject(emailSubject);
		 
					// Create object to add multimedia type content
					BodyPart messageBodyPart1 = new MimeBodyPart();
		 
					// Set the body of email
					messageBodyPart1.setText(emailBody);
					// Create another object to add another content
					MimeBodyPart messageBodyPart2 = new MimeBodyPart();
		 
					// Mention the file which you want to send
					String filename = "attachmentPath";
		 
					// Create data source and pass the filename
					DataSource source = new FileDataSource(filename);
		 
					// set the handler
					messageBodyPart2.setDataHandler(new DataHandler(source));
		 
					// set the file
					messageBodyPart2.setFileName(filename);
		 
					// Create object of MimeMultipart class
					Multipart multipart = new MimeMultipart();
		 
					// add body part 1
					multipart.addBodyPart(messageBodyPart2);
		 
					// add body part 2
					multipart.addBodyPart(messageBodyPart1);
		 
					// set the content
					message.setContent(multipart);
		 
					// finally send the email
					Transport.send(message);
		 
					System.out.println("=====Email Sent=====");
		 
				} catch (MessagingException e) {
		 
					throw new RuntimeException(e);
		 
				}
		 		
	}
}
