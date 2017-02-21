package Game;

public class DungeonMap implements GameMap {
private char[][] matrix={
		{'X','X','X','X','X','X','X','X','X','X'},
		{'X','H',' ',' ','I',' ','X',' ','G','X'},
		{'X','X','X',' ','X','X','X',' ',' ','X'},
		{'X',' ','I',' ','I',' ','X',' ',' ','X'},
		{'X','X','X',' ','X','X','X',' ',' ','X'},
		{'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
		{'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
		{'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X'},
		{'X', ' ', 'I', ' ', 'I', ' ', 'X', 'k', ' ', 'X'},
		{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
	};

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
	//gamelogic(x, y);	
	return false;
}

@Override
public void printmap() {
	for(int i=0;i<this.matrix.length;i++)
	{
		System.out.println(matrix[i]);
	}
	
}
}



