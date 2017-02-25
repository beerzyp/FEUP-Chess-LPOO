package Game;

import java.util.ArrayList;

public class GameLogic {
	public GameLogic(GameMap map)
	{
		this.map = map;
		this.gameover = false;
	};
	
	private boolean gameover;
	private GameMap map;
	private ArrayList<GameElements>  elements;
	
	public void setMap(GameMap m){this.map=m;}
	public GameMap getMap(){return this.map;}

	public void setGameOver(boolean over){this.gameover = over;}
	public boolean getGameOver(){return this.gameover;}
	
	public void addGameElements(GameElements elements){this.elements.add(elements);}
	public ArrayList<GameElements> getGameElements(){return this.elements;}

}
