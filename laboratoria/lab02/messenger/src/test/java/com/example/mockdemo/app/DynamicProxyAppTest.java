package com.example.mockdemo.app;

import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

public class DynamicProxyAppTest {

	private static final String VALID_SERVER = "inf.ug.edu.pl";
	private static final String INVALID_SERVER = "inf.ug.edu.eu";

	private static final String VALID_MESSAGE = "some message";
	private static final String INVALID_MESSAGE = "ab";

	@Test
	public void checkSending() {

		InvocationHandler ih = new MessageServiceHandler();
		MessageService msMock = (MessageService) Proxy.newProxyInstance(
				MessageService.class.getClassLoader(),
				new Class[] { MessageService.class }, ih);

		Messenger messenger = new Messenger(msMock);

		assertEquals(1, messenger.sendMessage(INVALID_SERVER, VALID_MESSAGE));
		assertEquals(2, messenger.sendMessage(VALID_SERVER, INVALID_MESSAGE));

		assertThat(messenger.sendMessage(VALID_SERVER, VALID_MESSAGE),
				either(equalTo(0)).or(equalTo(1)));

	}

	
	class MessageServiceHandler implements InvocationHandler {

		@Override
		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			if ("checkConnection".equals(method.getName())) {
				
				if (VALID_SERVER.equals(args[0].toString())) {
					return ConnectionStatus.SUCCESS;
				} else {
					return ConnectionStatus.FAILURE;
				}
			}
			if ("send".equals(method.getName())) {
				if (VALID_SERVER.equals(args[0].toString()) && VALID_MESSAGE.equals(args[1].toString())) {
					return SendingStatus.SENT;
				} 
				if(VALID_SERVER.equals(args[0].toString()) && INVALID_MESSAGE.equals(args[1].toString())) {
					throw new MalformedRecipientException();
				}
				
				else {
					return SendingStatus.SENDING_ERROR;
				}
			}
			return -1;
		}

	}
}
