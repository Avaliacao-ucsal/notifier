package com.ucsal.notification.channels;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.ucsal.notification.annotations.NoticationChannelType;
import com.ucsal.notification.interfaces.NotificationChannel;
import com.ucsal.notification.models.Notification;

@NoticationChannelType("email")
public class EmailNotification implements NotificationChannel{
	  private String host;
	    private String user;
	    private String password;

	    public EmailNotification(String host, String user, String password) {
	        this.host = host;
	        this.user = user;
	        this.password = password;
	    }

	    @Override
	    public void send(Notification notification) {
	        Properties properties = new Properties();
	        properties.put("mail.smtp.host", this.host);
	        properties.put("mail.smtp.port", "2525");
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.starttls.enable", "true");

	        Authenticator authenticator = new Authenticator() {
	            @Override
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(user, password);
	            }
	        };

	        Session session = Session.getInstance(properties, authenticator);

	        try {
	            MimeMessage message = new MimeMessage(session);
	            message.setFrom("atilamacedo001@gmail.com");
	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(notification.getRecipient()));
	            message.setSubject(notification.getSubject());
	            message.setText(notification.getMessage());
	            Transport.send(message);
	            System.out.println("Sent email successfully...");
	        } catch (MessagingException mex) {
	            mex.printStackTrace();
	        }
	    }
	
	
}
