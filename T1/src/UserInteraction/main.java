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
	GameElements Guard = new GEGuard(9,2);
	GameElements Hero = new GEHero(2,2);

	
	GameLogic logic = new GameLogic(dungeon);
	
	logic.addGameElements(Guard);
	}

}
