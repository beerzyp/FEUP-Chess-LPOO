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
	
	public void setGame(){		
		for(int i = 0; i < this.elements.size(); i++)
		{
			
			this.ActualMap[this.elements.get(i).getx()][this.elements.get(i).gety()] = this.elements.get(i).getSymbol();
			if(this.elements.get(i).getHaveWeapon())
				this.ActualMap[this.elements.get(i).getWeaponX()][this.elements.get(i).getWeaponY()] = this.elements.get(i).getWeapon();
			colisoes(this.elements.get(i));
			if(this.elements.get(i).isStun())
			{
				this.ActualMap[this.elements.get(i).getx()][this.elements.get(i).gety()] = this.elements.get(i).getStunnedSymbol();
				if(this.elements.get(i).decStunTime()==0)
				{
					this.ActualMap[this.elements.get(i).getx()][this.elements.get(i).gety()] = this.elements.get(i).getSymbol();
				}
			}
		}
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
	public double distancePoints(double x1,double y1, double x2,double y2)
	{
		return Math.sqrt(Math.abs(x2-x1)*Math.abs(x2-x1)+Math.abs(y2-y1)*Math.abs(y2-y1));
	}
	public void colisoes(GameElements g1)
	{
		double a1=1;
		if(g1.getSymbol() =='H' || g1.getSymbol() =='A' || g1.getSymbol()=='K')//se g1 for o Hero
		{
			for(int i=0;i<this.elements.size();i++)
			{
				
				if(this.elements.get(i).getHaveWeapon()) //o elemento é Ogre
				{
				
					//if(this.elements.get(i).getWeaponX()==g1.getx() && this.elements.get(i).gety()==g1.gety())//arma do
					if(Math.floor(distancePoints(this.elements.get(i).getWeaponX(),this.elements.get(i).getWeaponY(),g1.getx(),g1.gety())) == 0)
					{
						this.gameover=true;
					
					}
					else if(g1.getSymbol()=='H' ||g1.getSymbol()=='K')
					{
						if(distancePoints(this.elements.get(i).getx(),this.elements.get(i).gety(),g1.getx(),g1.gety()) <=a1)
						{
							this.elements.get(i).setStunned();
						}
						
						
					}				
				}
				
				
				else if(this.elements.get(i).getSymbol()=='D' || this.elements.get(i).getSymbol()=='R' || this.elements.get(i).getSymbol()=='S')//Guardas
				{
					if(distancePoints(this.elements.get(i).getx(),this.elements.get(i).gety(),g1.getx(),g1.gety()) <=a1)
					{
						this.gameover=true;
						break;
					}
					
				}
			}	
		}
		else if(g1.getHaveWeapon()) //se g1 for um ogre
		{
			if(g1.getWeaponX() == this.keyx && g1.getWeaponY()==this.keyy)
			{
				if(!this.key)//se a key ainda estiver no mapa
				{
				this.ActualMap[this.keyx][this.keyy]='$';
				}
			}
			
		}
	}
	public void setkeySymb(char newsymb){this.keySymb=newsymb;}
}
