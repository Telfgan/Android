package com.example.RaspianieApp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.RaspianieApp.R;
import com.example.RaspianieApp.ScheduleAdapter;
import com.example.RaspianieApp.ScheduleSheet;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.schedule_rv);

        ScheduleSheet schedule = new ScheduleSheet();
        String[] disciplines = getResources().getStringArray(R.array.disciplines);
        String[] teachers = getResources().getStringArray(R.array.teachers);
        schedule.initializeSchedule(disciplines, teachers);

        ScheduleAdapter adapter = new ScheduleAdapter(this, schedule);
        recyclerView.setAdapter(adapter);
    }
}