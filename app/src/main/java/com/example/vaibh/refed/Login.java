package com.example.vaibh.refed;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    private Button btnLogin, btnSignup;
    private EditText edtUsername, edtPassword;
    private TextView txtWelcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtWelcome = findViewById(R.id.txtWelcome);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),"fonts/welcomefont.ttf");
        txtWelcome.setTypeface(custom_font);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignup = findViewById(R.id.btnSignup);
        edtUsername = findViewById(R.id.edtUsername);


    }
}
