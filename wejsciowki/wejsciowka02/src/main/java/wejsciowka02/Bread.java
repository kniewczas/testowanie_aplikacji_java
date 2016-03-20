package wejsciowka02;

public class Bread {

	private int a;
	private float b;
	private double c;
	
	public Bread(int a, float b, double c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public int GetA()
	{
		return this.a;
	}
	
	public float GetB()
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
	
	public void SetB(float b)
	{
		this.b = b;
	}
	
	public void GetC(double c)
	{
		this.c = c;
	}
}
