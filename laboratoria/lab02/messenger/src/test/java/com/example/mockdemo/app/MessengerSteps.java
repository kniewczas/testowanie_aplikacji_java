package com.example.mockdemo.app;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.example.mockdemo.messenger.MessageService;


public class MessengerSteps {

	private Messenger messenger;
	private MessageService ms;
	
	@Given("A messenger")
	public void runMessenger()
	{
		messenger = new Messenger(ms);
	}
	
	@When()
	
}
