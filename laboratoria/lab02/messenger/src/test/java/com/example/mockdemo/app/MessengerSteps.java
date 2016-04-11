package com.example.mockdemo.app;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.example.mockdemo.messenger.MessageService;


public class MessengerSteps {

	private Messenger messenger;
	private MessageService ms;
	private String SERVER;
	private String MESSAGE;
	
	@Given("a messenger")
	public void runMessenger() {
		messenger = new Messenger(ms);
	}
	
	@When("message sending to server '$server' is '$message'")
	public void sendMessage(String message, String server) {
		SERVER = server;
		MESSAGE = message;
	}
	
	@Then("messenger should return $result")
	public void checkIfSent(int result) {
		assertEquals(result, messenger.sendMessage(SERVER, MESSAGE));
	}
	
	@Then("connection should be $result")
	public void checkConnection(int result) {
		assertEquals(result, messenger.testConnection(SERVER));
	}
	
}

