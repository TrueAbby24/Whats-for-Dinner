package com.infs3202.wfd.whatsfordinner;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import Main.HttpRequest;

public class DietActivity extends AppCompatActivity {

    private CheckBox[] checkBoxArray = {};

    private CheckBox vegCheck;
    private CheckBox pesceCheck;
    private CheckBox veganCheck;
    private CheckBox glutenCheck;
    private CheckBox lactoseCheck;

    private TextInputEditText other;
    private Button nextBtn;

    private List<String> checked;

    private String password;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);
        checked = Collections.<String>emptyList();

        vegCheck = (CheckBox) findViewById(R.id.checkBoxVege);
        pesceCheck = (CheckBox) findViewById(R.id.checkBoxPesce);
        veganCheck = (CheckBox) findViewById(R.id.checkBoxVegan);
        glutenCheck = (CheckBox) findViewById(R.id.checkBoxGlutenFree);
        lactoseCheck = (CheckBox) findViewById(R.id.checkBoxLactose);

        other = (TextInputEditText) findViewById(R.id.dietOther);
        nextBtn = (Button) findViewById(R.id.dietNextBtn);

        final List<CheckBox> checkBoxList = new ArrayList(Arrays.asList(checkBoxArray));
        checkBoxList.add(vegCheck);
        checkBoxList.add(pesceCheck);
        checkBoxList.add(veganCheck);
        checkBoxList.add(glutenCheck);
        checkBoxList.add(lactoseCheck);


        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checked != null){
                    checked.clear();
                }

                checkBoxChecked(checkBoxList);
                String diet = null;
                for (String s : checked) {
                    if (diet == null)
                        diet = s;
                    else
                        diet += "," + s;
                }
                other = (TextInputEditText) findViewById(R.id.dietOther);
                if (other.getText() != null) {
                    diet += other.getText().toString();
                }

                    password = getIntent().getStringExtra("password");
                    email = getIntent().getStringExtra("email");

                    boolean success = HttpRequest.register(email, password, diet);
                    if (!success) {
                        email = null;
                        password = null;
                        Toast.makeText(getBaseContext(), "Unable to register, please try again", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getBaseContext(), RegisterActivity.class);
                        startActivity(intent);
                    } //else {
                        Intent intent = new Intent(getBaseContext(), AllergiesActivity.class);
                        intent.putExtra("email", email);
                        intent.putExtra("password", password);
                        intent.putExtra("diet", diet);
                        startActivity(intent);
                   // }

            }


            public void checkBoxChecked(List<CheckBox> list) {
                for (CheckBox diet : list) {
                    if (diet.isChecked()) {
                        checked.add(diet.getText().toString());
                    }
                }
            }
        });
    }
}