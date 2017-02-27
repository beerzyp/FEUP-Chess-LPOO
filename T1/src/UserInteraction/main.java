package UserInteraction;

import Game.DungeonMap;
import Game.GEGuard;
import Game.GEHero;
import Game.GameElements;
import Game.GameLogic;
import Game.GameMap;

public class main {
	public static void main(String[] args)
	{
	GameMap dungeon = new DungeonMap();
	GameElements Guard = new GEGuard(9,2,'G');
	GameElements Hero = new GEHero(2,2,'H');

	
	GameLogic logic = new GameLogic(dungeon);
	
	
	logic.addGameElements(Hero);
	logic.addGameElements(Guard);
	logic.setGame();
	
	//começo do jogo
	
	if(logic.getMap().moveTo(3, 2))
	{
		logic.testKey(3, 2);
		Hero.setx(3);
		Hero.sety(2);
		System.out.print(logic.setGame());
	}
	
	
	}

}
