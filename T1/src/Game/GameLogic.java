package Game;

import java.util.ArrayList;

public class GameLogic {
	
	public GameLogic(GameMap map)
	{
		this.map = map;
		this.gameover = false;
		this.key = false;
	};
	
	private boolean gameover;
	private GameMap map;
	private boolean key;
	private ArrayList<GameElements> elements;
	private char[][] ActualMap = this.map.getMap();
	
	public void setMap(GameMap m){this.map=m;}
	public GameMap getMap(){return this.map;}

	public void setGameOver(boolean over){this.gameover = over;}
	public boolean getGameOver(){return this.gameover;}
	
	public void addGameElements(GameElements elements){this.elements.add(elements);}
	public ArrayList<GameElements> getGameElements(){return this.elements;}
	
	public void setKey(boolean key){this.key = key;}
	public boolean getKey(){return this.key;}
	
	public char[][] setGame(){
		char[][] MapClone = this.ActualMap;
		
		for(int i = 0; i < this.elements.size(); i++)
		{
			MapClone[this.elements.get(i).getx()][this.elements.get(i).gety()] = this.elements.get(i).getSymbol();
		}
		
		return MapClone;
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
