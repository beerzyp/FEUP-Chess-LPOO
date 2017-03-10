package Game;

public class Pair {
	private int x;
	private int y;
	
	public int getx(){return x;}
	public int gety(){return y;}
	public void setx(int x){this.x=x;}
	public void sety(int y){this.y=y;}
	public Pair(int x,int y)
	{
		this.x=y;
		this.y=x;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}
