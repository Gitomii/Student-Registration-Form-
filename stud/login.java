package stud;

import java.awt.EventQueue;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.Action;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.io.*;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	Connection con;
	Statement st;
	ResultSet rs;
	private JPasswordField t2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(273, 107, 258, 219);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel l1 = new JLabel("UserName:");
		l1.setFont(new Font("Tahoma", Font.BOLD, 16));
		l1.setBounds(10, 10, 91, 40);
		panel.add(l1);
		
		JLabel lblNewLabel = new JLabel("Password:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 85, 91, 40);
		panel.add(lblNewLabel);
		
		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		t1.setBounds(111, 21, 134, 26);
		panel.add(t1);
		t1.setColumns(10);
		
		JButton b1 = new JButton("LOGIN");
		b1.setBackground(SystemColor.textHighlight);
		b1.setForeground(SystemColor.activeCaption);
		b1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost/inform1","root","srushti");
				st=con.createStatement();
				
				String sql="Select * from inlog where UserName='"+t1.getText()+"' and Password='"+t2.getText().toString()+"'";
			    rs=st.executeQuery(sql);
				if(rs.next()) 
					try {
						menu frame = new menu();
						frame.setVisible(true);
						JOptionPane.showMessageDialog(null, "LOGIN SUCCESSFULLY","  ",JOptionPane.INFORMATION_MESSAGE);
					} catch (Exception p) {
						p.printStackTrace();
					}	
					else
					JOptionPane.showMessageDialog(null, "INCORRECT USERNAME OR PASSWORD","  ",JOptionPane.INFORMATION_MESSAGE);
					//con.close();
				}
				catch(Exception x) {
					System.out.println(x);
					}	
			}
		});
		b1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		b1.setBounds(35, 154, 190, 40);
		panel.add(b1);
		
		t2 = new JPasswordField();
		t2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t2.setBounds(111, 96, 137, 26);
		panel.add(t2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Pictures\\Saved Pictures\\photo-1529539795054-3c162aab037a (2)"));
		lblNewLabel_1.setBounds(-61, 0, 1043, 432);
		contentPane.add(lblNewLabel_1);
	}
}
