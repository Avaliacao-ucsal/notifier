package com.ucsal.notification.channels;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.ucsal.notification.annotations.NoticationChannelType;
import com.ucsal.notification.interfaces.NotificationChannel;
import com.ucsal.notification.models.Notification;

@NoticationChannelType("whatsapp")
public class WhatsAppNotification implements NotificationChannel{
	 public static final String ACCOUNT_SID = "SID";
	 public static final String AUTH_TOKEN = "TOKEN";
	 
	 static {
		 Twilio.init(AUTH_TOKEN, ACCOUNT_SID);
	 }
	 
	@Override
	public void send(Notification notification) {
		Message message = Message.creator(new PhoneNumber("whatsapp:+yournumber"),new PhoneNumber("whatsapp:+"+notification.getRecipient()),notification.getMessage()).create();
		
		 System.out.println("Sent WhatsApp message successfully: " + message.getSid());
	}

}
