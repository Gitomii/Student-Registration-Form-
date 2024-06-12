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
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class informc extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
					informc frame = new informc();
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
	public informc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD COURSE");
		lblNewLabel.setForeground(new Color(240, 255, 255));
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 25));
		lblNewLabel.setBounds(210, 10, 169, 44);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.WHITE);
		panel.setBounds(10, 64, 342, 162);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel l1 = new JLabel("Department ID:");
		l1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l1.setBounds(10, 10, 106, 19);
		panel.add(l1);
		
		JLabel l2 = new JLabel("Department Name:");
		l2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l2.setBounds(10, 49, 130, 19);
		panel.add(l2);
		
		JLabel l3 = new JLabel("Course Name:");
		l3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l3.setBounds(10, 85, 106, 19);
		panel.add(l3);
		
		JLabel l4 = new JLabel("No. Of Sem.:");
		l4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l4.setBounds(10, 125, 106, 19);
		panel.add(l4);
		
		t1 = new JTextField();
		t1.setBounds(150, 12, 106, 17);
		panel.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(150, 51, 106, 17);
		panel.add(t2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(150, 87, 106, 17);
		panel.add(t3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(150, 127, 106, 17);
		panel.add(t4);
		
		final JButton b1 = new JButton("SAVE");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==b1){
					
				Object[] row=new Object[11];
				model=(DefaultTableModel)table.getModel();
				row[0]=t1.getText();	
				row[1]=t2.getText();	
				row[2]=t3.getText();	
				row[3]=t4.getText();	
				
				model.addRow(row);
				
				try{
					String var1=t1.getText();
					String var2=t2.getText();
					String var3=t3.getText();	
					String var4=t4.getText();
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/inform1","root","srushti");
					String sql="INSERT INTO infc VALUES(?,?,?,?)";	
					PreparedStatement pq=con.prepareStatement(sql);
					pq.setString(1,var1);
					pq.setString(2,var2);			
					pq.setString(3,var3 );						
					pq.setString(4,var4);
					
					
				
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
		b1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b1.setBounds(410, 81, 85, 26);
		contentPane.add(b1);
		
		JButton b2 = new JButton("RESET");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setText(" ");
				t2.setText(" ");
				t3.setText(" ");
				t4.setText(" ");
				JOptionPane.showMessageDialog(null, "RESETED SUCCESSFULLY","  ",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		b2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b2.setBounds(410, 129, 85, 26);
		contentPane.add(b2);
		
		JButton b3 = new JButton("BACK");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		b3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b3.setBounds(410, 178, 85, 26);
		contentPane.add(b3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 236, 535, 212);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 515, 192);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Dept ID", "Dept Name", "Course Name", "No. Of Sem"
			}
		));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Pictures\\wallpapersden.com_goku-new-dragon-ball-z-art_2400x1350.jpg"));
		lblNewLabel_1.setBounds(0, 0, 555, 458);
		contentPane.add(lblNewLabel_1);
	}

}
