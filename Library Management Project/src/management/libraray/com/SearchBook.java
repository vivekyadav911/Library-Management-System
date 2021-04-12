package management.libraray.com;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class SearchBook extends JFrame {

	private JPanel contentPane;
	private JTextField searchField;
	private JTable table;
	String Sname,Sauthor,Sprice,Scategory,Sdate;
	int Sid;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchBook frame = new SearchBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
		
	
	public SearchBook() {
		setTitle("BOOK SEARCH");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 422);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search Book");
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(251, 26, 169, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("<-back");
		
		lblNewLabel_1.setFont(new Font("Segoe UI Emoji", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 11, 64, 34);
		contentPane.add(lblNewLabel_1);
		
		searchField = new JTextField();
		searchField.setBackground(new Color(255, 255, 153));
		searchField.setBounds(204, 66, 229, 34);
		contentPane.add(searchField);
		searchField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 134, 557, 238);
		contentPane.add(scrollPane);
		
		String [] cols = {"Id", "Name","Author","Category","Price"};
		DefaultTableModel dtm = new DefaultTableModel(cols,0);
		table = new JTable(dtm);
		
		scrollPane.setViewportView(table);
		
		JButton searchBtn = new JButton("Search");
		searchBtn.setBackground(new Color(102, 51, 102));
	
		searchBtn.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 15));
		searchBtn.setBounds(110, 66, 89, 34);
		contentPane.add(searchBtn);
		
		table.setForeground(Color.CYAN);
		table.setBackground(Color.DARK_GRAY);
		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setBackground(Color.BLUE);
		tableHeader.setForeground(Color.WHITE);
		
		
		
		
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new MainPage().setVisible(true);
			}
		});
		
		searchBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

 				Connection con = DatabaseDriver.getConnection();
				String query = "select *from bookdetails where  Author or Name  like ? " ;
			
				if (e.getClickCount()==1) {
					((DefaultTableModel)table.getModel()).setRowCount(0);
				}
				try {
				
					PreparedStatement ps = con.prepareCall(query);
					
					ps.setString(1,  "%" + searchField.getText() + "%");
					
					ResultSet rs =ps.executeQuery();
					
					while(rs.next()) {
					
						 Sname = rs.getString("Name");
						 Sauthor = rs.getString("Author");
						 Sprice = rs.getString("Price");
						 Scategory = rs.getString("Category");
						Sdate = rs.getString("Date");
						Sid = rs.getInt("Id");
						
						dtm.addRow(new Object[] {Sid,Sname,Sauthor,Scategory,Sprice});
					}
					
				
				} catch (SQLException ex) {
					
					ex.printStackTrace();
				}
				
			}
		});
	
	}
}

