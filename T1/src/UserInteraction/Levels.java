package UserInteraction;


import java.util.Scanner;

import Game.DungeonMap;
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
			System.out.println(l.getActualMap()[i]); 
		}
	}
	
	public int level1()
	{
		//Level one
		System.out.println("Level 1:Dungeon");
		
		GameMap dungeon = new DungeonMap();
		GameElements Guard = new GEGuardRookie(1,8);
		GameElements Guard2 = new GEGuardSuspicious(1,8);
		GameElements Guard3 = new GEGuardDrunken(1,8);
	
		GameElements Hero = new GEHero(1,1,'H');
		
		GameLogic logic = new GameLogic(dungeon);
		logic.addGameElements(Hero);
		logic.addGameElements(Guard);
		logic.addGameElements(Guard2);
		logic.addGameElements(Guard3);
		
		logic.setGame();
		printboard(logic);
		
		while(logic.getGameOver()==false && logic.getGameWin()==false)
		{	
			System.out.println("Faça a jogada e toque enter (w,a,s,d):");
			Scanner s = new Scanner(System.in);
			char c = s.next().charAt(0);
			
			while(!logic.moveHero(c))
			{
				System.out.println("Fa�a a jogada e toque enter:");
				s = new Scanner(System.in);
				c = s.next().charAt(0);
			}
			
			logic.cleanActualMap();
			
			
			Guard.move(logic.getActualMap());
			Guard2.move(logic.getActualMap());
			Guard3.move(logic.getActualMap());
			
			logic.setGame();
			printboard(logic);
		}
			
		if(logic.getGameWin()) //next level
		{
			System.out.println("Congratulations! You won level 1!");
			return 0;
		}
		else if(logic.getGameOver() == true){
			System.out.println("Game Over! Try Again!");
			return 1;
		}
		
		return -1;
	}

	public int level2()
	{
		//Level one
		System.out.println("Level 2:Ogre");
		
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
		
		while(logic.getGameOver()==false && logic.getGameWin()==false)
		{	
			logic.setGame();
			System.out.println("Faça a jogada e toque enter (w,a,s,d):");
			Scanner s = new Scanner(System.in);
			char c = s.next().charAt(0);
			
			while(!logic.moveHero(c))
			{
				System.out.println("Fa�a a jogada e toque enter:");
				s = new Scanner(System.in);
				c = s.next().charAt(0);
			}
			
			logic.cleanActualMap();
			
			
			
			
			if(!Ogre.isStun())
				Ogre.move(logic.getActualMap());
			
			if(!Ogre2.isStun())
				Ogre2.move(logic.getActualMap());
			
			logic.setGame();
			printboard(logic);
		}
			
		if(logic.getGameWin()) //next level
		{
			System.out.println("Congratulations! You won level 2!");
			return 0;
		}
		else if(logic.getGameOver() == true){
			System.out.println("Game Over! Try Again!");
			return 1;
		}
		
		return -1;
		
	}


}
