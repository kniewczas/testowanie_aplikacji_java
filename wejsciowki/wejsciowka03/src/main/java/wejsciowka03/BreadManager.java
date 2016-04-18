package wejsciowka03;

import java.util.List;

public class BreadManager {
	private IBreadManager breadManager;
	private List<Bread> breadlist;
	
	public BreadManager(IBreadManager breadManager)
	{
		breadManager = breadManager;
		//breadlist = new List<Bread>();
	}
	
	public boolean Add(Bread bread)
	{
		return breadlist.add(bread);
	}
	
	public Bread Remove(int number)
	{
		return breadlist.remove(number);
	}
	
	public int GetSize()
	{
		return breadlist.size();
	}
	
	public Bread Get(int code)
	{
		return breadManager.Get(code);
	}
	
	public boolean Find(int code)
	{
		return breadManager.Find(code);
	}
}
