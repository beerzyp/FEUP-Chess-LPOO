package Game;

import java.util.Arrays;

public class DungeonMap implements GameMap, Cloneable {
	
	public DungeonMap(){};
	public DungeonMap(char[][] map){
		int l = map.length;
		matrix = new char[l][];
		for  (int i = 0 ; i < l ; i++) {
			matrix[i] = Arrays.copyOf(map[i], map[i].length);
		}	
	};
	
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
    DungeonMap n =  new DungeonMap(matrix);
    return n;
}


public char[][] getMap() {
	return this.matrix;
}


public GameMap nextMap() {
	return new OgreMap();
}


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



