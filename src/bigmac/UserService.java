package bigmac;

import java.net.URL;

import com.visural.common.IOUtil;

class UserService {

    // ....

    public void authFacebookLogin(String accessToken, int expires) {
        try {
            /*JSONObject resp = new JSONObject(
                IOUtil.urlToString(new URL("https://graph.facebook.com/me?access_token=" + accessToken)));
            String id = resp.getString("id");
            String firstName = resp.getString("first_name");
            String lastName = resp.getString("last_name");
            String email = resp.getString("email");
			*/
            // ...
            // create and authorise the user in your current system w/ data above
            // ...

        } catch (Throwable ex) {
            throw new RuntimeException("failed login", ex);
        }
    }
}
