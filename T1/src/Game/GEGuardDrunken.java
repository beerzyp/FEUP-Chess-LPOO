package Game;

import java.util.Random;

public class GEGuardDrunken extends GameElements {
	
	
	public boolean testMap(char[][] map, int x, int y)
	{
		if(map[x][y] == ' ')	
			return true;
		else if(map[x][y] == 'k')
			return true;
		else if(map[x][y] == 'A')
			return true;
		else if(map[x][y] == 'H')
			return true;
		else if(map[x][y] == 'K')
			return true;
		
		
		return false;
	}
	public void move(char[][] map)
	{
		Random randomGenerator = new Random();
		int newX = randomGenerator.nextInt(map.length-2)+1;
		int newY = randomGenerator.nextInt(map.length-2)+1;
		
		while(!testMap(map, newX, newY)){
		newX = randomGenerator.nextInt(map.length-2)+1;
		newY = randomGenerator.nextInt(map.length-2)+1;
		}
		this.setx(newX);
		this.sety(newY);
		map[newX][newY] = this.getSymbol();
		
		newX = this.getx();
		newY = this.gety();
		
	}
	public GEGuardDrunken(int x, int y, char symbol)
	{
		super(x, y, symbol, false);

	};
}