package Game;

import java.util.ArrayList;

import Others.Pair;


public class GEGuardRookie extends GEGuard {
	
	
   

	public void move(char[][] map)
	{  
		if(it != this.getCaminho().size()-1)
		{
			it++;
			Pair a = this.getCaminho().get(it);
			this.setx(a.getx());
			this.sety(a.gety());
		}
		else
		{
			it=0;
		}
		
	}
	public GEGuardRookie(int x,int y, ArrayList<Pair> a)
	{
		super(x,y,'G', a);
		

	};

	public GEGuardRookie(int x, int y, char symbol,ArrayList<Pair> a)
	{	
		super(x, y,'G',a);
		
	};
}