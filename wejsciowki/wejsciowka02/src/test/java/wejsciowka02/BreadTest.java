package wejsciowka02;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BreadTest {

	private BreadManager breadManager;
	private IBreadManager mock;
	
	//Bread bread = new Bread(3,(float) 4.5,23.3);
	//List<Bread> breads;
	
	@Before
	public void setUp() {
		mock = createMock(IBreadManager.class);
		breadManager = new BreadManager(mock);
	}
	
	@Test
	public void breadSimpleTest()
	{
		Bread bread = new Bread(1, "bread",5.5);	
		expect(mock.Add(bread)).andReturn(true).atLeastOnce();
		expect(mock.Remove(0)).andReturn(true).atLeastOnce();
		expect(mock.ReturnSize()).andReturn(1).atLeastOnce();
		replay(mock);
		assertEquals(breadManager.Add(bread),true);
		assertEquals(breadManager.Remove(0),true);
		assertEquals(breadManager.ReturnSize(),1);
	}
}
