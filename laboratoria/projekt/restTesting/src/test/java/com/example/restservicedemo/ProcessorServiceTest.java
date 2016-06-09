package com.example.restservicedemo;


import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.delete;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.put;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.InvalidPathException;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.PathNotFoundException;
import com.jayway.jsonpath.internal.path.PathCompiler;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static com.jayway.jsonpath.JsonPath.read;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.dbunit.Assertion;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.xml.XmlPath;
import com.example.restservicedemo.domain.Processor;

public class ProcessorServiceTest {
	
	private static IDatabaseConnection connection;
	private static IDatabaseTester databaseTester;	
	
	//6700K processor data
	private static final String PROC_NAME = "6700K";
	private static final String PROC_FAMILY = "Core i7";
	private static final int PROC_CORES = 4;
	private static final double PROC_CLOCK_RATE = 4.0; //GHz
	
	//1280v5 processor data
	private static final String PROC_NAME2 = "1280v5";
	private static final String PROC_FAMILY2 = "Xeon E3 v5";
	private static final int PROC_CORES2 = 4;
	private static final double PROC_CLOCK_RATE2 = 2.7; //GHz
	
	Processor testProc = new Processor(1, PROC_NAME, PROC_FAMILY, PROC_CLOCK_RATE, PROC_CORES);
	Processor testProc2 = new Processor(2, PROC_NAME2, PROC_FAMILY2, PROC_CLOCK_RATE2, PROC_CORES2);
	
	@BeforeClass
	public static void setUp()
	{
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/restservicedemo/api";
	}
	
	@Test
	public void insertProcessorTest()
	{
	
		Processor outputProc, outputProc2;
		String strProcCount;
		
		//cleaning
	    delete("/processor/").then().assertThat().statusCode(201);

	    //insert first proc
		given().contentType(MediaType.APPLICATION_JSON).body(testProc).
		when().post("/processor/send").
		then().assertThat().statusCode(201);
		
		outputProc = get("/processor/" + String.valueOf(testProc.getId())).as(Processor.class);
		assertEquals(testProc.getModel(), outputProc.getModel());
		
		//insert second proc
		given().contentType(MediaType.APPLICATION_JSON).body(testProc2).
		when().post("/processor/send").
		then().assertThat().statusCode(201);
		
		outputProc2 = get("/processor/" + String.valueOf(testProc2.getId())).as(Processor.class);
		assertEquals(testProc2.getModel(), outputProc2.getModel());
		
		//testing amount of inserted data
		strProcCount = get("/processor/count").asString();	
		assertEquals("2", strProcCount);
	}
	
	@Test
	public void getProcessorTest(){
		
		//cleaning
		delete("/processor/").then().assertThat().statusCode(201);
		
		//insert some data
		given().contentType(MediaType.APPLICATION_JSON).body(testProc).
		when().post("/processor/send").
		then().assertThat().statusCode(201);
		
		given().contentType(MediaType.APPLICATION_JSON).body(testProc2).
		when().post("/processor/send").
		then().assertThat().statusCode(201);
		
		//com.jayway.restassured.response.Response response = get("/processor/all");
		//String strAllProc = response.getBody().asString();
		
		Processor outputProc = get("/processor/" + String.valueOf(testProc.getId())).as(Processor.class);
		assertEquals(testProc.getModel(), outputProc.getModel());
		
		Processor outputProc2 = get("/processor/" + String.valueOf(testProc2.getId())).as(Processor.class);
		assertEquals(testProc2.getModel(), outputProc2.getModel());
		
	}
	
	@Test
	public void searchProcessorsTest(){
		
		String strSearchQuery = "";
		
		delete("/processor/").then().assertThat().statusCode(201);
		
		given().contentType(MediaType.APPLICATION_JSON).body(testProc).
		when().post("/processor/send").
		then().assertThat().statusCode(201);
		
		given().contentType(MediaType.APPLICATION_JSON).body(testProc2).
		when().post("/processor/send").
		then().assertThat().statusCode(201);
		
		//search by family and model name		
		strSearchQuery += "/processor/find/";
		strSearchQuery += testProc2.getFamily();
		strSearchQuery += "/";
		strSearchQuery += testProc2.getModel();
		
		String strResult = get(strSearchQuery).asString();
		assertEquals(true, strResult.contains(testProc2.getModel()));
	
		//search by fastest procs		
		double dTestAvg = ((testProc.getClockRating() + testProc2.getClockRating()) / 2);
		boolean bAboveAvg = false;
		
		if(testProc.getClockRating() > dTestAvg)
		{
			bAboveAvg = true;
		}
		strResult = get("/processor/find/fastest").asString();
		assertEquals(bAboveAvg, strResult.contains(testProc.getModel()));
		
		bAboveAvg = false;
		
		if(testProc2.getClockRating() > dTestAvg)
		{
			bAboveAvg = true;
		}
		strResult = get("/processor/find/fastest").asString();
		assertEquals(bAboveAvg, strResult.contains(testProc2.getModel()));
	}
	
	
	@Test
	public void updateProcessorTest()
	{		
		Processor newProcessor = new Processor(1, "E342", "Xeon", 3.07, 4);
		
		delete("/processor/").then().assertThat().statusCode(201);
		
		given().contentType(MediaType.APPLICATION_JSON).
		body(testProc).
		when().
		post("/processor/send").then().assertThat().statusCode(201);
		/*
		given().contentType(MediaType.APPLICATION_JSON).
		body(newProcessor).
		when().
		put("/processor/" + testProc.getId() + testProc.getFamily() +
				testProc.getModel() + testProc.getClockRating() +
				testProc.getCores()).then().assertThat().statusCode(201);
		
		Processor processor = get("/processor/" + testProc.getId()).as(Processor.class);	
		assertEquals(newProcessor.getModel(), processor.getModel());		
			*/
	}
	
	@Test
	public void deleteProcessorTest()
	{
		//deleting by ID
	    given().contentType(MediaType.APPLICATION_JSON).
		body(testProc).
		when().
		post("/processor/send").then().assertThat().statusCode(201);
		
		delete("/processor/" + testProc.getId()).then().assertThat().statusCode(201);
		
		//deleting all
		given().contentType(MediaType.APPLICATION_JSON).
		body(testProc).
		when().
		post("/processor/send").then().assertThat().statusCode(201);
		
		given().contentType(MediaType.APPLICATION_JSON).
		body(testProc2).
		when().
		post("/processor/send").then().assertThat().statusCode(201);
		
		delete("/processor/").then().assertThat().statusCode(201);
		
		//check if processors exists after delete
		Processor processor = get("/processor/" + testProc.getId()).as(Processor.class);	
		assertEquals(null, processor.getModel());
		
		Processor processor2 = get("/processor/" + testProc.getId()).as(Processor.class);	
		assertEquals(null, processor2.getModel());
		
		//checking amount of data after delete
		String strResult = get("/processor/count").asString();	
		assertEquals(0, Integer.parseInt(strResult));
	}
	


}
