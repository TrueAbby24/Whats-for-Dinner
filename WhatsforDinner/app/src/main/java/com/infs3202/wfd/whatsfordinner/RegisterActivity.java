package com.infs3202.wfd.whatsfordinner;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText registerEmail = (EditText) findViewById(R.id.register_email);
        final EditText registerPassword = (EditText) findViewById(R.id.register_password);

        final Button bRegister = (Button) findViewById(R.id.register_next);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                final String email = registerEmail.getText().toString();
                final String password = registerPassword.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success"); //name is whatever it is coded as in php

                            if (success){
                                Intent intent = new Intent(RegisterActivity.this, AllergiesActivity.class);
                                RegisterActivity.this.startActivity(intent);
                            } else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("Register Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(email, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
            }
        });
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
