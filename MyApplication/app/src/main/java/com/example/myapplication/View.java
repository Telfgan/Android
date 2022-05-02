package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class View extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.schedule_rv);

        TablePage schedule = new TablePage();
        String[] disciplines = getResources().getStringArray(R.array.disciplines);
        String[] teachers = getResources().getStringArray(R.array.teachers);
        schedule.initializeSchedule(disciplines, teachers);

        TableTool adapter = new TableTool(this, schedule);
        recyclerView.setAdapter(adapter);
    }
}