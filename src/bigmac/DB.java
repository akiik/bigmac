package bigmac;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DB {
    String url = "jdbc:mysql://localhost:3306/elections";
    String username = "root";
    String password = "";
    private Connection connection = null;

    public DB(){
    	try {
	        System.out.println("Loading driver...");
	        Class.forName("com.mysql.jdbc.Driver");
	        System.out.println("Driver loaded!");
	    } catch (ClassNotFoundException e) {
	        throw new RuntimeException("Cannot find the driver in the classpath!", e);
	    }
    }
    public void connect(){
	    try {
	        System.out.println("Connecting database...");
	        setConnection(DriverManager.getConnection(url, username, password));
	        System.out.println("Database connected!");	           
	    } catch (SQLException e) {
	        throw new RuntimeException("Cannot connect the database!", e);
	    } 
    }
	public void disconnect(){
		 System.out.println("Closing the connection.");
		 if (getConnection() != null) try { getConnection().close(); } catch (SQLException ignore) {}
	}
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	} 	


}
