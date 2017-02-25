package Game;

public interface GameMap {
char[][] getMap();
GameMap nextMap();
boolean moveTo(int x,int y);
}
