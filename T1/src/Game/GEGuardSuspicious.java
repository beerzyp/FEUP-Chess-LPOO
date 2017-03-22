package Game;

import java.util.ArrayList;
import java.util.Random;

public class GEGuardSuspicious extends GEGuard {
	
	public GEGuardSuspicious(int x, int y)
	{
		super(x, y,'G');

	};
	public GEGuardSuspicious(int x, int y, char symbol,ArrayList<Pair> a)
	{	
		super(x, y, 'G',a);
	};
	

	public void move(char[][] map){
		
		if(it != this.getCaminho().size()-1)
		{   
			Random randomGenerator = new Random();
		    int bool = randomGenerator.nextInt(2);
		    
		    if(bool==0)
		    {
				it++;
				Pair a = this.getCaminho().get(it);
				this.setx(a.getx());
				this.sety(a.gety());
		    }
		    else
		    {
		    	if(it == 0)
				{
					it = this.getCaminho().size()-1;
				}
				else
				it--;
		    	
		    	Pair a = this.getCaminho().get(it);
				this.setx(a.getx());
				this.sety(a.gety());
		    }
		}
		else
		{
			it=0;
		}	
	}
}