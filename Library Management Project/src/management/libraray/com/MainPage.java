package management.libraray.com;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import images.Utility;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuKeyEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;



public class MainPage extends JFrame {

	

	

		private JPanel contentPane;
		

		public MainPage() {
			setTitle("Library DashBoard");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 673, 420);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(153, 204, 204));
			contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			
			JMenuBar menuBar = new JMenuBar();
			menuBar.setForeground(new Color(255, 255, 102));
			menuBar.setBackground(new Color(255, 255, 102));
			menuBar.setBounds(0, 0, 657, 22);
			contentPane.add(menuBar);
			
			JMenu file = new JMenu("File");
			menuBar.add(file);
			
			JMenuItem addBook = new JMenuItem("Add Book"); 
			addBook.setForeground(new Color(0, 0, 0));
			addBook.setBackground(new Color(0, 255, 0));
			
			
			
			file.add(addBook);
			
			JMenuItem booksearch = new JMenuItem("Search Book");
			booksearch.setBackground(new Color(0, 255, 51));
			
			file.add(booksearch);
			
			JMenuItem booksort = new JMenuItem("Book Sort");
			booksort.setBackground(new Color(0, 255, 102));
			
			
			file.add(booksort);
			
			JMenuItem logout = new JMenuItem("Logout");
			logout.setBackground(new Color(255, 0, 0));
			logout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_UNDEFINED, 0));
			
			file.add(logout);
			
			JMenuItem booklist = new JMenuItem("Book List");
			booklist.setBackground(new Color(51, 153, 255));
			
			
			
			JMenu view = new JMenu("View\r\n");
			view.setBackground(new Color(153, 51, 153));
			menuBar.add(view);
			view.add(booklist);
			
			JMenuItem userList = new JMenuItem("Users List");
			userList.setBackground(new Color(153, 153, 255));
			
			view.add(userList);
			
			JMenu edit = new JMenu("Edit");
			edit.setBackground(new Color(153, 204, 51));
			menuBar.add(edit);
			
			JMenuItem update = new JMenuItem("Update Books");
			
			edit.add(update);
			
			JMenuItem deleteBook = new JMenuItem("Delete Book");
			deleteBook.setBackground(new Color(51, 255, 153));
			
			edit.add(deleteBook);
			
			
			
			JLabel lblNewLabel = new JLabel("My Library Dashboard");
			lblNewLabel.setFont(new Font("Modern No. 20", Font.BOLD, 17));
			lblNewLabel.setBounds(232, 33, 235, 28);
			contentPane.add(lblNewLabel);
			
			JLabel MyProfileLabel = new JLabel("My Profile");
			MyProfileLabel.setHorizontalAlignment(SwingConstants.CENTER);
			
			MyProfileLabel.setIcon(null);
			MyProfileLabel.setFont(new Font("Script MT Bold", Font.BOLD, 15));
			MyProfileLabel.setLabelFor(this);
			MyProfileLabel.setBackground(new Color(Color.TRANSLUCENT));
			MyProfileLabel.setText("My profile");
			
			MyProfileLabel.setBounds(62, 135, 93, 22);
			contentPane.add(MyProfileLabel);
			
			JLabel MyBooksLabel = new JLabel("My Books");
			MyBooksLabel.setIcon(null);
			MyBooksLabel.setFont(new Font("Script MT Bold", Font.BOLD, 15));
			MyBooksLabel.setBackground(Color.CYAN);
			MyBooksLabel.setBounds(513, 135, 93, 22);
			contentPane.add(MyBooksLabel);
			
			JLabel lblNewLabel_2 = new JLabel("Users List");
			lblNewLabel_2.setFont(new Font("Script MT Bold", Font.BOLD, 15));
			lblNewLabel_2.setBounds(355, 132, 93, 28);
			contentPane.add(lblNewLabel_2);
			
			JLabel UpdateBooksLabel = new JLabel("Update Books");
			UpdateBooksLabel.setFont(new Font("Script MT Bold", Font.BOLD, 15));
			UpdateBooksLabel.setBounds(62, 337, 93, 22);
			contentPane.add(UpdateBooksLabel);
			
			JLabel searchBookLabel = new JLabel("Search Book");
			searchBookLabel.setFont(new Font("Script MT Bold", Font.BOLD, 15));
			searchBookLabel.setBounds(62, 238, 93, 28);
			contentPane.add(searchBookLabel);
			
			JLabel sortBookLabel = new JLabel("Sort Book ");
			sortBookLabel.setFont(new Font("Script MT Bold", Font.BOLD, 15));
			sortBookLabel.setBounds(203, 238, 93, 28);
			contentPane.add(sortBookLabel);
			
			JLabel DeleteBookLabel = new JLabel("Delete Book");
			DeleteBookLabel.setFont(new Font("Script MT Bold", Font.BOLD, 15));
			DeleteBookLabel.setBounds(345, 238, 93, 28);
			contentPane.add(DeleteBookLabel);
			
			JLabel LogoutLabel = new JLabel("Logout");
			LogoutLabel.setFont(new Font("Script MT Bold", Font.BOLD, 15));
			LogoutLabel.setForeground(new Color(0, 0, 0));
			LogoutLabel.setBounds(491, 238, 93, 28);
			contentPane.add(LogoutLabel);
			
			JLabel MyProfile = new JLabel("New label");
			
			MyProfile.setIcon(Utility.resizeImg(new ImageIcon(MainPage.class.getResource("/management/library/images/myprofile.png")),93,61));
			MyProfile.setBounds(62, 75, 93, 61);
			contentPane.add(MyProfile);
			
			JLabel MyBooks = new JLabel("New label");
			
			MyBooks.setIcon(Utility.resizeImg(new ImageIcon(MainPage.class.getResource("/management/library/images/myBook.jpg")),94,64));
			MyBooks.setBounds(503, 72, 94, 64);
			contentPane.add(MyBooks);
			
			JLabel UsersList = new JLabel("New label");
			
			
			UsersList.setIcon(Utility.resizeImg(new ImageIcon(MainPage.class.getResource("/management/library/images/userlist.png")),94,64));
			UsersList.setBounds(345, 73, 94, 64);
			contentPane.add(UsersList);
			
			JLabel UpdateBooks = new JLabel("");
			
			UpdateBooks.setIcon(Utility.resizeImg(new ImageIcon(MainPage.class.getResource("/management/library/images/update.png")),97,64));
			UpdateBooks.setBounds(62, 277, 97, 64);
			contentPane.add(UpdateBooks);
			
			JLabel searchBook = new JLabel("New label");
			
			searchBook.setIcon(Utility.resizeImg( new ImageIcon(MainPage.class.getResource("/management/library/images/search.png")),102,64));
			searchBook.setBounds(62, 182, 102, 64);
			contentPane.add(searchBook);
			
			JLabel sortBook = new JLabel("New label");
			
			sortBook.setIcon(Utility.resizeImg( new ImageIcon(MainPage.class.getResource("/management/library/images/sort.png")),68,64));
			sortBook.setBounds(203, 182, 68, 64);
			contentPane.add(sortBook);
			
			JLabel DeleteBook = new JLabel("New label");
			
			DeleteBook.setIcon(Utility.resizeImg(new ImageIcon(MainPage.class.getResource("/management/library/images/imagePerson.jpg")),94,64));;
			DeleteBook.setBounds(344, 171, 94, 64);
			contentPane.add(DeleteBook);
			
			JLabel Logout = new JLabel("New label");
			
			Logout.setIcon(Utility.resizeImg(new ImageIcon(MainPage.class.getResource("/management/library/images/logout.jpg")),94,61));
			Logout.setBounds(490, 168, 94, 61);
			contentPane.add(Logout);
			
			JLabel lblNewLabel_1 = new JLabel("Add Book");
			
			lblNewLabel_1.setIcon(Utility.resizeImg(new ImageIcon(MainPage.class.getResource("/management/library/images/addbook.png")),83,69));
			lblNewLabel_1.setBounds(213, 67, 83, 69);
			contentPane.add(lblNewLabel_1);
			
			JLabel lblNewLabel_3 = new JLabel("Add Book");
			lblNewLabel_3.setFont(new Font("Script MT Bold", Font.BOLD, 14));
			lblNewLabel_3.setBounds(223, 140, 83, 14);
			contentPane.add(lblNewLabel_3);
			
			// Event handling
			
			addBook.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					new AddingBook().setVisible(true);
					dispose();
				}
			});
			
			booklist.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new BookList().setVisible(true);
				}
			});
			
			MyBooks.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					new BookList().setVisible(true);
				}
			});
			
			Logout.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					new LoginClass().setVisible(true);
				}
			});
			
			UsersList.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					new UserList().setVisible(true);
				}
			});
			
			MyProfile.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					dispose();
					new MyProfile().setVisible(true);
				}
			});
			UpdateBooks.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					new UpdateBooks().setVisible(true);
				}
			});
			
			DeleteBook.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					new DeleteBooks().setVisible(true);
				}
			});
			
			sortBook.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					new BookSorting().setVisible(true);
				}
			});
			
			
			booksearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new SearchBook().setVisible(true);
					
				}
			});
			
			logout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new LoginClass().setVisible(true);
					
				}
			});
			searchBook.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					new SearchBook().setVisible(true);
				}
			});
			booklist.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					new BookList().setVisible(true);
				}
			});
			booksort.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
			new BookSorting().setVisible(true);
				}
			});
			
			
			
			   userList.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)  {
					dispose();
					new UserList().setVisible(true);
				}
			});
			
			update.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new UpdateBooks().setVisible(true);
				}
			});
			deleteBook.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new DeleteBooks().setVisible(true);
				}
			});
			
			lblNewLabel_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					new AddingBook().setVisible(true);
				}
			});
			
			
			
		}
	}

