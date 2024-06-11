package com.ucsal.notification.channels;

import java.util.Properties;

public class Configurador {

	public static Properties getEmailProperties(String host, String port, String auth, String starttls) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", auth);
        properties.put("mail.smtp.starttls.enable", starttls);
        return properties;
    }
}