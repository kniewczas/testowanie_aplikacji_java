package wejsciowka02;

public class Bread {

	private int a;
	private String b;
	private double c;
	private String d;
	
	public Bread(int a, String b, double c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public int GetA()
	{
		return this.a;
	}
	
	public String GetB()
	{
		return this.b;
	}
	
	public double GetC()
	{
		return this.c;
	}
	
	public void SetA(int a)
	{
		this.a = a;
	}
	
	public void SetB(String b)
	{
		this.b = b;
	}
	
	public void GetC(double c)
	{
		this.c = c;
	}
}
