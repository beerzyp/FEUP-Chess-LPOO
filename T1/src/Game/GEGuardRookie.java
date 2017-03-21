package Game;

import java.util.ArrayList;


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
	public GEGuardRookie(int x,int y)
	{
		super(x,y,'G');
		

	};
	public GEGuardRookie(int x, int y, char symbol,ArrayList<Pair> a)
	{	
		super(x, y,'G',a);
		
	};
}