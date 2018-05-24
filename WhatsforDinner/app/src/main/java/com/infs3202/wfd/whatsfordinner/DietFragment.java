package com.infs3202.wfd.whatsfordinner;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DietFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DietFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DietFragment extends Fragment {
    //CheckBox vegCheck;
    //CheckBox pesceCheck;
    //CheckBox veganCheck;
    //CheckBox glutenCheck;
    //CheckBox lactoseCheck;


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


        //vegCheck = (CheckBox)getView().findViewById(R.id.checkBoxVege);
        //pesceCheck = (CheckBox)getView().findViewById(R.id.checkBoxPesce);
        //veganCheck = (CheckBox)getView().findViewById(R.id.checkBoxVegan);
        //glutenCheck = (CheckBox)getView().findViewById(R.id.checkBoxGlutenFree);
        //lactoseCheck = (CheckBox)getView().findViewById(R.id.checkBoxLactose);

        return view;
    }

}
