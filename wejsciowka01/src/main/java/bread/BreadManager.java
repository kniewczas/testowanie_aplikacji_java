package bread;

import java.util.ArrayList;
import java.util.List;

public class BreadManager{

	private List<Bread> listA = new ArrayList<Bread>();
	
	public void Add(int number, Bread bread)
	{
		this.listA.add(number, bread);
	}
	
	public void Remove(int number)
	{
		this.listA.remove(number);
	}
	
	public int getSize()
	{
		return this.listA.size();
	}
}
