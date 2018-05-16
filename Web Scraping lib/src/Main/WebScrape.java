package Main;

import java.io.IOException;

import javax.print.DocFlavor.STRING;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.sun.xml.internal.bind.v2.model.util.ArrayInfoUtil;

public class WebScrape {



	private static void imdbExample() throws IOException{
		final Document doc = Jsoup.connect("https://www.imdb.com/chart/top").get();
		
		for (Element row : doc.select("table.chart.full-width tr")){
			final String title = row.select(".titleColumn a").text();
			final String rating = row.select(".imdbRating").text();
			System.out.println(title + "--> Rating: " + rating);
			
		}
	}
	
	private static void firstTry() throws Exception{
		final String recipeBaseUrl = "https://www.allrecipes.com/recipe/";
		String url = "https://www.allrecipes.com/search/?wt=chocolate&ingIncl=nut";
		final Document doc = Jsoup.connect(url).get();
//		System.out.println(doc);
		int i = 0;
		for (Element recipeCard : doc.select("#fixedGridSection article.fixed-recipe-card")){
			i++;
			String title = recipeCard.select(".fixed-recipe-card__info h3").text();
			String blurb = recipeCard.select(".fixed-recipe-card__info .fixed-recipe-card__description").text();
			String imgUrl = recipeCard.select("img.fixed-recipe-card__img").attr("data-original-src");
			String recipeUrl = recipeCard.select("h3+a").attr("href");
			String id = recipeUrl.substring(recipeBaseUrl.length());
			id = id.substring(0,id.indexOf('/'));
			
			System.out.format("%d-->%s(%s)\n",i,title,id);
			System.out.println("    "+ blurb);
			System.out.println("    img: "+ imgUrl);
			System.out.println("    recipe source: " + recipeUrl);
		}
//		System.out.println("TOTAL: " + i);
	}
	
	public static void main(String[] args) throws Exception {
//		imdbExample();
//		firstTry();
//		JSONObject test = new JSONObject();	
//		JSONArray arrayBuff = new JSONArray();	
//		test.put("preferences", arrayBuff);
//		arrayBuff = new JSONArray();
//		arrayBuff.add("vegan");		
//		test.put("dietary_req", arrayBuff);
//		arrayBuff = new JSONArray();
//		arrayBuff.add("nuts");
//		arrayBuff.add("fish");
//		test.put("allergies", arrayBuff);
//		arrayBuff = new JSONArray();
//		arrayBuff.add("white chocolate");
//		test.put("keywords", arrayBuff);	
//		arrayBuff = new JSONArray();
//		arrayBuff.add("flour");
//		arrayBuff.add("egg");
//		test.put("ingredients", arrayBuff);
//		System.out.println(test);
//		SearchServer s = new SearchServer(test.toString());
//		System.out.println(s.getResults());
//		RecipeServer r = new RecipeServer("257193");
//		System.out.println(r.getJSON());
		SearchTerms x = new SearchTerms();
		x.addPrefrence("pizza");
		x.addPrefrence("italian");
		System.out.println("before: " + x.toString());
		x.removePrefrence("pizza");
		System.out.println("after: " + x.toString());
		
		
	}
}
