package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpRequest {
	
	/**
	 * Sends a get request to server with given url.
	 * @param url
	 * @return
	 */
	private static String sendGet(String url) {
		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			if( con.getResponseCode() != HttpURLConnection.HTTP_OK)
				return "{}";
//			System.out.println("\nSending 'GET' request to URL : " + url);
//			System.out.println("Response Code : " + responseCode);
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			if(response.toString() == null) 
				return "{}";
			return response.toString();
		} catch (Exception e) {
			return "{}";
		}

	}
	
	/**
	 * Constructs a get request to server and retrieves results of a specific recipe.
	 * @param id
	 * @return
	 */
	public static String getRecipe(String id) {
		return sendGet("https://infs3202-5eab4a09.uqcloud.net/recipe.php?id="+id);
	}
	
	public static String getSearchResults(String terms) {
		return sendGet("https://infs3202-5eab4a09.uqcloud.net/search.php?terms="+terms);
		
	}
	
}
