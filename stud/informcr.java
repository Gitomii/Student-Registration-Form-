package stud;
import java.sql.*;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.Color;

public class informcr extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					informcr frame = new informcr();
					frame.setVisible(true);
				} catch (Exception d) {
					d.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public informcr() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 698, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ALLOCATE MARKS FOR CREDIT ACTIVITY");
		lblNewLabel.setForeground(new Color(128, 128, 0));
		lblNewLabel.setBackground(new Color(128, 128, 0));
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 25));
		lblNewLabel.setBounds(109, 16, 483, 46);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(109, 86, 289, 160);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel l1 = new JLabel("Credit No.:");
		l1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l1.setBounds(10, 10, 115, 23);
		panel.add(l1);
		
		JLabel l2 = new JLabel("Activity Name:");
		l2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l2.setBounds(10, 67, 115, 23);
		panel.add(l2);
		
		JLabel l3 = new JLabel("Activity Marks:");
		l3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l3.setBounds(10, 127, 115, 23);
		panel.add(l3);
		
		t1 = new JTextField();
		t1.setBounds(135, 12, 130, 23);
		panel.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(135, 69, 130, 23);
		panel.add(t2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(135, 129, 130, 23);
		panel.add(t3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(408, 86, 170, 160);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		final JButton b1 = new JButton("SAVE");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==b1) {
				try{
					String var1=t1.getText();
					String var2=t2.getText();
					String var3=t3.getText();	
										
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/inform1","root","srushti");
					String sql="INSERT INTO infcr VALUES(?,?,?)";	
					PreparedStatement pq=con.prepareStatement(sql);
					pq.setString(1,var1);
					pq.setString(2,var2);			
					pq.setString(3,var3);
			
				pq.executeUpdate(); 
				System.out.println("YES");
			}
				
					catch(Exception m){
					System.out.println(m);
					}
			}
			JOptionPane.showMessageDialog(null, "DONE SUCCESSFULLY","  ",JOptionPane.INFORMATION_MESSAGE);	
			}
		});
		b1.setBounds(40, 10, 90, 27);
		panel_1.add(b1);
		
		final JButton b2 = new JButton("DELETE");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==b2){
					try{
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost/inform1","root","srushti");
						String sql = "DELETE FROM infcr where creditno=?";
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
		b2.setBounds(40, 47, 90, 27);
		panel_1.add(b2);
		
		JButton b3 = new JButton("RESET");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setText(" ");
				t2.setText(" ");
				t3.setText(" ");
				
				JOptionPane.showMessageDialog(null, "RESETED SUCCESSFULLY","  ",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		b3.setBounds(40, 84, 90, 27);
		panel_1.add(b3);
		
		JButton b4 = new JButton("EXIT");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		b4.setBounds(40, 121, 90, 27);
		panel_1.add(b4);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Pictures\\1920x1080-Blue-Night-Big-Moon-Anime-Scenery-4k-Laptop-Full- - Copy.jpg"));
		lblNewLabel_1.setBounds(0, 0, 684, 282);
		contentPane.add(lblNewLabel_1);
	}
}
