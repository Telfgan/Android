package com.example.alarm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Calendar dateTime = Calendar.getInstance();
    Button btnTimer;



    private final TimePickerDialog.OnTimeSetListener onTimeSetListener =
            (view, hourOfDay, minute) -> {
                dateTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
                dateTime.set(Calendar.MINUTE, minute);
                setAlarm();
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private void setAlarm() {
        long timerMillis = dateTime.getTimeInMillis();
        long currentMillis = System.currentTimeMillis();
        if (timerMillis < currentMillis) {
            long dayMillis = 24 * 60 * 60 * 1000;
            timerMillis += dayMillis;
        }

        Intent alarm = new Intent(MainActivity.this, AlarmTrigger.class);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, timerMillis,
                PendingIntent.getBroadcast(getApplicationContext(), 0, alarm, 0));
    }
}