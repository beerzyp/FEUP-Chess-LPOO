package Gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu {
	JFrame frame;

	
	public static void main(String[] args) throws IOException {		 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public MainMenu() {
		initialize();
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {frame = new JFrame();frame.getContentPane().setFont(new Font("Courier New", Font.PLAIN, 12));frame.setBounds(100, 100, 181, 160);frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);frame.getContentPane().setLayout(null);		JButton btnPlay = new JButton("Play");btnPlay.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
		EventQueue.invokeLater(new Runnable() {public void run() { try {guim window = new guim();window.frame.setVisible(true);} catch (Exception e) {e.printStackTrace();}}});frame.dispose();
		}});btnPlay.setBounds(31, 13, 117, 29);frame.getContentPane().add(btnPlay);JButton btnCreateGame = new JButton("Create Game");btnCreateGame.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
		EventQueue.invokeLater(new Runnable() {public void run() { try {createMap window = new createMap();window.frame.setVisible(true);} catch (Exception e) {e.printStackTrace();}}});	frame.dispose();}});
		btnCreateGame.setBounds(31, 54, 117, 29);frame.getContentPane().add(btnCreateGame);JButton btnExit = new JButton("Exit");btnExit.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {System.exit(0);}});btnExit.setBounds(31, 97, 117, 29);
				frame.getContentPane().add(btnExit);
			}
}
