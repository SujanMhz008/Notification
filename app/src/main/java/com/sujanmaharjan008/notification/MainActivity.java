package com.sujanmaharjan008.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sujanmaharjan008.notification.model.Channel;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManagerCompat;
    private Button btnOne, btnTwo;
    int counter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManagerCompat = NotificationManagerCompat.from(this);

        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        Channel channel = new Channel(this);
        channel.createChannel();

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNotificationOne();
            }
        });
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNotificationTwo();
            }
        });
    }

    public void displayNotificationOne(){
        Notification notification = new NotificationCompat.Builder(this, Channel.CHANNEL_1)
                .setSmallIcon(R.drawable.ic_insert_comment_black_24dp)
                .setContentTitle("First Message")
                .setContentText("This is first message.")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(counter, notification);
        counter = counter + 1;
    }
    public void displayNotificationTwo(){
        Notification notification = new NotificationCompat.Builder(this, Channel.CHANNEL_2)
                .setSmallIcon(R.drawable.ic_insert_comment_black_24dp)
                .setContentTitle("Second Message")
                .setContentText("This is second message.")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(counter, notification);
        counter = counter+1;
    }
}
