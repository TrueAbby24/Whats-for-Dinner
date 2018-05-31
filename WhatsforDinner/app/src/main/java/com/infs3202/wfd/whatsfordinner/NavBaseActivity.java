package com.infs3202.wfd.whatsfordinner;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import java.io.IOException;
import java.util.List;

import Main.HttpRequest;
import Main.RecipeClient;
import Main.RecipeMiniClient;
import Main.SearchResultsClient;
import Main.SearchTerms;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NavBaseActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnFragmentInteractionListener {
    private final String url = "https://infs32025eab4a09.uqcloud.net/"; // the base url for search
    public User user1;
    private String email;
    private String diet;
    private String allergies;
    private List<String> ingredients;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_base);

        email = getIntent().getStringExtra("email");
        diet = getIntent().getStringExtra("diet");
        allergies = getIntent().getStringExtra("allergies");

        user1 = new User();
        try {
            user1.setEmail(email);
            user1.setPassword(getIntent().getStringExtra("password"));

            for (String s : diet.split(",")) {
                user1.addDiet(s);
            }
            for (String s : allergies.split(",")) {
                user1.addAllergy(s);
            }
        } catch (NullPointerException e) {

            user1.setEmail("bloubulle@pretoria.co.za");
            user1.setPassword("Vic");
            user1.addAllergy("dairy");
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        displaySelectedScreen(R.id.nav_kitchen);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_base, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void displaySelectedScreen(int id){
        Fragment fragment = null;

        switch (id) {
            case R.id.nav_kitchen:
                fragment = new KitchenFragment();
                break;
            case R.id.nav_search:
                fragment = new SearchFragment();
                break;
            case R.id.nav_allergies:
                fragment = new AllergiesFragment();
                break;
            case R.id.nav_diet:
                fragment = new DietFragment();
                break;

        }

       /** if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.nav_content, fragment).commit();
        } **/

       if (fragment != null) {
           FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
           ft.replace(R.id.nav_content, fragment);
           ft.addToBackStack(null);
           ft.commit();
       }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        displaySelectedScreen(id);

        return true;
    }

    public User getUserDetails(){
        return user1;
    }

    // FRAGMENT SHENANIGANS

    /**
     *  Used to opem a new fragment based off the id provided.
     *
     * @param id String indicating which fragment is to replace the current
     */
    @Override
    public void changeFragment(String id){
        Fragment fragment = null;
        switch (id) {
            case "name":
                fragment = new NameSearchFragment();
                break;
            case "ingr":
                fragment = new IngrSearchFragment();
                break;
            case "ingrReturn":
                fragment = new IngrSearchFragment();
                break;
            case "ingrSearch":
                fragment = new IngrSearchResultsFragment();
                break;
            case "recipe":
                fragment = new RecipeFragment();
                break;
        }
        runReplaceTransaction(fragment);
    }

    /** Creates a transaction which replaces the current fragment and adds it to the back stack
     *  before committing it.
     *
     * @param newFragment This is the fragment that is used to replace the current fragment
     */
    public void runReplaceTransaction(Fragment newFragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.nav_content, newFragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public SearchResultsClient runNameSearch(TextInputEditText editText){
        String nameParam = editText.getText().toString();

        SearchTerms searchTerms = new SearchTerms();
        searchTerms.addKeywords(nameParam);

        for (String s : diet.split(",")){
            searchTerms.addDietReq(s);
        }
        for (String s : allergies.split(",")){
            searchTerms.addAllergies(s);
        }
        String data =  HttpRequest.getSearchResults(searchTerms.toString());
        SearchResultsClient results = null;
        try {
            results = new SearchResultsClient(data);
        } catch (Exception e) {
            Toast.makeText(this, "ERROR: Unable to retrieve search results.", Toast.LENGTH_SHORT).show();
        }

        return results;
    }




    public SearchResultsClient runIngrSearch(List<String> list){


        SearchTerms searchTerms = new SearchTerms();

        for (String s : diet.split(",")){
            searchTerms.addDietReq(s);
        }
        for (String s : allergies.split(",")){
            searchTerms.addAllergies(s);
        }
        for (String s : list){
            searchTerms.addIngredients(s);
        }
        String data =  HttpRequest.getSearchResults(searchTerms.toString());
        SearchResultsClient results = null;
        try {
            results = new SearchResultsClient(data);
        } catch (Exception e) {
            Toast.makeText(this, "ERROR: Unable to retrieve search results.", Toast.LENGTH_SHORT).show();
        }

        return results;
    }

    public List<String> getIngrList(){
        return ingredients;
    }

    public void setIngrList(List<String> list){
        ingredients = list;
    }

    public void recipePopulate (RecipeClient recipe) {

    }

    public void onClick(View view) {

    }




}
