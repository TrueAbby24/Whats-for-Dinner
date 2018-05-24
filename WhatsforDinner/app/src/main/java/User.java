import java.util.HashMap;

/**
 * Created by s4285131 on 24/05/2018.
 */

public class User {
    String eMail;
    HashMap<String, Boolean> diets = new HashMap();
    HashMap<String, Boolean> allergies = new HashMap();


    public void User(String email){

        eMail = email;

        diets.put("@string/d_vege", false);
        diets.put("@string/d_pesce", false);
        diets.put("@string/d_vegan", false);
        diets.put("@string/d_gluten", false);
        diets.put("@string/d_lactose", false);

        allergies.put("@string/a_milk", false);
        allergies.put("@string/a_peanuts", false);
        allergies.put("@string/a_tree_nuts", false);
        allergies.put("@string/a_eggs", false);
        allergies.put("@string/a_soy", false);
        allergies.put("@string/a_fish", false);
        allergies.put("@string/a_shellfish", false);
        allergies.put("@string/a_wheat", false);
    }


}


