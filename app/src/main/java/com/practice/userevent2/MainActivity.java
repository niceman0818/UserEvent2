package com.practice.userevent2;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.core.app.NotificationCompat;


        import android.app.Notification;
        import android.app.NotificationChannel;
        import android.app.NotificationManager;
        import android.content.Context;
        import android.os.Build;
        import android.os.Bundle;
        import android.text.Editable;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String NOTIFICATION_CHANNEL_ID = "channel1_ID";
    private static final String NOTIFICATION_CHANNEL_NAME ="channel1";

    private TextView textView;
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_user_event_2);

        textView = (TextView) findViewById(R.id.textview);
        editText = (EditText) findViewById(R.id.edittext);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotification();
            }
        });

    }

    public void showNotification() {
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_LOW;

            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, NOTIFICATION_CHANNEL_NAME, importance);

            notificationManager.createNotificationChannel(notificationChannel);
        }
        int notificationId = 0;
        Editable input = editText.getText();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), NOTIFICATION_CHANNEL_ID);

        builder.setSmallIcon(R.drawable.ad);
        builder.setContentTitle("알림 타이틀이여");
        builder.setContentText(input);

        notificationManager.notify(notificationId, builder.build());
    }
}
