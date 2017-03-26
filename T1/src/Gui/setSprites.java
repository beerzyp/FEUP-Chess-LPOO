package Gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Gui.guim;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import UserInteraction.Levels;

public class setSprites extends JPanel implements KeyListener {
	private guim gui;
	private ImageIcon Hero = new ImageIcon("res/images/shinchan.gif");
	private ImageIcon Guard = new ImageIcon("res/images/guard.gif");
	private ImageIcon GuardSleeping = new ImageIcon("res/images/guardsleeping.gif");
	private ImageIcon Wall = new ImageIcon("res/images/bush.png");
	private ImageIcon Key = new ImageIcon("res/images/lever.png");
	private ImageIcon Ogre = new ImageIcon("res/images/ogre.gif");
	private ImageIcon Floor = new ImageIcon("res/images/floor.png");
	private ImageIcon Stun = new ImageIcon("res/images/stun.gif");
	private ImageIcon Weapon = new ImageIcon("res/images/heroweapon.png");
	private ImageIcon Dollar = new ImageIcon("res/images/keydestructed.png");
	private ImageIcon DoorClosed = new ImageIcon("res/images/doorclosed.png");
	private ImageIcon DoorOpen = new ImageIcon("res/images/dooropened.png");
	private ImageIcon WeaponOgre = new ImageIcon("res/images/ogreweapon.gif");
	private ImageIcon HeroArmored = new ImageIcon("res/images/shinchanweapon.gif");
	private ImageIcon HeroKey = new ImageIcon("res/images/shinchankey.gif");
	
	private int upKey = KeyEvent.VK_W;
	private int leftKey = KeyEvent.VK_A;
	private int rightKey = KeyEvent.VK_D;
	private int downKey = KeyEvent.VK_S;
	
	private Levels level;
	public setSprites(Levels lvl, guim gui)
	{this.level=lvl;
	this.gui=gui;
	addKeyListener(this);
	setFocusable(true);
	requestFocus();}
	protected void drawImageOnBoard()
	{  
		
		this.removeAll();

		for (int j = 0; j < level.getActualMap().length; j++) {
			for (int i = 0; i < level.getActualMap()[j].length; i++) {
				if (level.getActualMap()[j][i] == 'X')
					this.add(new JLabel(this.Wall));
				else if (level.getActualMap()[j][i] == ' ')
					this.add(new JLabel(this.Floor));
				else if (level.getActualMap()[j][i] == 'A') 
					this.add(new JLabel(this.HeroArmored));
				else if (level.getActualMap()[j][i] == 'H')
					this.add(new JLabel(this.Hero));
				else if (level.getActualMap()[j][i] == '8')
					this.add(new JLabel(this.Stun));
				else if (level.getActualMap()[j][i] == 'G') 
					this.add(new JLabel(this.Guard));
				else if (level.getActualMap()[j][i] == 'g')
					this.add(new JLabel(this.GuardSleeping));
				else if (level.getActualMap()[j][i] == 'K')
					this.add(new JLabel(this.HeroKey));
				else if (level.getActualMap()[j][i] == 'k') 
					this.add(new JLabel(this.Key));
				else if (level.getActualMap()[j][i] == 'O')
					this.add(new JLabel(this.Ogre));
				else if (level.getActualMap()[j][i] == '*')
					this.add(new JLabel(this.WeaponOgre));
				else if (level.getActualMap()[j][i] == 'w')
					this.add(new JLabel(this.Weapon));
				else if (level.getActualMap()[j][i] == '$')
					this.add(new JLabel(this.Dollar));
				else if (level.getActualMap()[j][i] == 'I')
					this.add(new JLabel(this.DoorClosed));
				else if (level.getActualMap()[j][i] == 'S')
					this.add(new JLabel(this.DoorOpen));
				
			}
		}
		this.validate();
		
	}

	
	public void keyPressed(KeyEvent e) {
		if(gui.getGameOver())
		{}
		else{
	switch(e.getKeyCode()){
	case KeyEvent.VK_W:
	  gui.moveHero('w');
		break;
	case KeyEvent.VK_A:
		gui.moveHero('a');
		break;
	case KeyEvent.VK_D:
		gui.moveHero('d');
		break;
	case KeyEvent.VK_S:
		gui.moveHero('s');
		break;
	}}
	
	}

	
	public void keyReleased(KeyEvent arg0) {
	}

	
	public void keyTyped(KeyEvent arg0) {
	}
}
