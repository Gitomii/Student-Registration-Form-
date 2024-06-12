package stud;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class ccc extends JFrame {

	private JPanel contentPane;
	private JTextField t1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ccc frame = new ccc();
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
	public ccc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		t1 = new JTextField();
		t1.setBounds(171, 75, 132, 25);
		contentPane.add(t1);
		t1.setColumns(10);
		
		JButton b1 = new JButton("New button");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					String var1=t1.getText();	
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/inform1","root","srushti");
					//String sql="INSERT INTO inff VALUES(?)";	
					//PreparedStatement pq=con.prepareStatement(sql);
					//pq.setString(1,var1);pq.executeUpdate();
					System.out.println("YES");
				}
				
					catch(Exception m){
					System.out.println("NO");
					}
			}
		});
		b1.setBounds(184, 162, 119, 25);
		contentPane.add(b1);
	}

}
