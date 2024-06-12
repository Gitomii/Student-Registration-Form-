package stud;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class abcd extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	Connection con=null;
	PreparedStatement pq=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					abcd frame = new abcd();
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
	public abcd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("enter name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(137, 102, 107, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblEnterNo = new JLabel("enter no");
		lblEnterNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnterNo.setBounds(137, 164, 107, 31);
		contentPane.add(lblEnterNo);
		
		t1 = new JTextField();
		t1.setBounds(273, 102, 124, 31);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(273, 167, 124, 31);
		contentPane.add(t2);
		
		JButton btnNewButton = new JButton("save");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String var1=t1.getText();
				String var2=t2.getText();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/ap","root","srushti");
					try {
					String sql="INSERT INTO app VALUES(?,?)";	
					pq=con.prepareStatement(sql);
					pq.setString(1,var1);
					pq.setString(2,var2);	
				}
					catch(SQLException s) {
						s.printStackTrace();
					}
					}
				catch(Exception e1) {
					System.out.println("no");
					
				}
			/*	
			finally {
				try {
					if(pq!=null)pq.close();
					if(con!=null)con.close();
				}
				catch(Exception w) {
					System.out.println(w);
				}
				
				
				
			}*/
				System.out.println("closed");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(212, 271, 107, 41);
		contentPane.add(btnNewButton);
	}
}
