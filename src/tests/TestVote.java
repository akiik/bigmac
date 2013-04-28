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

public class TestVote {

	private Selenium selenium;
	private int votesBefore;
	private int votesAfter;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/");
		selenium.start();
		//testkasutaja on id'ga 16 ja kandidaat, kellele hääl antakse on id'ga 27;
		//võtame andmebaasist kandidaadi algse häältearvu;
		DB db = new DB();
		db.connect();
		String sql= "SELECT votes FROM candidate WHERE id='27';";
		System.out.println(sql);
	  	try {
	  		Statement statement = db.getConnection().createStatement();
	  		ResultSet resultSet = statement.executeQuery(sql);	    
	  		if (resultSet.next()) {
	  	    			votesBefore= resultSet.getInt("votes");
	  		}
	  		
	  	} catch (SQLException e) {
	  		e.printStackTrace();
	  	}
	    db.disconnect();
	}
	
	
	@Test
	public void testVote() throws Exception {
	
		selenium.open("/bigmac");
		selenium.waitForPageToLoad("30000");		
		selenium.click("link=Hääleta");
		selenium.waitForPageToLoad("30000");
		selenium.select("name=erakond","value=Eesti Konservierakond");
		selenium.select("name=piirkond","value=Harjumaa");
		selenium.select("name=candidates","value=27");
		selenium.click("//input[@type='submit' and @value='Hääleta']");
		selenium.waitForPageToLoad("30000");
		//kontollime, kas kasutaja suunati õigele lehele.
		assertTrue(selenium.isTextPresent("Olete edukalt oma hääle andnud"));
		//kontrollime, kas muudatused on toimunud ka andmebaasi tasandil.
		DB db = new DB();
		db.connect();
		String sql= "SELECT votes FROM candidate WHERE id='27';";
		System.out.println(sql);
	  	try {
	  		Statement statement = db.getConnection().createStatement();
	  		ResultSet resultSet = statement.executeQuery(sql);	    
	  		if (resultSet.next()) {
	  	    			votesAfter= resultSet.getInt("votes");
	  		}
	  	} catch (SQLException e) {
	  		e.printStackTrace();
	  	}
	    db.disconnect();
	    //kandidaadil nr 27 peab olema üks hääl rohkem kui enne
	    assertTrue(votesBefore + 1 == votesAfter);
	    
	}
	
	

	@After
	public void tearDown() throws Exception {
		//võtame antud hääle tagasi
		DB db = new DB();
		db.connect();
	  	try {
	  		Statement statement = db.getConnection().createStatement();	 
	  		statement.executeUpdate("UPDATE candidate SET votes=(votes-1) WHERE id='27';");	
	  		statement.executeUpdate("UPDATE person SET vote=NULL WHERE id=16;");	
	  	} catch (SQLException e) {
	  		e.printStackTrace();
	  	}
	  	db.disconnect();
		selenium.stop();
	}
}
