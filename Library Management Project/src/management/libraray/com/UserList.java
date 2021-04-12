package management.libraray.com;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserList extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel df;
	private String name;
	private String email;
	private String password;
	private JLabel lblNewLabel_1;
	private int id;

	
	public UserList() {
		setTitle("LIST OF USERS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 447);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 153));
		contentPane.setBorder(new EmptyBorder(10, 5, 10, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String [] cols= {"Id","Name","Email","Password"};
		 df = new DefaultTableModel(cols,0);
		
		
		JLabel lblNewLabel = new JLabel("Users List");
		lblNewLabel.setFont(new Font("News706 BT", Font.ITALIC, 25));
		lblNewLabel.setBounds(232, 41, 210, 36);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 106, 567, 272);
		contentPane.add(scrollPane);
		
		table = new JTable(df);
		scrollPane.setViewportView(table);
		
		lblNewLabel_1 = new JLabel("<-back");
		
		lblNewLabel_1.setFont(new Font("Wide Latin", Font.ITALIC, 10));
		lblNewLabel_1.setBounds(10, 11, 50, 21);
		contentPane.add(lblNewLabel_1);
		
		
		table.setForeground(Color.CYAN);
		table.setBackground(Color.DARK_GRAY);
		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setBackground(Color.BLUE);
		tableHeader.setForeground(Color.WHITE);
		
		
		Connection con =DatabaseDriver.getConnection();
		String query= "select * from userdetails";
		try {
			PreparedStatement ps = con.prepareCall(query);
		ResultSet rs=	ps.executeQuery(query);
		
		DefaultTableModel model =(DefaultTableModel)table.getModel();
		while(rs.next()) {
			name = rs.getString("Name");
			email = rs.getString("Email");
			password = rs.getString("Password");
			id =rs.getInt("Id");
			
			model.addRow(new Object[] {id,name,email,password});
		
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new MainPage().setVisible(true);
			}
		});
		}
	
}

