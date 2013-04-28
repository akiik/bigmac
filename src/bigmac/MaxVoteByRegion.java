package bigmac;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import data.Candidate;
import data.Candidates;
import data.Person;
import data.Region;
import data.Leader;

/**
 * Servlet implementation class MaxVoteByRegion
 */
@WebServlet("/maxvote")
public class MaxVoteByRegion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaxVoteByRegion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maxParty = "";
		int maxVotes = 0;
		int votes = 0;
		int totalVotes = 0;
		
		String region = request.getParameter("region");
	      response.setContentType("application/json");
	      response.setCharacterEncoding("UTF-8");
	      PrintWriter out = response.getWriter();
	      
		      DB db = new DB();
		      db.connect();
		      String sql= "SELECT party, SUM(votes) AS  'Total' FROM candidate " + 
		    		  "WHERE REGION = '" + region + "' " + 
		    		  "GROUP BY Party";
		      System.out.println(sql);
		  	try {
		  		Statement statement = db.getConnection().createStatement();
		  		ResultSet resultSet = statement.executeQuery(sql);	    
		  	    while (resultSet.next()) {
		  	    	votes = resultSet.getInt("Total");
		  	    	totalVotes += votes;
		  	    	if (votes > maxVotes) {
		  	    		maxVotes = votes;
		  	    		maxParty = resultSet.getString("Party");
		  	    	}
		  	    }
		  	    float percent;
		  	    if (totalVotes == 0) {
		  	    	percent = 0;
		  	    	maxParty = "Hääled puuduvad";
		  	    }
		  	    else percent = maxVotes*100/totalVotes;
		  	    
		  	    if (maxParty.equals("AAE")) maxParty = "Anonüümsete Aneemikute Erakond";
		  	    if (maxParty.equals("EKE")) maxParty = "Eesti Konservierakond";
		  	    if (maxParty.equals("KRE")) maxParty = "Koondatud Reisisaatjate Erakond";
		  	    if (maxParty.equals("KOE")) maxParty = "Korruptsioonierakond";
		  	    if (maxParty.equals("OVP")) maxParty = "Ootamatu Vastupanu Erakond";
		  	    
		  	    Leader leader = new Leader(maxParty, percent);
	  	    	Gson gson = new Gson();
	  	    	String json = gson.toJson(leader);
	  	    	out.println(json);
		  	} catch (SQLException e) {
		  		e.printStackTrace();
		  	}
		      db.disconnect();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
