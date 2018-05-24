import java.util.HashMap;

/**
 * Created by s4285131 on 24/05/2018.
 */

public class User {
    private String eMail;
    private HashMap<String, Boolean> diets = new HashMap();
    private HashMap<String, Boolean> allergies = new HashMap();
    private String otherAllergy = "";
    private String otherDietReq = "";



    public void User(String email){
        eMail = email;
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
        diets.put("Vegetarian", false);
        diets.put("Pesecetarian", false);
        diets.put("Vegan", false);
        diets.put("Gluten Free", false);
        diets.put("Lactose Intolerant", false);

        allergies.put("Milk", false);
        allergies.put("Peanuts", false);
        allergies.put("Tree Nuts", false);
        allergies.put("Eggs", false);
        allergies.put("Soy", false);
        allergies.put("Fish", false);
        allergies.put("Shellfish", false);
        allergies.put("Wheat", false);
    }

    public boolean getAllergy(String id) {
        return allergies.get(id);
    }

    public void changeAllergy(String id, Boolean value) {
        allergies.put(id,value);
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

    public String getOtherDietReq () {
        return otherDietReq;
    }


}


