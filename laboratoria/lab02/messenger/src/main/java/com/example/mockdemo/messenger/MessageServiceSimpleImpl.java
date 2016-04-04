package com.example.mockdemo.messenger;

import java.util.Random;

public class MessageServiceSimpleImpl implements MessageService {

	private Random random = new Random();

	public ConnectionStatus checkConnection(String server) {
		// checking the server here ...
		if (!server.endsWith(".pl")) {
			return ConnectionStatus.FAILURE;
		}
		// ...
		return ConnectionStatus.SUCCESS;
	}

	public SendingStatus send(String server, String message)
			throws MalformedRecipientException {

		if (message == null || message.length() < 3)
			throw new MalformedRecipientException();
		
		if (server == null || server.length() < 4)
			throw new MalformedRecipientException();
		
		if (checkConnection(server) == ConnectionStatus.FAILURE) {
			return SendingStatus.SENDING_ERROR;
		}

		// sending logic here ...
		if (random.nextBoolean()) {
			return SendingStatus.SENT;
		}
		return SendingStatus.SENDING_ERROR;
	}

}
