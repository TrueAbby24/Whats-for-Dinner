package Main;

import java.io.IOException;
import java.util.ArrayList;

import javax.print.DocFlavor.STRING;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

//import com.sun.xml.internal.bind.v2.model.util.ArrayInfoUtil;

public class WebScrape {
	private static final String POST_PARAMS = "userName=Pankaj";
	
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
	
	private static void originalLibFunctionality() {
//		SEARCH		
//		SearchServer s = new SearchServer(terms.toString());
//		System.out.println("(S) Search results:");
//		System.out.println(s.getResults());
//		SEARCH RESULTS BREAK UP
//		SearchResultsClient sr = new SearchResultsClient(s.getResults());
//		**GET RECIPE RESULTS ONE AT A TIME
//		RecipeMiniClient rm = sr.getRecipeMini();
//		int i = 0;
//		while(rm != null) {
//			System.out.println((++i) + "--"+rm.getTitle());
//			rm = sr.getRecipeMini();
//		}
//		JSONObject recipeID = new JSONObject();
		
		
//		RecipeServer r = new RecipeServer("257193");
//		System.out.println(r.getJSON());
//		RecipeClient rc = new RecipeClient(r.getJSON());
//		String buffer = rc.getNextStep();
//		i = 1;
//		System.out.println("--STEPS:");
//		while (buffer != null){
//			System.out.println(i++ + ".) " + buffer);
//			buffer = rc.getNextStep();
//		}
//		System.out.println("--METHOD--");
//		i = 0;
//		for (String x : rc.getMethodList()) {
//			i++;
//			System.out.println(i+"-->"+x);
//		}
		
	}
	
	private static void testHttpRequest() {
		//		SEARCH TERMS
		SearchTerms terms = new SearchTerms();
		terms.addDietReq("vegan");
		terms.addAllergies("nuts");
		terms.addAllergies("nuts");
		terms.addKeywords("white chocolate");
		terms.addIngredients("flour");
		terms.addIngredients("egg");
		System.out.println("(C) search terms:");
		System.out.println(terms.toString());
		System.out.println(HttpRequest.getSearchResults(terms.toString()));
		System.out.println(HttpRequest.getRecipe("257193"));

	}
	private static void sendPOST() throws IOException {
//		URL obj = new URL("https://infs3202-5eab4a09.uqcloud.net/testStuff/post.php");
		URL obj = new URL("https://infs3202-5eab4a09.uqcloud.net/rego.php");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");

		// For POST only - START
		con.setDoOutput(true);
		OutputStream os = con.getOutputStream();
//		os.write("email=bloubulle@pretoria.co.za&name=Vic".getBytes());
		os.write("email=456rftyjhbn&password=siddy".getBytes());
		os.flush();	
		os.close();
		// For POST only - END
		int responseCode = con.getResponseCode();
		System.out.println("POST Response Code: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { //success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
//				response.append(inputLine);
				System.out.println(inputLine);
			}
			in.close();
			// print result
//			System.out.println(response.toString());
		} else {
			System.out.println("POST request not worked");
		}
	}
	
	public static void main(String[] args) throws Exception {
//		imdbExample();
//		firstTry();
//		originalLibFunctionality();
//		testHttpRequest();
//		sendPOST();email=456rftyjhbn&password=siddy
		System.out.println(HttpRequest.tryLogin("sid@gmail.com", "siddy"));
		
	}
}
