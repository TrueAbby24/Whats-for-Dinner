package com.infs3202.wfd.whatsfordinner;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Ac
 */
public class DietFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    CheckBox[] checkBoxArray = {};

    CheckBox vegCheck;
    CheckBox pesceCheck;
    CheckBox veganCheck;
    CheckBox glutenCheck;
    CheckBox lactoseCheck;

    TextInputEditText other;
    Button saveBtn;

    List<String> checked;


    public DietFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_diet, container, false);


        vegCheck = (CheckBox)view.findViewById(R.id.checkBoxVegeF);
        pesceCheck = (CheckBox)view.findViewById(R.id.checkBoxPesceF);
        veganCheck = (CheckBox)view.findViewById(R.id.checkBoxVeganF);
        glutenCheck = (CheckBox)view.findViewById(R.id.checkBoxGlutenFreeF);
        lactoseCheck = (CheckBox)view.findViewById(R.id.checkBoxLactoseF);

        other = (TextInputEditText) view.findViewById(R.id.dietOtherF);
        saveBtn = (Button) view.findViewById(R.id.dietSaveBtn);

        final List<CheckBox> checkBoxList = new ArrayList(Arrays.asList(checkBoxArray));
        checkBoxList.add(vegCheck);
        checkBoxList.add(pesceCheck);
        checkBoxList.add(veganCheck);
        checkBoxList.add(glutenCheck);
        checkBoxList.add(lactoseCheck);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checked.clear();
                checkBoxChecked(checkBoxList);
                // send to server/db
            }
        });

        


        return view;
    }


    public void checkBoxChecked(List<CheckBox> list){
        for(CheckBox diet:list){
            if (diet.isChecked()){
                checked.add(diet.getText().toString());
            }
        }
    }

}
