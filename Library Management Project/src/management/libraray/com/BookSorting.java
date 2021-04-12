package management.libraray.com;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class BookSorting extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	private DefaultTableModel df;
	private String name,author,price,category,date;
	private int id;
	int count;
	 PreparedStatement	ps;
   
    private JTable table;
    private JScrollPane scrollPane;
    private JLabel back;

	public BookSorting()  {
		setTitle("SORT BOOKS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 433);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Books Sorting");
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(269, 11, 137, 30);
		contentPane.add(lblNewLabel);
		
		String [] sorts = {"Sort Here","Sort by Name","Sort by Id","Sort by Date","Sort by AuthorName","Newest Added","Oldest Added","Price Low","Price High"};
		comboBox = new JComboBox(sorts);
		comboBox.setBackground(new Color(255, 153, 204));
		
		
		
		
		comboBox.setBounds(457, 13, 173, 28);
		contentPane.add(comboBox);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 88, 596, 284);
		contentPane.add(scrollPane);
		
	
		String [] cols= {"Id","Name","Author","Price","Category","Date"};
		 df = new DefaultTableModel(cols,0);
		
			table = new JTable(df);
			table.setBounds(48, 114, 582, 250);
			scrollPane.setViewportView(table);
			table.setForeground(Color.CYAN);
			table.setBackground(Color.DARK_GRAY);
			
			back = new JLabel("<-back");
			
			back.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 13));
			back.setBounds(10, 11, 58, 30);
			contentPane.add(back);
			
			JTableHeader tableHeader = table.getTableHeader();
			tableHeader.setBackground(Color.BLUE);
			tableHeader.setForeground(Color.WHITE);
			
			// creating database connection 
        Connection con = DatabaseDriver.getConnection();
        
       
        
       
        comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if (e.getStateChange()<=1) {
				
				
					if(comboBox.getSelectedItem().equals("Sort Here")) {
						
						String initial = "select *from bookdetails ";
					
					try {	
			    
				    
						ps = con.prepareCall(initial);

						ResultSet rs1=	ps.executeQuery();
						
						
						DefaultTableModel model =(DefaultTableModel)table.getModel();
						while(rs1.next()) {
							 name = rs1.getString("Name");
							 author = rs1.getString("Author");
							 price = rs1.getString("Price");
							 category = rs1.getString("Category");
							date = rs1.getString("Date");
							id = rs1.getInt("Id");
							
							model.addRow(new Object[] {id,name,author,price,category,date});
						
							}
						  
						}catch(Exception h) {
							h.printStackTrace();
						}
					}
					
					
					
					if(comboBox.getSelectedItem().equals("Sort by Name")) {
						((DefaultTableModel)table.getModel()).setRowCount(0);
						String queryName = "select *from bookdetails order by Name";
					
					try {	
			    
				    
						ps = con.prepareCall(queryName);

						ResultSet rs1=	ps.executeQuery();
						
						
						DefaultTableModel model =(DefaultTableModel)table.getModel();
						while(rs1.next()) {
							 name = rs1.getString("Name");
							 author = rs1.getString("Author");
							 price = rs1.getString("Price");
							 category = rs1.getString("Category");
							date = rs1.getString("Date");
							id = rs1.getInt("Id");
							
							model.addRow(new Object[] {id,name,author,price,category,date});
						
							}
						  
						}catch(Exception h) {
							h.printStackTrace();
						}
					}
					
					if (comboBox.getSelectedItem().equals("Sort by Id")) {
						((DefaultTableModel)table.getModel()).setRowCount(0);
						String idquery = "select *from bookdetails order by Id";

						try {	
				    
					   
							ps = con.prepareCall(idquery);

							ResultSet rs1=	ps.executeQuery();
							
							
							DefaultTableModel model =(DefaultTableModel)table.getModel();
							while(rs1.next()) {
								 name = rs1.getString("Name");
								 author = rs1.getString("Author");
								 price = rs1.getString("Price");
								 category = rs1.getString("Category");
								date = rs1.getString("Date");
								id = rs1.getInt("Id");
								
								
								model.addRow(new Object[] {id,name,author,price,category,date});
							
								}
							  
							}catch(Exception h) {
								h.printStackTrace();
							}
					}
					if (comboBox.getSelectedItem().equals("Sort by Date")) {
						((DefaultTableModel)table.getModel()).setRowCount(0);
						String datequery = "select *from bookdetails order by Date ";

						try {	
				    
					   
							ps = con.prepareCall(datequery);

							ResultSet rs1=	ps.executeQuery();
							
							
							DefaultTableModel model =(DefaultTableModel)table.getModel();
							while(rs1.next()) {
								 name = rs1.getString("Name");
								 author = rs1.getString("Author");
								 price = rs1.getString("Price");
								 category = rs1.getString("Category");
								date = rs1.getString("Date");
								id = rs1.getInt("Id");
								
								
								model.addRow(new Object[] {id,name,author,price,category,date});
							
								}
							  
							}catch(Exception h) {
								h.printStackTrace();
							}
					}
					
					if (comboBox.getSelectedItem().equals("Sort by AuthorName")) {
						((DefaultTableModel)table.getModel()).setRowCount(0);
						String authorquery = "select *from bookdetails order by Author";

						try {	
				    
					   
							ps = con.prepareCall(authorquery);

							ResultSet rs1=	ps.executeQuery();
							
							
							DefaultTableModel model =(DefaultTableModel)table.getModel();
							while(rs1.next()) {
								 name = rs1.getString("Name");
								 author = rs1.getString("Author");
								 price = rs1.getString("Price");
								 category = rs1.getString("Category");
								date = rs1.getString("Date");
								id = rs1.getInt("Id");
								
								
								model.addRow(new Object[] {id,name,author,price,category,date});
							
								}
							  
							}catch(Exception h) {
								h.printStackTrace();
							}
					}
					if (comboBox.getSelectedItem().equals("Newest Added")) {
						((DefaultTableModel)table.getModel()).setRowCount(0);
						String newest = "select *from bookdetails order by Date ASC";

						try {	
				    
					   
							ps = con.prepareCall(newest);

							ResultSet rs1=	ps.executeQuery();
							
							
							DefaultTableModel model =(DefaultTableModel)table.getModel();
							while(rs1.next()) {
								 name = rs1.getString("Name");
								 author = rs1.getString("Author");
								 price = rs1.getString("Price");
								 category = rs1.getString("Category");
								date = rs1.getString("Date");
								id = rs1.getInt("Id");
								
								
								model.addRow(new Object[] {id,name,author,price,category,date});
							
								}
							  
							}catch(Exception h) {
								h.printStackTrace();
							}
					}
					
					if (comboBox.getSelectedItem().equals("Oldest Added")) {
						((DefaultTableModel)table.getModel()).setRowCount(0);
						String oldest = "select *from bookdetails order by Date DESC";

						try {	
				    
					   
							ps = con.prepareCall(oldest);

							ResultSet rs1=	ps.executeQuery();
							
							
							DefaultTableModel model =(DefaultTableModel)table.getModel();
							while(rs1.next()) {
								 name = rs1.getString("Name");
								 author = rs1.getString("Author");
								 price = rs1.getString("Price");
								 category = rs1.getString("Category");
								date = rs1.getString("Date");
								id = rs1.getInt("Id");
								
								
								model.addRow(new Object[] {id,name,author,price,category,date});
							
								}
							  
							}catch(Exception h) {
								h.printStackTrace();
							}
					}
					
					if (comboBox.getSelectedItem().equals("Price High")) {
						((DefaultTableModel)table.getModel()).setRowCount(0);
						String high = "select *from bookdetails order by Price ";

						try {	
				    
					   
							ps = con.prepareCall(high);

							ResultSet rs1=	ps.executeQuery();
							
							
							DefaultTableModel model =(DefaultTableModel)table.getModel();
							while(rs1.next()) {
								 name = rs1.getString("Name");
								 author = rs1.getString("Author");
								 price = rs1.getString("Price");
								 category = rs1.getString("Category");
								date = rs1.getString("Date");
								id = rs1.getInt("Id");
								
								
								model.addRow(new Object[] {id,name,author,price,category,date});
							
								}
							  
							}catch(Exception h) {
								h.printStackTrace();
							}
					}
					
					if (comboBox.getSelectedItem().equals("Price Low")) {
						((DefaultTableModel)table.getModel()).setRowCount(0);
						String low = "select *from bookdetails order by Price DESC";

						try {	
				    
					   
							ps = con.prepareCall(low);

							ResultSet rs1=	ps.executeQuery();
							
							
							DefaultTableModel model =(DefaultTableModel)table.getModel();
							while(rs1.next()) {
								 name = rs1.getString("Name");
								 author = rs1.getString("Author");
								 price = rs1.getString("Price");
								 category = rs1.getString("Category");
								date = rs1.getString("Date");
								id = rs1.getInt("Id");
								
								
								model.addRow(new Object[] {id,name,author,price,category,date});
							
								}
							  
							}catch(Exception h) {
								h.printStackTrace();
							}
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
				 
				
			}
			
		
       
}     
			
		       
		
		
       
		
		
		
		 
        
		
		
		
		
	
