package com.infs3202.wfd.whatsfordinner;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AllergiesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AllergiesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AllergiesFragment extends Fragment {
    CheckBox milkCheck;
    CheckBox peanutsCheck;
    CheckBox treeNutsCheck;
    CheckBox eggsCheck;
    CheckBox soyCheck;
    CheckBox fishCheck;
    CheckBox shellfishCheck;
    CheckBox wheatCheck;

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


        return view;
    }
}
