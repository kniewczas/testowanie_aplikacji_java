package com.example.restservicedemo;

import static com.jayway.restassured.RestAssured.delete;
import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.ws.rs.core.MediaType;

//import static org.junit.Assert.*;

//import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.restservicedemo.domain.Processor;
import com.example.restservicedemo.service.ProcessorManager;
import com.jayway.restassured.RestAssured;
//import com.example.restservicedemo.domain.Processor;
//import com.example.restservicedemo.service.ProcessorManager;

public class ProcessorManagerTest {

	private ProcessorManager pm = new ProcessorManager();
	
	@BeforeClass
	public static void setUp(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/restservicedemo/api";
	}
	
	@Test
	public void testCrud(){
		
		//Processor proc = pm.advancedSearch("Core i7", "6700K", 0.0);
		
		
	
	}
	
	
}
