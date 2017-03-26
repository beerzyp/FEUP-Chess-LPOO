package UserInteraction;


import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JLabel;

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
import Others.Pair;

public class Levels {
	GameLogic logic;
	public GameElements Guard,Hero;
	
	public Levels(){}
	public void Initializel1(String typeGuard)
	{
		ArrayList<Pair> caminho = new ArrayList<Pair>();
		caminho.add(new Pair(8,1));
		caminho.add(new Pair(7,1));
		caminho.add(new Pair(7,2));
		caminho.add(new Pair(7,3));
		caminho.add(new Pair(7,4));
		caminho.add(new Pair(7,5));
		caminho.add(new Pair(6,5));
		caminho.add(new Pair(5,5));
		caminho.add(new Pair(4,5));
		caminho.add(new Pair(3,5));
		caminho.add(new Pair(2,5));
		caminho.add(new Pair(1,5));
		caminho.add(new Pair(1,6));
		caminho.add(new Pair(2,6));
		caminho.add(new Pair(3,6));
		caminho.add(new Pair(4,6));
		caminho.add(new Pair(5,6));
		caminho.add(new Pair(6,6));
		caminho.add(new Pair(7,6));
		caminho.add(new Pair(8,6));
		caminho.add(new Pair(8,5));
		caminho.add(new Pair(8,4));
		caminho.add(new Pair(8,3));
		caminho.add(new Pair(8,2));		
		caminho.add(new Pair(8,1));
		
		GameMap dungeon = new DungeonMap(null);
		logic = new GameLogic(dungeon);
		
		Hero = new GEHero(1,1,'H');
		
		if(typeGuard=="Suspicious")
		{
			Guard = new GEGuardSuspicious(1,8, caminho);
		}
		else if(typeGuard=="Rookie")
		{
			Guard = new GEGuardRookie(1,8, caminho);
		}
		else if(typeGuard=="Drunken")
		{
			Guard = new GEGuardDrunken(1,8, caminho);
		}
		else{return;}
		
		logic.addGameElements(Hero);
		logic.addGameElements(Guard);
		Guard.move(logic.getActualMap());
		logic.setGame();
	}
	public char[][] getActualMap()
	{
		return this.logic.getActualMap();
	}
	public boolean moveH(char c){
		if(!logic.moveHero(c))
		{
			return false;
		}
		if(!logic.level2)
			this.moveG();
		else{
			this.moveO();
 		}
		return true;
	}
	
	private void moveO() {
		for (int i = 0; i < logic.getGameElements().size(); i++) {
			if(logic.getGameElements().get(i).getSymbol() == 'O')
				if(!logic.getGameElements().get(i).isStun())
					logic.getGameElements().get(i).move(logic.getActualMap());
		}
	}
	public String returnboard()
	{	
		char [][] map = logic.getActualMap(); 
	  String output = "";
	  for(int i =0; i < map.length; i++){ //pinta o jogo
		for (int j = 0; j < map[i].length; j++) {
			output += map[i][j] + " ";
		}
		output += "\n";
	  }
	  
	  return output;
	}
	public void printboard(GameLogic l)
	{
		for(int i =0; i < l.getActualMap().length; i++) //pinta o jogo
		{ 
			System.out.println(l.getActualMap()[i]); 
		}
	}
	
	public void Initializel2(int lblNumberOfOgres) {
		System.out.print(lblNumberOfOgres);
		GameMap dungeon = new OgreMap(null);
		Hero = new GEHero(1,1,'H');
		logic = new GameLogic(dungeon);
		logic.addGameElements(Hero);
		GameElements Ogre;
		
		for (int i = 0; i < lblNumberOfOgres; i++) {
			Ogre = new GEOgre(2,3+i,'O', 2, 4);
			logic.addGameElements(Ogre);
		}
		
		moveO();
		moveH('d');
		logic.setGame();
		logic.cleanActualMap();
		moveH('a');
		logic.setGame();

		
	}
	
	public int level1()
	{
		ArrayList<Pair> caminho = new ArrayList<Pair>();
		caminho.add(new Pair(8,1));
		caminho.add(new Pair(7,1));
		caminho.add(new Pair(7,2));
		caminho.add(new Pair(7,3));
		caminho.add(new Pair(7,4));
		caminho.add(new Pair(7,5));
		caminho.add(new Pair(6,5));
		caminho.add(new Pair(5,5));
		caminho.add(new Pair(4,5));
		caminho.add(new Pair(3,5));
		caminho.add(new Pair(2,5));
		caminho.add(new Pair(1,5));
		caminho.add(new Pair(1,6));
		caminho.add(new Pair(2,6));
		caminho.add(new Pair(3,6));
		caminho.add(new Pair(4,6));
		caminho.add(new Pair(5,6));
		caminho.add(new Pair(6,6));
		caminho.add(new Pair(7,6));
		caminho.add(new Pair(8,6));
		caminho.add(new Pair(8,5));
		caminho.add(new Pair(8,4));
		caminho.add(new Pair(8,3));
		caminho.add(new Pair(8,2));		
		caminho.add(new Pair(8,1));
		
		
		//Level one
		System.out.println("Level 1:Dungeon");
		
		GameMap dungeon = new DungeonMap(null);
		GameElements Guard = new GEGuardRookie(1,8, caminho);
		GameElements Guard2 = new GEGuardSuspicious(1,8, caminho);
		GameElements Guard3 = new GEGuardDrunken(1,8, caminho);
	
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
		
		GameMap dungeon = new OgreMap(null);
		GameElements Ogre = new GEOgre(2,4,'O', 2, 4);
		GameElements Ogre2 = new GEOgre(4,7,'O', 4, 7);
		GameElements Ogre3 = new GEOgre(5,3,'O', 5, 4);

		GameElements Hero = new GEHero(1,1,'H');
		
		GameLogic logic = new GameLogic(dungeon);
		logic.addGameElements(Hero);
		logic.addGameElements(Ogre);
		logic.addGameElements(Ogre2);
		logic.addGameElements(Ogre3);

		Ogre.move(logic.getActualMap());
		Ogre2.move(logic.getActualMap());
		Ogre3.move(logic.getActualMap());

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
			
			System.out.print("flag:");

			System.out.print(Ogre.isStun());
			
			
		if(!Ogre.isStun())
			Ogre.move(logic.getActualMap());			
		if(!Ogre2.isStun())
			Ogre2.move(logic.getActualMap());
		if(!Ogre3.isStun())
			Ogre3.move(logic.getActualMap());
			
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
	
	public void moveG(){
		Guard.move(logic.getActualMap());
	}
	
	public void setGame() {
		logic.setGame();		
	}
	public void cleanMap() {
		logic.cleanActualMap();
	}
	public boolean gameWin() {
		return logic.getGameWin();
	}
	public boolean gameOver() {
		return logic.getGameOver();
	}
	public boolean boolLevel2() {
		return logic.level2;
	}
	public void addElements(GEOgre geOgre) {
		logic.addGameElements(geOgre);
		
	}
	public void InitializeNewMap(char[][] newMap, Pair pair) {
		GameMap dungeon = new DungeonMap(newMap);
	
		GameElements Hero = new GEHero(pair.getx(),pair.gety(),'H');
		
		logic = new GameLogic(dungeon);
		logic.addGameElements(Hero);
		
		logic.setGame();
		
	}


}
