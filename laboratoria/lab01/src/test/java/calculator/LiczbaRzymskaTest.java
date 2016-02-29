package calculator;

import static org.junit.Assert.*;
import org.junit.Test;

public class LiczbaRzymskaTest 
{
	private LiczbaRzymska test = new LiczbaRzymska();
	
	@Test
	public void liczbaRzymskaTest()
	{
		test.getNumber(5);
		assertEquals("V", test.toString());
		
		test.getNumber(1234);
		assertEquals("MCCXXXIV", test.toString());
		
		test.getNumber(199);
		assertEquals("CXCIX", test.toString());
	}
	
}
