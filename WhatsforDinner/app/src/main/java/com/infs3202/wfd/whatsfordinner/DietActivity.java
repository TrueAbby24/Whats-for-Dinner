package com.infs3202.wfd.whatsfordinner;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DietActivity extends AppCompatActivity {

    CheckBox[] checkBoxArray = {};

    CheckBox vegCheck;
    CheckBox pesceCheck;
    CheckBox veganCheck;
    CheckBox glutenCheck;
    CheckBox lactoseCheck;

    TextInputEditText other;
    Button nextBtn;

    List<String> checked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);

        vegCheck = (CheckBox)findViewById(R.id.checkBoxVege);
        pesceCheck = (CheckBox)findViewById(R.id.checkBoxPesce);
        veganCheck = (CheckBox)findViewById(R.id.checkBoxVegan);
        glutenCheck = (CheckBox)findViewById(R.id.checkBoxGlutenFree);
        lactoseCheck = (CheckBox)findViewById(R.id.checkBoxLactose);

        other = (TextInputEditText)findViewById(R.id.dietOther);
        nextBtn = (Button)findViewById(R.id.dietSaveBtn);

        final List<CheckBox> checkBoxList = new ArrayList(Arrays.asList(checkBoxArray));
        checkBoxList.add(vegCheck);
        checkBoxList.add(pesceCheck);
        checkBoxList.add(veganCheck);
        checkBoxList.add(glutenCheck);
        checkBoxList.add(lactoseCheck);


        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checked.clear();
                checkBoxChecked(checkBoxList);
                // send to server/db
                // move to allergies activity
                //Intent intent = new Intent(this, AllergiesActivity.class);
                //startActivity(intent);
            }
        });
    }

    public void checkBoxChecked(List<CheckBox> list){
        for(CheckBox diet:list){
            if (diet.isChecked()){
                checked.add(diet.getText().toString());
            }
        }
    }
}

/*      on "Next" button press
            - record which checkboxes are checked
            - send data to server
            - might need to change ID for boxes if it's not possible to send the text value
*/