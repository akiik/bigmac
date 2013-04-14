package bigmac;

import java.io.*;
import java.net.URL;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.visural.common.StringUtil;

@WebServlet("/fbauth")
public class FBOAuth implements Filter {

    public void init(FilterConfig fc) throws ServletException {
    }

    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)sr;
        HttpServletResponse res = (HttpServletResponse)sr1;
        String code = sr.getParameter("code");
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
                        throw new RuntimeException("Unexpected auth response");
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
                	res.sendRedirect("http://ec2-23-21-6-189.compute-1.amazonaws.com:8080/bigmac");
                } else {
                    throw new RuntimeException("Access token and expires not found");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }       
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