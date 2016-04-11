package wejsciowka02;

import static org.easymock.EasyMock.*;
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
		breadManager.Add(bread);
		assertEquals(bread,breadManager.Get(4525));
		verify(mock);	
	}
	
	@Test
	public void removeTest()
	{
		expect(mock.Remove(4525)).andReturn(true).atLeastOnce();
		expect(mock.GetSize()).andReturn(0).atLeastOnce();
		replay(mock);
		breadManager.Remove(4525);
		int size = breadManager.GetSize();
		assertEquals(0, size);
		verify(mock);
	}
}
