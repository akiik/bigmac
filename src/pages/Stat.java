package pages;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Candidate;
import data.Party;
import data.Person;
import data.Region;

import bigmac.DB;

/**
 * Servlet implementation class Stat
 */
@WebServlet("/stats")
public class Stat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Stat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		java.util.List<Candidate> candidates = new ArrayList<Candidate>();
		
	    DB db = new DB();
	    db.connect();
        String sql= "SELECT * FROM candidate AS ca" +
        		" JOIN party AS pa ON pa.id=ca.party" +
        		" JOIN person AS pe ON pe.id=ca.person" +
        		" JOIN region AS re ON re.id=ca.region;";
		try {
			Statement statement = db.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(sql);	    
		    while (resultSet.next()) {
    	    	Candidate kandidaat = new Candidate(
    	    			resultSet.getInt("ca.id"),
    	    			new Person(resultSet.getInt("ca.person"),resultSet.getString("pe.name")),
    	    			new Party(resultSet.getString("ca.party"),resultSet.getString("pa.name")),
    	    			new Region(resultSet.getString("ca.region"),resultSet.getString("re.name")) 	    			
	    			);
    	    	kandidaat.setVotes(resultSet.getInt("ca.votes"));
    	    	candidates.add(kandidaat);
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
				
	    db.disconnect();
	    
	    

        request.setAttribute("candidates", candidates); // This will be available as ${candidates}

		
		// TODO Auto-generated method stub
		// SIIA ANDMETE PÄRGING JA SIIS EDASI stat.jsp lehele
		// VAATA vote.java 
		 request.getRequestDispatcher("/stat.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
