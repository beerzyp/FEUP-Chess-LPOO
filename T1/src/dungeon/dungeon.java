package dungeon;

import java.util.Vector;

public class dungeon {
	static int herox;
	static int heroy;
	static int key;
	static int gameover;
	
	public static void main(String[] args)
	{
		Vector<Vector<char[]>> a1= new Vector<Vector<char[]>>();
		char[][] matrix=
			{
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
		
		herox = 2;
		heroy = 2;
		key = 0;
		gameover = 0;
		
		for(int i =0; i < 10; i++)
		{
			System.out.println(matrix[i]);
		}
	}

	public static void verifica(String direction, int x, int y, char[][] matrix)
	{
		if(direction == "up")
		{
			if(matrix[herox-1][heroy]  == 'X')
			{
				
			}
			else if(matrix[herox-1][heroy] == 'I')
			{
				
			}
			else if(matrix[herox-1][heroy] == 'S')
			{
				gameover = 1;
			}
			else if(matrix[herox-1][heroy] == 'G')
			{
				gameover = 1;
			}
			else if(matrix[herox-1][heroy] == ' ')
			{
				matrix[herox-1][heroy] = 'H';
				matrix[herox][heroy] = ' ';
				herox = herox-1;
			}
		}
	}
}
