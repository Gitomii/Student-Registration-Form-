package stud;
import java.sql.*;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class inform extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
	private JTextField t7;
	private JTextField t8;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JComboBox cb;
	PreparedStatement pq;
	private JTextField t9;
	private JTable table;
	DefaultTableModel model;
	protected String z;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inform frame = new inform();
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
	public inform() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 983, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Registeration Form");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 32));
		lblNewLabel.setBounds(109, 10, 490, 73);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 84, 293, 235);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel l1 = new JLabel("ROLL NO.:");
		l1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		l1.setBounds(10, 28, 72, 16);
		panel.add(l1);
		
		JLabel l2 = new JLabel("STUD NAME:");
		l2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		l2.setBounds(10, 62, 87, 16);
		panel.add(l2);
		
		JLabel l3 = new JLabel("STUD CLASS:");
		l3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		l3.setBounds(10, 99, 87, 16);
		panel.add(l3);
		
		JLabel l4 = new JLabel("LOCAL ADD:");
		l4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		l4.setBounds(10, 136, 87, 16);
		panel.add(l4);
		
		JLabel l5 = new JLabel("CONTACT NO.:");
		l5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		l5.setBounds(10, 174, 103, 16);
		panel.add(l5);
		
		t1 = new JTextField();
		t1.setBounds(116, 28, 96, 19);
		panel.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(116, 62, 96, 19);
		panel.add(t2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(116, 136, 96, 19);
		panel.add(t3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(116, 174, 96, 19);
		panel.add(t4);
		
		cb = new JComboBox();
		cb.setModel(new DefaultComboBoxModel(new String[] {"BA", "BCOM", "BCA"}));
		cb.setBounds(116, 98, 96, 19);
		panel.add(cb);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(393, 84, 293, 235);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel l6 = new JLabel("EMAIL ID:");
		l6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		l6.setBounds(10, 28, 89, 13);
		panel_1.add(l6);
		
		JLabel l7 = new JLabel("DOB:");
		l7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		l7.setBounds(10, 64, 89, 13);
		panel_1.add(l7);
		
		JLabel l8 = new JLabel("GENDER:");
		l8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		l8.setBounds(10, 101, 89, 13);
		panel_1.add(l8);
		
		JLabel l9 = new JLabel("PRN NO.:");
		l9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		l9.setBounds(10, 138, 89, 13);
		panel_1.add(l9);
		
		JLabel l10 = new JLabel("PASSED YEAR:");
		l10.setFont(new Font("Tahoma", Font.PLAIN, 13));
		l10.setBounds(10, 176, 89, 13);
		panel_1.add(l10);
		
		t5 = new JTextField();
		t5.setBounds(133, 26, 96, 19);
		panel_1.add(t5);
		t5.setColumns(10);
		
		t6 = new JTextField();
		t6.setColumns(10);
		t6.setBounds(133, 62, 96, 19);
		panel_1.add(t6);
		
		t7 = new JTextField();
		t7.setColumns(10);
		t7.setBounds(133, 136, 96, 19);
		panel_1.add(t7);
		
		t8 = new JTextField();
		t8.setColumns(10);
		t8.setBounds(133, 174, 96, 19);
		panel_1.add(t8);
		
		final JRadioButton r1 = new JRadioButton("MALE");
		buttonGroup.add(r1);
		r1.setBounds(133, 98, 58, 21);
		panel_1.add(r1);
		
		final JRadioButton r2 = new JRadioButton("FEMALE");
		buttonGroup.add(r2);
		r2.setBounds(194, 98, 78, 21);
		panel_1.add(r2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 51, 51));
		panel_2.setBounds(0, 346, 686, 66);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		final JButton b1 = new JButton("SAVE");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					
					Object[] row=new Object[11];
					model=(DefaultTableModel)table.getModel();
					row[0]=t9.getText();	
					model.addRow(row);
					
					try{
						String var1=t1.getText();
						String var2=t2.getText();
						String var3=r1.getText();	
						String var4=(String)cb.getSelectedItem();
						String localadd=t3.getText();
						String contactno=t4.getText();
						String emailid=t5.getText();
						String dob=t6.getText();
						String prnno=t7.getText();
						String passedyear=t8.getText();
					
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost/inform1","root","srushti");
    					String sql="INSERT INTO inff VALUES(?,?,?,?,?,?,?,?,?,?)";	
						PreparedStatement pq=con.prepareStatement(sql);
						pq.setString(1,var1);
						pq.setString(2,var2);			
						pq.setString(4, var4);						
						pq.setString(5,localadd);
						pq.setString(6,contactno);
						pq.setString(7,emailid);
						pq.setString(8,dob);
						pq.setString(9,prnno);
						pq.setString(10,passedyear);
						
						if(r1.isSelected()) {
							pq.setString(3,"male");
						}
						else {
							pq.setString(3,"female");
						}

						pq.executeUpdate();
						System.out.println("YES");
					}
					
						catch(Exception m){
						System.out.println("NO");
						}
					
				JOptionPane.showMessageDialog(null, "DONE SUCCESSFULLY","  ",JOptionPane.INFORMATION_MESSAGE);	
				
			}
		});
		b1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		b1.setBounds(10, 10, 75, 46);
		panel_2.add(b1);
		
		final JButton b2 = new JButton("VIEW");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==b2){
					try{
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost/inform1","root","srushti");
						
						PreparedStatement pq = con.prepareStatement("SELECT * FROM inff where rollno=?");
					   pq.setString(1,t1.getText());
					//Statement st = con.createStatement();
					ResultSet rs =pq.executeQuery();
					while(rs.next()){
						
					String rollno=rs.getString(1); 
					t1.setText(rollno); 
					String studname=rs.getString(2);
					t2.setText(studname); 
					String localadd=rs.getString(3);
					t3.setText(localadd);  
					String contactno=rs.getString(6);
					t4.setText(contactno);
					String gender=rs.getString(3);
			
					if(gender.equals("male")) {
						r1.setSelected(true);
					}
					else {
						r2.setSelected(true);
					}
					
					String studclass=rs.getString("dept");
					cb.setSelectedItem(studclass);
					
					String emailid=rs.getString(7);
					t5.setText(emailid);
					String dob=rs.getString(8);
					t6.setText(dob);
					String prnno=rs.getString(9);
					t7.setText(prnno);
					String passedyear=rs.getString(10);
					t8.setText(passedyear);

					// System.out.println(" "+rollno+" "+studname+" "+studclass+" "+localadd+" "+contactno+" "+emailid+" "+dob+" "+gender+" "+prnno+" "+passedyear+" ");
					}}
					catch(Exception p){
					System.out.println("NO");
					}}
			}
		});
		b2.setFont(new Font("Tahoma", Font.ITALIC, 15));
		b2.setBounds(95, 10, 75, 46);
		panel_2.add(b2);
		
		final JButton b3 = new JButton("UPDATE");
		b3.addActionListener(new ActionListener() {
		private String var4;
		private PreparedStatement pq;

		public void actionPerformed(ActionEvent e) {
			//
			if(e.getSource()==b3){
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/inform1","root","srushti");
					//PreparedStatement pq = con.prepareStatement("update inff set studname=?,gender=?,dept=?,localadd=?,contactno=?,emailid=?,dob=?,prnno=?,passyear=? where rollno=?");				    
					String a = t1.getText();
					String b = t2.getText();
					String var3=r1.getText();
					if(r1.isSelected()) {
					String var31=r1.getText();	
					}
					else {
						String var31=r2.getText();
					}
					String var4 = (String)cb.getSelectedItem();
					String c = t3.getText();
			
					String d = t4.getText();
					String o = t5.getText();
					String f = t6.getText();
					String g = t7.getText();
					String h = t8.getText();
					
					String sql3 = "update inff set studname=?,gender=?,dept=?,localadd=?,contactno=?,emailid=?,dob=?,prnno=?,passyear=? where rollno=?";
					pq=con.prepareStatement(sql3);
					
					pq.setString(1,b);
					pq.setString(2,c);
					pq.setString(3,d);
					pq.setString(4,var3);
					pq.setString(5,var4);
					pq.setString(5,f);
					pq.setString(6,g);
					pq.setString(7,h);
					pq.setString(8,a);
					
					
					
					
					pq.execute();
					System.out.println("YES");
					/*if(r1.isSelected()) {
						pq.setString(3,"male");
					}
					else {
						pq.setString(3,"female");
					}
					
					
					//cb.getSelectedItem();
					
					pq.setString(4,t3.getText());
					pq.setString(5,t4.getText());
					pq.setString(6,t5.getText());
					pq.setString(7,t6.getText());
					pq.setString(8,t7.getText());
					pq.setString(9,t8.getText());
					*/
					
					
		//			pq.executeUpdate();
		//	System.out.println("yes");
			}
			catch(Exception q){
			System.out.println(q);
			}}
		}
		});
		b3.setFont(new Font("Tahoma", Font.ITALIC, 15));
		b3.setBounds(180, 10, 98, 46);
		panel_2.add(b3);
		
		final JButton b4 = new JButton("DELETE");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==b4){
					try{
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost/inform1","root","srushti");
						String sql = "DELETE FROM inff where rollno=?";
					pq = con.prepareStatement(sql);
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
		b4.setFont(new Font("Tahoma", Font.ITALIC, 15));
		b4.setBounds(288, 10, 98, 46);
		panel_2.add(b4);
		
		JButton b5 = new JButton("RESET");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setText(null);
				t2.setText(null);
				t3.setText(null);
				t4.setText(null);
				t5.setText(null);
				t6.setText(null);
				t7.setText(null);
				t8.setText(null);
				
			/*	if(r1.isSelected()) {
					r1.clearSelection();
				}
				else {
					r2.clearSelection();
				}
			*/
				//cb.setSelected(false);
			
				JOptionPane.showMessageDialog(null, "RESETED SUCCESSFULLY","  ",JOptionPane.INFORMATION_MESSAGE);
			}
			
		});
		b5.setFont(new Font("Tahoma", Font.ITALIC, 15));
		b5.setBounds(396, 10, 89, 46);
		panel_2.add(b5);
		
		JButton b6 = new JButton("SEARCH");
		b6.setFont(new Font("Tahoma", Font.ITALIC, 15));
		b6.setBounds(495, 10, 93, 46);
		panel_2.add(b6);
		
		JButton b7 = new JButton("EXIT");
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		b7.setFont(new Font("Tahoma", Font.ITALIC, 15));
		b7.setBounds(598, 10, 75, 46);
		panel_2.add(b7);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Pictures\\wallpapersden.com_goku-new-dragon-ball-z-art_2400x1350.jpg"));
		lblNewLabel_1.setBounds(0, 0, 696, 465);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(706, 55, 263, 357);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		t9 = new JTextField();
		t9.setBounds(10, 66, 243, 31);
		panel_3.add(t9);
		t9.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 107, 243, 240);
		panel_3.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				""
			}
		));
		
		JLabel lblNewLabel_2 = new JLabel("Enter Student Name:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 28, 243, 28);
		panel_3.add(lblNewLabel_2);
		
		JLabel label = new JLabel("New label");
		label.setBounds(25, 0, 228, 357);
		panel_3.add(label);
	}
}
