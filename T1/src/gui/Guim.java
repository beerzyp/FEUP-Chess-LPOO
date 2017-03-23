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

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Guim {

	private JFrame frame;
	private JTextField textField;
	
	private int upKey = KeyEvent.VK_W;
	private int leftKey = KeyEvent.VK_A;
	private int rightKey = KeyEvent.VK_D;
	private int downKey = KeyEvent.VK_S;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		GuardType.setModel(new DefaultComboBoxModel(new String[] {"Novice", "Rookie", "Suspicious","Drunken"}));
		GuardType.setBounds(191, 39, 248, 22);
		frame.getContentPane().add(GuardType);
		
		JLabel lblNumberOfOgres = new JLabel("Number Of Ogres: ");
		lblNumberOfOgres.setBounds(32, 14, 200, 15);
		frame.getContentPane().add(lblNumberOfOgres);
		
		textField = new JTextField();
		textField.setBounds(172, 12, 114, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(38, 81, 248, 323);
		frame.getContentPane().add(textArea);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() //starts game
		{
			public void actionPerformed(ActionEvent a)
			{
				UserInteraction.main.main(null);
			}
		});
		btnNewGame.setBounds(332, 112, 117, 25);
		frame.getContentPane().add(btnNewGame);
		
		JButton btnNewButton = new JButton("W");
		btnNewButton.setFont(new Font("Courier 10 Pitch", Font.BOLD, 11));
		btnNewButton.setBounds(358, 218, 41, 22);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnA = new JButton("A");
		btnA.setFont(new Font("Courier 10 Pitch", Font.BOLD, 11));
		btnA.setBounds(334, 252, 41, 22);
		frame.getContentPane().add(btnA);
		
		JButton btnD = new JButton("D");
		btnD.setFont(new Font("Courier 10 Pitch", Font.BOLD, 11));
		btnD.setBounds(387, 252, 41, 22);
		frame.getContentPane().add(btnD);
		
		JButton btnS = new JButton("S");
		btnS.setFont(new Font("Courier 10 Pitch", Font.BOLD, 11));
		btnS.setBounds(358, 287, 41, 22);
		frame.getContentPane().add(btnS);
		
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
		
		
		
//		JTextArea  = new JTextArea();
//		mazeArea.setFont(new Font("Courier New", Font.PLAIN, 14));
//		mazeArea.setEditable(false);
//		mazeArea.setToolTipText("");
//		mazeArea.setBounds(42, 171, 263, 266);
//		frame.getContentPane().add(mazeArea);

		

		
	
		

}
	}
