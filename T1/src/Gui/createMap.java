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
import Others.Pair;

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

	public class createMap{

	    private Levels level = new Levels();
		private JFrame frame;

		
		char [][] newMap = {{'X','X','X','X','X','X','X','X','X','X'},
							{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
							{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
							{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
							{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
							{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
							{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
							{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
							{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
							{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}
							};
		
		
		
		
		/**
		 * Launch the application.
		 * @throws IOException 
		 */
		public static void main(String[] args) throws IOException {		 
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						createMap window = new createMap();
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
		public createMap() {
			initialize();
		}

	    
		
		
		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() 
		{ 
			frame = new JFrame();
			frame.getContentPane().setFont(new Font("Courier New", Font.PLAIN, 12));
			frame.setBounds(100, 100, 602, 521);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			level.InitializeNewMap(this.newMap, new Pair(1,1));

			final setSprites panel = new setSprites(this.level, this);
			panel.setBounds(95, 45, 405, 405);
			frame.getContentPane().add(panel);
			panel.setLayout(new GridLayout(10, 0, 0, 0));
			
			JButton btnCreate = new JButton("Create");
			btnCreate.addActionListener(new ActionListener() //starts game
					{ 
						public void actionPerformed(ActionEvent a)
						{
							//new guim(level, panel);
						}
					});

			btnCreate.setBounds(242, 462, 117, 29);
			frame.getContentPane().add(btnCreate);
			 
			panel.addMouseListener(panel);
			panel.requestFocus();
			
			panel.drawImageOnBoard();
			
			JButton btnNewOgre = new JButton("New Ogre");
			btnNewOgre.addActionListener(new ActionListener() //starts game
					{ 
						public void actionPerformed(ActionEvent a)
						{
							panel.setWorkingChar('O'); 
						}
					});
			btnNewOgre.setBounds(6, 6, 117, 29);
			frame.getContentPane().add(btnNewOgre);
			
			JButton btnNewWall = new JButton("New Wall");
			btnNewWall.setBounds(124, 6, 117, 29);
			btnNewWall.addActionListener(new ActionListener() //starts game
					{ 
						public void actionPerformed(ActionEvent a)
						{
							panel.setWorkingChar('X');
						}
					});
			frame.getContentPane().add(btnNewWall);
			
			JButton btnNewHero = new JButton("New Weapon");
			btnNewHero.setBounds(242, 6, 117, 29);
			btnNewHero.addActionListener(new ActionListener() //starts game
					{ 
						public void actionPerformed(ActionEvent a)
						{
							panel.setWorkingChar('w');
						}
					});
			frame.getContentPane().add(btnNewHero);
			
			JButton btnNewLever = new JButton("New Lever");
			btnNewLever.setBounds(360, 6, 117, 29);
			btnNewLever.addActionListener(new ActionListener() //starts game
					{ 
						public void actionPerformed(ActionEvent a)
						{
							panel.setWorkingChar('k');
						}
					});
			frame.getContentPane().add(btnNewLever);
			
			JButton btnNewDoor = new JButton("New Door");
			btnNewDoor.setBounds(477, 6, 117, 29);
			btnNewDoor.addActionListener(new ActionListener() //starts game
					{ 
						public void actionPerformed(ActionEvent a)
						{
							panel.setWorkingChar('I');
						}
					});
			frame.getContentPane().add(btnNewDoor);
						

	}
		
}
