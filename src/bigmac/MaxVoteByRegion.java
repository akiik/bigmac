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
		  	    
		  	    float percent = maxVotes*100/totalVotes;
	  	    	Gson gson = new Gson();
	  	    	String json = gson.toJson(maxParty + ":" + percent);
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
