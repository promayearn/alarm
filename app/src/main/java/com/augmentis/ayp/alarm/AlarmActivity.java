package com.augmentis.ayp.alarm;

import android.app.AlarmManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AlarmActivity extends AppCompatActivity {

    AlarmManager alarmManager;

    private TextView hTextView;
    private TextView mTextView;
    private Button setAlarmButton;
    private Button clsAlarmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        hTextView = (TextView) findViewById(R.id.time_h);
        mTextView = (TextView) findViewById(R.id.time_m);

        setAlarmButton = (Button) findViewById(R.id.set_alarm);
        setAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        clsAlarmButton = (Button) findViewById(R.id.clear_alarm);
        clsAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
}
