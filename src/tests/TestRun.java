package tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bigmac.DB;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;


public class TestRun {

	private Selenium selenium;
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/");
		selenium.start();
		
		//testkasutajaks on isik id'ga 16, see on hardcodetud servletis PostCandidateServlet,
		//kuna see on ühtlasi ka ainus süsteemi kasutaja (kuna autentimissüsteem puudub)
		//siis seame andmebaasi algseisu ka enne testide käivitamist(ehk kustutame isiku kandidaatide tabelist)
		
		DB db = new DB();
		db.connect();
		String sql= "DELETE FROM candidate WHERE person='16';";
		System.out.println(sql);
	  	try {
	  		Statement statement = db.getConnection().createStatement();
	  		statement.executeUpdate(sql);	      		
	  	} catch (SQLException e) {
	  		e.printStackTrace();
	  	}
	    db.disconnect();		
	}
	
	@Test
	public void testRun() throws Exception {

		selenium.open("/bigmac");
		selenium.waitForPageToLoad("30000");		
		selenium.click("link=Kandideeri");
		selenium.waitForPageToLoad("30000");
		selenium.select("name=erakonnad","value=AAE");
		selenium.select("name=piirkond","value=HR");
		selenium.select("name=haridus","value=korg");
		selenium.type("//input[@type='text' and @value='Sisesta tegevusala']", "Raamatupidaja");
		selenium.click("//input[@type='submit' and @value='Kandideeri!']");
		selenium.waitForPageToLoad("30000");
		//kontollime, kas kasutaja suunati õigele lehele.
		assertTrue(selenium.isTextPresent("Olete edukalt kandidaadiks lisatud!"));
		
		//kontrollime, kas muudatused on toimunud ka andmebaasi tasandil.
		DB db = new DB();
		db.connect();
		String sql= "SELECT * FROM candidate WHERE person='16' AND party = 'AAE' AND region = 'HR';";
		System.out.println(sql);
	  	try {
	  		Statement statement = db.getConnection().createStatement();
	  		ResultSet resultSet = statement.executeQuery(sql);	    
	  		assertTrue(resultSet.next());
	  	} catch (SQLException e) {
	  		e.printStackTrace();
	  	}
	    db.disconnect();
		
	}

	@After
	public void tearDown() throws Exception {
		// kustutame isiku kandidaatide tabelist 
		DB db = new DB();
		db.connect();
	  	try {
	  		Statement statement = db.getConnection().createStatement();
	  		statement.executeUpdate("DELETE FROM candidate WHERE person='16';");	 
	  	} catch (SQLException e) {
	  		e.printStackTrace();
	  	}
	  	db.disconnect();
		selenium.stop();
	}
}
