package com.blogspot.svdevs.drinkwater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

import static com.blogspot.svdevs.drinkwater.App.CHANNEL_1;

public class MainActivity extends AppCompatActivity {

    Button btn;
    Timer t = new Timer();
    Switch switchC;
    private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchC = findViewById(R.id.switch1);

        notificationManager = NotificationManagerCompat.from(this);

//        btn = findViewById(R.id.Btn);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                enableNotification();
//            }
//        });

        switchC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchC.isChecked()){
                    t.scheduleAtFixedRate(new TimerTask() {
                        @Override
                        public void run() {
                            enableNotification();
                        }
                    },0,600000);

                }else if(!switchC.isChecked()){
                    Toast.makeText(MainActivity.this, "Disabled... ", Toast.LENGTH_SHORT).show();
                    t.cancel();
                    finishAffinity();
                }
            }
        });
    }

    private void enableNotification() {

        Notification notification = new NotificationCompat.Builder(this,CHANNEL_1)
                .setSmallIcon(R.drawable.flower)
                .setContentTitle("Drink Water")
                .setContentText("Please drink a glass of water")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManager.notify(1,notification);
    }


}
