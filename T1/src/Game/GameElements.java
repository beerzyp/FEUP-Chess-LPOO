package Game;

public abstract class GameElements {
	private int x;
	private int y;
	private char symbol;
	
	private boolean stun; //atributo que verifica se este elemento está stunned
	private int stunfor;
	private char stunned='8';
	
	private boolean isarmed;
	private char armed;
	
	private boolean haveWeapon; //atributo que verifica se este elemento tem uma arma
	private char weapon ='*';
	private int weaponx;
	private int weapony;

	public int getStunfor(){return this.stunfor;}
	public boolean isStun(){return this.stun;}
	public char getStunnedSymbol(){return this.stunned;}
	public void setStunned(){this.stun=true;}
	public int decStunTime()
	{
		if(this.stunfor == 0)
		{   System.out.println(this.stunfor);
			this.stun=false; 
			this.stunfor = 2;
			return 0;
		}

			this.stunfor--; 
			return -1;

	}
	
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
		this.stunfor = 2;
		this.stun = false;
		this.isarmed=false;
		this.armed='A';
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
