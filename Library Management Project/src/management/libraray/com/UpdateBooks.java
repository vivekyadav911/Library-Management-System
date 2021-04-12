package management.libraray.com;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import images.Utility;

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class UpdateBooks extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField author;
	private JTextField price;
	private JTextField category;
	private JTextField id;
	private JLabel doneUpdate;
	private JLabel lblNewLabel_7;

	
	public UpdateBooks() {
		setTitle("UPDATE BOOKS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 444);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Books");
		lblNewLabel.setFont(new Font("Lucida Handwriting", Font.BOLD, 15));
		lblNewLabel.setBounds(269, 27, 157, 46);
		contentPane.add(lblNewLabel);
		
		username = new JTextField();
		username.setBackground(new Color(255, 204, 255));
		username.setBounds(241, 130, 196, 34);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel nameLabel = new JLabel("Update Name");
		nameLabel.setForeground(new Color(255, 0, 0));
		nameLabel.setFont(new Font("Sylfaen", Font.BOLD, 13));
		nameLabel.setBounds(146, 140, 85, 20);
		contentPane.add(nameLabel);
		
		author = new JTextField();
		author.setBackground(new Color(255, 204, 255));
		author.setBounds(244, 196, 193, 34);
		contentPane.add(author);
		author.setColumns(10);
		
		JLabel authorLabel = new JLabel("Update Author");
		authorLabel.setForeground(new Color(255, 0, 0));
		authorLabel.setFont(new Font("Sylfaen", Font.BOLD, 13));
		authorLabel.setBounds(139, 206, 96, 20);
		contentPane.add(authorLabel);
		
		price = new JTextField();
		price.setBackground(new Color(255, 204, 255));
		price.setBounds(244, 261, 193, 34);
		contentPane.add(price);
		price.setColumns(10);
		
		JLabel priceLabel = new JLabel("Update Price");
		priceLabel.setForeground(new Color(255, 0, 0));
		priceLabel.setFont(new Font("Sylfaen", Font.BOLD, 13));
		priceLabel.setBounds(139, 271, 85, 20);
		contentPane.add(priceLabel);
		
		category = new JTextField();
		category.setBackground(new Color(255, 204, 255));
		category.setBounds(244, 327, 193, 34);
		contentPane.add(category);
		category.setColumns(10);
		
		JLabel categoryLabel = new JLabel("Update Category");
		categoryLabel.setForeground(new Color(255, 0, 0));
		categoryLabel.setFont(new Font("Sylfaen", Font.BOLD, 13));
		categoryLabel.setBounds(139, 335, 106, 24);
		contentPane.add(categoryLabel);
		
		id = new JTextField();
		id.setBackground(new Color(255, 204, 153));
		id.setBounds(304, 72, 66, 36);
		contentPane.add(id);
		id.setColumns(10);
		
		JLabel idLabel = new JLabel("Enter Id of book to update");
		idLabel.setForeground(new Color(255, 0, 0));
		idLabel.setFont(new Font("Square721 BT", Font.BOLD, 11));
		idLabel.setBounds(139, 83, 155, 14);
		contentPane.add(idLabel);
		
		doneUpdate = new JLabel("");
		
		doneUpdate.setIcon(Utility.resizeImg(new ImageIcon(UpdateBooks.class.getResource("/management/library/images/updateYes.png")), 85, 65));
		doneUpdate.setBounds(515, 206, 85, 65);
		contentPane.add(doneUpdate);
		
		lblNewLabel_7 = new JLabel("UPDATE");
		lblNewLabel_7.setForeground(new Color(0, 51, 0));
		lblNewLabel_7.setFont(new Font("Sylfaen", Font.BOLD, 11));
		lblNewLabel_7.setBounds(525, 274, 75, 14);
		contentPane.add(lblNewLabel_7);
		
		back = new JLabel("<-back");
		
		back.setFont(new Font("Sylfaen", Font.BOLD, 13));
		back.setBounds(10, 11, 46, 14);
		contentPane.add(back);
		
	
	
	doneUpdate.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			if (valid()==true) {
				
			update();
			}
		}
	});
	
	back.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			dispose();
			new MainPage().setVisible(true);
			
		}
	});
		
	}
	public void update() {
	  Connection con=	DatabaseDriver.getConnection();
	  String query = "update bookdetails set Name=? ,Author=?,Price=?,Category=? where id=?";
	  try {
		PreparedStatement ps = con.prepareCall(query);
		ps.setString(1, username.getText());
		ps.setString(2, author.getText());
		ps.setString(3, price.getText());
		ps.setString(4, category.getText());
		ps.setInt(5, Integer.parseInt(id.getText()));
		
		int set = ps.executeUpdate();
		if (set>0) {
			JOptionPane.showMessageDialog(UpdateBooks.this, "Successfully Updated");
		}else {
			JOptionPane.showMessageDialog(UpdateBooks.this, "Error to Update");
		}
		con.close();
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	}
	private String Uname,Uauthor,Uprice,Ucategory;
	private int uid;
	private JLabel back;
	public boolean valid() {
		
		
		Uname = username.getText();
		Uauthor = author.getText();
		Uprice = price.getText();
		Ucategory = category.getText();
		uid = Integer.parseInt(id.getText());
		
			
			
			
			// if conditions for text

		if (id.getText().toString().isBlank()) {
			JOptionPane.showMessageDialog(UpdateBooks.this,"please enter Id");
			return false;
			
		}
		else if (Uname.isBlank()) {
				JOptionPane.showMessageDialog(UpdateBooks.this,"please enter Book Name");
				return false;
				
			}
		else if(Uauthor.isBlank()) {
				JOptionPane.showMessageDialog(UpdateBooks.this,"please enter Author Name");
				return false;
				
			}
		else if (Uprice.isBlank()) {
				JOptionPane.showMessageDialog(UpdateBooks.this,"please enter  Price ");
				return false;
			}
		else	if (Ucategory.isBlank()) {
				JOptionPane.showMessageDialog(UpdateBooks.this, "Please enter book generic");
				return false;
			}
			
			return true;
			
			
		
	}
}
