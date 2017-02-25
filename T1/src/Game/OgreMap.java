package Game;

public class OgreMap implements GameMap {
	OgreMap(){};
	private char[][] matrix={
			{'X','X','X','X','X','X','X','X','X'},
			{'I',' ',' ',' ',' ',' ',' ','k','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', ' ', ' ', ' ', ' ', ' ',' ',' ', 'X'},
			{'X', ' ', ' ', ' ', ' ', ' ',' ',' ','X'},
			{'X', ' ', ' ', ' ', ' ', ' ',' ',' ','X'},
			{'X', 'X', 'X', 'X', 'X', 'X','X','X','X'},
		};

	@Override

	public char[][] getMap() {
		return this.matrix;
	}

	@Override
	public GameMap nextMap() {
		return null;
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
