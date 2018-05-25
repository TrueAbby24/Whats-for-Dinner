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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Main.HttpRequest;


/**
 * A simple {@link Fragment} subclass.
 * Activities thactory method to
 * create an instance of this fragment.
 */
public class AllergiesFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private User user;
    private CheckBox[] checkBoxArray = {};

    private  CheckBox checkMilk;
    private  CheckBox checkPeanut;
    private CheckBox checkTreeNut;
    private CheckBox checkEgg;
    private CheckBox checkSoy;
    private CheckBox checkFish;
    private CheckBox checkShellFish;
    private CheckBox checkWheat;
    private TextInputEditText other;
    private Button saveBtn;

    private List<String> checked;

    public AllergiesFragment() {
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
        View view = inflater.inflate(R.layout.fragment_allergies, container, false);

        checkMilk = (CheckBox) view.findViewById(R.id.checkBoxMilkF);
        checkPeanut = (CheckBox) view.findViewById(R.id.checkBoxPeanutsF);
        checkTreeNut = (CheckBox) view.findViewById(R.id.checkBoxTreeNutsF);
        checkEgg = (CheckBox) view.findViewById(R.id.checkBoxEggsF);
        checkSoy = (CheckBox) view.findViewById(R.id.checkBoxSoyF);
        checkFish = (CheckBox) view.findViewById(R.id.checkBoxFishF);
        checkShellFish = (CheckBox) view.findViewById(R.id.checkBoxShellfishF);
        checkWheat = (CheckBox) view.findViewById(R.id.checkBoxWheatF);

        other = (TextInputEditText) view.findViewById(R.id.allergyOtherF);
        saveBtn = (Button) view.findViewById(R.id.allergySaveBtn);

        final List<CheckBox> checkBoxList = new ArrayList(Arrays.asList(checkBoxArray));
        checkBoxList.add(checkMilk);
        checkBoxList.add(checkPeanut);
        checkBoxList.add(checkTreeNut);
        checkBoxList.add(checkEgg);
        checkBoxList.add(checkSoy);
        checkBoxList.add(checkFish);
        checkBoxList.add(checkShellFish);
        checkBoxList.add(checkWheat);

        user = mListener.getUserDetails();

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checked.clear();
                checkBoxChecked(checkBoxList);
                // send to server/db
                if(!HttpRequest.insertAllergy(user.geteMail(), user.getAllergy())) {
                    Toast.makeText(getContext(), "Catastrophic failure! Could not connect to server!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return view;
    }


    public void checkBoxChecked(List<CheckBox> list){
        for(CheckBox allergy:list){
            if (allergy.isChecked()){
                checked.add(allergy.getText().toString());
            }
        }
    }
}
