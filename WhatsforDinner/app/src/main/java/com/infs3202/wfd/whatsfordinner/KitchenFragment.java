package com.infs3202.wfd.whatsfordinner;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class KitchenFragment extends Fragment {
    private Context mContext;
    private ConstraintLayout mConstraintLayout;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    final List<String> recipeList = new ArrayList(); //fill this to fill recyclerview

    public KitchenFragment() {
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
        View view = inflater.inflate(R.layout.fragment_kitchen, container, false);

        mContext = getContext();
        mConstraintLayout = (ConstraintLayout) view.findViewById(R.id.nameConstraintLayout);


        mRecyclerView = (RecyclerView)view.findViewById(R.id.kitchenRecycler);

        mLayoutManager = new LinearLayoutManager(this.getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new KitchenAdapter(mContext, recipeList);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }
    // need to add a function the retrieves the users list of saved recipes from db on create

}
