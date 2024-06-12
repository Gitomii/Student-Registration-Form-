package stud;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.print.*;
import javafx.print.Printer;import javax.swing.JTextArea;

public class informs extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTable table;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					informs frame = new informs();
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
	public informs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD SUBJECT ON COURSE FORM");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 25));
		lblNewLabel.setBounds(175, 10, 397, 54);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setForeground(Color.BLACK);
		panel.setBounds(41, 74, 342, 243);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel l1 = new JLabel("Subject Code:");
		l1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l1.setBounds(10, 10, 103, 25);
		panel.add(l1);
		
		JLabel l2 = new JLabel("Subject Name");
		l2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l2.setBounds(10, 56, 103, 25);
		panel.add(l2);
		
		JLabel l3 = new JLabel("Enter Sem No.:");
		l3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l3.setBounds(10, 101, 114, 25);
		panel.add(l3);
		
		JLabel l4 = new JLabel("Select Department:");
		l4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l4.setBounds(10, 146, 130, 25);
		panel.add(l4);
		
		JLabel l5 = new JLabel("Select Course:");
		l5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l5.setBounds(10, 191, 103, 25);
		panel.add(l5);
		
		t1 = new JTextField();
		t1.setBounds(150, 10, 130, 25);
		panel.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(150, 61, 130, 25);
		panel.add(t2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(150, 106, 130, 25);
		panel.add(t3);
		
		final JComboBox cb1 = new JComboBox();
		cb1.setModel(new DefaultComboBoxModel(new String[] {"Arts", "Commerce", "Computer Science"}));
		cb1.setBounds(150, 150, 130, 21);
		panel.add(cb1);
		
		final JComboBox cb2 = new JComboBox();
		cb2.setModel(new DefaultComboBoxModel(new String[] {"BA", "BCA ", "MCA", "MCS", "BCOM"}));
		cb2.setBounds(150, 195, 130, 21);
		panel.add(cb2);
		
		final JPanel txtR = new JPanel();
		txtR.setBackground(Color.LIGHT_GRAY);
		txtR.setBounds(399, 74, 342, 243);
		contentPane.add(txtR);
		txtR.setLayout(null);
		
		JLabel l6 = new JLabel("Enter The Subject Name:");
		l6.setBounds(10, 10, 171, 25);
		txtR.add(l6);
		l6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		t4 = new JTextField();
		t4.setBounds(10, 45, 322, 25);
		txtR.add(t4);
		t4.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 80, 322, 153);
		txtR.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				""
			}
		));
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(10, 345, 741, 62);
		contentPane.add(panel_2);
		
		final JButton b1 = new JButton("SAVE");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==b1){
					
					Object[] row=new Object[11];
					model=(DefaultTableModel)table.getModel();
					row[0]=t4.getText();
					
					
					model.addRow(row);
					
					try{
						String subcode=t1.getText();
						String name=t2.getText();
						String semno=t3.getText();
						String dept=(String)cb1.getSelectedItem();
						String course=(String)cb2.getSelectedItem();

						
					
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost/inform1","root","srushti");
    					String sql="INSERT INTO infs VALUES(?,?,?,?,?)";	
						PreparedStatement pq=con.prepareStatement(sql);
						pq.setString(1,subcode);
						pq.setString(2,name);			
						pq.setString(3, semno);						
						pq.setString(4,dept);
						pq.setString(5,course);
						
						

						int q = pq.executeUpdate();
						System.out.println("YES");
					}
					
						catch(Exception m){
						System.out.println(m);
						}
					}
				JOptionPane.showMessageDialog(null, "DONE SUCCESSFULLY","  ",JOptionPane.INFORMATION_MESSAGE);	
				}
			
		});
		b1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		b1.setBounds(10, 10, 75, 46);
		panel_2.add(b1);
		
		JButton b2 = new JButton("UPDATE");
		b2.setFont(new Font("Tahoma", Font.ITALIC, 15));
		b2.setBounds(95, 10, 98, 46);
		panel_2.add(b2);
		
		final JButton b3 = new JButton("DELETE");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==b3){
					try{
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost/inform1","root","srushti");
						String sql = "DELETE FROM infs where subcode=?";
					PreparedStatement pq = con.prepareStatement(sql);
					String b=t1.getText();
					pq.setString(1, b);
					int rowsDeleted = pq.executeUpdate();

					if (rowsDeleted > 0){
					    System.out.println("YES");
						}
					}
					catch(Exception h){
					System.out.println("NO");
					}
					JOptionPane.showMessageDialog(null, "USER DELETED SUCCESSFULLY","  ",JOptionPane.INFORMATION_MESSAGE);
					}
			}
		});
		b3.setFont(new Font("Tahoma", Font.ITALIC, 15));
		b3.setBounds(203, 10, 98, 46);
		panel_2.add(b3);
		
		JButton b4 = new JButton("RESET");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setText(" ");
				t2.setText(" ");
				t3.setText(" ");
				JOptionPane.showMessageDialog(null, "RESETED SUCCESSFULLY","  ",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		b4.setFont(new Font("Tahoma", Font.ITALIC, 15));
		b4.setBounds(311, 10, 89, 46);
		panel_2.add(b4);
		
		JButton b5 = new JButton("SEARCH");
		b5.setFont(new Font("Tahoma", Font.ITALIC, 15));
		b5.setBounds(410, 10, 93, 46);
		panel_2.add(b5);
		
		JButton b6 = new JButton("EXIT");
		b6.setFont(new Font("Tahoma", Font.ITALIC, 15));
		b6.setBounds(513, 10, 75, 46);
		panel_2.add(b6);
		
		JButton btnNewButton = new JButton("PRINT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			try {
				txtR.print(null);
			}	
				catch(Exception ee) {
					System.err.format("No Printer found", ee.getMessage());
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnNewButton.setBounds(598, 10, 133, 46);
		panel_2.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Pictures\\wallpapersden.com_goku-new-dragon-ball-z-art_2400x1350.jpg"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(0, 0, 761, 442);
		contentPane.add(lblNewLabel_1);
	}
}
