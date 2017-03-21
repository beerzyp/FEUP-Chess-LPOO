package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Game.DungeonMap;
import Game.GEGuardRookie;
import Game.GEHero;
import Game.GEOgre;
import Game.GameElements;
import Game.GameLogic;
import Game.GameMap;
import Game.Pair;

public class OgreTest {
	char[][] map =		{{'X',' ',' ','X'},
			             {'X',' ',' ','X'},
						 {'I',' ',' ',' '},
						 {'X',' ',' ','X'}};
	
			
	//coordenadas não estao representadas nas funcoes por (x,y) mas sim (y,x)
			
	GameElements Hero = new GEHero(1,1,'H');
	GameElements Ogre = new GEOgre(2,2,'O', 2, 3);
	GameElements Ogre1 = new GEOgre(2,3,'O', 2, 3);
	GameElements Ogre2 = new GEOgre(3,2,'O', 2, 3);
	@Test
	public void testMoveHeroIsCaught() 
	{
		GameMap dungeon = new DungeonMap(map);
		GameLogic logic = new GameLogic(dungeon);
		logic.addGameElements(Hero);
		logic.addGameElements(Ogre);
		logic.addGameElements(Ogre1);
		logic.addGameElements(Ogre2);
		logic.moveHero('d');
		logic.moveHero('d');
		assertFalse(logic.getGameOver());
		logic.moveHero('s');
		Ogre1.move(logic.getActualMap());
		Ogre.move(logic.getActualMap());
		Ogre2.move(logic.getActualMap());
		logic.setGame();
		assertTrue(logic.getGameOver());
	}
}
