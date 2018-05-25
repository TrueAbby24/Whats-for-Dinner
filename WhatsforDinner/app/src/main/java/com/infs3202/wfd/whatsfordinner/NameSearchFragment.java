package com.infs3202.wfd.whatsfordinner;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;

import Main.SearchResultsClient;
import okhttp3.Response;


/**
 * A simple {@link Fragment} subclass.
 * Use the
 * create an instance of this fragment.
 */
public class NameSearchFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    public TextInputEditText searchParam;
    public TextView test;
    public Button searchButton;

    private Context mContext;
    private ConstraintLayout mConstraintLayout;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    final List<String> recipeList = new ArrayList(); //fill this to fill recyclerview

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
        test = (TextView) view.findViewById(R.id.testtext);
        searchButton = (Button) view.findViewById(R.id.nSearch);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                searchParam = (TextInputEditText)getView().findViewById(R.id.nameSearchParam);
                SearchResultsClient result;
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


        mContext = getContext();
        mConstraintLayout = (ConstraintLayout) view.findViewById(R.id.nameConstraintLayout);


        mRecyclerView = (RecyclerView)view.findViewById(R.id.nameRecycleView);

        mLayoutManager = new LinearLayoutManager(this.getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new NameSearchAdapter(mContext, recipeList);
        mRecyclerView.setAdapter(mAdapter);

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
