package com.example.vaibh.refed;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mukesh.countrypicker.fragments.CountryPicker;
import com.mukesh.countrypicker.interfaces.CountryPickerListener;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class WelcomeScreenOne extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private TextView txtWelcome;
    private EditText edtName,edtAge;
    private Button btnNext;
    private MultiAutoCompleteTextView mltHost,mltHome;
    private String name,age,hostName,homeName,uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen_one);

        mAuth = FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this,MainActivity.class));
        }

        txtWelcome = findViewById(R.id.txtWelcome);
        txtWelcome.setText("Welcome " + mAuth.getCurrentUser().getEmail().replace("@makefakedomain.com",""));

        edtName = findViewById(R.id.edtName);
        edtAge = findViewById(R.id.edtAge);

        mltHost = findViewById(R.id.mltHost);
        mltHome = findViewById(R.id.mltHome);

        btnNext = findViewById(R.id.btnSubmit);

        uid = mAuth.getCurrentUser().getUid();
        DatabaseReference currentUser_read = FirebaseDatabase.getInstance().getReference().child("Users").child(uid);

        currentUser_read.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                if(dataSnapshot.child("Name").exists()){
                    String dataName = dataSnapshot.child("Name").getValue().toString();
                    edtName.setText(dataName);
                }


                if(dataSnapshot.child("Age").exists()){
                    String dataAge = dataSnapshot.child("Age").getValue().toString();
                    edtAge.setText(dataAge);
                }



                if(dataSnapshot.child("Home_Country").exists()){
                    String dataHomeCountry = dataSnapshot.child("Home_Country").getValue().toString();
                    mltHome.setText(dataHomeCountry);
                    homeName = mltHome.getText().toString();
                }

                if(dataSnapshot.child("Host_Country").exists()){
                    String dataHostCountry = dataSnapshot.child("Host_Country").getValue().toString();
                    mltHost.setText(dataHostCountry);
                    hostName = mltHost.getText().toString();
                }



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        //Select a Host Country from Drop down
        mltHost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final CountryPicker picker = CountryPicker.newInstance("Select Country");  // dialog title
                picker.setListener(new CountryPickerListener() {
                    @Override
                    public void onSelectCountry(String name, String code, String dialCode, int flagDrawableResID) {
                        // Implement your code here
                        hostName = name;
                        mltHost.setText(hostName);
                        picker.dismiss();
                    }
                });
                picker.show(getSupportFragmentManager(), "COUNTRY_PICKER");

            }
        });


        //Select a Home Country from Drop down
        mltHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CountryPicker picker = CountryPicker.newInstance("Select Country");  // dialog title
                picker.setListener(new CountryPickerListener() {
                    @Override
                    public void onSelectCountry(String name, String code, String dialCode, int flagDrawableResID) {
                        // Implement your code here
                        homeName = name;
                        mltHome.setText(homeName);
                        picker.dismiss();
                    }
                });
                picker.show(getSupportFragmentManager(), "COUNTRY_PICKER");
            }
        });

        //OnClick listener on button to store user data onto Firebase

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                name = edtName.getText().toString();
                age = edtAge.getText().toString();
                if(name.isEmpty() || age.isEmpty() || mltHost.getText().toString().isEmpty() || mltHome.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please enter all fields",Toast.LENGTH_LONG).show();
                }
                else {

                    DatabaseReference currentUser = FirebaseDatabase.getInstance().getReference().child("Users").child(uid);


                    Map addInformation = new HashMap();
                    addInformation.put("Name", name);
                    addInformation.put("Age", age);
                    addInformation.put("Host_Country", hostName);
                    addInformation.put("Home_Country", homeName);
                    addInformation.put("Avatar","frogav");

                    currentUser.setValue(addInformation);

                    Intent setAvatar = new Intent(getApplicationContext(), Login.class);
                    startActivity(setAvatar);
                }
            }
        });


    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        // Need to Implement

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        //Need to Implement
    }
}
