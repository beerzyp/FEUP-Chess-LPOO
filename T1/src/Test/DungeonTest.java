package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Game.DungeonMap;
import Game.GEGuardDrunken;
import Game.GEGuardRookie;
import Game.GEGuardSuspicious;
import Game.GEHero;
import Game.GameElements;
import Game.GameLogic;
import Game.GameMap;
import Game.Pair;

public class DungeonTest {
	
	char[][] map =		{{'X','X','X','X','X'},
			             {'X',' ',' ',' ','X'},
						 {'I',' ',' ',' ','X'},
						 {'I','k',' ',' ','X'},
						 {'X','X','X','X','X'}};
	
	public ArrayList<Pair> caminho= new ArrayList<Pair>();
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
	}
	
	@Test
	public void  testHeroCantExitDoor()
	{
		GameMap dungeon = new DungeonMap(map);
		GameLogic logic = new GameLogic(dungeon);
		logic.addGameElements(Hero);
		logic.addGameElements(Guard);
		logic.moveHero('s');
		logic.moveHero('a');
		logic.setGame();
		assertEquals(new Pair(2,1) ,logic.getHeroPosition());
		assertFalse(logic.getGameOver());
		assertFalse(logic.getGameWin());
	}
	
	@Test
	public void  testHeroOpenDoors()
	{
		GameMap dungeon = new DungeonMap(map);
		GameLogic logic = new GameLogic(dungeon);
		logic.addGameElements(Hero);
		logic.addGameElements(Guard);
		assertEquals(logic.getActualMap()[2][0], 'I');
		assertEquals(logic.getActualMap()[3][0], 'I');
		logic.moveHero('s');
		logic.moveHero('s');
		logic.setGame();
		assertEquals(logic.getActualMap()[2][0], 'S');
		assertEquals(logic.getActualMap()[3][0], 'S');
	}

	@Test
	public void  testHeroWinsLevel1()
	{
		GameMap dungeon = new DungeonMap(map);
		GameLogic logic = new GameLogic(dungeon);
		
		logic.addGameElements(Hero);
		logic.addGameElements(Guard);
		assertFalse(logic.getGameWin());
		logic.moveHero('s');
		logic.moveHero('s');
		logic.moveHero('a');
		logic.setGame();
		assertFalse(logic.getGameOver());
		assertTrue(logic.getGameWin());
	}
	
	@Test
	public void  testMoveGuardRookie()
	{
		GameMap dungeon = new DungeonMap(map);
		GameLogic logic = new GameLogic(dungeon);
		caminho.add(new Pair(3,1));
		caminho.add(new Pair(3,2));
		GameElements Guard1 = new GEGuardRookie(1,3,'G',caminho);
		//GameElements GuardSusp = new GEGuardSuspicious(2,2,'H',caminho);
		logic.addGameElements(Hero);
		logic.addGameElements(Guard1);
		Guard1.move(logic.getActualMap());
		logic.setGame();
		assertEquals(logic.getActualMap()[2][3],'G');
	}
	@Test
	public void  testMoveGuardSuspicious()
	{
		GameMap dungeon = new DungeonMap(map);
		GameLogic logic = new GameLogic(dungeon);
		caminho.add(new Pair(3,1));
		caminho.add(new Pair(3,2));
		GameElements Guard1 = new GEGuardSuspicious(1,3,'G',caminho);
		//GameElements GuardSusp = new GEGuardSuspicious(2,2,'H',caminho);
		logic.addGameElements(Hero);
		logic.addGameElements(Guard1);
		Guard1.move(logic.getActualMap());
		logic.setGame();
		
	}
	@Test
	public void  testMoveGuardDrunken()
	{
		GameMap dungeon = new DungeonMap(map);
		GameLogic logic = new GameLogic(dungeon);
		caminho.add(new Pair(3,1));
		caminho.add(new Pair(3,2));
		GameElements Guard1 = new GEGuardDrunken(1,3,'G',caminho);
		//GameElements GuardSusp = new GEGuardSuspicious(2,2,'H',caminho);
		logic.addGameElements(Hero);
		logic.addGameElements(Guard1);
		Guard1.move(logic.getActualMap());
		logic.setGame();
		
	}

}
