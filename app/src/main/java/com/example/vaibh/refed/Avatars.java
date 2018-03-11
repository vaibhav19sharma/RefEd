package com.example.vaibh.refed;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ScaleDrawable;
import android.media.Image;
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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.goodiebag.carouselpicker.CarouselPicker;

public class Avatars extends AppCompatActivity {

    CarouselPicker carouselPicker1;
    Button btnNext;
    private Integer currentItem;
    TextView txtView;
    FirebaseAuth mAuth;
    String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar);

        mAuth = FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this,MainActivity.class));
        }

        uid = mAuth.getCurrentUser().getUid();
        carouselPicker1 = (CarouselPicker) findViewById(R.id.carouselPicker1);

        btnNext = findViewById(R.id.btnNext);
        //Carousel w all images
        List<CarouselPicker.PickerItem> itemsImages = new ArrayList<>();
        itemsImages.add(new CarouselPicker.DrawableItem(R.drawable.catav));
        itemsImages.add(new CarouselPicker.DrawableItem(R.drawable.frogav));
        itemsImages.add(new CarouselPicker.DrawableItem(R.drawable.lionav));
        itemsImages.add(new CarouselPicker.DrawableItem(R.drawable.tigerav));
        CarouselPicker.CarouselViewAdapter imageAdapter = new CarouselPicker.CarouselViewAdapter(this, itemsImages, 0);
        final String[] Images = {"catav", "frogav", "lionav", "tigerav"};
        carouselPicker1.setAdapter(imageAdapter);

        currentItem = 0;

        carouselPicker1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentItem = position;
                txtView.setText(Integer.toString(currentItem));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        txtView = findViewById(R.id.txtVIew);
        txtView.setText(Integer.toString(currentItem));
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                DatabaseReference currentUser_read = FirebaseDatabase.getInstance().getReference().child("Users").child(uid);

                try {
                    currentUser_read.child("Avatar").setValue(Images[currentItem]);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Intent dashboard = new Intent(getApplicationContext(),UserDashboard.class);
                startActivity(dashboard);

            }
        });

    }
}