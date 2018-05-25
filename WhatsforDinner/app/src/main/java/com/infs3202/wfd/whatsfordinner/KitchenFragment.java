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
import android.widget.Toast;

import org.json.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

import Main.HttpRequest;
import Main.RecipeClient;


public class KitchenFragment extends Fragment {
    private Context mContext;
//    private OnFragmentInteractionListener mListener;
    private ConstraintLayout mConstraintLayout;
    private User user;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    final List<RecipeClient> recipeList = new ArrayList(); //fill this to fill recyclerview

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
        user = mListener.getUserDetails();
        mContext = getContext();
        mConstraintLayout = (ConstraintLayout) view.findViewById(R.id.nameConstraintLayout);


        mRecyclerView = (RecyclerView)view.findViewById(R.id.kitchenRecycler);

        mLayoutManager = new LinearLayoutManager(this.getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new KitchenAdapter(mContext, recipeList);
        mRecyclerView.setAdapter(mAdapter);

        String rawRes = HttpRequest.getFavRecipes(user.geteMail());
        try {
            JSONParser parse = new JSONParser();
            JSONArray recipeIDs = (JSONArray) parse.parse(rawRes);
            String id;
            for (int i = 0; i < recipeIDs.length(); i++) {
                id = (String) recipeIDs.get(i);
                recipeList.add(new RecipeClient(HttpRequest.getRecipe(id)));
//                recipeData.getCookingTime();
//                recipeData.getTitle();
//                recipeData.getServingSize();
//                recipeData.getCalories();
            }
        } catch (Exception e) {
            Toast.makeText(getContext(), "ERROR: Unable to retrieve favourite recipes.", Toast.LENGTH_SHORT).show();
        }


        return view;
    }
    // need to add a function the retrieves the users list of saved recipes from db on create
    private OnFragmentInteractionListener mListener;






}
