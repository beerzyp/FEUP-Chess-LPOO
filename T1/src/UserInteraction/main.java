package UserInteraction;

import Game.DungeonMap;
import Game.GEGuard;
import Game.GEHero;
import Game.GameElements;
import Game.GameLogic;

public class main {
	DungeonMap dungeon;
	GameElements Guard = new GEGuard();
	GameElements Hero = new GEGuard();

	
	GameLogic logic = new GameLogic(dungeon);

}
