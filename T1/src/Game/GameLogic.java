package Game;

import java.util.ArrayList;

import Others.Pair;

public class GameLogic implements Cloneable {
	
	/**
	 * This constructor creates a logic associated with a specific GameMap
	 *
	 * @param map  DungeonMap and OgreMap both implement the interface GameMap
	 */
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
	}
	
	private boolean gameover;
	private GameMap map;
	private boolean key;
	private ArrayList<GameElements> elements = new ArrayList<GameElements>();
	public char[][] ActualMap;
	private int keyx;
	private int keyy;
	private boolean OgreKey;
	private boolean gamewin;
	public boolean level2;
	private int weaponX = 2;
	private int weaponY = 1;
	private char weaponSymbol='w';
	private boolean weaponBool;
	
	
	/**
	 * Prints the current map state that is passed by getActualMap method
	 * @see GameLogic.getActualMap()
	 * 
	 */
	public void printboard()
	{
		for(int i =0; i < this.getActualMap().length; i++) //pinta o jogo
		{
			System.out.println(this.getActualMap()[i]); 
		}
	}
	
	
	/**
	 * returns it(int) to Hero position in ArrayList<GameElements> elements
	 * @return Hero is indentified by char 'H' or 'K' or 'A'
	 */
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
	
	/**
	 * This method constructs a pair with the current Hero position in the gameboard
	 * @return A constructed Pair calling method getx() and gety() that return the position in board for any element
	 * @see Others.Pair
	 */
	public Pair getHeroPosition()
	{	 int p=getHeroPosAtArray();
		
		return new Pair(this.getGameElements().get(p).getx(),this.getGameElements().get(p).gety());
	}
	
	/**
	 * This method is responsible for moving the Hero in game
	 * @param direction It's a char specified by the player in game, w=up , a=left, s=down, d=right
	 * @return boolean, if true hero was able to move and hero positions were updated, if false nothing changed
	 */
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

	/**
	 * This is a bool indicating if level2 is currently the map
	 */
	public void setLevel2(){this.level2=true;}
	
	/**
	 * This method is used to set private atribute gamewin
	 * @param win If win value is true the Hero has won the game! It's initiated as false.
	 */
	public void setGameWin(boolean win){this.gamewin=win;}
	
	/**
	 * @see setGameWin
	 * @return Returns the GameWin boolean
	 */
	public boolean getGameWin(){return this.gamewin;}

	/**
	 * This method set's the current map that is being played
	 * @param m Recieves a type GameMap param
	 * @see GameMap, DungeonMap,OgreMap and setMap function
	 */
	public void setMap(GameMap m){this.map=m;}
	
	/**
	 * This method returns the current map that is being played
	 * @return A type GameMap, GameMap is an interface and DungeonMap and OgreMap both implement GameMap
	 */
	public GameMap getMap(){return this.map;}
	
	/**
	 * This method set's the gameover boolean, wich indicates if the Hero has lost the game
	 * @param over if true Hero has lost the game, it's initiated as false
	 */
	public void setGameOver(boolean over){this.gameover = over;}
	
	/**
	 * This method returns the gameover boolean, wich indicates if the Hero has lost the game
	 * @return gameOver
	 */
	public boolean getGameOver(){return this.gameover;}
	
	/**
	 * This method adds a element to the ArrayList<GameElements>, it has to be called(1 time) in the start of each game, to add elements to the game
	 * @param element it's any character of the game
	 */
	public void addGameElements(GameElements element){this.elements.add(element);}
	
	/**
	 * This method returns the ArrayList<GameElements>
	 * @return returns a vector with all the characters that are in the current game
	 */
	public ArrayList<GameElements> getGameElements(){return this.elements;}
	
	/**
	 * This method set's the key value to true or false
	 * @param key true if Hero has the key in possession, it's initialized as false
	 */
	public void setKey(boolean key){this.key = key;}
	
	/**
	 * This method returns the key value
	 * @return key true if Hero has the key in possession, it's initialized as false
	 */
	public boolean getKey(){return this.key;}
	
	/**
	 * This method is called with the intention of checking if Hero will pick the key in his next move (OgreMap), if it does it changes the hero symbol to 'K' and removes the key from map
	 * @param x is the x value in the map 
	 * @param y is the y value in the map 
	 * @return boolean, true if hero has caught the key, false if hero landed on every other position that isn't the key position
	 */
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

	/**
	 * This method returns the actual game board
	 * @return a [][]char matrix that is the current board
	 */
	public char[][]getActualMap(){return this.ActualMap;}
	
	/**
	 * This method is called on every move of the game, and removes from board all elements from last iteration
	 */
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
	
	/**
	 * this method is responsible for setting all current characters in the board, it's called every move of the game before printing the board
	 */
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
	
	/**
	 * This method creates a clone (copy of a matrix) of the initial map that was passed through the GameMap class
	 * @param input recieves a char[][] matrix from the OgreMap or DungeonMap class
	 * @return a char[][] copy of that matrix
	 */
	public static char[][] CopyCharMatrix(char[][] input) {
	    if (input == null)
	        return null;
	    
	    char[][] result = new char[input.length][];
	    
	    for (int r = 0; r < input.length; r++) {
	        result[r] = input[r].clone();
	    }
	    
	    return result;
	}

	/**
	 *This method is useful for the Dungeon Map,  once the hero picks the key this method is called to change all doors from closed to open
	 */
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
	
	/**
	 * This method is useful for the OgreMap, once the hero picks the lever doors remain closed, they just open when hero is one position away from the doors
	 */
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
	
	/**
	 * This method is useful for checking if Hero has picked the key
	 * @param x position in column
	 * @param y position in line
	 * @return  boolean, true is x,y conrresponds to key position
	 */
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
	
	/**
	 * There was a need to get the x and y position of the key in any map, this method goes through a map, and saves the keyx and keyy position for the key in that map
	 */
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
	
	/**
	 * This method checks whether the Hero has moved to a open door therefore winning the game
	 * @param g1 Hero, only works with characters 'H','A','K'
	 */
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
	
	/**
	 * Auxiliar method to calculate distance between two points, it's used in colisions
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return
	 */
	public double distancePoints(double x1,double y1, double x2,double y2)
	{
		return Math.sqrt(Math.abs(x2-x1)*Math.abs(x2-x1)+Math.abs(y2-y1)*Math.abs(y2-y1));
	}
	
	/**
	 * This method is called in function setGame for every element of the game, it checks the logic colisions for all the maps
	 * @param g1 any game element
	 */
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
