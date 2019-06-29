package com.tms.notification01;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.RemoteInput;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RemoteViews;

import java.util.ArrayList;

import static com.tms.notification01.App.CHANNEL_1_ID;
import static com.tms.notification01.App.CHANNEL_2_ID;
import static com.tms.notification01.App.CHANNEL_3_ID;
import static com.tms.notification01.App.CHANNEL_4_ID;
import static com.tms.notification01.App.CHANNEL_5_ID;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManagerCompat;
    private EditText editTextTitle;
    private EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManagerCompat = NotificationManagerCompat.from(this);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextMessage = findViewById(R.id.editTextMessage);
    }


    public void sendOnChannel1 (View view) {
        RemoteViews collapsedView = new RemoteViews(getPackageName(),
                R.layout.notification_collapsed);

        RemoteViews expandedView = new RemoteViews(getPackageName(),
                R.layout.notification_expanded);

        Intent clickIntent = new Intent(this, NotificationReceiver.class);
        PendingIntent clickPending = PendingIntent.getBroadcast(this, 0, clickIntent, 0);

        /*collapsedView.setTextViewText(R.id.textViewColapsed_1, "Hello Pero");
        expandedView.setImageViewResource(R.id.image_expanded, R.drawable.ic_v1);*/

        expandedView.setOnClickPendingIntent(R.id.image_expanded, clickPending);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_one)
                .setCustomContentView(collapsedView)
                .setCustomBigContentView(expandedView)
                .setStyle(new NotificationCompat.DecoratedCustomViewStyle())

                .build();

        notificationManagerCompat.notify(1, notification);
    }

    public void sendOnChannel2 (View view) {
     /*   Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.photo);


        Notification notification = new NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_two)
                .setContentTitle(editTextTitle.getText().toString())
                .setContentText(editTextMessage.getText().toString())
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setLargeIcon(largeIcon)
                .setStyle(new NotificationCompat.BigTextStyle()
                    .bigText(getString(R.string.dummy))
                    .setBigContentTitle("Big content title")
                    .setSummaryText("Summary text"))
                .build();

        notificationManagerCompat.notify(2, notification);*/
    }


}
