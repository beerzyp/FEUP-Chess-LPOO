package Game;
 
import java.util.ArrayList;
import java.util.Random;

import Others.Pair;
 
public class GEOgre extends GameElements {
	
    private ArrayList<Pair> caminho = new ArrayList<Pair>();
    int it;
   
    public int aletorio4(){
        Random randomGenerator = new Random();
        int newint = randomGenerator.nextInt(4);
        return newint;
    }
   
   
    public ArrayList<Pair> getCaminho()
    {
        return this.caminho;
    }
   
    public boolean testMap(char[][] map, int x, int y){
        if(map[x][y] == ' ')   
            return true;
        else if(map[x][y] == 'k')
            return true;
        else if(map[x][y] == '*')
            return true;
       
       
        return false;
    }
    public void moveOgreSword(char[][] map,int newX,int newY)
    {
       newX = this.getx();
       newY = this.gety();
       
        while(!testMap(map, newX, newY))
        {      
        	newX = this.getx();
            newY = this.gety();
        	
            switch(aletorio4()){
            case 0:
                newY = newY + 1;
                break;
            case 1:
                newY = newY - 1;
                break;
            case 2:
                newX = newX + 1;
                break;
            case 3:
                newX = newX - 1;
                break;
        }
           
        }
       
        this.setWeaponPos(newX, newY);
    }
   
    public void move(char[][] map){
        int xat=this.getx();
        int yat=this.gety();
        
        
        System.out.println(xat);
        System.out.println(yat);
        
        switch(aletorio4()){
        case 0:
            yat = yat + 1;
            break;
        case 1:
            yat = yat - 1;
            break;
        case 2:
            xat = xat + 1;
            break;
        case 3:
            xat = xat - 1;
            break;
        }
        
        while(!testMap(map,xat,yat))
        { System.out.println("entra");
        
	        xat=this.getx();
	        yat=this.gety();
        	
            switch(aletorio4()){
            case 0:
                yat = yat + 1;
                break;
            case 1:
                yat = yat - 1;
                break;
            case 2:
                xat = xat + 1;
                break;
            case 3:
                xat = xat - 1;
                break;
            }
        }
        this.setx(xat);
        this.sety(yat);
        map[xat][yat] = this.getSymbol();
       
       
       
       moveOgreSword(map,xat,yat);
       
   
       
    };
 
   
    public GEOgre(int x, int y, char symbol, int weaponx, int weapony)
    {
        super(x, y, symbol, true);
        this.setWeaponPos(weaponx, weapony);
 
    };
}