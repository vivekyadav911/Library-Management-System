package management.libraray.com;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import images.Utility;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

public class MyProfile extends JFrame {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyProfile frame = new MyProfile();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JPanel contentPane;
	static ResultSet rs;
	String selectedfile;
	JTextField Username,Email,Password;
	JLabel mypic;

	public MyProfile() {
		setTitle("MY PROFILE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 443);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 0));
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("My Profile");
		lblNewLabel.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 20));
		lblNewLabel.setBounds(238, 29, 148, 32);
		contentPane.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBackground(new Color(255, 255, 153));
		panel_1.setBounds(309, 72, 279, 301);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setBounds(10, 26, 82, 14);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 11));
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setBounds(14, 94, 61, 14);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Sylfaen", Font.BOLD, 11));
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setBounds(14, 177, 61, 14);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Sylfaen", Font.BOLD, 11));
		
		Username = new JTextField();
		Username.setBackground(new Color(255, 204, 153));
		Username.setBounds(20, 51, 243, 32);
		panel_1.add(Username);
		Username.setColumns(10);
		
		Email = new JTextField();
		Email.setBackground(new Color(255, 204, 153));
		Email.setBounds(24, 119, 239, 37);
		panel_1.add(Email);
		Email.setColumns(10);
		
		Password = new JTextField();
		Password.setBackground(new Color(255, 204, 153));
		Password.setBounds(24, 202, 239, 32);
		panel_1.add(Password);
		Password.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("save");
		btnNewButton_1.setBackground(new Color(0, 0, 255));
		
		btnNewButton_1.setFont(new Font("Swis721 Cn BT", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_1.setBounds(97, 255, 89, 23);
		panel_1.add(btnNewButton_1);
		
		
		JLabel lblNewLabel_4 = new JLabel("<-back");
		
		lblNewLabel_4.setFont(new Font("Swis721 Hv BT", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(255, 204, 51));
		panel.setBounds(14, 72, 249, 213);
		contentPane.add(panel);
		panel.setLayout(null);
		
		 mypic = new JLabel("user pic");
		mypic.setBounds(10, 11, 229, 191);
		panel.add(mypic);
		
		JButton btnNewButton = new JButton("Add Pic");
		
		btnNewButton.setBackground(new Color(255, 0, 102));
		btnNewButton.setBounds(84, 319, 89, 23);
		contentPane.add(btnNewButton);
		
   
       
      
 
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.setCurrentDirectory(new File(System.getProperty("user.home")));
				int filepath =fc.showOpenDialog(MyProfile.this);
				if (filepath==JFileChooser.APPROVE_OPTION) {
					 selectedfile = fc.getSelectedFile().getAbsolutePath();
					mypic.setIcon(Utility.resizeImg(new ImageIcon(selectedfile), 229, 191));
					
				}
			}
		});
	
	
	
		
		
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MainPage().setVisible(true);
			}
		});
		
		
}
	
	private String name,email,pass,image;
	
	private boolean valid() {
		name= Username.getText();
		email= Email.getText();
		pass= Password.getText();
		
		
		
		// if conditions for text
		if (name.isBlank()) {
			JOptionPane.showMessageDialog(MyProfile.this,"please enter your name");
			return false;
			
		}else if(email.isBlank()) {
			JOptionPane.showMessageDialog(MyProfile.this,"please enter your email");
			return false;
			
		}else if (pass.isBlank()) {
			JOptionPane.showMessageDialog(MyProfile.this,"please enter your password");
			return false;
		}else {
			return true;
		}
		
		
	}
	}

