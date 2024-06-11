package com.ucsal.notification.channels;

import java.util.Properties;

public class ConfigEmailNotification {
	private String host;
	private String port;
	private String auth;
	private String starttls;
	private final String user;
	private final String apiToken;
	
	
	public ConfigEmailNotification(String host, String port, String auth, String starttls, String user, String apiToken) {
        this.host = host;
        this.port = port;
        this.auth = auth;
        this.starttls = starttls;
        this.user = user;
        this.apiToken = apiToken;
    }
	
	public Properties getProperties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", this.host);
        properties.put("mail.smtp.port", this.port);
        properties.put("mail.smtp.auth", this.auth);
        properties.put("mail.smtp.starttls.enable", this.starttls);
        return properties;
    }
	 public String getUser() {
	        return user;
	    }

	    public String getApiToken() {
	        return apiToken;
	    }
	}