package wejsciowka02;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BreadTest {

	private BreadManager breadManager;
	private IBreadManager mock;
	private Bread bread = new Bread("white bread", 2.54, 4525);
	List<Bread> breadList;
	 
	@Before
	public void setUp() {
		mock = createMock(IBreadManager.class);
		breadManager = new BreadManager(mock);
	}
	
	@Test 
	public void AddTest()
	{
		expect(mock.Add(bread)).andReturn(true).atLeastOnce();
		expect(mock.Get(bread.GetCode())).andReturn(bread);
		replay(mock);
		//assertEquals()	
	}
	
	/*@Test
	public void breadSimpleTest()
	{
		Bread bread = new Bread(1, "bread",5.5);
		
		expect(mock.Add(bread)).andReturn(true).atLeastOnce();
		expect(mock.Remove(0)).andReturn(true).atLeastOnce();
		expect(mock.ReturnSize()).andReturn(1).atLeastOnce();
		replay(mock);
		assertEquals(true, breadManager.Add(bread));
		assertEquals(true, breadManager.Remove(0));
		assertEquals(3,breadManager.ReturnSize());
	}*/
}
