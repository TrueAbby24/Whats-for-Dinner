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
        milkCheck = (TextInputEditText)getView().findViewById(R.id.checkBoxMilk);
        peanutsCheck = (TextInputEditText)getView().findViewById(R.id.checkBoxPeanuts);
        treeNutsCheck = (TextInputEditText)getView().findViewById(R.id.checkBoxTreeNuts);
        eggsCheck = (TextInputEditText)getView().findViewById(R.id.checkBoxEggs);
        soyCheck = (TextInputEditText)getView().findViewById(R.id.checkBoxSoy);
        fishCheck = (TextInputEditText)getView().findViewById(R.id.checkBoxFish);
        shellfishCheck = (TextInputEditText)getView().findViewById(R.id.checkBoxShellfish);
        wheatCheck = (TextInputEditText)getView().findViewById(R.id.checkBoxWheat);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_allergies, container, false);
    }
}
