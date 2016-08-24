package com.augmentis.ayp.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.widget.ToggleButton;

@TargetApi(23)
public class AlarmActivity extends AppCompatActivity {

    private static final String TAG = "AlarmActivity";

    AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    private static AlarmActivity inst;

    private EditText hEditText;
    private EditText mEditText;
    private Button setButton;
    private Button clsButton;
    Calendar calendar = Calendar.getInstance();

    public static AlarmActivity instance() {
        return inst;
    }

    @Override
    public void onStart() {
        super.onStart();
        inst = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        hEditText = (EditText) findViewById(R.id.time_h);
        mEditText = (EditText) findViewById(R.id.time_m);

        alarmManager.cancel(pendingIntent);
        setAlarmText("");
        Log.d("MyActivity", "Alarm Off");

        setButton = (Button) findViewById(R.id.set_alarm);
        setButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Click");
                Log.d("MyActivity", "Alarm On");
                calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hEditText.getText().toString()));
                calendar.set(Calendar.MINUTE, Integer.parseInt(mEditText.getText().toString()));
                calendar.set(Calendar.SECOND, 00);
                Intent myIntent = new Intent(AlarmActivity.this, AlarmReceiver.class);
                pendingIntent = PendingIntent.getBroadcast(AlarmActivity.this, 0, myIntent, 0);
                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
            }
        });

        clsButton = (Button) findViewById(R.id.clear_alarm);
        clsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmManager.cancel(pendingIntent);
                Log.d(TAG, "Alarm Cancel " + calendar.getTime());
            }
        });
    }

    public void setAlarmText(String alarmText) {
        Log.d(TAG, alarmText);
    }

}