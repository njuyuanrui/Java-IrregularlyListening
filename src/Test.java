

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;




public class Test extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Test() {
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setBounds(0, 0, 686, 678);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel doubleGame = new DoubleGamePanel(686,678);
 	    this.getContentPane().add(doubleGame);
 	    doubleGame.setSize(800, 600);
 	    doubleGame.setLocation(0, 0);
 	    doubleGame.setVisible(true);
 	    doubleGame.setOpaque(true);
		
		/*setBounds(0, 0, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
	
		JPanel teamsMapsPanel = new TeamsMapsPanel(1366,768);
 	    this.getContentPane().add(teamsMapsPanel);
 	    teamsMapsPanel.setSize(1366,768);
 	   	teamsMapsPanel.setLocation(0, 0);
 	   	teamsMapsPanel.setVisible(true);
 	   	teamsMapsPanel.setOpaque(true);*/
		
	}

}
