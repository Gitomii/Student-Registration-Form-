package stud;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class informtab extends JFrame {

	protected static final DefaultTableModel DefaultTableModel = null;
	private JPanel contentPane;
	private JTable table;
	Statement st;
	ResultSet rs;
	Connection con;
	private JScrollPane scrollPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					informtab frame = new informtab();
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
	public informtab() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(107, 63, 315, 184);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		
		JButton b1 = new JButton("save");
		b1.addActionListener(new ActionListener() {
			//private JTable tableData;

			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost/sonoo","root","srushti");
					try {
					Statement st=con.createStatement();
					String abc="SELECT * FROM hi";
					// PreparedStatement pq = con.prepareStatement("SELECT * FROM hi where rollno=?");
				   //pq.setString(1,t1.getText());
				
				ResultSet rs =st.executeQuery(abc);
				ResultSetMetaData rsmd=rs.getMetaData();
				DefaultTableModel model=(DefaultTableModel);
				table.getModel();
				int cols=rsmd.getColumnCount();
				String[] colName=new String[cols]; for(int i=0;i<cols;i++)
					colName[i]=rsmd.getColumnName(i+1);
						model.setColumnIdentifiers(colName);
			}
			catch(Exception t) {
				System.out.println("noo");
				}
			}
				catch(Exception p){
					System.out.println("NO");
					}}
		});
		b1.setBounds(223, 283, 85, 21);
		contentPane.add(b1);
	}
}
