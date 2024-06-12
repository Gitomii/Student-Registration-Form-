package stud;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class infortab extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	Statement st;
	ResultSet rs;
	DefaultTableModel model;
	Connection con;
	private JScrollPane scrollPane;
	private JButton b2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					infortab frame = new infortab();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public infortab() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(164, 56, 290, 162);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		
		JButton b1 = new JButton("show");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost/sonoo","root","srushti");
					try {
					Statement st=con.createStatement();
					String abc="SELECT * FROM hi";
					
				ResultSet rs =st.executeQuery(abc);
				ResultSetMetaData rsmd=rs.getMetaData();
				model=(DefaultTableModel)table.getModel();
				
				int cols=rsmd.getColumnCount();
				String[] colName=new String[cols]; for(int i=0;i<cols;i++)
					colName[i]=rsmd.getColumnName(i+1);
						model.setColumnIdentifiers(colName);
						String id,name,price,gender;
						while(rs.next()) {
							id=rs.getString(1);
							name=rs.getString(2);
							price=rs.getString(3);
							gender=rs.getString(4);
							String[] row= {id,name,price,gender};
							model.addRow(row);
						}
						
			}
			catch(Exception t) {
				System.out.println("noo");
				}
			}
				catch(Exception p){
					System.out.println("NO");
					}
			}
		});
		b1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b1.setBounds(171, 256, 149, 44);
		contentPane.add(b1);
		
		b2 = new JButton("clear");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel());
				
			}
		});
		b2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b2.setBounds(330, 257, 149, 42);
		contentPane.add(b2);
	}

}
