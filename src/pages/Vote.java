package pages;

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

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import bigmac.DB;

/**
 * Servlet implementation class 
 */
@WebServlet("/vote")
public class Vote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vote() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
		
		java.util.List<String> partys = new ArrayList<String>();
		java.util.List<String> regions = new ArrayList<String>();
		
	    DB db = new DB();
	    db.connect();
	    String sql= "SELECT name FROM party";
		try {
			Statement statement = db.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(sql);	    
		    while (resultSet.next()) {
		      partys.add(resultSet.getString("name"));
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	    sql= "SELECT name FROM region";
		try {
			Statement statement = db.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(sql);	    
		    while (resultSet.next()) {
		      regions.add(resultSet.getString("name"));
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
	    db.disconnect();

        request.setAttribute("partys", partys); // This will be available as ${message}
        request.setAttribute("regions", regions);
        request.getRequestDispatcher("/vote.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
