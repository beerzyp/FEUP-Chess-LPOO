package Game;

public class GEHero extends GameElements {
	
public GEHero(int x, int y, char symbol)
{
	super(x, y, symbol, false);

};

public boolean moveTo(char[][] map, int x, int y){
	if(map[x][y] == ' ')
		return true;
	else if(map[x][y] == 'k')
		return true;
	else if(map[x][y] == 'S')
		return true;
	else if(map[x][y] == 'w')
		return true;
	
	return false;
}

public void move(char[][] map){
	
};
}
