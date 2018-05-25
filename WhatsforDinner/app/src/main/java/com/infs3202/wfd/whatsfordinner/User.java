package com.infs3202.wfd.whatsfordinner;

import java.util.ArrayList;

/**
 * Created by s4285131 on 24/05/2018.
*/

public class User {
    private String eMail;
    private ArrayList<String> diets;
    private ArrayList<String> allergies;
    private String otherAllergy;
    private String otherDietReq;
    private String password;



    public void User(){
       diets = new ArrayList();
       allergies = new ArrayList();
       otherAllergy = "";
       otherDietReq = "";
//    diets.put("@string/d_vege", false);
//    diets.put("@string/d_pesce", false);
//    diets.put("@string/d_vegan", false);
//    diets.put("@string/d_gluten", false);
//    diets.put("@string/d_lactose", false);
//
//    allergies.put("@string/a_milk", false);
//    allergies.put("@string/a_peanuts", false);
//    allergies.put("@string/a_tree_nuts", false);
//    allergies.put("@string/a_eggs", false);
//    allergies.put("@string/a_soy", false);
//    allergies.put("@string/a_fish", false);
//    allergies.put("@string/a_shellfish", false);
//    allergies.put("@string/a_wheat", false);
//        diets.put("Vegetarian", false);
//        diets.put("Pesecetarian", false);
//        diets.put("Vegan", false);
//        diets.put("Gluten Free", false);
//        diets.put("Lactose Intolerant", false);
//
//        allergies.put("Milk", false);
//        allergies.put("Peanuts", false);
//        allergies.put("Tree Nuts", false);
//        allergies.put("Eggs", false);
//        allergies.put("Soy", false);
//        allergies.put("Fish", false);
//        allergies.put("Shellfish", false);
//        allergies.put("Wheat", false);
    }

    public void setEmail(String email) {
        this.eMail = email;
    }

    public String geteMail () {
        return eMail;
    }

   public String[] getDiet () {
        String[]  result = new String[diets.size()];
        for (int i = 0; i < diets.size(); i++){
            result[i] = diets.get(i);
        }
        return result;
   }

    public String getAllergy() {
        String res = "";
        for (int i = 0; i < allergies.size(); i++){
            if (i == 0)
                res = allergies.get(i);
            else
                res += ","+allergies.get(i);
        }
        return res;
    }

    public void addAllergy(String s) {
        allergies.add(s);
    }

    public void addDiet (String s) {
        diets.add(s);
    }

    public void setOtherAllergy(String allergy) {
        this.otherAllergy = allergy;
    }

    public void setOtherDietReq (String dietReq) {
        this.otherDietReq = dietReq;
    }

    public String getOtherAllergy() {
        return otherAllergy;
    }
    public String getOtherDietReq() {
        return otherDietReq;
    }
    public String getPassword() {return password;}
    public  void setPassword(String pass) {
        password = pass;
    }



}


