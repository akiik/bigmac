package bigmac;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import data.Candidate;
import data.Party;
import data.Person;
import data.Region;
/*
 * 
 * Servlet that serves candidate's data according to id
 * We do not use url parameters (like /candidate?id=12) cause the REST style communicating requirement 
 * 
 * 
 */
@WebServlet("/candidate/*") 
public class CandidateServlet extends HttpServlet {
      @Override
      public void doGet(HttpServletRequest request,
                        HttpServletResponse response)
          throws ServletException, IOException {
          response.setContentType("application/json");
          response.setCharacterEncoding("UTF-8");
    	  PrintWriter out = response.getWriter();
    	  String[] pathInfo = request.getPathInfo().split("/");
          String id = pathInfo[1]; // {id}
          if(isValidID(id)){     	  
		        DB db = new DB();
		        db.connect();
		        String sql= "SELECT * FROM candidate AS ca" +
		        		" JOIN party AS pa ON pa.id=ca.party" +
		        		" JOIN person AS pe ON pe.id=ca.person" +
		        		" JOIN region AS re ON re.id=ca.region" +
		        		"  WHERE ca.id="+id+";";
		        System.out.println(sql);
		    	try {
		    		Statement statement = db.getConnection().createStatement();
		    		ResultSet resultSet = statement.executeQuery(sql);	    
		    	    if (resultSet.next()) {
		    	    	Candidate kandidaat = new Candidate(
		    	    			resultSet.getInt("ca.id"),
		    	    			new Person(resultSet.getInt("ca.person"),resultSet.getString("pe.name")),
		    	    			new Party(resultSet.getString("ca.party"),resultSet.getString("pa.name")),
		    	    			new Region(resultSet.getString("ca.region"),resultSet.getString("re.name"))
	    	    			);
		    	    	Gson gson = new Gson();
		    	    	String json = gson.toJson(kandidaat);
		    	    	out.println(json); 
		    	    }
		    	} catch (SQLException e) {
		    		e.printStackTrace();
		    	}
		        db.disconnect();
          }
          else {
        	  out.println("INVALID ID!");
          }
      }
      
      static boolean isValidID(String id){
    	     try
    	     {
    	        Integer.parseInt( id );
    	        return true;
    	     }
    	     catch( Exception e )
    	     {
    	    	 return false;
    	     }
    	     

      }
      
      
}
