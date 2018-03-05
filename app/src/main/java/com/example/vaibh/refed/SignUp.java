package com.example.vaibh.refed;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;


public class SignUp extends AppCompatActivity {

    private Button btnSignup;
    private EditText edtUsername, edtPassword,edtPasswordConfirm;
    private TextView txtWelcome;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private String uid,email,password,passwordConfirmation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        txtWelcome = findViewById(R.id.txtWelcome);
        btnSignup = findViewById(R.id.btnSignup);
        edtUsername = findViewById(R.id.edtUsername);

        edtPassword = findViewById(R.id.edtPassword);
        edtPasswordConfirm = findViewById(R.id.edtConfirm);

        // Takes the username as a String and then adds a fake domain name


        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = edtUsername.getText().toString().trim() + "@makeFakedomain.com";
                password = edtPassword.getText().toString();
                passwordConfirmation = edtPasswordConfirm.getText().toString();

                if(!password.equals(passwordConfirmation)){
                    Toast.makeText(getApplicationContext(),"Passwords Do not Match",Toast.LENGTH_LONG).show();
                }

                else{
                    register();
                }
            }
        }
        );

    }

    private void register() {

        // Checks if Email is empty
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please Enter a Username", Toast.LENGTH_LONG).show();
            return;
        }
            progressDialog.setMessage("Registering you to RefEd!");
            progressDialog.show();

            firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (task.isSuccessful()) {
                                        progressDialog.dismiss();
                                        //User is successfully registered.
                                        // Redirects to Login Activity
                                        Intent login = new Intent(getApplicationContext(), Login.class);
                                        startActivity(login);
                                    } else {
                                        // Checks if the user is already registered
                                        if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                            Toast.makeText(getApplicationContext(), "User is already Registered.", Toast.LENGTH_SHORT).show();
                                        } else {
                                            Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                            progressDialog.dismiss();
                                        }
                                    }

                                }
                            }
                    );


    }
}