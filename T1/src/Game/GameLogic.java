package Game;

import java.util.ArrayList;

public class GameLogic implements Cloneable {
	
	public GameLogic(GameMap map)
	{
		this.map = map;
		this.gameover = false;
		this.key = false;
		this.ActualMap = map.clone().getMap();
	};
	
	private boolean gameover;
	private GameMap map;
	private boolean key;
	private ArrayList<GameElements> elements = new ArrayList<GameElements>();
	private char[][] ActualMap;
	
	public void setMap(GameMap m){this.map=m;}
	public GameMap getMap(){return this.map;}

	public void setGameOver(boolean over){this.gameover = over;}
	public boolean getGameOver(){return this.gameover;}
	
	public void addGameElements(GameElements element){this.elements.add(element);}
	public ArrayList<GameElements> getGameElements(){return this.elements;}
	
	public void setKey(boolean key){this.key = key;}
	public boolean getKey(){return this.key;}
	
	public char[][]getActualMap(){return this.ActualMap;}
	public char[][] setGame(){
		char[][] MapClone = CopyCharMatrix(this.ActualMap); 
		
		
		for(int i = 0; i < this.elements.size(); i++)
		{
			MapClone[this.elements.get(i).getx()][this.elements.get(i).gety()] = this.elements.get(i).getSymbol();
		}
		
		return MapClone;
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

	public boolean testKey(int x, int y)
	{
		if(this.ActualMap[x][y] == 'k')
		{
			this.setKey(true);
			this.ActualMap[x][y] = ' ';
			for(int i=0;i<this.ActualMap.length;i++)
			{
				for(int k=0;k<this.ActualMap[i].length;k++)
				{
					if(this.ActualMap[i][k] == 'I')
					{
						this.ActualMap[i][k]='S';
					}
				}
			}
			return true;
		}
		
		return false;
	}
}
