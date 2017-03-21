package Game;

public interface GameMap{
char[][] getMap();
boolean moveTo(int x,int y);
GameMap clone();
}
