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

public class AllergiesActivity extends AppCompatActivity {
    private String email;
    private String diet;

    private CheckBox[] checkBoxArray = {};

    private CheckBox checkMilk;
    private CheckBox checkPeanut;
    private CheckBox checkTreeNut;
    private CheckBox checkEgg;
    private CheckBox checkSoy;
    private CheckBox checkFish;
    private CheckBox checkShellFish;
    private CheckBox checkWheat;
    private TextInputEditText other;
    private Button nextBtn;

    private List<String> checked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allergies);

        email = getIntent().getStringExtra("email");
        diet = getIntent().getStringExtra("diet");

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
                String allergies = null;
                for (String s : checked) {
                    if (allergies == null)
                        allergies = s;
                    else
                        allergies += "," + s;
                }
                other = (TextInputEditText) findViewById(R.id.dietOther);
                if (other.getText() != null) {
                    allergies += "," + other.getText().toString();
                }

                //send to server

                Intent intent = new Intent(getBaseContext(), NavBaseActivity.class);
                intent.putExtra("email", email);
                intent.putExtra("diet", diet);
                intent.putExtra("allergies", allergies);
                startActivity(intent);
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