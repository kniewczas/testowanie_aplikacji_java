package wejsciowka03;

public class BreadManager {
	private IBreadManager breadManager;

	public BreadManager(IBreadManager breadManager)
	{
		this.breadManager = breadManager;
	}
	
	public boolean Add(Bread bread)
	{
		return breadManager.Add(bread);
	}
	
	public boolean Remove(int number)
	{
		return breadManager.Remove(number);
	}
	
	public int GetSize()
	{
		return breadManager.GetSize();
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
