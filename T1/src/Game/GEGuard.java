package Game;

import java.util.ArrayList;

public abstract class GEGuard extends GameElements {
	
	private ArrayList<Pair> caminho = new ArrayList<Pair>();
    int it;
    public ArrayList<Pair> getCaminho()
    {	
    	return this.caminho;
    }
	
	public GEGuard(int x, int y, char symbol)
	{
		super(x, y, symbol, false);
		this.caminho.add(new Pair(8,1));
		this.caminho.add(new Pair(7,1));
		this.caminho.add(new Pair(7,2));
		this.caminho.add(new Pair(7,3));
		this.caminho.add(new Pair(7,4));
		this.caminho.add(new Pair(7,5));
		this.caminho.add(new Pair(6,5));
		this.caminho.add(new Pair(5,5));
		this.caminho.add(new Pair(4,5));
		this.caminho.add(new Pair(3,5));
		this.caminho.add(new Pair(2,5));
		this.caminho.add(new Pair(1,5));
		this.caminho.add(new Pair(1,6));
		this.caminho.add(new Pair(2,6));
		this.caminho.add(new Pair(3,6));
		this.caminho.add(new Pair(4,6));
		this.caminho.add(new Pair(5,6));
		this.caminho.add(new Pair(6,6));
		this.caminho.add(new Pair(7,6));
		this.caminho.add(new Pair(8,6));
		this.caminho.add(new Pair(8,5));
		this.caminho.add(new Pair(8,4));
		this.caminho.add(new Pair(8,3));
		this.caminho.add(new Pair(8,2));		
		this.caminho.add(new Pair(8,1));
		it=0;
		
	};
	
	public GEGuard(int x, int y, char symbol,ArrayList<Pair> a)
	{	
		super(x, y,symbol,false);
		this.caminho=a;
	};
	
	
	public abstract void move(char[][] map);
}
