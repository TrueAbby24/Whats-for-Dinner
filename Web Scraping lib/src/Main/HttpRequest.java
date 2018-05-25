package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class HttpRequest {
	private final static String BASE_URL = "https://infs3202-5eab4a09.uqcloud.net/";
	
	
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

	private static String sendPost(String url, String params) {
//		URL obj = new URL("https://infs3202-5eab4a09.uqcloud.net/testStuff/post.php");
//		URL obj = new URL("https://infs3202-5eab4a09.uqcloud.net/rego.php");
		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("POST");
			con.setDoOutput(true);
			OutputStream os = con.getOutputStream();
	//		os.write("email=bloubulle@pretoria.co.za&name=Vic".getBytes());
//			os.write("email=456rftyjhbn&password=siddy".getBytes());
			os.write(params.getBytes());
			os.flush();	
			os.close();
			int responseCode = con.getResponseCode();
			System.out.println("POST Response Code: " + responseCode);
	
			if (responseCode == HttpURLConnection.HTTP_OK) { //success
				BufferedReader in = new BufferedReader(new InputStreamReader(
						con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				return response.toString();
			} else {

				return "{\"success\":false}";
			}
		}catch (Exception e) {
			return "{\"success\":false}";
		}
		
	}
	
	/**
	 * Constructs a get request to server and retrieves results of a specific recipe.
	 * @param id
	 * @return
	 */
	public static String getRecipe(String id) {
		return sendGet(BASE_URL+"recipe.php?id="+id);
	}
	
	/**
	 * Constructs a get request from users search terms and returns results
	 * @param terms	search terms
	 * @return
	 */
	public static String getSearchResults(String terms) {
		return sendGet(BASE_URL+"search.php?terms="+terms);		
	}
	
	private static boolean getSuccess (String json) {
		try {
			JSONParser parse = new JSONParser();
			JSONObject jobj = (JSONObject) parse.parse(json);
			return (boolean) jobj.get("success");
		} catch (Exception e) {
			return false;
		}
		
	}
	
	
	public static boolean register(String email, String password, String diet) {
		String params = "email="+email+"&password="+password+"&diet="+diet; 
		return getSuccess(sendPost(BASE_URL + "rego.php", params));
	}
	
	public static boolean tryLogin(String email, String password) {
		String params = "email="+email+"&password="+password; 
		return getSuccess(sendPost(BASE_URL + "login.php", params));
	}
	
}
