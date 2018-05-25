package com.infs3202.wfd.whatsfordinner;

import android.support.design.widget.TextInputEditText;
import android.widget.Button;

import java.util.List;

import Main.RecipeClient;
import Main.SearchResultsClient;
import okhttp3.Response;

/**
 * Declare methods to be overridden in NavBaseActivity that are used for interacting with fragments
 */

public interface OnFragmentInteractionListener {
    /**
     * Method for changing fragments without using the drawer menu
     * @param id - String used to identify which fragments will be loaded
     */
    void changeFragment(String id);

    SearchResultsClient runNameSearch(TextInputEditText editText);

    SearchResultsClient runIngrSearch(List<String> list);

    User getUserDetails();

    List<String> getIngrList();

    void setIngrList(List<String> list);

    void recipePopulate (RecipeClient recipe);


}


