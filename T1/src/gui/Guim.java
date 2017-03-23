package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;

import javax.swing.DefaultComboBoxModel;
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
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

public class Guim {

    private Levels level = new Levels();
	private JFrame frame;
	private JTextField textField;
	
	private JButton btnD;
	private JButton btnA;
	private JButton btnW;
	private JButton btnS;
	
	private String guard_type;
	private JTextArea newtext;
	

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {		 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Guim window = new Guim();
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
	public Guim() {
		initialize();
	}

    
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 496, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	
	
		JLabel guardtype = new JLabel("Personality of Guard: ");
		guardtype.setVerticalAlignment(SwingConstants.TOP);
		guardtype.setBounds(32, 43, 200, 22);
		frame.getContentPane().add(guardtype);
		
	    JComboBox GuardType = new JComboBox();
		GuardType.setModel(new DefaultComboBoxModel(new String[] {"Rookie", "Suspicious","Drunken"}));
		GuardType.setBounds(191, 39, 248, 22);
		frame.getContentPane().add(GuardType);
		this.guard_type = (String)GuardType.getSelectedItem();
		
		JLabel lblNumberOfOgres = new JLabel("Number Of Ogres: ");
		lblNumberOfOgres.setBounds(32, 14, 200, 15);
		frame.getContentPane().add(lblNumberOfOgres);
		
		textField = new JTextField();
		textField.setBounds(172, 12, 114, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
		textArea.setBounds(38, 81, 248, 323);
		frame.getContentPane().add(textArea);
		this.newtext=textArea;

		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() //starts game
		{ 
			public void actionPerformed(ActionEvent a)
			{
				caralho();
			}
		});
		btnNewGame.setBounds(332, 112, 117, 25);
		frame.getContentPane().add(btnNewGame);
		
		JButton btnW = new JButton("W");
		btnW.setFont(new Font("Courier 10 Pitch", Font.BOLD, 11));
		btnW.setBounds(358, 218, 41, 22);
		frame.getContentPane().add(btnW);
		btnW.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent a)
			{
				level.MoveHero('d');
				
			}
		});
		

		
		JButton btnA = new JButton("A");
		btnA.setFont(new Font("Courier 10 Pitch", Font.BOLD, 11));
		btnA.setBounds(334, 252, 41, 22);
		frame.getContentPane().add(btnA);
		btnA.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent a)
			{
				level.MoveHero('d');
				
			}
		});

		
		JButton btnD = new JButton("D");
		btnD.setFont(new Font("Courier 10 Pitch", Font.BOLD, 11));
		btnD.setBounds(387, 252, 41, 22);
		frame.getContentPane().add(btnD);
		btnD.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent a)
			{
				level.MoveHero('d');
				printBoard();
			}
		});
		
		JButton btnS = new JButton("S");
		btnS.setFont(new Font("Courier 10 Pitch", Font.BOLD, 11));
		btnS.setBounds(358, 287, 41, 22);
		frame.getContentPane().add(btnS);
		btnS.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent a)
			{
				level.MoveHero('d');
				
			}
		});
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent a)
			{
				System.exit(0);
			}
		});
		btnExit.setBounds(332, 404, 117, 25);
		frame.getContentPane().add(btnExit);
		
		JLabel label = new JLabel("");
		label.setBounds(32, 451, 284, 15);
		frame.getContentPane().add(label);
		
		
	
		

		

}

	protected void printBoard(){}
	protected void caralho() {
		
		level.Initializel1(this.guard_type);
		this.newtext.setText(level.returnboard());
	}	
}
