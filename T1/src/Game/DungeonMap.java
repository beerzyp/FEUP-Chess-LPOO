package Game;

public class DungeonMap implements GameMap, Cloneable {
	public DungeonMap(){};
	public DungeonMap(char[][] map){};
private char[][] matrix={
		{'X','X','X','X','X','X','X','X','X','X'},
		{'X',' ',' ',' ','I',' ','X',' ',' ','X'},
		{'X','X','X',' ','X','X','X',' ',' ','X'},
		{'X',' ','I',' ','I',' ','X',' ',' ','X'},
		{'X','X','X',' ','X','X','X',' ',' ','X'},
		{'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
		{'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
		{'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X'},
		{'X', ' ', 'I', ' ', 'I', ' ', 'X', 'k', ' ', 'X'},
		{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}
	};



@Override public DungeonMap clone() {
    return new DungeonMap();
}

@Override
public char[][] getMap() {
	return this.matrix;
}

@Override
public GameMap nextMap() {
	return new OgreMap();
}

@Override
public boolean moveTo(int x, int y) {
	
	if(this.matrix[x][y] == ' ')
		return true;
	else if(this.matrix[x][y] == 'k')
		return true;
	else if(this.matrix[x][y] == 'S')
		return true;
	
	return false;
}

}



