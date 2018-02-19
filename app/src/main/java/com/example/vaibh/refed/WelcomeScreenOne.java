package com.example.vaibh.refed;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.mukesh.countrypicker.fragments.CountryPicker;
import com.mukesh.countrypicker.interfaces.CountryPickerListener;

import org.w3c.dom.Text;

public class WelcomeScreenOne extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private TextView txtWelcome;
    private EditText edtName,edtAge;
    private MultiAutoCompleteTextView mltHost,mltHome;

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
        txtWelcome.setText("Welcome" + mAuth.getCurrentUser().getEmail().replace("@makefakedomain.com",""));

        edtName = findViewById(R.id.edtName);
        edtAge = findViewById(R.id.edtAge);

        mltHost = findViewById(R.id.mltHost);
        mltHome = findViewById(R.id.mltHome);

        String name = edtName.getText().toString();
        String age = edtAge.getText().toString();


        //Select a Host Country from Drop down
        mltHost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final CountryPicker picker = CountryPicker.newInstance("Select Country");  // dialog title
                picker.setListener(new CountryPickerListener() {
                    @Override
                    public void onSelectCountry(String name, String code, String dialCode, int flagDrawableResID) {
                        // Implement your code here
                        String hostName = name;
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
                        String homeName = name;
                        mltHome.setText(homeName);
                        picker.dismiss();
                    }
                });
                picker.show(getSupportFragmentManager(), "COUNTRY_PICKER");
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
