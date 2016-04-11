package com.example.mockdemo.app;
import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MessageService;


public class MessengerTest {

	private Messenger messenger;
	private MessageService mock;

	static final String VALID_SERVER = "inf.ug.edu.pl";
	static final String VALID_MESSAGE = "some message";
	
	@Before
	public void setUp() {
		mock = createMock(MessageService.class);
		messenger = new Messenger(mock);
	}

	@Test
	public void testConnection() {
		expect(mock.checkConnection(VALID_SERVER)).andReturn(ConnectionStatus.SUCCESS).atLeastOnce();
		replay(mock);
		assertEquals(0, messenger.testConnection(VALID_SERVER));
		verify(mock);
	}
}
