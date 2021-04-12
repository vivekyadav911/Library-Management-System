package management.libraray.com;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import images.Utility;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;

public class LoginClass extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField email;


	public LoginClass() {
		setTitle("Login ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 478);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground(new Color(153, 102, 51));
		panel.setBounds(20, 27, 220, 401);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel loginImage = new JLabel("");
		
		loginImage.setIcon(Utility.resizeImg(new ImageIcon(LoginClass.class.getResource("/management/library/images/library.jpeg")), 200, 169));
		//lblNewLabel_4.setIcon(Utility.resizeImg(new ImageIcon(LoginClass.class.getResource("/management/library/images/library.jpeg")), 200, 169));
		
		loginImage.setBounds(10, 11, 200, 169);
		panel.add(loginImage);
		
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(Utility.resizeImg(new ImageIcon(LoginClass.class.getResource("/management/library/images/logindescription.jpg")),154,181));
		lblNewLabel_5.setBounds(41, 209, 154, 181);
		panel.add(lblNewLabel_5);
		
		JPanel LoginConatainer = new JPanel();
		LoginConatainer.setBackground(new Color(153, 51, 51));
		LoginConatainer.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		LoginConatainer.setBounds(296, 28, 366, 400);
		contentPane.add(LoginConatainer);
		LoginConatainer.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Bernard MT Condensed", Font.BOLD, 25));
		lblNewLabel.setBounds(145, 24, 64, 31);
		LoginConatainer.add(lblNewLabel);
		
		username = new JTextField();
		username.setBounds(93, 101, 216, 31);
		LoginConatainer.add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter username");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(93, 85, 216, 14);
		LoginConatainer.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter password");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(93, 199, 216, 14);
		LoginConatainer.add(lblNewLabel_2);
		
		JButton login = new JButton("Login");
		
		login.setBackground(new Color(255, 255, 0));
		login.setForeground(new Color(255, 255, 255));
		login.setBounds(156, 270, 89, 23);
		LoginConatainer.add(login);
		
		JLabel notRegistered = new JLabel("If not registered?");
		notRegistered.setForeground(new Color(0, 51, 204));
		notRegistered.setBackground(new Color(51, 51, 204));
		
		notRegistered.setBounds(246, 307, 110, 14);
		LoginConatainer.add(notRegistered);
		
		email = new JTextField();
		email.setBounds(93, 158, 216, 31);
		LoginConatainer.add(email);
		email.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(93, 143, 46, 14);
		LoginConatainer.add(lblNewLabel_3);
		
		pass = new JPasswordField();
		pass.setBounds(93, 213, 216, 31);
		LoginConatainer.add(pass);
		
		
		// Action listeners
		
		notRegistered.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				new RegisterClass().setVisible(true);
				dispose();
			}
		});
		
		
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(email.getText().isBlank()) {
				if(validUser()) {
					
					
				Connection con = DatabaseDriver.getConnection();
				
				
				String query= "select *from userDetails where Name=? and Password=?";
				try {
					
					
					UserModel user = new UserModel();
					user.setUsername(userName);
					user.setPassword(Password);
					PreparedStatement ps = con.prepareCall(query);
					ps.setString(1,user.getUsername());
					ps.setString(2, user.getPassword());
					
				 ResultSet rs= ps.executeQuery();
				
				 if(rs.next()) {
					  
					 dispose();
					new MainPage().setVisible(true);
					
					  JOptionPane.showMessageDialog(LoginClass.this, "successfully logged in");
				  }else {
					  JOptionPane.showMessageDialog(LoginClass.this, "User Name or Password is incorrect");
				  }
				  
				 
					con.close();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}}
				if(username.getText().isBlank()) {
				if(validEmail()) {
					
					
					Connection con = DatabaseDriver.getConnection();
					
					
					String query= "select *from userDetails where Email=? and Password=?";
					try {
						
						
						UserModel user = new UserModel();
						user.setEmail(Email);
						user.setPassword(Password);
						PreparedStatement ps = con.prepareCall(query);
						ps.setString(1,user.getEmail());
						ps.setString(2, user.getPassword());
						
					 ResultSet rs= ps.executeQuery();
					
					 if(rs.next()) {
						  
						 dispose();
						new MainPage().setVisible(true);
						
						  JOptionPane.showMessageDialog(LoginClass.this, "successfully logged in");
					  }else {
						  JOptionPane.showMessageDialog(LoginClass.this, "Your Email or Password is incorrect");
					  }
					  
					 
						con.close();
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
				}
				}
				}
			
			
		});
		
	}
	
	public String userName,Email,Password;
	private JPasswordField pass;
	private boolean validUser() {
		userName = username.getText();
		
		Password = String.valueOf(pass.getPassword());
		
		
		
		if (userName.isBlank()) {
			JOptionPane.showMessageDialog(this,"Please enter your name");
			return false;
		}else if (Password.isBlank()) {
			
			JOptionPane.showMessageDialog(this,"please enter your password");
			return false;
		}else { 
			return true;
		}
		
	}
	public boolean validEmail() {
		Email = email.getText();
		Password= String.valueOf(pass.getPassword());
		if (Password.isBlank()) {
			JOptionPane.showMessageDialog(this,"please enter your Password");
			return false;
		}else if (Email.isBlank()) {
			
			JOptionPane.showMessageDialog(this,"please enter your Email");
			return false;
		}else {
			return true;
		}
	}
	
	
	
	
}
