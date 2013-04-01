package bigmac;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

/**
 * Servlet implementation class DropVoteServlet
 */
@WebServlet("/dropvote")
public class DropVoteServlet extends HttpServlet {
	private int person = 4;
	private int vote = 18;
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DropVoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			
			String SQLStringVote = "SELECT vote FROM person WHERE id = " + person + ";";
			System.out.println(SQLStringVote);
			DB db = new DB();
			db.connect();
			Statement stat = db.getConnection().createStatement();
	        ResultSet resultSet = stat.executeQuery(SQLStringVote);
	        if (resultSet.next()) {
	        	vote = resultSet.getInt("vote");
	        }
			String SQLStringCandidate;
			String SQLStringVoter;
		    SQLStringCandidate = "UPDATE candidate SET votes = (votes-1) WHERE id = " + vote + ";";
		    SQLStringVoter = "UPDATE person SET vote = NULL WHERE id = " + person + ";";
		    System.out.println(SQLStringCandidate);
		    System.out.println(SQLStringVoter);
	        stat.executeUpdate(SQLStringCandidate);
	        stat.executeUpdate(SQLStringVoter);
	        db.disconnect();
	        
	        String success= "Sinu hääl on tühistatud!";
	        request.setAttribute("message", success);
	        request.getRequestDispatcher("/message.jsp").forward(request, response);
	        
			} catch (SQLException e){
				throw new RuntimeException("Statement execution failed miserably!", e);
			}
	}

}
