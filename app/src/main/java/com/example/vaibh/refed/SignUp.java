package com.example.vaibh.refed;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;


public class SignUp extends AppCompatActivity {

    private Button btnSignup;
    private EditText edtUsername, edtPassword, edtName, edtAge, edtHomeCountry, edtHostCountry;
    private TextView txtWelcome;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        txtWelcome = findViewById(R.id.txtWelcome);
        btnSignup = findViewById(R.id.btnSignup);
        edtUsername = findViewById(R.id.edtUsername);
        edtName = findViewById(R.id.edtName);
        edtAge = findViewById(R.id.edtAge);
        edtPassword = findViewById(R.id.edtPassword);
        edtHomeCountry = findViewById(R.id.edtHomeCountry);
        edtHostCountry = findViewById(R.id.edtHostCountry);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });

    }

    private void register(){
        // Takes the username as a String and then adds a fake domain name
        String email = edtUsername.getText().toString().trim() + "@makeFakedomain.com";
        String password = edtPassword.getText().toString().trim();
        String name = edtName.getText().toString();
        // Checks if Email is empty
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please Enter a Username",Toast.LENGTH_LONG).show();
            return;
        }

        // Checks if the name field is empty
        if(name.isEmpty()){
            Toast.makeText(this,"Please enter a Name",Toast.LENGTH_SHORT).show();
        }

        progressDialog.setMessage("Registering you to RefEd!" );
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            progressDialog.dismiss();
                            //User is successfully registered.
                            // Redirects to Login Activity
                            Intent login = new Intent(getApplicationContext(),Login.class);
                            startActivity(login);
                        }
                        else{
                            // Checks if the user is already registered
                            if(task.getException() instanceof FirebaseAuthUserCollisionException){
                                Toast.makeText(getApplicationContext(), "User is already Registered.",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_LONG).show();
                                progressDialog.dismiss();
                            }
                        }

                    }
                }
                );

    }
}
