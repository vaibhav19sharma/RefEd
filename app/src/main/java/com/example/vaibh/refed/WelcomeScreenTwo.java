package com.example.vaibh.refed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.john.waveview.WaveView;

public class WelcomeScreenTwo extends AppCompatActivity {

        private WaveView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen_two);

        wv = findViewById(R.id.wave_view);
        wv.setProgress(40);
    }
}
