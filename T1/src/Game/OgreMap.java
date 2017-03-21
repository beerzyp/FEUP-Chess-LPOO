package Game;

import java.util.ArrayList;
import java.util.Arrays;

public class OgreMap implements GameMap, Cloneable {
	public OgreMap(){
		for  (int i = 0 ; i < matrix.length ; i++) {
			for  (int j = 0 ; j < matrix[i].length ; j++) {
				if(matrix[i][j] == 'I'){
					this.doors.add(new Pair(i,j)); 
				}
			}
		}
	};
	public OgreMap(char[][] map) {
		int l = map.length;
		matrix = new char[l][];
		for  (int i = 0 ; i < l ; i++) {
			matrix[i] = Arrays.copyOf(map[i], map[i].length);
		}
		
		for  (int i = 0 ; i < matrix.length ; i++) {
			for  (int j = 0 ; j < matrix[i].length ; j++) {
				if(matrix[i][j] == 'I'){
					this.doors.add(new Pair(i,j));
				}
			}
		}
	}
	
	ArrayList<Pair> doors = new ArrayList<Pair>();
	private char[][] matrix={
			{'X','X','X','X','X','X','X','X','X'},
			{'I',' ',' ',' ',' ',' ',' ','k','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', ' ', ' ', ' ', ' ', ' ',' ',' ', 'X'},
			{'X', ' ', ' ', ' ', ' ', ' ',' ',' ','X'},
			{'X', 'X', 'X', 'X', 'X', 'X','X','X','X'},
		};

	@Override public OgreMap clone() {
		OgreMap n =  new OgreMap(matrix);
	    return n;
	}
	
	ArrayList<Pair> getDoors(){return this.doors;}
	
	

	public char[][] getMap() {
		return this.matrix;
	}


//	public GameMap nextMap() {
//		return null;
//	}


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
