package management.libraray.com;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.Color;
import java.awt.SystemColor;

public class BookList extends JFrame {
    private DefaultTableModel df;
	private JPanel contentPane;
	private JTable table;
	private String name,author,price,category,date,image;
	private JTable listBook;
	private JLabel listback;
	private int id;
	
	

	public BookList()  {
		setTitle("List Of Books");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		String [] cols= {"Id","Name","Author","Price","Category","ImageUrl","Date"};
		 df = new DefaultTableModel(cols,0);
		
		
		
		JLabel list = new JLabel("Books List");
		list.setForeground(SystemColor.desktop);
		list.setFont(new Font("Mistral", Font.BOLD, 25));
		list.setBounds(305, 28, 112, 27);
		contentPane.add(list);
		
		
		
		
		listBook = new JTable(df);
		JScrollPane scrollPane = new JScrollPane(listBook);
		listBook.setBackground(Color.DARK_GRAY);
		listBook.setForeground(Color.CYAN);
		
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportView(listBook);
		scrollPane.setBounds(24, 83, 650, 334);
		contentPane.add(scrollPane);
		
		listback = new JLabel("<-back");
		
		listback.setFont(new Font("Showcard Gothic", Font.BOLD, 13));
		listback.setBounds(10, 11, 49, 27);
		contentPane.add(listback);
		
		JTableHeader tableHeader = listBook.getTableHeader();
		tableHeader.setBackground(Color.BLUE);
		tableHeader.setForeground(Color.WHITE);
		//setting size of column
		TableColumnModel colsize = listBook.getColumnModel();
		colsize.getColumn(0).setPreferredWidth(30);
		colsize.getColumn(1).setPreferredWidth(100);
		colsize.getColumn(2).setPreferredWidth(70);
		colsize.getColumn(3).setPreferredWidth(50);
		colsize.getColumn(4).setPreferredWidth(70);
		colsize.getColumn(5).setPreferredWidth(150);
		colsize.getColumn(6).setPreferredWidth(60);
		
		
		// getting table data
		Connection con =DatabaseDriver.getConnection();
		String query= "select * from bookdetails ";
		try {
			PreparedStatement ps = con.prepareCall(query);
		ResultSet rs=	ps.executeQuery(query);
		
		DefaultTableModel model =(DefaultTableModel)listBook.getModel();
		while(rs.next()) {
			 name = rs.getString("Name");
			 author = rs.getString("Author");
			 price = rs.getString("Price");
			 category = rs.getString("Category");
			date = rs.getString("Date");
			id = rs.getInt("Id");
			image = rs.getString("Image");
			
			model.addRow(new Object[] {id,name,author,price,category,image,date});
		
		}
		
		listback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new MainPage().setVisible(true);
			}
		});
		
		
		
		
		
		
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
	}
	
	
}
