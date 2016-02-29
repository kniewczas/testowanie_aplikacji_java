package bread;

import static org.junit.Assert.*;
import org.junit.Test;

public class BreadTest {

	BreadManager testA = new BreadManager();
	Bread testB = new Bread(3,(float) 5.3,5.3);
	
	@Test
	public void testAdd()
	{	
		testA.Add(0, testB);
		assertEquals(testA.getSize(), 1);
		testA.Remove(0);
		assertEquals(testA.getSize(), 0);
	}
}
