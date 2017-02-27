package UserInteraction;

import Game.DungeonMap;
import Game.GEGuard;
import Game.GEHero;
import Game.GameElements;
import Game.GameLogic;
import Game.GameMap;

public class main {
	public static void main(String[] args)
	{
	GameMap dungeon = new DungeonMap();
	GameElements Guard = new GEGuard(1,8,'G');
	GameElements Hero = new GEHero(1,1,'H');

	
	GameLogic logic = new GameLogic(dungeon);
	for(int i =0; i < 10; i++)
	{
		System.out.println(logic.setGame()[i]);
	}
	
	logic.addGameElements(Hero);
	logic.addGameElements(Guard);
	for(int i =0; i < 10; i++)
	{
		System.out.println(logic.setGame()[i]);
	}
	
	//começo do jogo
	
	if(logic.getMap().moveTo(1, 2))
	{
		//logic.testKey(1, 2);
		Hero.setx(1);
		Hero.sety(2);
		for(int i =0; i < 10; i++)
		{
			System.out.println(logic.setGame()[i]);
		}
		
		for(int i =0; i < 10; i++)
		{
			System.out.println(logic.getMap().getMap()[i]);
		}
		
	}
	
	
	}

}
