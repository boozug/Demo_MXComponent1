 package com.example.demo_mxcomponent1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.SQLException;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.sql.Connection;
import java.sql.DriverManager;


import java.nio.channels.AsynchronousFileChannel;


 public class Login_form extends AppCompatActivity {
     // declare
     String DATABASE_TABLE = "Users";
     public static final String DATABASE_NAME = "Accounts";
     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_login_form);
         RelativeLayout btnLogin = (RelativeLayout) findViewById(R.id.relative_layout_btn);
         final EditText txtUserName = (EditText) findViewById(R.id.TxtUsername);
         final EditText txtPassword = (EditText) findViewById(R.id.TxtPassword);
         btnLogin.setOnClickListener(new View.OnClickListener() {
                                         //            public Database.DatabaseHelper database = new Database.DatabaseHelper(this,DATABASE_NAME,null,1);
                                         String username = txtUserName.getText().toString();
                                         String password = txtPassword.getText().toString();

                                         public void onClick(View view) {
                                             try {
                                                 if (username.length() > 0 && password.length() > 0) {
                                                     DBUserAdapter dbUser = new DBUserAdapter(Login_form.this);
                                                     dbUser.open();
                                                     if(dbUser.Login(username,password))
                                                     {
                                                         Toast.makeText(Login_form.this,"Successfully Logged In", Toast.LENGTH_LONG).show();
                                                     }
                                                     else {
                                                         Toast.makeText(Login_form.this,"Invalid Username/Password", Toast.LENGTH_LONG).show();
                                                     }
                                                 }
                                             } catch (Exception e) {
                                                 Toast.makeText(Login_form.this, e.getMessage(), Toast.LENGTH_LONG).show();
                                             }
                                         }
                                     }

         );
         TextView register = (TextView) findViewById(R.id.textView_register);
         register.setMovementMethod(LinkMovementMethod.getInstance());
         register.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(Login_form.this, Signup_Form.class);
                 startActivity(intent);
             }
         });
     }
}