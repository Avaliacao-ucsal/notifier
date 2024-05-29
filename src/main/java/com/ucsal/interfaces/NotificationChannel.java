package com.ucsal.interfaces;

import com.ucsal.notification.models.Notification;

public interface NotificationChannel {
	void send(Notification notification);
}
