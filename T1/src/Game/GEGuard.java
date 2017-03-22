package Game;

import java.util.ArrayList;

import Others.Pair;

public abstract class GEGuard extends GameElements {
	
	
	private ArrayList<Pair> caminho = new ArrayList<Pair>();
    int it;
    public ArrayList<Pair> getCaminho()
    {	
    	return this.caminho;
    }
	
	
	public GEGuard(int x, int y, char symbol,ArrayList<Pair> a)
	{	
		super(x, y,symbol,false);	
			this.caminho=a;
			it = 0;
	};
	
	
	public abstract void move(char[][] map);
}
