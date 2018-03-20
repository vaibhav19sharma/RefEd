package com.example.vaibh.refed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Achievements extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);

        String completedModules[] = {"Module1","Module2"};

        CustomAdapterAchievements achievementAdapter = new CustomAdapterAchievements(this, completedModules);

        ListView listModules = (ListView) findViewById(R.id.lstModules);
        listModules.setAdapter(achievementAdapter);

        listModules.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String module = String.valueOf(parent.getItemAtPosition(position));
                Toast.makeText(getApplicationContext(),module,Toast.LENGTH_LONG).show();
            }
        });



    }
}
