package com.infs3202.wfd.whatsfordinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

         final EditText registerEmail = (EditText) findViewById(R.id.register_email);
         final EditText registerPassword = (EditText) findViewById(R.id.register_password);

         Button bRegister = (Button) findViewById(R.id.register_next);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                final String email = registerEmail.getText().toString();
                final String password = registerPassword.getText().toString();

                Intent intent = new Intent(getBaseContext(), NavBaseActivity.class);
                intent.putExtra("email", email);
                intent.putExtra("password", password);
                startActivity(intent);

            }
        });
    }
}
