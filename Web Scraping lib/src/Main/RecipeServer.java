package Main;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sun.org.apache.xalan.internal.xsltc.dom.ArrayNodeListIterator;

public class RecipeServer {
	private String recipeID ;
	private final static String BASE_RECIPE_URL = 
			"https://www.allrecipes.com/recipe/";
	private String cookingTime;
	private String servingSize;
	private String name; 
	private String calories;
	private ArrayList<String> ingredients;
	private ArrayList<String> method;
//	private JSONArray ingredients2;
//	private JSONArray method2;
	public RecipeServer (String id) throws IOException { 
		this.recipeID = id;		
		findDetails();
	}
	
	public void findDetails() throws IOException{
		String buffer = BASE_RECIPE_URL + recipeID;
		final Document doc = Jsoup.connect(buffer).get();
		cookingTime = doc.select("span.ready-in-time").text();
		servingSize = doc.select("#metaRecipeServings").attr("content");
		calories = doc.select(".calorie-count span:first-child").text();
		ingredients = new ArrayList<>();
		for (Element ingredientItem : doc.select("ul#lst_ingredients_1 li")){
			buffer = ingredientItem.select("label").attr("title");
			if (!buffer.equals("")){
				ingredients.add(buffer);
			}
		}
		for (Element ingredientItem : doc.select("ul#lst_ingredients_2 li")){
			buffer = ingredientItem.select("label").attr("title");
			if (!buffer.equals("")){
				ingredients.add(buffer);
			}
		}	
		
		method = new ArrayList<>();
		for (Element step : doc.select("ol.list-numbers.recipe-directions__list "
				+ "li.step") ){			
			buffer = step.select("span.recipe-directions__list--item").text();
			if(!buffer.equals("")){
				method.add(buffer);
			}
		}		
	}
	
	public String getJSON() {
		JSONObject result = new JSONObject();
		result.put("cookingTime", cookingTime);
		result.put("servingSize", servingSize);
		result.put("name", name);
		result.put("calories", calories);
		result.put("ingredients", ingredients);
		result.put("method", method);
		return result.toJSONString();
	}
	
	
}


