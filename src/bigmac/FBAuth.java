package bigmac;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.visural.common.StringUtil;

@WebServlet("/fbauth")
public class FBAuth extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		
		HttpServletRequest req = (HttpServletRequest) request;
	    HttpServletResponse res = (HttpServletResponse) response;
	    
	    if (request.getParameter("code") != null) {
	    	System.out.println(request.getParameter("code"));
	    	String code = req.getParameter("code");
	        if (StringUtil.isNotBlankStr(code)) {
	            String authURL = Facebook.getAuthURL(code);
	            URL url = new URL(authURL);
	            try {
	                String result = readURL(url);
	                String accessToken = null;
	                Integer expires = null;
	                String[] pairs = result.split("&");
	                for (String pair : pairs) {
	                    String[] kv = pair.split("=");
	                    if (kv.length != 2) {
	                    	res.sendRedirect(Facebook.mainPage);
	                    	System.out.println("I don't like this number of pairs. I also don't like licorice.");
	                    } else {
	                        if (kv[0].equals("access_token")) {
	                            accessToken = kv[1];
	                        }
	                        if (kv[0].equals("expires")) {
	                            expires = Integer.valueOf(kv[1]);
	                        }
	                    }
	                }
	                if (accessToken != null && expires != null) {
	                    //UserService us = UserService.get();
	                    //us.authFacebookLogin(accessToken, expires);
	                    System.out.println("Access token: " + accessToken + ", expires: " + expires);
	                	res.sendRedirect(Facebook.mainPage);
	                } else {
	                    throw new RuntimeException("Access token and expires not found");
	                }
	            } catch (IOException e) {
	                throw new RuntimeException(e);
	            }
	        }       

	    }
	    System.out.println("Reached auth. No luck.");
    }

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    doGet(request, response);
	}
	
    private String readURL(URL url) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        InputStream is = url.openStream();
        int r;
        while ((r = is.read()) != -1) {
            baos.write(r);
        }
        return new String(baos.toByteArray());
    }

    public void destroy() {
    }
}
