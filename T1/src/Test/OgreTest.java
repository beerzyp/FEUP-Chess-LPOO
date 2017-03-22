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
		Ogre.move(map); 
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
	
	@Test(timeout=1000)
	public void testSomeRandomBehaviour()
	{
		GameMap ogremap = new OgreMap(map);
		GameLogic logic = new GameLogic(ogremap);
		GameElements Ogre1 = new GEOgre(1,3,'O', 1, 2);
		logic.addGameElements(Hero);
		logic.addGameElements(Ogre1);
		boolean OgreupSwordup=false,OgreupSwordright=false,OgreupSwordleft=false,OgreupSworddown=false,OgrerigthSwordup=false,OgrerigthSwordright=false,OgrerigthSwordleft=false,OgrerigthSworddown=false,OgreleftSwordup=false,OgreleftSwordright=false,OgreleftSwordleft=false,OgreleftSworddown=false,OgredownSwordup=false,OgredownSwordright=false,OgredownSwordleft=false,OgredownSworddown=false;
		int xatual;
		int yatual;
		while(OgreupSwordup!=true || OgreupSwordright!=true || OgreupSwordleft!=true || OgreupSworddown!=true || 
		OgrerigthSwordup!=true || OgrerigthSwordright!=true || OgrerigthSwordleft!=true || 
		OgrerigthSworddown!=true || OgreleftSwordup!=true || OgreleftSwordright!=true || 
		OgreleftSwordleft!=true || OgreleftSworddown!=true || OgredownSwordup!=true || 
		OgredownSwordright!=true || OgredownSwordleft!=true || OgredownSworddown!=true)
		{   
			xatual=Ogre1.getx();
			yatual=Ogre1.gety();
			Ogre.move(map);
//			if(xatual-Ogre1.getx()==-1)
//			{
//				OgreupSwordup=true;
//			}
			
			
		}
	}
}
