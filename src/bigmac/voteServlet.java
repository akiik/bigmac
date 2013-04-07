package bigmac;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class voteServlet
 */
@WebServlet("/dovote")
public class voteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public voteServlet() {
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
	   @Override
	   public void doPost(HttpServletRequest request, HttpServletResponse response)
	               throws IOException, ServletException {
	      // Set the response message's MIME type
	      response.setContentType("text/html; charset=UTF-8");
	      
	      try {
	         // Prepare the values
	         String SQLString;
	    	  
	    	 String person = request.getParameter("id");
	         if (person != null){
	        	 int id = Integer.parseInt(person);
		         DB db = new DB();
		         db.connect();
		         
		         SQLString = "UPDATE candidate SET votes = (votes + 1) WHERE id='"+id+"';";
		         System.out.println(SQLString);
		         Statement stat = db.getConnection().createStatement();
		         stat.executeUpdate(SQLString);
		         SQLString = " UPDATE person SET vote = '"+id+"' WHERE id='16';";
		         stat.executeUpdate(SQLString);
		        db.disconnect();
		        String success= "Olete edukalt oma hääle andnud, Teie hääl loeb!";
		        request.setAttribute("message", success);
		        request.getRequestDispatcher("/message.jsp").forward(request, response);
	         }
	      } catch (SQLException e) {
	    	  throw new RuntimeException("Statement execution failed miserably!", e);
	      }

	   }

}
