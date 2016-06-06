package com.example.restservicedemo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.example.restservicedemo.domain.Processor;
import com.example.restservicedemo.service.ProcessorManager;

public class DbUnitTest {
	
	ProcessorManager pm = new ProcessorManager();

	@Test
	@Ignore
	public void procAddTest() {

		Processor p = new Processor(7, "940", "Core i7", 3.02, 4);
		assertEquals(1, pm.addProcessor(p));
	}

}
