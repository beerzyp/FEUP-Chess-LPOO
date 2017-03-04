package Game;

import java.util.Random;

public class GEOgre extends GameElements {
	
	public int ramdomWeaponPos(){
		Random randomGenerator = new Random();
		int newint = randomGenerator.nextInt(4);
		return newint;
	}
	
	public boolean testMap(char[][] map, int x, int y){
		if(map[x][y] == ' ')	
			return true;
		else if(map[x][y] == 'k')
			return true;
		else if(map[x][y] == 'A')
			return true;
		else if(map[x][y] == 'H')
			return true;
		else if(map[x][y] == '*')
			return true;
		else if(map[x][y] == 'K')
			return true;
		
		
		return false;
	}
	
	public void move(char[][] map){
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
		
		while(!testMap(map, newX, newY))
		{
			newX = this.getx();
			newY = this.gety();
			
			switch(ramdomWeaponPos()){
			case 0:
				newY = newY + 1;
				break;
			case 1:
				newY = newY - 1;
				break;
			case 2:
				newX = newX + 1;
				break;
			case 3:
				newX = newX - 1;
				break;
			}
			
		}
		
		this.setWeaponPos(newX, newY);
		
	};

	
	public GEOgre(int x, int y, char symbol, int weaponx, int weapony)
	{
		super(x, y, symbol, true);
		this.setWeaponPos(weaponx, weapony);

	};
}
