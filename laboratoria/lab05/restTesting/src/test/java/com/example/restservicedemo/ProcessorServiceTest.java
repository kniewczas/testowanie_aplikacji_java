package com.example.restservicedemo;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.delete;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.put;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.jayway.restassured.RestAssured;
import com.example.restservicedemo.domain.Processor;

public class ProcessorServiceTest {
	
	//6700K processor data
	private static final String PROC_NAME = "6700K";
	private static final String PROC_FAMILY = "Core i7";
	private static final int PROC_CORES = 4;
	private static final double PROC_CLOCK_RATE = 4.0; //GHz
	
	//1280v5 processor data
	private static final String PROC_NAME2 = "1280v5";
	private static final String PROC_FAMILY2 = "Xeon E3 v5";
	private static final int PROC_CORES2 = 4;
	private static final double PROC_CLOCK_RATE2 = 3.7; //GHz
	
	Processor processor = new Processor(1, PROC_NAME, PROC_FAMILY, PROC_CLOCK_RATE, PROC_CORES);
	Processor processor2 = new Processor(2, PROC_NAME2, PROC_FAMILY2, PROC_CLOCK_RATE2, PROC_CORES2);
	
	@BeforeClass
	public static void setUp(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/restservicedemo/api";
	}
	
	@Test
	public void insertProcessorTest(){
	
	    //delete("/processor/").then().assertThat().statusCode(201);
		
		given().contentType(MediaType.APPLICATION_JSON).
		body(processor).
		when().
		post("/processor/send").then().assertThat().statusCode(201);
		
		Processor outputProcessor = get("/processor/1").as(Processor.class);
		assertEquals(PROC_NAME, equalTo(outputProcessor.getModel()));
	}
	
	@Test
	public void getProcessorTest(){
		
		//delete("/processor/").then().assertThat().statusCode(201);
		
		//checking objects
		given().contentType(MediaType.APPLICATION_JSON).
		body(processor).
		when().
		post("/processor/send").then().assertThat().statusCode(201);
		Processor p1 = get("/processor/1").as(Processor.class);
		
		given().contentType(MediaType.APPLICATION_JSON).
		body(processor2).
		when().
		post("/processor/send").then().assertThat().statusCode(201);
		Processor p2 = get("/processor/2").as(Processor.class);
		
		assertEquals(processor, p1);
		assertEquals(processor2, p2);
		
		//checking with little rest helper method
		String sResult = get("/processor/count").asString();	
		assertEquals(2, Integer.parseInt(sResult));
	}
	
	@Test
	public void searchProcessorsTest(){
		
		
	}
	
	@Test
	public void updateProcessorTest(){
		
		Processor newProcessor = new Processor(1, "E342", "Xeon", 3.07, 4);
		
		given().contentType(MediaType.APPLICATION_JSON).
		body(processor).
		when().
		post("/processor/send").then().assertThat().statusCode(201);
		Processor oldProcessor = get("/processor/1").as(Processor.class);
		
		given().contentType(MediaType.APPLICATION_JSON).
		body(newProcessor).
		when().
		put("/processor/1").then().assertThat().statusCode(201);
			
	}
	
	@Test
	public void deleteProcessorTest(){
		
		given().contentType(MediaType.APPLICATION_JSON).
		body(processor).
		when().
		post("/processor/send").then().assertThat().statusCode(201);
		
		given().contentType(MediaType.APPLICATION_JSON).
		body(processor2).
		when().
		post("/processor/send").then().assertThat().statusCode(201);		
		
		delete("/processor/").then().assertThat().statusCode(201);
		
		String sResult = get("/processor/count").asString();	
		assertEquals(0, Integer.parseInt(sResult));
		
	}
	


}
