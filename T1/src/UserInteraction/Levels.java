package UserInteraction;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

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

public class Levels {
	Levels(){}
	
	
	public void printboard(GameLogic l)
	{
		for(int i =0; i < l.getActualMap().length; i++) //pinta o jogo
		{
			System.out.println(l.getActualMap()[i]); //MUITO IMPORTANTE, so existe um save do jogo para o tabuleiro nesta funcao setGame()
		}
	}
	
	public ArrayList<Integer> moveHasd(char direction, GameElements Hero)
	{
		ArrayList<Integer> a = new ArrayList<Integer>();
		
		if(direction == 'w')
		{	
			a.add(Hero.getx() - 1);
			a.add(Hero.gety());			
		}
		else if(direction == 's')
		{
			a.add(Hero.getx() + 1);
			a.add(Hero.gety());
		}
		else if(direction == 'd')
		{
			a.add(Hero.getx());
			a.add(Hero.gety() + 1);
		}
		else if(direction == 'a')
		{
			a.add(Hero.getx());
			a.add(Hero.gety() - 1);
		}
		
		return a;
	}
	
	public void level1()
	{
		//Level one
		System.out.println("Level 1:Dungeon");
		
		GameMap dungeon = new DungeonMap();
		GameElements Guard = new GEGuard(2,7,'G');
		GameElements Hero = new GEHero(1,1,'H');
		
		GameLogic logic = new GameLogic(dungeon);
		logic.addGameElements(Hero);
		logic.addGameElements(Guard);
		
		logic.setGame();
		printboard(logic);
		
		while(logic.getGameOver()==false || logic.getGameWin())
		{	
			System.out.println("Faça a jogada e toque enter (w,a,s,d):");
			Scanner s = new Scanner(System.in);
			char c = s.next().charAt(0);
			
			System.out.println(c);
			
			while(!logic.getMap().moveTo(moveHasd(c, Hero).get(0), moveHasd(c, Hero).get(1)))
			{
				System.out.println("Fa�a a jogada e toque enter:");
				s = new Scanner(System.in);
				c = s.next().charAt(0);
			}
			
			logic.cleanActualMap();
			
			logic.testKey(moveHasd(c, Hero).get(0), moveHasd(c, Hero).get(1));
			Hero.setx(moveHasd(c, Hero).get(0));
			Hero.sety(moveHasd(c, Hero).get(1));
			
			logic.setGame();
			printboard(logic);
		}
			
		if(logic.getGameWin()) //next level
		{
			
		}
		
	
	
	}

	public void level2()
	{
		//Level one
		System.out.println("Level 1:Ogre");
		
		GameMap dungeon = new OgreMap();
		GameElements Ogre = new GEOgre(2,4,'O', 2, 4);
		GameElements Ogre2 = new GEOgre(4,7,'O', 4, 7);
		GameElements Hero = new GEHero(1,1,'H');
		
		GameLogic logic = new GameLogic(dungeon);
		logic.addGameElements(Hero);
		logic.addGameElements(Ogre);
		logic.addGameElements(Ogre2);

		Ogre.move(logic.getActualMap());
		Ogre2.move(logic.getActualMap());
		logic.setGame();
		printboard(logic);
		
		while(logic.getGameOver()==false || logic.getGameWin())
		{	
			System.out.println("Faça a jogada e toque enter (w,a,s,d):");
			Scanner s = new Scanner(System.in);
			char c = s.next().charAt(0);
			
			System.out.println(c);
			
			while(!logic.getMap().moveTo(moveHasd(c, Hero).get(0), moveHasd(c, Hero).get(1)))
			{
				System.out.println("Fa�a a jogada e toque enter:");
				s = new Scanner(System.in);
				c = s.next().charAt(0);
			}
			
			logic.cleanActualMap();
			
			logic.pickKey(moveHasd(c, Hero).get(0), moveHasd(c, Hero).get(1));
			Hero.setx(moveHasd(c, Hero).get(0));
			Hero.sety(moveHasd(c, Hero).get(1));
			
			if(!Ogre.isStun())
				Ogre.move(logic.getActualMap());
			
			if(!Ogre2.isStun())
				Ogre2.move(logic.getActualMap());
			
			logic.setGame();
			printboard(logic);
		}
			
		if(logic.getGameWin()) //next level
		{
			
		}
		
	
	
	}


}
