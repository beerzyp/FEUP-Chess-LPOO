package Game;

public interface GameMap {
	
void printmap();
char[][] getMap();
GameMap nextMap();
boolean moveTo(int x,int y);



}
