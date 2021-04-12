package management.libraray.com;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import images.Utility;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.Color;

public class DeleteBooks extends JFrame {


	private JPanel contentPane;
	private JTextField bookName;
	private JTextField author;
	private JTextField id;
	private JLabel delete;
	private JLabel lblNewLabel_4;
	private JLabel back;

	
	public DeleteBooks() {
		setTitle("DELETE BOOKS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 444);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete Books");
		lblNewLabel.setFont(new Font("Lucida Handwriting", Font.BOLD, 15));
		lblNewLabel.setBounds(269, 27, 157, 46);
		contentPane.add(lblNewLabel);
		
		bookName = new JTextField();
		bookName.setBackground(new Color(0, 255, 255));
		bookName.setBounds(241, 142, 196, 34);
		contentPane.add(bookName);
		bookName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("DeleteBYName");
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 13));
		lblNewLabel_1.setBounds(121, 152, 106, 20);
		contentPane.add(lblNewLabel_1);
		
		author = new JTextField();
		author.setBackground(new Color(0, 255, 255));
		author.setBounds(244, 206, 193, 34);
		contentPane.add(author);
		author.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("DeleteByAuthor");
		lblNewLabel_2.setFont(new Font("Sylfaen", Font.BOLD, 13));
		lblNewLabel_2.setBounds(121, 216, 110, 20);
		contentPane.add(lblNewLabel_2);
		
		id = new JTextField();
		id.setBackground(new Color(0, 255, 255));
		id.setBounds(241, 79, 196, 29);
		contentPane.add(id);
		id.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Delete By Book Id");
		lblNewLabel_5.setFont(new Font("Square721 BT", Font.BOLD, 11));
		lblNewLabel_5.setBounds(139, 83, 155, 14);
		contentPane.add(lblNewLabel_5);
		
		delete = new JLabel("");
		
		delete.setIcon(Utility.resizeImg(new ImageIcon(DeleteBooks.class.getResource("/management/library/images/deleteYes.png")), 93, 72));
		delete.setBounds(294, 257, 93, 72);
		contentPane.add(delete);
		
		lblNewLabel_4 = new JLabel("DELETE BOOKS");
		lblNewLabel_4.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_4.setBounds(293, 331, 94, 20);
		contentPane.add(lblNewLabel_4);
		
		back = new JLabel("<-back");
		
		back.setFont(new Font("Sylfaen", Font.BOLD, 13));
		back.setBounds(10, 11, 46, 14);
		contentPane.add(back);
		
		
		delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				delete();
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
	public void delete() {
		String bname, bauthor;
		int bid;
		 PreparedStatement ps=null;
		 Connection con=	DatabaseDriver.getConnection();
		 String queryId = "delete from bookdetails where Id=?";
		  String queryName ="delete from bookdetails where Name=?";
		  String queryAuthor ="delete from bookdetails where Author=?";
		  
		 
		  bname = bookName.getText();
		  bauthor = author.getText();
		 bid = Integer.parseInt(id.getText());
		 
		  try {
			  
				
				  if (!bname.isBlank()) {
					  ps = con.prepareCall(queryName);
					  ps.setString(1,bname); }
				  
				  if (!bauthor.isBlank()) { 
					  ps= con.prepareCall(queryAuthor);
				  ps.setString(1, bauthor);
				  }
				if (bid!=0) {
					ps = con.prepareStatement(queryId);
					ps.setInt(1, bid);
				}
			
			  
			int set = ps.executeUpdate();
			if (set>0) {
				JOptionPane.showMessageDialog(DeleteBooks.this, "Successfully Deleted");
			}else {
				JOptionPane.showMessageDialog(DeleteBooks.this, "Error in Deleting");
			}
			con.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		  
		  
		
		}
	}

