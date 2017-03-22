package Game;

import java.util.ArrayList;

public class GameLogic implements Cloneable {
	
	
	public GameLogic(GameMap map)
	{
		this.map = map;
		this.gameover = false;
		this.key = false;
		this.ActualMap = map.clone().getMap();
		
		if(map instanceof OgreMap)
			this.level2 = true;
		else
			this.level2 = false;
		
		setkeypos();
		this.gamewin = false;
		OgreKey = false;
		this.weaponBool = false;
	};
	
	private boolean gameover;
	private GameMap map;
	private boolean key;
	private ArrayList<GameElements> elements = new ArrayList<GameElements>();
	private char[][] ActualMap;
	private int keyx;
	private int keyy;
	private boolean OgreKey;
	private boolean gamewin;
	private boolean level2;
	private int weaponX = 2;
	private int weaponY = 1;
	private char weaponSymbol='w';
	private boolean weaponBool;
	
	public void printboard()
	{
		for(int i =0; i < this.getActualMap().length; i++) //pinta o jogo
		{
			System.out.println(this.getActualMap()[i]); 
		}
	}
	
	public int getHeroPosAtArray()
	{  int p=0;
		for(int i=0;i<this.getGameElements().size();i++)
		{
			if(this.getGameElements().get(i).getSymbol()=='H' || this.getGameElements().get(i).getSymbol()=='A' || this.getGameElements().get(i).getSymbol()=='K')
			{
				p=i;
			}
		}
		return p;
	}
	public Pair getHeroPosition()
	{	 int p=getHeroPosAtArray();
		
		return new Pair(this.getGameElements().get(p).getx(),this.getGameElements().get(p).gety());
	}
	public boolean moveHero(char direction)
	{ int p=getHeroPosAtArray();
	    
		if(direction == 'w')
		{	
			if(((GEHero)this.getGameElements().get(p)).moveTo(ActualMap, this.getGameElements().get(p).getx()- 1, this.getGameElements().get(p).gety())){
				if(level2)
					this.pickKey(this.getGameElements().get(p).getx()- 1, this.getGameElements().get(p).gety());
				else
					this.testKey(this.getGameElements().get(p).getx()- 1, this.getGameElements().get(p).gety());
				
				this.getGameElements().get(p).setx(this.getGameElements().get(p).getx()- 1);
				}
			else
				return false;
				
		}
		else if(direction == 's')
		{	if(((GEHero)this.getGameElements().get(p)).moveTo(ActualMap, this.getGameElements().get(p).getx()+ 1, this.getGameElements().get(p).gety())){
			if(level2)
				this.pickKey(this.getGameElements().get(p).getx()+ 1, this.getGameElements().get(p).gety());
			else
				this.testKey(this.getGameElements().get(p).getx()+ 1, this.getGameElements().get(p).gety());
			
			this.getGameElements().get(p).setx(this.getGameElements().get(p).getx()+ 1);
			}
				
			else 
				return false;
			
		}
		else if(direction == 'd')
		{   if(((GEHero)this.getGameElements().get(p)).moveTo(ActualMap, this.getGameElements().get(p).getx(), this.getGameElements().get(p).gety()+1)){
			if(level2)
				this.pickKey(this.getGameElements().get(p).getx(), this.getGameElements().get(p).gety()+1);
			else
				this.testKey(this.getGameElements().get(p).getx(), this.getGameElements().get(p).gety()+1);
			
			this.getGameElements().get(p).sety(this.getGameElements().get(p).gety()+ 1);
			}
			else 
				return false;
		}
		else if(direction == 'a')
		{ 	if(((GEHero)this.getGameElements().get(p)).moveTo(ActualMap, this.getGameElements().get(p).getx(), this.getGameElements().get(p).gety()-1)){
			if(level2)
				this.pickKey(this.getGameElements().get(p).getx(), this.getGameElements().get(p).gety()-1);
			else
				this.testKey(this.getGameElements().get(p).getx(), this.getGameElements().get(p).gety()-1);
			
			this.getGameElements().get(p).sety(this.getGameElements().get(p).gety()-1);
			}			
		else 
				return false;
		}
		
		return true;
		
	}
	
	public void setLevel2(){this.level2=true;}
	public void setGameWin(boolean win){this.gamewin=win;}
	public boolean getGameWin(){return this.gamewin;}

	
	public void setMap(GameMap m){this.map=m;}
	public GameMap getMap(){return this.map;}

	public void setGameOver(boolean over){this.gameover = over;}
	public boolean getGameOver(){return this.gameover;}
	
	public void addGameElements(GameElements element){this.elements.add(element);}
	public ArrayList<GameElements> getGameElements(){return this.elements;}
	
	public void setKey(boolean key){this.key = key;}
	public boolean getKey(){return this.key;}
	public boolean pickKey(int x, int y){
		if(this.ActualMap[x][y] == 'k')
		{
			this.setKey(true);
			this.elements.get(getHeroPosAtArray()).setSymbol('K');
			this.ActualMap[x][y] = ' ';
			return true;
		}
		
		return false;
	}

	
	public char[][]getActualMap(){return this.ActualMap;}
	public void cleanActualMap(){
		if(this.key){
			this.ActualMap = CopyCharMatrix(this.map.getMap());
			if(this.OgreKey)
				this.changeMapKey();
			else
				changeMapOgreKey();
		}
		else
			this.ActualMap = CopyCharMatrix(this.map.getMap()); 
		
		if(level2)
			if(!weaponBool)
				this.ActualMap[this.weaponX][this.weaponY] = this.weaponSymbol;

	}
	
	public void setGame(){		
		for(int i = 0; i < this.elements.size(); i++)
		{
			this.testWin(this.elements.get(i));
			this.ActualMap[this.elements.get(i).getx()][this.elements.get(i).gety()] = this.elements.get(i).getSymbol();
			if(this.elements.get(i).getHaveWeapon())
				this.ActualMap[this.elements.get(i).getWeaponX()][this.elements.get(i).getWeaponY()] = this.elements.get(i).getWeapon();
			colisoes(this.elements.get(i));
			if(this.elements.get(i).isStun())
			{
				this.ActualMap[this.elements.get(i).getx()][this.elements.get(i).gety()] = this.elements.get(i).getStunnedSymbol();
				this.elements.get(i).decStunTime();
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
	public void changeMapOgreKey(){
		for(int i=0;i<this.ActualMap.length;i++)
		{
			for(int k=0;k<this.ActualMap[i].length;k++)
			{
				if(this.ActualMap[i][k] == 'k')
				{
					this.ActualMap[i][k]=' ';
				}
			}
		}
	}	
	public boolean testKey(int x, int y)
	{
		if(this.ActualMap[x][y] == 'k')
		{
			this.setKey(true);
			this.OgreKey = true;
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
					this.keyx=i;
					this.keyy=j;
				}
			}
		}
	}
	
	public void testWin(GameElements g1){
		
		if(g1.getSymbol() =='H' || g1.getSymbol() =='A' || g1.getSymbol()=='K')//se g1 for o Hero
		{
		for(int j=0; j < this.ActualMap.length; j++){
			for(int k=0; k < this.ActualMap[j].length; k++){
				if(this.ActualMap[j][k] == 'S'){
					if(Math.floor(this.distancePoints(g1.getx(), g1.gety(), j, k)) == 0)
					{
						this.gamewin = true;
					}
					}
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
			if(Math.floor(this.distancePoints(weaponX, weaponY, g1.getx(), g1.gety())) == 0)
			{
				g1.setSymbol('A');
				this.weaponBool = true;
			}
			
			if(Math.floor(this.distancePoints(keyx, keyy, g1.getx(), g1.gety())) == 0)
			{	
				
				if(level2){
				g1.setSymbol('K');
				}
			}
			
			for(int i=0;i<this.elements.size();i++)
			{
				
				if(this.elements.get(i).getHaveWeapon()) //o elemento � Ogre
				{
				
					//if(this.elements.get(i).getWeaponX()==g1.getx() && this.elements.get(i).gety()==g1.gety())//arma do
					if(Math.floor(distancePoints(this.elements.get(i).getWeaponX(),this.elements.get(i).getWeaponY(),g1.getx(),g1.gety())) == 0)
					{
						this.gameover=true;
					
					}
					else if(g1.getSymbol()=='A' ||g1.getSymbol()=='K')
					{
						if(distancePoints(this.elements.get(i).getx(),this.elements.get(i).gety(),g1.getx(),g1.gety()) <=a1)
						{
							this.elements.get(i).setStunned();
						}
						
						
					}
					
				}
				
				
				else if(this.elements.get(i).getSymbol()=='G')//Guardas
				{
					if(distancePoints(this.elements.get(i).getx(),this.elements.get(i).gety(),g1.getx(),g1.gety()) <=a1)
					{
						this.gameover=true;
						break;
					}
					
				}
				
				if(g1.getSymbol() =='H' || g1.getSymbol() =='A' || g1.getSymbol()=='K')
				{
					if(level2)
					{if(this.key)
					{
						for(int l = 0; l < ((OgreMap) this.map).getDoors().size(); l++){
							if(distancePoints(((OgreMap) this.map).getDoors().get(l).gety(),((OgreMap) this.map).getDoors().get(l).getx(),g1.getx(),g1.gety()) <= a1)
							{
								changeMapKey();
								this.OgreKey = true;
							}
						}
					}}
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
	
}
