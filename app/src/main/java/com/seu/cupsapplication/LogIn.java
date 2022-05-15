package com.seu.cupsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {
    TextView username,password,ediName, ediRePass, ediPass;
    ImageView signup;
    Button login,signUpBtn;
    TinyDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        username = findViewById(R.id.name);
        password =findViewById(R.id.passwordLgin);
        signup =findViewById(R.id.signup);
        login = findViewById(R.id.buttonLg);
        db= new TinyDB(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = username.getText().toString();
                String pass = password.getText().toString();

                if (name.isEmpty() && pass.isEmpty()){
                    Toast.makeText(LogIn.this, "the name or password is empty!", Toast.LENGTH_SHORT).show();
                }else {
                    Boolean checkUser = db.checkUserPassName(name,pass);
                   if (checkUser){
                       Toast.makeText(LogIn.this, "login is successful", Toast.LENGTH_SHORT).show();

                       Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                       intent.putExtra("username", name);
                       startActivity(intent);
                   }else {
                       Toast.makeText(LogIn.this, "SORRY, something wrong!", Toast.LENGTH_SHORT).show();
                   }
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog signup =new Dialog(LogIn.this);
                signup.setContentView(R.layout.signup_dialog);

                ediName=signup.findViewById(R.id.usernameUp);
                ediPass =signup.findViewById(R.id.edipass);
                ediRePass =signup.findViewById(R.id.ediRepass);
                signUpBtn =signup.findViewById(R.id.signupBtn);

                signUpBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String username = ediName.getText().toString();
                        String rePassword = ediRePass.getText().toString();
                        String password = ediPass.getText().toString();
                        if (username.isEmpty() && password.isEmpty() && rePassword.isEmpty()){
                            Toast.makeText(LogIn.this, "fill all the field first!", Toast.LENGTH_SHORT).show();
                        }else {
                            if (password.equals(rePassword)){
                                boolean checkUser =db.checkUserName(username);
                                if (!checkUser){
                                    Boolean insert = db.insertUser(username,password);
                                    if (insert){
                                        Toast.makeText(LogIn.this, "the account created successfully", Toast.LENGTH_SHORT).show();
                                        signup.dismiss();
                                    }else {
                                        Toast.makeText(LogIn.this, "create an account fail", Toast.LENGTH_SHORT).show();
                                    }
                                }else {
                                    Toast.makeText(LogIn.this, "the user name is already exists!", Toast.LENGTH_SHORT).show();
                                }
                            }else {
                                Toast.makeText(LogIn.this, "the password not match!!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                signup.show();

            }
        });
    }
}