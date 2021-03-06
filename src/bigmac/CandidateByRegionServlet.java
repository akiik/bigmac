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
import com.google.gson.JsonElement;

import data.Candidate;
import data.Candidates;
import data.Party;
import data.Person;
import data.Region;

/**
 * Servlet implementation class CandidateByRegionServlet
 */
@WebServlet("/candidates/region/*")
public class CandidateByRegionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidateByRegionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  	  String[] pathInfo = request.getPathInfo().split("/");
      String regionName = pathInfo[1]; // {Regiooni nimi}
      Candidates candidates = new Candidates( new ArrayList<Candidate>() );
      response.setContentType("application/json");
      response.setCharacterEncoding("UTF-8");
      PrintWriter out = response.getWriter();
      
	      DB db = new DB();
	      db.connect();
	      String sql= "SELECT * FROM candidate AS ca" +
	      		" JOIN party AS pa ON pa.id=ca.party" +
	      		" JOIN person AS pe ON pe.id=ca.person" +
	      		" JOIN region AS re ON re.id=ca.region" +
	      		"  WHERE re.name='"+regionName+"';";
	      System.out.println(sql);
	  	try {
	  		Statement statement = db.getConnection().createStatement();
	  		ResultSet resultSet = statement.executeQuery(sql);	    
	  	    while (resultSet.next()) {
	  	    			candidates.getCandidates().add(new Candidate(
		  	    			resultSet.getInt("ca.id"),
		  	    			new Person(resultSet.getInt("ca.person"),resultSet.getString("pe.name")),
		  	    			new Party(resultSet.getString("ca.party"),resultSet.getString("pa.name")),
		  	    			null
		    			));
	  	    }
  	    	Gson gson = new Gson();
  	    	
  	    	String json = gson.toJson(candidates);
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
