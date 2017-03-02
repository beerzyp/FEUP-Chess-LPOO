package Game;

public abstract class GameElements {
	private int x;
	private int y;
	private char symbol;
	private char weapon = '*';
	private int weaponx;
	private int weapony;
	private boolean haveWeapon;
	
	public void setHaveWeapon(boolean bool){this.haveWeapon=bool;}
	public boolean getHaveWeapon(){return this.haveWeapon;}

	public int getWeaponX(){return this.weaponx;}
	public int getWeaponY(){return this.weapony;}
	public char getWeapon(){return this.weapon;}
	public void setWeaponPos(int x, int y){this.weaponx = x; this.weapony = y;}
	
	public GameElements(int xPos, int yPos,char symbolChar, boolean bweapon)
	{
		x = xPos;
		y = yPos;
		symbol = symbolChar;
		haveWeapon = bweapon;
	}
	
	public abstract void move(char[][] map);
	
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
