package management.libraray.com;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import images.Utility;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.Color;

public class SplashScreen extends JFrame {

	private JPanel contentPane;
	static JProgressBar prog;
	static JLabel splashImage;
	
	public static void main(String[] args) {

		try {
			SplashScreen frame = new SplashScreen();
			frame.setVisible(true);
			

			for (int i = 0; i <= 100; i++) {
				prog.setValue(i);
				if (prog.getValue()==0) {
				splashImage.setIcon(Utility.resizeImg(new ImageIcon(SplashScreen.class.getResource("/management/library/images/splash1.jpg")), 467, 266));
				}
				if (prog.getValue()==25) {
					
					splashImage.setIcon(Utility.resizeImg(new ImageIcon(SplashScreen.class.getResource("/management/library/images/splash2.png")), 467, 266));
				}
				if (prog.getValue()==50) {
					splashImage.setIcon(Utility.resizeImg(new ImageIcon(SplashScreen.class.getResource("/management/library/images/splash3.jpg")), 467, 266));
				}
				if (prog.getValue()==75) {
					splashImage.setIcon(Utility.resizeImg(new ImageIcon(SplashScreen.class.getResource("/management/library/images/splash4.jpg")), 467, 266));
				}
				
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			if (prog.getValue() == 100) {
				new LoginClass().setVisible(true);
				frame.dispose();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Create the frame.
	 */
	public SplashScreen() {
		
		setTitle("Splash Screen");
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 345);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(-32, 5, 658, 329);
		panel.setBackground(new Color(255, 255, 0));
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(106, 24, 467, 266);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

	   splashImage = new JLabel("");
	   splashImage.setSize(400, 300);
		
		
		panel_1.add(splashImage, BorderLayout.EAST);

		prog = new JProgressBar();
		prog.setIndeterminate(true);
		prog.setStringPainted(true);
		prog.setForeground(new Color(102, 102, 204));
		prog.setBorderPainted(true);

		panel_1.add(prog, BorderLayout.SOUTH);

	}
}
