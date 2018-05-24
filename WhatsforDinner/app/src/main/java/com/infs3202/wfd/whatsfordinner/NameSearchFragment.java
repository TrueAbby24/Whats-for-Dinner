package com.infs3202.wfd.whatsfordinner;


import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.json.simple.parser.ParseException;

import Main.SearchResultsClient;
import okhttp3.Response;


/**
 * A simple {@link Fragment} subclass.
 * Use the
 * create an instance of this fragment.
 */
public class NameSearchFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
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
        View view = inflater.inflate(R.layout.fragment_name_search, container, false);
        final TextView test = (TextView) view.findViewById(R.id.testtext);
        Button searchButton = (Button) view.findViewById(R.id.nSearch);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                searchParam = (TextInputEditText)getView().findViewById(R.id.nameSearchParam);
                Response result;
                result = mListener.runNameSearch(searchParam);
                Log.v("response return", result.toString());
                try {
                    SearchResultsClient src = new SearchResultsClient(result.toString());
                    test.setText((CharSequence) src);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

        return view;
    }

    /**
     *  Send parameters for search by recipe name
     *
     */

    public void OnAttach(Activity activity){
        super.onAttach(activity);

        try {
            mListener = (OnFragmentInteractionListener) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()
            + " must implement OnNameSearchListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;

    }

/**
    public void onNameSearchButtonClick(View view) throws ParseException {
        searchParam = (TextInputEditText)getView().findViewById(R.id.nameSearchParam);
        Response result;
        result = mListener.runNameSearch(searchParam);
        Log.v("response return", result.toString());
        SearchResultsClient src = new SearchResultsClient(result.toString());


    }
**/
}
