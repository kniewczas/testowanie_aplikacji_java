package com.example.mockdemo.app;
import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;


public class MessengerTest {

	private Messenger messenger;
	private MessageService mock;
	private final String SERVER = "inf.ug.edu.pl";
	private final String MESSAGE = "Hello!";
	
	@Before
	public void setUp() {
		mock = createMock(MessageService.class);
		messenger = new Messenger(mock);
	}

	@Test
	public void testConnection() {
		expect(mock.checkConnection(SERVER)).andReturn(ConnectionStatus.SUCCESS).atLeastOnce();
		replay(mock);
		assertEquals(0, messenger.testConnection(SERVER));
		verify(mock);
	}
	
	@Test
	public void testSending() throws MalformedRecipientException{
		expect(mock.send(SERVER, MESSAGE)).andReturn(SendingStatus.SENT).atLeastOnce();
		replay(mock);
		assertEquals(0,messenger.sendMessage(SERVER, MESSAGE));
		verify(mock);
	}
	
}
