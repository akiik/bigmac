package tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bigmac.DB;

import com.google.gson.Gson;
import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

import data.Candidate;
import data.Party;
import data.Person;

public class TestSearch {

	private Selenium selenium;


	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/");
		selenium.start();		
	}
	
	@Test
	public void searchCandidate() throws Exception {

		selenium.open("/bigmac");
		selenium.waitForPageToLoad("30000");		
		selenium.click("link=Hääleta");
		selenium.waitForPageToLoad("30000");
		selenium.type("css=input#tags", "Eha Keha");
		selenium.click("css=a#searchbyname");
		assertTrue(selenium.isTextPresent("Nimi: Eha Keha"));		
		
	}
	
	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
