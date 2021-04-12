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
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import images.Utility;

public class AddingBook extends JFrame {
	private JTextField name;
	private JTextField price;
	private JTextField author;
	private JTextField imageUrl;
	private JTextField date;
	JComboBox category;
	String strDate;
	private JLabel bookImage;
	
	
	public AddingBook() {
		setTitle("ADD BOOK");
		
		getContentPane().setFont(new Font("Rockwell", Font.BOLD, 30));
		getContentPane().setBackground(new Color(102, 204, 255));
		setBounds(100, 100, 777, 550);
		getContentPane().setLayout(null);
		
		JLabel label1 = new JLabel("Add Book");
		label1.setForeground(new Color(255, 255, 0));
		label1.setFont(new Font("Serif", Font.BOLD, 30));
		
		label1.setBounds(271, 11, 169, 36);
		getContentPane().add(label1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(153, 255, 153));
		panel.setBounds(26, 78, 300, 376);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		 bookImage = new JLabel("Image of book");
		bookImage.setBackground(new Color(255, 255, 0));
		bookImage.setBounds(10, 11, 228, 154);
		
		panel.add(bookImage);
		
		JLabel description = new JLabel("");
		description.setIcon(Utility.resizeImg(new ImageIcon(AddingBook.class.getResource("/management/library/images/book description.jpg")), 228, 154));
		description.setBounds(10, 201, 228, 154);
		panel.add(description);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBackground(new Color(153, 51, 204));
		panel_1.setBounds(379, 78, 357, 376);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		name = new JTextField();
		name.setBounds(83, 30, 236, 28);
		panel_1.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Book Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 37, 74, 21);
		panel_1.add(lblNewLabel_2);
		
		price = new JTextField();
		price.setBounds(25, 102, 123, 34);
		panel_1.add(price);
		price.setColumns(10);
		
		author = new JTextField();
		author.setBounds(176, 102, 143, 34);
		panel_1.add(author);
		author.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Book Price");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(36, 76, 91, 28);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Author Name");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(176, 84, 123, 21);
		panel_1.add(lblNewLabel_4);
		
		imageUrl = new JTextField();
		imageUrl.setBounds(29, 227, 233, 28);
		panel_1.add(imageUrl);
		imageUrl.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Category");
		lblNewLabel_5.setBounds(35, 155, 92, 14);
		panel_1.add(lblNewLabel_5);
		
		Date currentDate = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	     strDate= formatter.format(currentDate);
		
		date = new JTextField();
		date.setBounds(176, 168, 143, 28);
		panel_1.add(date);
		date.setColumns(10);
		date.setText(strDate);
		
		JLabel lblNewLabel_6 = new JLabel("Date added");
		lblNewLabel_6.setBounds(176, 155, 103, 14);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Book Image");
		lblNewLabel_7.setBounds(38, 213, 89, 14);
		panel_1.add(lblNewLabel_7);
		
		JButton browse = new JButton("browse");
		browse.setForeground(new Color(255, 204, 0));
		
		browse.setBounds(272, 227, 47, 28);
		panel_1.add(browse);
		
		JButton addBook = new JButton("Add Book");
		
		addBook.setBackground(Color.GREEN);
		addBook.setBounds(59, 299, 103, 28);
		panel_1.add(addBook);
		
		JButton resetBook = new JButton("Reset Book");
		
		resetBook.setBackground(new Color(255, 0, 0));
		resetBook.setBounds(179, 299, 100, 28);
		panel_1.add(resetBook);
		
		 category = new JComboBox();
		category.setModel(new DefaultComboBoxModel(new String[] 
				{"Select Generics", "Text Book", "Novel", "Science Fiction", "Horror and Thriller",
						"Adventure", "Biography", "Bussiness Books","Life Style","Psychology","Romantic","Philosophy","Comics","Historical",
						"Mythological","Informational"}));
		
		category.setBounds(25, 170, 143, 26);
		panel_1.add(category);
		
		JLabel back = new JLabel("<-back");
		back.setForeground(new Color(0, 0, 0));
		
		back.setFont(new Font("Tahoma", Font.BOLD, 12));
		back.setBackground(Color.YELLOW);
		back.setBounds(10, 11, 47, 36);
		getContentPane().add(back);
		

		resetBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (name!=null || price !=null || author!=null  || imageUrl!=null ) {
					name.setText(null);
					price.setText(null);
					author.setText(null);
					category.setSelectedItem("Select Generics");
					imageUrl.setText(null);
					
					
				}
				
			}
		});	
		addBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   
				
				if (valid()) {
					BookModel book = new BookModel();
					book.setName(Bname);
					book.setAuthor(Bauthor);
					book.setCategory(Bcategory);
					book.setPrice(Bprice);
					book.setDate(strDate);
					book.setImage(Bimage);
					
					Connection con =DatabaseDriver.getConnection();
					String query = "insert into bookdetails (Name,Author,Price,Category,Date,Image)values (?,?,?,?,?,?)";
					try {
						PreparedStatement ps = con.prepareStatement(query);
						ps.setString(1, book.getName());
						ps.setString(2, book.getAuthor());
						ps.setString(3, book.getPrice());
						ps.setString(4, book.getCategory());
						ps.setString(5, book.getDate());
						ps.setString(6, book.getImage());
						
						
						int set = ps.executeUpdate();
						if (set>0) {
							JOptionPane.showMessageDialog(AddingBook.this, "Book is added");
						}else {
							JOptionPane.showMessageDialog(AddingBook.this, "Not Added");
						}
						con.close();
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
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
	
		browse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(AddingBook.this);
				
				if (result == JFileChooser.APPROVE_OPTION) {
				    String selectedFile = fileChooser.getSelectedFile().getAbsolutePath();
				    
				    bookImage.setIcon(Utility.resizeImg(new ImageIcon(selectedFile), 228, 154));
				    imageUrl.setText(selectedFile);
			}
				
			}
		});
	}
	
	
	private String Bname ,Bprice,Bauthor,Bimage,Bcategory;
	private boolean valid() {
		Bname = name.getText();
		Bprice = price.getText();
		Bauthor= author.getText();
		
		Bimage = imageUrl.getText();
		Bcategory= category.getSelectedItem().toString();
		
		
		
		// if conditions for text
		if (Bname.isBlank()) {
			JOptionPane.showMessageDialog(AddingBook.this,"please enter the Name of book");
			return false;
			
		}else if(Bprice.isBlank()) {
			JOptionPane.showMessageDialog(AddingBook.this,"please enter the Price of book");
			return false;
			
		}else if (Bauthor.isBlank()) {
			JOptionPane.showMessageDialog(AddingBook.this,"please enter the Author Name");
			return false;
		}else if (Bcategory.equalsIgnoreCase("Select Generics")) {
			JOptionPane.showMessageDialog(AddingBook.this, "Please select book generic");
			return false;
		}else {
			return true;
		}
		
		
	}
}
