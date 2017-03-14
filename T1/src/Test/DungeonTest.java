package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Game.DungeonMap;
import Game.GEGuard;
import Game.GEGuardDrunken;
import Game.GEGuardRookie;
import Game.GEGuardSuspicious;
import Game.GEHero;
import Game.GEOgre;
import Game.GameElements;
import Game.GameLogic;
import Game.GameMap;
import Game.OgreMap;
import Game.Pair;

public class DungeonTest {
	char[][] map =		{{'X','X','X','X','X'},
			             {'X',' ',' ',' ','X'},
						 {'I',' ',' ',' ','X'},
						 {'I','k',' ',' ','X'},
						 {'X','X','X','X','X'}};
	
			
			
			
	GameElements Guard = new GEGuardRookie(1,3);
	GameElements Hero = new GEHero(1,1,'H');
	
	@Test
	public void testMoveHeroToFreeCell() {
		GameMap dungeon = new DungeonMap(map);
		GameLogic logic = new GameLogic(dungeon);
		logic.addGameElements(Hero);
		logic.addGameElements(Guard);
		assertEquals(new Pair(1,1) ,logic.getHeroPosition());
		assertTrue(logic.moveHero('s'));
		assertEquals(new Pair(2,1) ,logic.getHeroPosition());
	}
	@Test
	public void testMoveHeroToWall() {
		GameMap dungeon = new DungeonMap(map);
		GameLogic logic = new GameLogic(dungeon);
		logic.addGameElements(Hero);
		logic.addGameElements(Guard);
		assertEquals(new Pair(1,1) ,logic.getHeroPosition());
		logic.moveHero('w');
		assertEquals(new Pair(1,1) ,logic.getHeroPosition());
	}
	
	@Test
	public void  testHeroIsCapturedByGuard()
	{
		GameMap dungeon = new DungeonMap(map);
		GameLogic logic = new GameLogic(dungeon);
		logic.addGameElements(Hero);
		logic.addGameElements(Guard);
		assertFalse(logic.getGameOver());
		logic.moveHero('d');
		logic.setGame();
		assertTrue(logic.getGameOver());
//		assertEquals(logic.)	
		
	}


}
