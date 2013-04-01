package bigmac;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import data.Candidate;
import data.Candidates;
import data.Party;
import data.Person;
import data.Region;

/**
 * Servlet implementation class AutoComplete
 */
@WebServlet("/autocomplete")
public class AutoComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoComplete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		java.util.List<String> candidates= new ArrayList<String>();
		PrintWriter out = response.getWriter();
		String q=request.getParameter("foo");
		
		DB db = new DB();
        db.connect();
        String sql= "SELECT * FROM candidate AS ca" +
        		" JOIN person AS pe ON pe.id=ca.person" +
        		"  WHERE pe.name COLLATE UTF8_GENERAL_CI LIKE '"+q+"%';";
        System.out.println(sql);
    	try {
    		Statement statement = db.getConnection().createStatement();
	  		ResultSet resultSet = statement.executeQuery(sql);	    
	  	    while (resultSet.next()) {
	  	    			candidates.add(resultSet.getString("pe.name"));
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
