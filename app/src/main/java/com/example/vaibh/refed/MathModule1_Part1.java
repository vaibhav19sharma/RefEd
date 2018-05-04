package com.example.vaibh.refed;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.VideoView;

import org.json.JSONArray;
import org.json.JSONException;

public class MathModule1_Part1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_module1__part1);
        final String completedModules[] = {"Basic Ratios","Equivalent Ratios","Ratios with Double Number Lines","Ratios with Tape Diagrams"};

        CustomAdapterAchievements achievementAdapter = new CustomAdapterAchievements(this, completedModules);

        ListView listModules = (ListView) findViewById(R.id.lvParts);
        VideoView vvIntro = findViewById(R.id.vvIntro);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.ratiosandpropotions);
        vvIntro.setVideoPath(uri.toString());
        vvIntro.requestFocus();
        vvIntro.start();

        listModules.setAdapter(achievementAdapter);

        listModules.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String module = String.valueOf(parent.getItemAtPosition(position));
                Toast.makeText(getApplicationContext(),module,Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(),Activity_Math.class);
                i.putExtra("Name",completedModules[position]);
                startActivity(i);
            }
        });
    }
}
