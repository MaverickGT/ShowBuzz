package Controler;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

public class UserFunctions {

	
	private JSONParser jsonParser;

 
    private static String loginURL = "http://polisciuk.com/android_PHP_Database_ShowBuzz/";
 
    private static String checkLogin = "checkLogin";
  

    private static String register_tag = "register";
	
     
    // constructor
    public UserFunctions(){
        jsonParser = new JSONParser();
    }
    
    public JSONObject LoginConfirmation(String username, String password){
        // Building Parameters
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("tag", checkLogin));
        params.add(new BasicNameValuePair("success", "1"));
        params.add(new BasicNameValuePair("error", "0"));
        params.add(new BasicNameValuePair("username", username));
        params.add(new BasicNameValuePair("password", password));
        params.add(new BasicNameValuePair("results", "" ));
        
        JSONObject json = jsonParser.getJSONFromUrl(loginURL, params);
     
       
        return json;
    }
    
    public JSONObject RegisterAccount(String username, String password){
        // Building Parameters
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("tag", register_tag));
        params.add(new BasicNameValuePair("username", username));
        params.add(new BasicNameValuePair("password", password));
        params.add(new BasicNameValuePair("results", "" ));
        
        JSONObject json = jsonParser.getJSONFromUrl(loginURL, params);
     
       
        return json;
    }
    
}
