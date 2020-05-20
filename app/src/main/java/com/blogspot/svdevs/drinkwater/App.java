package com.blogspot.svdevs.drinkwater;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {

    public static final String CHANNEL_1 = "drinkWater";

    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannel();
    }

    private void createNotificationChannel() {

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){

            NotificationChannel drinkWater = new NotificationChannel(
                    CHANNEL_1,
                    "Drink Water",
                    NotificationManager.IMPORTANCE_HIGH
            );
            drinkWater.enableLights(true);
            drinkWater.enableVibration(true);
            drinkWater.setDescription("Please drink a glass of water");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(drinkWater);
        }
    }
}
