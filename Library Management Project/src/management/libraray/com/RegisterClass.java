package management.libraray.com;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import images.Utility;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class RegisterClass extends JFrame {

	private JPanel contentPane;
	private JTextField Rusername;
	private JPasswordField Rpassword;
	private JTextField Remail;
	private JTextField textField;

	
	public RegisterClass() {
		setTitle("REGISTER ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 473);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 0));
		panel.setBounds(10, 26, 235, 386);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Profile Photo");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblNewLabel.setBounds(43, 22, 162, 43);
		panel.add(lblNewLabel);
		
		JLabel UserPhoto = new JLabel("");
		UserPhoto.setForeground(new Color(255, 204, 255));
		UserPhoto.setBackground(new Color(255, 204, 204));
		UserPhoto.setBounds(10, 61, 215, 141);
		panel.add(UserPhoto);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(Utility.resizeImg(new ImageIcon(RegisterClass.class.getResource("/management/library/images/registerdescription.jpg")),215,131));
		lblNewLabel_7.setBounds(10, 244, 215, 131);
		panel.add(lblNewLabel_7);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 0, 0));
		panel_1.setBounds(306, 26, 356, 386);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		Rusername = new JTextField();
		Rusername.setBackground(new Color(51, 153, 102));
		Rusername.setBounds(111, 84, 235, 28);
		panel_1.add(Rusername);
		Rusername.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Register");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(129, 11, 105, 35);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("User Name");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(21, 91, 80, 14);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email Address");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(26, 142, 82, 14);
		panel_1.add(lblNewLabel_4);
		
		Rpassword = new JPasswordField();
		Rpassword.setBackground(new Color(51, 153, 102));
		Rpassword.setBounds(111, 186, 235, 28);
		panel_1.add(Rpassword);
		
		JLabel lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(26, 193, 86, 14);
		panel_1.add(lblNewLabel_5);
		
		Remail = new JTextField();
		Remail.setBackground(new Color(51, 153, 102));
		Remail.setBounds(111, 135, 233, 28);
		panel_1.add(Remail);
		Remail.setColumns(10);
		
		JButton Register = new JButton("Register Me");
		Register.setBackground(new Color(0, 51, 255));
		
		
		Register.setFont(new Font("Swis721 Lt BT", Font.ITALIC, 18));
		Register.setBounds(155, 272, 125, 23);
		panel_1.add(Register);
		
		JLabel Registered = new JLabel("If already registered?");
		
		Registered.setForeground(new Color(204, 255, 51));
		Registered.setBounds(213, 306, 143, 14);
		panel_1.add(Registered);
		
		textField = new JTextField();
		textField.setBackground(new Color(102, 153, 102));
		textField.setBounds(111, 233, 176, 28);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Image Url *");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(26, 240, 75, 14);
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBackground(new Color(102, 255, 0));
		btnNewButton.setBounds(297, 233, 49, 28);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_6 = new JLabel("* = optional");
		lblNewLabel_6.setForeground(new Color(255, 255, 0));
		lblNewLabel_6.setBounds(288, 372, 68, 14);
		panel_1.add(lblNewLabel_6);
		
		// Event handling
		
		Register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(valid()) {
					// User connectivity to databases
					UserModel user = new UserModel();
					user.setUsername(username);
					user.setEmail(email);
					user.setPassword(password);
					
					
					try {
						Connection con =DatabaseDriver.getConnection();
						
						PreparedStatement ps =con.prepareStatement("insert into userDetails (Name ,Email,Password) values (?,?,?)");
					   ps.setString(1,user.getUsername());
					   ps.setString(2, user.getEmail());
					   ps.setString(3, user.getPassword());
					  int rs= ps.executeUpdate();
					  
					  con.close();
					  
					  if (rs>0) {
						  JOptionPane.showMessageDialog(RegisterClass.this, "Successfully Registered");
					  }else {
						  JOptionPane.showMessageDialog(RegisterClass.this, "Registration Failed");
					  }
					  dispose();
					   new MainPage().setVisible(true);
					  
						
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
					
					
				}
			}
		});
		
		
		// Register to login 
		Registered.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new LoginClass().setVisible(true);
			}
		});
		
		
		
	}
	// user validation for registration
	
	private String username, email,password;
	private boolean valid() {
		
		username = Rusername.getText();
		email = Remail.getText();
		password = String.valueOf(Rpassword.getPassword());
		
		
		if (username.isBlank()) {
			JOptionPane.showMessageDialog(this,"Please enter your name");
			return false;
		}else if (email.isBlank()) {
			
			JOptionPane.showMessageDialog(this,"please enter your email");
			return false;
		}else if (password.isBlank()) {
			
			JOptionPane.showMessageDialog(this,"please enter your password");
			return false;
		}else { 
			return true;
		}
		
	}
	
	}
