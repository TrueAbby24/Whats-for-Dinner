package com.infs3202.wfd.whatsfordinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    /*      on "Next" button press
            - grab values from email and password fields to use in creating a new user
            - send values to server
            - or maybe collect all users details to send all at once when registering
*/
    public void nextClick(View view){
        Intent intent = new Intent(this, AllergiesActivity.class);
        startActivity(intent);
    }
}
