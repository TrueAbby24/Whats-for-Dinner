package com.infs3202.wfd.whatsfordinner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import Main.HttpRequest;
import Main.RecipeClient;


/**
 * A simple {@link Fragment} subclass.
 * Activi
 */
public class RecipeFragment extends Fragment {
    public TextView title;
    public TextView calories;
    public TextView serving;
    public TextView prepTime;
    public TextView ingre;
    public NestedScrollView method;
    private OnFragmentInteractionListener mListener;

    public RecipeFragment() {
        // Required empty public constructor
    }
    @SuppressLint("ValidFragment")
    public RecipeFragment(String id) {
        try {
            RecipeClient r = new RecipeClient(HttpRequest.getRecipe(id));
            title.setText(r.getTitle());
            calories.setText(r.getCalories()+" calories");
            serving.setText("Serving size: " + r.getServingSize());
            prepTime.setText("Prep Time: " + r.getCookingTime());
            String res = "";
            String s = r.getNextIngredient();
            int i = 1;
            while (s!= null) {
                res += i+") "+s + "\n";
                s = r.getNextIngredient();
                i++;
            }
//

            int N = r.getMethodList().length; // total number of textviews to add

            TextView[] myTextViews = new TextView[N]; // create an empty array;
            for (i = 0; i < N; i++) {
                s = r.getNextIngredient();
                TextView rowTextView = new TextView(getContext());
                rowTextView.setText(i+") "+s + "\n");
                method.addView(rowTextView);
                myTextViews[i] = rowTextView;
            }

//            method.addView((new TextView()).setText(setText(res);
        } catch (Exception e) {
            Toast.makeText(getContext(), "Can't find recipe information!", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recipe, container, false);

        title = (TextView) view.findViewById(R.id.titleView); // edit this things text
        calories = (TextView) view.findViewById(R.id.calories);
        serving= (TextView) view.findViewById(R.id.servings);
        prepTime = (TextView) view.findViewById(R.id.prepTime);
        ingre = (TextView) view.findViewById(R.id.ingred);
        method = (NestedScrollView) view.findViewById(R.id.method);

        mListener.changeFragment("recipe");
        return view;
    }
}
