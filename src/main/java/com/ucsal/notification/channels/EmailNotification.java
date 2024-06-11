package com.ucsal.notification.channels;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.ucsal.notification.interfaces.NotificationChannel;
import com.ucsal.notification.models.Notification;

public class EmailNotification implements NotificationChannel {
    private final ConfigEmailNotification config;

    public EmailNotification(ConfigEmailNotification config) {
        this.config = config;
    }

    @Override
    public void send(Notification notification) {
        Properties properties = config.getProperties();

        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(config.getUser(), config.getApiToken());
            }
        };

        Session session = Session.getInstance(properties, authenticator);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(config.getUser()));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(notification.getRecipient()));
            message.setSubject(notification.getSubject());
            message.setText(notification.getMessage());
            Transport.send(message);
            System.out.println("Email enviado com sucesso!");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}