package UserInteraction;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
	public void printboard(GameLogic l)
	{
		for(int i =0; i < l.getActualMap().length; i++) //pinta o jogo
		{
			System.out.println(l.getActualMap()[i]); //MUITO IMPORTANTE, so existe um save do jogo para o tabuleiro nesta funcao setGame()
		}
	}
	
	
	public void Levels(char w)
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
		while(logic.getGameOver()==false)
		{	
			System.out.println("Faça a jogada e toque enter:");
			char c = (char) System.in.read();
				if(c)
		    {
					
		    }
		}
			

		
	
	
	}


}
