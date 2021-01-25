package com.jobportal.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class RecoveryEmail {
	
	public static void sendRecoveryMail(String recipient, String securityCode) throws Exception {
		
		System.out.println("attempting to send recovery email");
		
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		String myEmailAccount = "burntoutrecovery@gmail.com";
		String password = "burningup21";
		
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myEmailAccount, password);
			}
		});
		
		Message message = prepareMessage(session, myEmailAccount, recipient, securityCode);
		
		Transport.send(message);
		System.out.println("Message successfully sent");
		
	}

	private static Message prepareMessage(Session session, String myEmailAccount, String recipient, String securityCode) {
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myEmailAccount));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			message.setSubject("Recover Your BurntOut Account");
			String htmlContent = "<h1>Use the provided security code to reset your password</h1><br/><h3>"+securityCode+"</h3><br/><a href='http://localhost:4200/passwordreset'>Password Reset</a>";
			message.setContent(htmlContent, "text/html");
			return message;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
