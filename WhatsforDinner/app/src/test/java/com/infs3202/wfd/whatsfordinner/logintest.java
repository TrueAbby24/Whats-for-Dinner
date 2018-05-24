

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by s4463389 on 24/05/2018.
 */

package com.infs3202.wfd.whatsfordinner;

public class registertest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "https://infs3202-5eab4a09.uqcloud.net/register.php"; //Link to php file on server handling login requests
    private Map<String, String> params;


    public registertest(String email, String password, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}

public static void main(){
    registertest rt1 = new registertest("test@email.com","password1",Response.Listener<String> listener);


    @Override
    public Map<String, String> getParams() {
        return params;
    }
}