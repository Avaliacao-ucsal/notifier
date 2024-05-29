package com.ucsal.channels;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.ucsal.interfaces.NotificationChannel;
import com.ucsal.notification.models.Notification;

public class EmailNotification implements NotificationChannel{
	private String from;
	private String host;
	
	public EmailNotification(String from, String host) {
		this.from = from;
		this.host = host;
	}

	@Override
	public void send(Notification notification) {
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", this.host);
		
		Session session = Session.getDefaultInstance(properties);
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress());
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(notification.getRecipient()));
            message.setSubject(notification.getSubject());
            message.setText(notification.getMessage());
            Transport.send(message);
            System.out.println("Sent email successfully...");
		}catch(MessagingException mex) {
			mex.printStackTrace();
		}
	}
	
	
}
