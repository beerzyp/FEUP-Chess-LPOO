package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;



import javax.swing.JTextField;
import javax.swing.JTextArea;

import UserInteraction.Levels;
import Game.DungeonMap;
import Game.GEGuardDrunken;
import Game.GEGuardRookie;
import Game.GEGuardSuspicious;
import Game.GEHero;
import Game.GameElements;
import Game.GameLogic;
import Game.GameMap;
import Game.OgreMap;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.UIManager;

public class guim{

    private Levels level = new Levels();
	private JFrame frame;
	private JTextField textField;
	private JPanel gameArea;
	
	private int upKey = KeyEvent.VK_W;
	private int leftKey = KeyEvent.VK_A;
	private int rightKey = KeyEvent.VK_D;
	private int downKey = KeyEvent.VK_S;
	
	private String guard_type;
	private JTextArea newtext;
	private JComboBox GuardType;
	private JLabel lblNumberOfOgres;
	private JButton w,a,s,d;
	private JLabel label1;
	private java.awt.Image exit;
	
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
	
	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {		 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guim window = new guim();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public guim() {
		initialize();
	}

    
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{  ImageIcon ii;
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Courier New", Font.PLAIN, 12));
		frame.setBounds(100, 100, 496, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	
	
		JLabel guardtype = new JLabel("Personality of Guard: ");
		guardtype.setVerticalAlignment(SwingConstants.TOP);
		guardtype.setBounds(32, 43, 200, 22);
		frame.getContentPane().add(guardtype);
		
	    GuardType = new JComboBox(new String[] {"Rookie", "Suspicious","Drunken"});
		GuardType.setBounds(191, 39, 248, 22);
		frame.getContentPane().add(GuardType);
		
		lblNumberOfOgres = new JLabel("Number Of Ogres: ");
		lblNumberOfOgres.setBounds(32, 14, 200, 15);
		frame.getContentPane().add(lblNumberOfOgres);
		
		textField = new JTextField();
		textField.setBounds(172, 12, 114, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setFont(new Font("Courier New", Font.PLAIN, 12));
		btnNewGame.addActionListener(new ActionListener() //starts game
		{ 
			public void actionPerformed(ActionEvent a)
			{
				initLevel1();
			}
		});
		btnNewGame.setBounds(364, 113, 117, 25);
		frame.getContentPane().add(btnNewGame);
		
		this.gameArea= new JPanel();
		this.gameArea.setBounds(20, 75, 330, 340);
		this.gameArea.setLayout(new GridLayout(10, 10, 0, 0));
		frame.getContentPane().add(gameArea);
		
		JButton btnW = new JButton("W");
		btnW.setEnabled(false);
		btnW.setFont(new Font("Courier New", Font.PLAIN, 11));
		btnW.addActionListener(new ActionListener() //starts game
				{ 
					public void actionPerformed(ActionEvent a)
					{
						moveHero('w');
					}
				});
		btnW.setBounds(398, 217, 41, 22);
		frame.getContentPane().add(btnW);
		this.w=btnW;
		

		
		JButton btnA = new JButton("A");
		btnA.setFont(new Font("Courier New", Font.PLAIN, 11));
		btnA.addActionListener(new ActionListener() //starts game
				{ 
					public void actionPerformed(ActionEvent a)
					{
						moveHero('a');
					}
				});
		btnA.setBounds(364, 251, 41, 22);
		frame.getContentPane().add(btnA);
		this.a=btnA;

		
		JButton btnD = new JButton("D");
		btnD.setFont(new Font("Courier New", Font.PLAIN, 11));
		btnD.addActionListener(new ActionListener() //starts game
				{ 
					public void actionPerformed(ActionEvent a)
					{
						moveHero('d');
					}
				});
		btnD.setBounds(432, 251, 41, 22);
		frame.getContentPane().add(btnD);
		this.d=btnD;
		
		JLabel label = new JLabel("Welcome to the Dungeon Game!");
		label.setBounds(32,421,284,15);
		label.setFont(new Font ("Courier New",Font.PLAIN,14));
		frame.getContentPane().add(label);
		this.label1=label;
		
		JButton btnS = new JButton("S");
		btnS.setFont(new Font("Courier New", Font.PLAIN, 11));
		btnS.addActionListener(new ActionListener() //starts game
				{ 
					public void actionPerformed(ActionEvent a)
					{
						moveHero('s');
					}
				});
		btnS.setBounds(398, 285, 41, 22);
		frame.getContentPane().add(btnS);
		this.s=btnS;
		
		this.w.setEnabled(false);
		this.a.setEnabled(false);
		this.s.setEnabled(false);
		this.d.setEnabled(false);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Courier New", Font.PLAIN, 12));
		btnExit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent a)
			{
				System.exit(0);
			}
		});
		btnExit.setBounds(364, 418, 117, 25);
		frame.getContentPane().add(btnExit);
		
		JLabel label1 = new JLabel("");
		label1.setFont(new Font("Courier New", Font.PLAIN, 15));
		label1.setBounds(32, 371, 284, 15);
		frame.getContentPane().add(label1);
		
		
//		JLabel gif= new JLabel(new ImageIcon("Z:/git/LPOO1617_T5G8nobo/T1/res/images/shinchankey.gif"));
//		
//		JPanel panel = new JPanel();
//		panel.add(gif);
//		
//	
//		panel.setBounds(342, 148, 106, 169);
//		frame.getContentPane().add(panel);
//		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		

}


	protected void moveHero(char a) {
		level.cleanMap();
		if(!level.moveH(a))
		{
			label1.setText("Invalid move, try again");
		}
		else{
		label1.setText("");
		level.setGame();
		}
		
		if(!level.gameWin())
			if(!level.gameOver()){
				level.setGame();
				drawImageOnBoard();
			}
			else
			{
				drawImageOnBoard();
				label1.setText("You lost the Game! Try Again!");
				this.a.setEnabled(false);
				this.w.setEnabled(false);
				this.s.setEnabled(false);
				this.d.setEnabled(false);
				return;
			}
		else
			if(!level.boolLevel2())
				initLevel2();
			else{
				label1.setText("You Won  the Game! Congratulations!");
				this.a.setEnabled(false);
				this.w.setEnabled(false);
				this.s.setEnabled(false);
				this.d.setEnabled(false);
			}
	}

	private void initLevel2() {    
		
		label1.setText("Level 2: The Ogre ");
		int nOgres = 1;
		this.a.setEnabled(true);
		this.w.setEnabled(true);
		this.s.setEnabled(true);
		this.d.setEnabled(true);
		
		
		try{
			Scanner scan = new Scanner(textField.getText());
			nOgres = scan.nextInt();
			scan.close();
			
			if(nOgres <= 0)
				throw new NoSuchElementException();
			
		}catch(NoSuchElementException exp){
			nOgres = 1;
			textField.setText("1");
		}
		
		if(nOgres > 5){
			nOgres = 5;
			textField.setText("5");
		}

		this.gameArea.setBounds(20, 75, 310, 320);
		this.gameArea.setLayout(new GridLayout(9, 9, 0, 0));

		
		
		level.Initializel2(nOgres);
		drawImageOnBoard();
		
 		
	}
	

	protected void initLevel1() {

		
		label1.setText("Level 1: The Dungeon");
		this.a.setEnabled(true);
		this.w.setEnabled(true);
		this.s.setEnabled(true);
		this.d.setEnabled(true);
		this.guard_type = (String)GuardType.getSelectedItem();
		level.Initializel1(this.guard_type);
		
		this.gameArea.setBounds(20, 75, 330, 340);
		this.gameArea.setLayout(new GridLayout(10, 10, 0, 0));

		drawImageOnBoard();
		
	}	
	
	protected void drawImageOnBoard()
	{   
		this.gameArea.removeAll();

		for (int j = 0; j < level.getActualMap().length; j++) {
			for (int i = 0; i < level.getActualMap()[j].length; i++) {
				if (level.getActualMap()[j][i] == 'X')
					this.gameArea.add(new JLabel(this.Wall));
				else if (level.getActualMap()[j][i] == ' ')
					this.gameArea.add(new JLabel(this.Floor));
				else if (level.getActualMap()[j][i] == 'A') 
					this.gameArea.add(new JLabel(this.HeroArmored));
				else if (level.getActualMap()[j][i] == 'H')
					this.gameArea.add(new JLabel(this.Hero));
				else if (level.getActualMap()[j][i] == '8')
					this.gameArea.add(new JLabel(this.Stun));
				else if (level.getActualMap()[j][i] == 'G') 
					this.gameArea.add(new JLabel(this.Guard));
				else if (level.getActualMap()[j][i] == 'g')
					this.gameArea.add(new JLabel(this.GuardSleeping));
				else if (level.getActualMap()[j][i] == 'K')
					this.gameArea.add(new JLabel(this.HeroKey));
				else if (level.getActualMap()[j][i] == 'k') 
					this.gameArea.add(new JLabel(this.Key));
				else if (level.getActualMap()[j][i] == 'O')
					this.gameArea.add(new JLabel(this.Ogre));
				else if (level.getActualMap()[j][i] == '*')
					this.gameArea.add(new JLabel(this.WeaponOgre));
				else if (level.getActualMap()[j][i] == 'w')
					this.gameArea.add(new JLabel(this.Weapon));
				else if (level.getActualMap()[j][i] == '$')
					this.gameArea.add(new JLabel(this.Dollar));
				else if (level.getActualMap()[j][i] == 'I')
					this.gameArea.add(new JLabel(this.DoorClosed));
				else if (level.getActualMap()[j][i] == 'S')
					this.gameArea.add(new JLabel(this.DoorOpen));
				
			}
		}
		this.gameArea.validate();
	
	}
}
