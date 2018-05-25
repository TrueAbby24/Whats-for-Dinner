package com.infs3202.wfd.whatsfordinner;


import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Main.RecipeMiniClient;
import Main.SearchResultsClient;


/**
 * A simple {@link Fragment} subclass.
 */
public class IngrSearchResultsFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    private Context mContext;
    public Button returnToIngr;
    private ConstraintLayout mConstraintLayout;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    final List<String> recipeList = new ArrayList();


    public IngrSearchResultsFragment() {
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
        View view = inflater.inflate(R.layout.fragment_ingr_search_results, container, false);



        mContext = getContext();
        mConstraintLayout = (ConstraintLayout) view.findViewById(R.id.layout);
        returnToIngr = (Button)view.findViewById(R.id.ingrReturn);

        mRecyclerView = (RecyclerView)view.findViewById(R.id.ingrResultsRecycleView);

        mLayoutManager = new LinearLayoutManager(this.getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);



        List<String> list = mListener.getIngrList();

        SearchResultsClient results = mListener.runIngrSearch(list);

        RecipeMiniClient mini = results.getRecipeMini();
        List<RecipeMiniClient> listResults = new ArrayList();
        while (mini != null) {
            mini = results.getRecipeMini();
            listResults.add(mini);
        }

        createListener(returnToIngr, "ingrReturn");
        //not sure if more is needed to populate the list
        //need to get list to fill recipeList on creation
        mAdapter = new IngrResultAdapter(mContext, listResults);
        mRecyclerView.setAdapter(mAdapter);


        return view;
    }

    public void createListener(Button btn, final String id){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                mListener.changeFragment(id);
            }
        });
    }

}
