package Game;

import java.util.ArrayList;

public class GameLogic implements Cloneable {
	
	public GameLogic(GameMap map)
	{
		this.map = map;
		this.gameover = false;
		this.key = false;
		this.ActualMap = map.clone().getMap();
		setkeypos();
		
	};
	
	private boolean gameover;
	private GameMap map;
	private boolean key;
	private ArrayList<GameElements> elements = new ArrayList<GameElements>();
	private char[][] ActualMap;
	private int keyx;
	private int keyy;
	private char keySymb;
	
	public void setMap(GameMap m){this.map=m;}
	public GameMap getMap(){return this.map;}

	public void setGameOver(boolean over){this.gameover = over;}
	public boolean getGameOver(){return this.gameover;}
	
	public void addGameElements(GameElements element){this.elements.add(element);}
	public ArrayList<GameElements> getGameElements(){return this.elements;}
	
	public void setKey(boolean key){this.key = key;}
	public boolean getKey(){return this.key;}
	
	public char[][]getActualMap(){return this.ActualMap;}
	public void cleanActualMap(){
		if(this.key){
			this.ActualMap = CopyCharMatrix(this.map.getMap()); 
			this.changeMapKey();
		}
		else
			this.ActualMap = CopyCharMatrix(this.map.getMap()); 
	}
	
	public char[][] setGame(){		
		for(int i = 0; i < this.elements.size(); i++)
		{
			
			this.ActualMap[this.elements.get(i).getx()][this.elements.get(i).gety()] = this.elements.get(i).getSymbol();
			if(this.elements.get(i).getHaveWeapon())
				this.ActualMap[this.elements.get(i).getWeaponX()][this.elements.get(i).getWeaponY()] = this.elements.get(i).getWeapon();
			colisoes(this.elements.get(i));
		}
		
		
		return this.ActualMap;
	}
	
	public static char[][] CopyCharMatrix(char[][] input) {
	    if (input == null)
	        return null;
	    
	    char[][] result = new char[input.length][];
	    
	    for (int r = 0; r < input.length; r++) {
	        result[r] = input[r].clone();
	    }
	    
	    return result;
	}

	
	public void changeMapKey(){
		for(int i=0;i<this.ActualMap.length;i++)
		{
			for(int k=0;k<this.ActualMap[i].length;k++)
			{
				if(this.ActualMap[i][k] == 'k')
				{
					this.ActualMap[i][k]=' ';
				}
				
				if(this.ActualMap[i][k] == 'I')
				{
					this.ActualMap[i][k]='S';
				}
			}
		}
	}
	public boolean testKey(int x, int y)
	{
		if(this.ActualMap[x][y] == 'k')
		{
			this.setKey(true);
			this.ActualMap[x][y] = ' ';
			this.changeMapKey();
			return true;
		}
		
		return false;
	}
	public void setkeypos()
	{
		for(int i=0;i<this.ActualMap.length;i++)
		{
			for(int j=0;j<this.ActualMap[i].length;j++)
			{
				if(this.ActualMap[i][j]=='k')
				{
					this.keySymb=this.ActualMap[i][j];
					this.keyx=i;
					this.keyy=j;
				}
			}
		}
	}
	public void colisoes(GameElements g1)
	{
		if(g1.getSymbol() =='H' || g1.getSymbol() =='A' || g1.getSymbol()=='K')//hero, se morrer
		{
			for(int i=0;i<this.elements.size();i++)
			{
				if(this.elements.get(i).getHaveWeapon())
				{
				
					if(this.elements.get(i).getWeaponX()==g1.getx() && this.elements.get(i).gety()==g1.gety())
					{
						this.gameover=true;
					}
					
					else if(g1.getSymbol()=='A' ||g1.getSymbol()=='K')
					{
						if(this.elements.get(i).getx()+1==g1.getx() && this.elements.get(i).gety()==g1.gety())
						{
							this.elements.get(i).setStun();
							this.elements.get(i).setStunfor(2);
						}
						else if(this.elements.get(i).getx()-1==g1.getx() && this.elements.get(i).gety()==g1.gety())
						{
							this.elements.get(i).setStun();
							this.elements.get(i).setStunfor(2);
						}
						else if(this.elements.get(i).getx()==g1.getx() && this.elements.get(i).gety()+1==g1.gety())
						{
							this.elements.get(i).setStun();
							this.elements.get(i).setStunfor(2);
						}
						else if(this.elements.get(i).getx()==g1.getx() && this.elements.get(i).gety()-1==g1.gety())
						{
							this.elements.get(i).setStun();
							this.elements.get(i).setStunfor(2);
						}
						
					}
					
				}
				else if(this.elements.get(i).getSymbol()=='G')
				{
					if(this.elements.get(i).getx()+1==g1.getx() && this.elements.get(i).gety()==g1.gety())
					{
						this.gameover=true;
					}
					else if(this.elements.get(i).getx()-1==g1.getx() && this.elements.get(i).gety()==g1.gety())
					{
						this.gameover=true;
					}
					else if(this.elements.get(i).getx()==g1.getx() && this.elements.get(i).gety()+1==g1.gety())
					{
						this.gameover=true;
					}
					else if(this.elements.get(i).getx()==g1.getx() && this.elements.get(i).gety()-1==g1.gety())
					{
						this.gameover=true;
					}
					
				}
			}
		}
		
		else if(g1.getHaveWeapon()) //se for um ogre
		{
			if(g1.getWeaponX() == this.keyx && g1.getWeaponY()==this.keyy)
			{
				if(!this.key)
				{
				this.ActualMap[this.keyx][this.keyy]='$';
				}
			}
			
		}
		else{}
	}
	public void setkeySymb(char newsymb){this.keySymb=newsymb;}
}
