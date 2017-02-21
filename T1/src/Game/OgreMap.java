package Game;

public class OgreMap implements GameMap {
	OgreMap(){};
	private char[][] matrix={
			{'X','X','X','X','X','X','X','X','X'},
			{'I',' ',' ',' ','O',' ',' ','k','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', ' ', ' ', ' ', ' ', ' ',' ',' ', 'X'},
			{'X', ' ', ' ', ' ', ' ', ' ',' ',' ','X'},
			{'X', 'H', ' ', ' ', ' ', ' ',' ',' ','X'},
			{'X', 'X', 'X', 'X', 'X', 'X','X','X','X'},
		};

	@Override

	public char[][] getMap() {
		// TODO Auto-generated method stub
		return this.matrix;
	}

	@Override
	public GameMap nextMap() {
		GameMap a1;
		return null;
	}

	@Override
	public boolean moveTo(int x, int y) {
		// TODO Auto-generated method stub
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
