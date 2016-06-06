package com.example.restservicedemo;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import com.jayway.restassured.RestAssured;
import com.example.restservicedemo.domain.Processor;
import com.example.restservicedemo.service.ProcessorManager;

public class ProcessorManagerTest {

	private ProcessorManager pm = new ProcessorManager();
	
	@BeforeClass
	public static void setUp(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/restservicedemo/api";
	}
	
	@Test
	public void getCar(){
		
		Processor nowy = new Processor(3,"jakisdfdsfsdf", "haswel", 34.4, 3);
		long id = 2;
		long count;

		int cos = pm.getRows();
		
		List<Processor> p = pm.showFastest();
		
		List<Processor> proc = pm.searchProcessors("haswel");
		
		List<Processor> costam = pm.advancedSearch("jakisdfdsfsdf", "haswel", 34.4, 3);
	}
	
	
}
