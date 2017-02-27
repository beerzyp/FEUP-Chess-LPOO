package UserInteraction;

import Game.DungeonMap;
import Game.GEGuard;
import Game.GEHero;
import Game.GEOgre;
import Game.GameElements;
import Game.GameLogic;
import Game.GameMap;
import Game.OgreMap;

public class main {
	public static void main(String[] args)
	{
	GameMap dungeon = new DungeonMap();
	GameMap ogremap = new OgreMap();

	GameElements Guard = new GEGuard(2,3,'G');
	GameElements Ogre = new GEOgre(2,4,'O');
	GameElements Hero = new GEHero(1,1,'H');

	
	GameLogic logic = new GameLogic(ogremap);
	
	logic.addGameElements(Hero);
	logic.addGameElements(Guard);
	logic.addGameElements(Ogre);
	
	
	//começo do jogo
	
	if(logic.getMap().moveTo(1, 7))
	{
		logic.testKey(1, 7);
		Hero.setx(1);
		Hero.sety(7);
		for(int i =0; i < logic.getMap().getMap().length; i++)
		{
			System.out.println(logic.setGame()[i]);
		}
		
	}
	
	
	}

}
