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

/**
 * Servlet implementation class CandidateByNameServlet
 */
@WebServlet("/candidate/name/*")
public class CandidateByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidateByNameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
  	  	String[] pathInfo = request.getPathInfo().split("/");
        String name = pathInfo[1]; // {name}

        DB db = new DB();
        db.connect();
        String sql= "SELECT * FROM candidate AS ca" +
        		" JOIN party AS pa ON pa.id=ca.party" +
        		" JOIN person AS pe ON pe.id=ca.person" +
        		" JOIN region AS re ON re.id=ca.region" +
        		"  WHERE pe.name COLLATE UTF8_GENERAL_CI LIKE '"+name+"';";
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
