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
import Game.OgreMap;
import Game.Pair;

public class OgreTest {
	char[][] map =		{{'X','X','X','X','X'},
			             {'X',' ',' ',' ','X'},
						 {'I',' ',' ',' ','X'},
						 {'I','k',' ',' ','X'},
						 {'X','X','X','X','X'}};
	
			
	//coordenadas não estao representadas nas funcoes por (x,y) mas sim (y,x)
			
	GameElements Hero = new GEHero(1,1,'H');
	GameElements Ogre = new GEOgre(1,3,'O', 1, 2);

	@Test
	public void testMoveHeroIsCaught() 
	{
		GameMap ogremap = new OgreMap(map);
		GameLogic logic = new GameLogic(ogremap);
		logic.addGameElements(Hero);
		logic.addGameElements(Ogre);	
		logic.moveHero('d');		
		assertFalse(logic.getGameOver());
		logic.setGame();

		assertTrue(logic.getGameOver());
	}
	
	@Test
	public void testMoveToKeyCell() 
	{
		GameMap ogremap = new OgreMap(map);
		GameLogic logic = new GameLogic(ogremap);
		logic.addGameElements(Hero);
		logic.addGameElements(Ogre);	
		
		assertEquals(Hero.getSymbol(), 'H');
		
		logic.moveHero('s');	
		logic.moveHero('s');

		logic.setGame();

		assertEquals(Hero.getSymbol(), 'K');
		
	}
	
	
	@Test
	public void testFailsOpenDoorCell() 
	{
		GameMap ogremap = new OgreMap(map);
		GameLogic logic = new GameLogic(ogremap);
		logic.addGameElements(Hero);
		logic.addGameElements(Ogre);	
		
		assertEquals(logic.getActualMap()[2][0], 'I');
		
		logic.moveHero('s');	

		logic.setGame();
		
		assertEquals(logic.getActualMap()[2][0], 'I');		
	}
	
	@Test
	public void testOpenDoorWithKey() 
	{
		GameMap ogremap = new OgreMap(map);
		GameLogic logic = new GameLogic(ogremap);
		logic.addGameElements(Hero);
		logic.addGameElements(Ogre);	
		
		assertEquals(logic.getActualMap()[3][0], 'I');
		
		logic.moveHero('s');
		logic.moveHero('s');

		logic.setGame();
		
		assertEquals(logic.getActualMap()[3][0], 'S');		
	}
	
	@Test
	public void testHeroWinsGame() 
	{
		GameMap ogremap = new OgreMap(map);
		GameLogic logic = new GameLogic(ogremap);
		logic.addGameElements(Hero);
		logic.addGameElements(Ogre);	
		
		assertFalse(logic.getGameWin());		
		
		logic.moveHero('s');
		logic.moveHero('s');
		logic.setGame();
		
		logic.moveHero('a');
		logic.setGame();
		
		assertTrue(logic.getGameWin());		
	}
	
}
