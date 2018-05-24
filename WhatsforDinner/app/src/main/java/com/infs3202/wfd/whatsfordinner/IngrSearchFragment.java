package com.infs3202.wfd.whatsfordinner;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the factory method to
 * create an instance of this fragment.
 */
public class IngrSearchFragment extends Fragment {
    private Context mContext;
    private Button mButtonAdd;
    private LinearLayout mLinearLayout;
    private TextInputEditText ingredientItem;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    public IngrSearchFragment() {
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
        final View view = inflater.inflate(R.layout.fragment_ingr_search, container, false);

        mContext = getContext();

        mLinearLayout = (LinearLayout) view.findViewById(R.id.layout);

        mButtonAdd = (Button) view.findViewById(R.id.add_btn);
        ingredientItem = (TextInputEditText) view.findViewById(R.id.ingredientInput);

        mRecyclerView = (RecyclerView)view.findViewById(R.id.ingrRecycleView);

        String[] ingredients = {};
        final List<String> ingredientList = new ArrayList(Arrays.asList(ingredients));

        mLayoutManager = new LinearLayoutManager(this.getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);



        mAdapter = new IngrSelectAdapter(mContext, ingredientList);
        mRecyclerView.setAdapter(mAdapter);

        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                int position = 0;
                String itemLabel = ingredientItem.getText().toString();

                for(String ingredient:ingredientList){
                    if(ingredientList.contains(ingredient)){
                        Toast.makeText(mContext, "This ingredient is already listed", Toast.LENGTH_SHORT).show();
                    } else{
                        ingredientList.add(position, itemLabel);
                    }
                }



                mAdapter.notifyItemInserted(position);
                mRecyclerView.scrollToPosition(position);

                Toast.makeText(mContext, "Added: " + itemLabel, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }



}
