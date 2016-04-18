package wejsciowka03;

import java.util.List;
import java.util.ArrayList;

public class BreadManager {
	private IBreadManager breadManager;
	private List<Bread> breadlist = new ArrayList<Bread>();
	
	public BreadManager(IBreadManager breadManager)
	{
		this.breadManager = breadManager;
	}
	
	public boolean Add(Bread bread)
	{
		return breadlist.add(bread);
	}
	
	public boolean Remove(int number)
	{
		for(int i = 0; i < breadlist.size(); i ++)
		{
			if(number == breadlist.get(i).GetCode() )
			{
				breadlist.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public int GetSize()
	{
		return breadlist.size();
	}
	
	public Bread Get(int code)
	{
		for(int i = 0; i < breadlist.size(); i ++)
		{
			if(code == breadlist.get(i).GetCode() )
			{
				return breadlist.get(i);
			}
		}
		return null;
	}
	
	public boolean Find(int code)
	{
		for(int i = 0; i < breadlist.size(); i ++)
		{
			if(code == breadlist.get(i).GetCode() )
			{
				return true;
			}
		}
		return false;
	}
}
