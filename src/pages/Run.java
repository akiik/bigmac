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

import data.Party;
import data.Region;

import bigmac.DB;

/**
 * Servlet implementation class Run
 */
@WebServlet("/run")
public class Run extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Run() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		java.util.List<Party> partys = new ArrayList<Party>();
		java.util.List<Region> regions = new ArrayList<Region>();
		
	    DB db = new DB();
	    db.connect();
	    String sql= "SELECT id,name FROM party";
		try {
			Statement statement = db.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(sql);	    
		    while (resultSet.next()) {
		      partys.add(new Party(resultSet.getString("id"),resultSet.getString("name")));
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	    sql= "SELECT id,name FROM region";
		try {
			Statement statement = db.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(sql);	    
		    while (resultSet.next()) {
		      regions.add(new Region(resultSet.getString("id"),resultSet.getString("name")));
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
	    db.disconnect();

        request.setAttribute("partys", partys); // This will be available as ${message}
        request.setAttribute("regions", regions);
        request.getRequestDispatcher("/run.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
