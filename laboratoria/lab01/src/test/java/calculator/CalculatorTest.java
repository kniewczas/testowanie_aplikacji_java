package calculator;

import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest 
{
	private Calculator test = new Calculator();		

	@Test
	public void testSubMethod() 
	{
		assertEquals(57, test.sub(100,43));
		assertEquals(-10, test.sub(10,20));
		assertEquals(10, test.sub(10,0));
		assertEquals(0 , test.sub(0,0));
	}
	
	@Test
	public void testDivMethod()
	{
		assertEquals(1, test.div(8, 5));
		assertEquals(0, test.div(0, 5));
		assertEquals(3 , test.div(-6, -2)); 
	}
	
	@Test
	public void testAddMethod()
	{
		assertEquals(8988, test.add(3545, 5443));
		assertEquals(-300, test.add(-200, -100));
		assertEquals(0, test.add(0, 0));
	}
	
	@Test
	public void testMultiMethod()
	{
		assertEquals(250, test.multi(5, 50));
		assertEquals(0, test.multi(5, 0));
		assertEquals(-200, test.multi(-40, 5));
	}
	
	@Test
	public void greaterMethod()
	{
		assertEquals(false, test.greater(4, 7));
	}
	
	@Test (expected = ArithmeticException.class)
	public void zeroExceptionTest()
	{
		assertEquals(-200, test.div(6, 0));
	}
	
	
}

