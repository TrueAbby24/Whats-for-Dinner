package com.infs3202.wfd.whatsfordinner;


import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NameSearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NameSearchFragment extends Fragment {

    OnFragmentInteractionListener searchCallback;
    TextInputEditText searchParam;

    public NameSearchFragment() {
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
        return inflater.inflate(R.layout.fragment_name_search, container, false);


    }

    /**
     *  Send parameters for search by recipe name
     *
     */

    public void OnAttach(Activity activity){
        super.onAttach(activity);

        try {
            searchCallback = (OnFragmentInteractionListener) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()
            + " must implement OnNameSearchListener");
        }
    }

    public void onNameSearchButtonClick(View view){
        searchParam = (TextInputEditText)findViewById(R.id.nameSearchParam);
        searchCallback.getNameSearchParam(searchParam);
    }

}
