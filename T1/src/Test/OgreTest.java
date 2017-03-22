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
	
	char[][] map2 =		{{'X','X','X','X','X'},
            {'X',' ',' ',' ','X'},
			 {'I',' ',' ',' ','X'},
			 {'I',' ',' ',' ','X'},
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
		GameMap ogremap = new OgreMap(map2);
		GameLogic logic = new GameLogic(ogremap);
		GameElements Ogre1 = new GEOgre(1,3,'O', 1, 2);
		logic.addGameElements(Hero);
		logic.addGameElements(Ogre1);
		
		Ogre1.move(logic.getActualMap());
		
		boolean OgreupSwordup=false,OgreupSwordright=false,OgreupSwordleft=false,OgreupSworddown=false,OgrerigthSwordup=false,OgrerigthSwordright=false,OgrerigthSwordleft=false,OgrerigthSworddown=false,OgreleftSwordup=false,OgreleftSwordright=false,OgreleftSwordleft=false,OgreleftSworddown=false,OgredownSwordup=false,OgredownSwordright=false,OgredownSwordleft=false,OgredownSworddown=false;
		int xatual, xwatual;
		int yatual, ywatual;
		
		while(
				OgreupSwordup!=true || OgreupSwordright!=true || OgreupSwordleft!=true || OgreupSworddown!=true || 
				OgrerigthSwordup!=true || OgrerigthSwordright!=true || OgrerigthSwordleft!=true || OgrerigthSworddown!=true || 
				OgreleftSwordup!=true || OgreleftSwordright!=true || OgreleftSwordleft!=true || OgreleftSworddown!=true || 
				OgredownSwordup!=true || OgredownSwordright!=true || OgredownSwordleft!=true || OgredownSworddown!=true
			)
		{   
			logic.cleanActualMap();
			
			xatual=Ogre1.getx();
			yatual=Ogre1.gety();
			
			Ogre1.move(logic.getActualMap());
			xwatual = Ogre1.getWeaponX();
			ywatual = Ogre1.getWeaponY();
			
			if(xatual-Ogre1.getx()==-1) //ogre anda para direita
			{
				if(xwatual - Ogre1.getx() == -1)
					OgrerigthSwordright = true;
				else if(xwatual - Ogre1.getx() == 1)
					OgrerigthSwordleft = true;
				else if(ywatual - Ogre1.gety() == -1)
					OgrerigthSwordup = true;
				else if(ywatual - Ogre1.gety() == 1)
					OgrerigthSworddown = true;
			}
			else if(xatual-Ogre1.getx()==1) //ogre anda para esquerda
			{
				if(xwatual - Ogre1.getx() == -1)
					OgreleftSwordright = true;
				else if(xwatual - Ogre1.getx() == 1)
					OgreleftSwordleft = true;
				else if(ywatual - Ogre1.gety() == -1)
					OgreleftSwordup = true;
				else if(ywatual - Ogre1.gety() == 1)
					OgreleftSworddown = true;
			}
			else if(yatual-Ogre1.gety()==-1) //ogre anda para baixo
			{
				if(xwatual - Ogre1.getx() == -1)
					OgredownSwordright = true;
				else if(xwatual - Ogre1.getx() == 1)
					OgredownSwordleft = true;
				else if(ywatual - Ogre1.gety() == -1)
					OgredownSwordup = true;
				else if(ywatual - Ogre1.gety() == 1)
					OgredownSworddown = true;
			}
			else if(yatual-Ogre1.gety()==1) //ogre anda para cima
			{
				if(xwatual - Ogre1.getx() == -1)
					OgreupSwordright = true;
				else if(xwatual - Ogre1.getx() == 1)
					OgreupSwordleft = true;
				else if(ywatual - Ogre1.gety() == -1)
					OgreupSwordup = true;
				else if(ywatual - Ogre1.gety() == 1)
					OgreupSworddown = true;
			}
			
			logic.setGame();
			
			System.out.print("(");
			System.out.print(Ogre1.getWeaponX());
			System.out.print(",");
			System.out.print(Ogre1.getWeaponY());
			System.out.print(")");

			
			logic.printboard();
			
			assertEquals(logic.getActualMap()[Ogre1.getx()][Ogre1.gety()], 'O');
			assertEquals(logic.getActualMap()[Ogre1.getWeaponX()][Ogre1.getWeaponY()], '*');
			
		}
	}
}
