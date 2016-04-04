package wejsciowka02;

public class Bread {

	private String name;
	private double price;
	private int code;
	
	public Bread(String name, double price, int code)
	{
		this.name = name;
		this.price = price;
		this.code = code;
	}
	
	public String GetName()
	{
		return this.name;
	}
	
	public int GetCode()
	{
		return this.code;
	}
}
