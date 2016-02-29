package calculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTestDouble {

	private Calculator test = new Calculator();
	
	@Test
	public void addDoubleMethod()
	{
		assertEquals(15.89, test.add(10.55, 5.34434), 0.01);
	}
	
	@Test
	public void subDoubleMethod()
	{
		assertEquals(14.11, test.sub(14.5453, 0.432), 0.01);
	}
	
	@Test
	public void divDoubleMethod()
	{
		assertEquals(4.54696, test.div(15.687,3.45), 0.00001);
	}
	
	@Test
	public void multiDoubleMethod()
	{
		assertEquals(1965.897, test.multi(3.545,554.555), 0.001);
	}
	
	@Test
	public void greaterDoubleMethod()
	{
		assertEquals(false, test.greater(0.0001, 0.001));
	}
}
