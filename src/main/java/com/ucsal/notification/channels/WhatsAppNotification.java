package com.ucsal.notification.channels;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.ucsal.notification.annotations.NoticationChannelType;
import com.ucsal.notification.interfaces.NotificationChannel;
import com.ucsal.notification.models.Notification;

@NoticationChannelType("whatsapp")
public class WhatsAppNotification implements NotificationChannel {
    static {
        Twilio.init(CredenciaisTwilio.ACCOUNT_SID, CredenciaisTwilio.AUTH_TOKEN);
    }

    @Override
    public void send(Notification notification) {
        Message message = Message.creator(
                new PhoneNumber("whatsapp:" + notification.getRecipient()),
                new PhoneNumber("whatsapp:+14155238886"),
                notification.getMessage()).create();

        System.out.println("Notificação Whatsapp enviada com sucesso: " + message.getSid());
    }
}
