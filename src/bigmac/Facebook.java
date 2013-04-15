package bigmac;


public class Facebook {
	
	// constructor
	public Facebook() {}
	
    // get these from your FB Dev App
    private static final String api_key = "245026645637413";     
    private static final String secret = "7e87440202521733c58418e3794060bb";
    private static final String client_id = "245026645637413";  
    
    public static final String mainPage = "http://ec2-23-21-6-189.compute-1.amazonaws.com:8080/bigmac";
    // set this to your servlet URL for the authentication servlet/filter
    private static final String redirect_uri = "http://ec2-23-21-6-189.compute-1.amazonaws.com:8080/bigmac/fbauth/"; 

    public static String getAPIKey() {
        return api_key;
    }

    public static String getSecret() {
        return secret;
    }

    public static String getLoginRedirectURL() {
        return "https://graph.facebook.com/oauth/authorize?client_id=" + 
            client_id + "&display=page&redirect_uri=" + redirect_uri;
    }

    public static String getAuthURL(String authCode) {
        return "https://graph.facebook.com/oauth/access_token?client_id=" + 
            client_id+"&redirect_uri=" + 
            redirect_uri+"&client_secret="+secret+"&code="+authCode;
    }
}
