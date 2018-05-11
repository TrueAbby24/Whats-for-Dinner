package com.infs3202.wfd.whatsfordinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DietActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);
    }
}

/*      on "Next" button press
            - record which checkboxes are checked
            - send data to server
            - might need to change ID for boxes if it's not possible to send the text value
*/