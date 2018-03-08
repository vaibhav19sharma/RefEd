package com.example.vaibh.refed;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ScaleDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

import in.goodiebag.carouselpicker.CarouselPicker;

public class Avatars extends AppCompatActivity {

    CarouselPicker carouselPicker1;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar);

        carouselPicker1 = (CarouselPicker) findViewById(R.id.carouselPicker1);

        btnNext = findViewById(R.id.btnNext);
        //Carousel w all images
        List<CarouselPicker.PickerItem> itemsImages = new ArrayList<>();
        itemsImages.add(new CarouselPicker.DrawableItem(R.drawable.catav));
        itemsImages.add(new CarouselPicker.DrawableItem(R.drawable.frogav));
        itemsImages.add(new CarouselPicker.DrawableItem(R.drawable.lionav));
        itemsImages.add(new CarouselPicker.DrawableItem(R.drawable.tigerav));
        CarouselPicker.CarouselViewAdapter imageAdapter = new CarouselPicker.CarouselViewAdapter(this, itemsImages, 0);
        carouselPicker1.setAdapter(imageAdapter);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent dashboard = new Intent(getApplicationContext(),UserDashboard.class);
                startActivity(dashboard);

            }
        });

    }
}