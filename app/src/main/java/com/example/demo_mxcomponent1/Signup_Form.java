 package com.example.demo_mxcomponent1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteException;
import android.widget.Toast;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.widget.Toast.*;


 public class Signup_Form extends AppCompatActivity {
     //region ------------------------------------------------------Main action
     public static DBUserAdapter.DatabaseHelper database;
     public static final String DATABASE_NAME = "Accounts";

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_signup__form);

         RelativeLayout btnRegister = (RelativeLayout) findViewById(R.id.relative_layout_btn);
         final EditText txtUserName = (EditText) findViewById(R.id.TxtUsername);
         final EditText txtPassword = (EditText) findViewById(R.id.TxtPassword);
         final EditText txtPasswordrpt = (EditText) findViewById(R.id.TxtRPTPassword);
         btnRegister.setOnClickListener(new View.OnClickListener() {
//             @Override
             public void onClick(View view) {
                 String username = txtUserName.getText().toString();
                 String password = txtPassword.getText().toString();
                 String rptpassword = txtPasswordrpt.getText().toString();
                 try {
                     if (username.length() >= 8) {
                         if (password.equals(rptpassword) ) {
                             DBUserAdapter dbUser = new DBUserAdapter(Signup_Form.this);
                             dbUser.open();
                             try {
                                 dbUser.AddUser(username,password);
                                 Toast.makeText(Signup_Form.this,"Finished. Pls check your account in the login form", Toast.LENGTH_LONG).show();
                                 dbUser.close();
                             }
                             catch (SQLiteException e){
                                 Toast.makeText(Signup_Form.this,e.getMessage(), Toast.LENGTH_LONG).show();
                             }
                         }
                         else {
                             Toast.makeText(Signup_Form.this,"Pls correct password", Toast.LENGTH_LONG).show();
                         }
                     }
                     else
                     {
                         Toast.makeText(Signup_Form.this,"Pls add an correct User", Toast.LENGTH_LONG).show();
                     }

                 }
                 catch(Exception e){
                     Toast.makeText(Signup_Form.this,e.getMessage(), Toast.LENGTH_LONG).show();

                 }
             }
         });
         //endregion

         //region change to login page
         TextView login = (TextView) findViewById(R.id.textView_login);
         login.setMovementMethod(LinkMovementMethod.getInstance());
         login.setOnClickListener(new View.OnClickListener() {

             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(Signup_Form.this, Login_form.class);
                 startActivity(intent);

             }
         });
         // endregion
     }
 }
