package Game;

import java.util.ArrayList;
import java.util.Random;

import Others.Pair;

public class GEGuardDrunken extends GEGuard {
	
	
	boolean drunk;
	boolean direction; // false pra frente. true pra tras
	
	public void move(char[][] map)
	{
		if(it != this.getCaminho().size()){   	if(!drunk){Random randomGenerator = new Random();
			    int bool = randomGenerator.nextInt(2);if(bool==0){this.setSymbol('g');this.drunk = true;}else{if(!this.direction){if(it != this.getCaminho().size()-1){it++;}else{it=0;}Pair a = this.getCaminho().get(it);this.setx(a.getx());
						this.sety(a.gety());}else{
			    		if(it == 0){it = this.getCaminho().size()-1;}else{it--;}Pair a = this.getCaminho().get(it);this.setx(a.getx());this.sety(a.gety());}
}}else{Random randomGenerator = new Random();int bool = randomGenerator.nextInt(2);
if(bool==0) {int bol = randomGenerator.nextInt(2);this.setSymbol('G');
			    	this.drunk = false;if(bol==0) {this.direction = true;}else {this.direction = false;}}
			    else  { }}	}else{it = 0;}
	}
	
	
	public boolean getDrunk(){return this.drunk;};
	
	public GEGuardDrunken(int x, int y,ArrayList<Pair> a)
	{	 
		super(x, y, 'G',a);
		this.drunk = false;
		this.direction=false;
	};
}