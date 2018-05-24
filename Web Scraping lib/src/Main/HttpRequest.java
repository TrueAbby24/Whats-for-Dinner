package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpRequest {
	
	// HTTP GET request
	private static String sendGet(String url) {
		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	
			// optional default is GET
			
			con.setRequestMethod("GET");
			
	//				System.out.println("URL: "+con.getURL());
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
	
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
	
	public String getRecipe(String id) {
		String url = "https://infs3202-5eab4a09.uqcloud.net/recipe.php?id="+id;
		return sendGet(url);
	}
	
	public String getSearchResults(String terms) {
		return terms;
		
	}
	
}
