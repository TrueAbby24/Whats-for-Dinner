package com.infs3202.wfd.whatsfordinner;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllergiesActivity extends AppCompatActivity {
    CheckBox[] checkBoxArray = {};

    CheckBox checkMilk;
    CheckBox checkPeanut;
    CheckBox checkTreeNut;
    CheckBox checkEgg;
    CheckBox checkSoy;
    CheckBox checkFish;
    CheckBox checkShellFish;
    CheckBox checkWheat;
    TextInputEditText other;
    Button nextBtn;

    List<String> checked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allergies);

        checkMilk = (CheckBox) findViewById(R.id.checkBoxMilk);
        checkPeanut = (CheckBox) findViewById(R.id.checkBoxPeanuts);
        checkTreeNut = (CheckBox) findViewById(R.id.checkBoxTreeNuts);
        checkEgg = (CheckBox) findViewById(R.id.checkBoxEggs);
        checkSoy = (CheckBox) findViewById(R.id.checkBoxSoy);
        checkFish = (CheckBox) findViewById(R.id.checkBoxFish);
        checkShellFish = (CheckBox) findViewById(R.id.checkBoxShellfish);
        checkWheat = (CheckBox) findViewById(R.id.checkBoxWheat);
        other = (TextInputEditText) findViewById(R.id.allergyOther);
        nextBtn = (Button) findViewById(R.id.allergyNextBtn);

        final List<CheckBox> checkBoxList = new ArrayList(Arrays.asList(checkBoxArray));
        checkBoxList.add(checkMilk);
        checkBoxList.add(checkPeanut);
        checkBoxList.add(checkTreeNut);
        checkBoxList.add(checkEgg);
        checkBoxList.add(checkSoy);
        checkBoxList.add(checkFish);
        checkBoxList.add(checkShellFish);
        checkBoxList.add(checkWheat);


        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checked.clear();
                checkBoxChecked(checkBoxList);
                // send to server/db
            }
        });
    }

    public void checkBoxChecked(List<CheckBox> list){
        for(CheckBox allergy:list){
            if (allergy.isChecked()){
                checked.add(allergy.getText().toString());
            }
        }
    }


}

/*      on "Next" button press
            - record which checkboxes are checked
            - send data to server
            - might need to change ID for boxes if it's not possible to send the text value
*/