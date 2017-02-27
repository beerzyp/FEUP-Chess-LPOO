package Game;

public class GameElements {
	protected int x;
	protected int y;
	protected char symbol;
	
	public int getx()
	{
		return this.x;
	}
	public int gety()
	{
		return this.y;
	}

	public void setx(int x)
	{
		this.x = x;
	}

	public void sety(int y)
	{
		this.y = y;
	}
	
	public char getSymbol(){return this.symbol;}
}
