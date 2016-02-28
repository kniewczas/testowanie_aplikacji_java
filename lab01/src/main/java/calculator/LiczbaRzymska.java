package calculator;

public class LiczbaRzymska 
{
	private int number;
	
	public void getNumber(int number)
	{
		this.number = number;
	}
	
	public String toString()
	{
		StringBuilder romNumber = new StringBuilder();
		
		int arab[] = {1000, 990, 900, 500, 490, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String rom[] = {"M","XM","CM","D","XD","CD","C","XC","L","XL","X","IX","V","IV","I"};
		
		int tempNumb = this.number;
		int i = 0;
		
		while (tempNumb > 0) 
		{
			while ((tempNumb - arab[i]) >= 0)
			{
				tempNumb -= arab[i];
				romNumber.append(rom[i]);
			}
			i++;
		}
		return romNumber.toString();
	}
}
