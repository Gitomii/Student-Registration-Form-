package stud;
import java.sql.*;
import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
public class informt extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTable table;
	JComboBox cb;
	DefaultComboBoxModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					informt frame = new informt();
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
	public informt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 466);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TEACHER REGISTERATION FORM");
		lblNewLabel.setBackground(SystemColor.desktop);
		lblNewLabel.setBounds(147, 11, 447, 64);
		lblNewLabel.setForeground(SystemColor.activeCaption);
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 29));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(10, 85, 356, 217);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel l1 = new JLabel("TEACHER ID.:");
		l1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		l1.setBounds(10, 23, 82, 16);
		panel.add(l1);
		
		JLabel l2 = new JLabel("TEACHER NAME:");
		l2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		l2.setBounds(10, 64, 99, 16);
		panel.add(l2);
		
		JLabel l3 = new JLabel("DEPARTMENT NAME:");
		l3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		l3.setBounds(10, 100, 125, 16);
		panel.add(l3);
		
		JLabel l4 = new JLabel("CONTACT NO:");
		l4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		l4.setBounds(10, 136, 125, 16);
		panel.add(l4);
		
		JLabel l5 = new JLabel("EMAIL ID.:");
		l5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		l5.setBounds(10, 173, 125, 16);
		panel.add(l5);
		
		t1 = new JTextField();
		t1.setBounds(155, 23, 96, 19);
		panel.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(155, 64, 96, 19);
		panel.add(t2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(155, 136, 96, 19);
		panel.add(t3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(155, 173, 96, 19);
		panel.add(t4);
		
		final JComboBox cb = new JComboBox();
		cb.setModel(new DefaultComboBoxModel(new String[] {"ARTS", "COMMERCE", "COMPUTER SCIENCE"}));
		cb.setBounds(155, 99, 96, 21);
		panel.add(cb);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaption);
		panel_2.setLayout(null);
		panel_2.setBounds(10, 328, 683, 64);
		contentPane.add(panel_2);
		
		final JButton b1 = new JButton("SAVE");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==b1){
				Object[] row=new Object[2];
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				row[0]=t5.getText();	
				model.addRow(row);
				
				try{
					String id=t1.getText();
					String name=t2.getText();
					
					String dept = (String)cb.getSelectedItem();
					String contactno=t3.getText();
					String email=t4.getText();
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/inform1","root","srushti");
					String sql="INSERT INTO inft VALUES(?,?,?,?,?)";	
					PreparedStatement pq=con.prepareStatement(sql);
					pq.setString(1,id);
					pq.setString(2,name);	
					pq.setString(3,dept);	
					pq.setString(4, contactno);						
					pq.setString(5,email);
				
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
					String id=rs.getString(1); 
					t1.setText(id); 
					
					String name=rs.getString(2);
					t2.setText(name); 
					
					String dept=rs.getString("dept");
					cb.setSelectedItem(dept);
					
					String contactno=rs.getString(5);
					t3.setText(contactno); 
					
					String email=rs.getString(6);
					t4.setText(email);

					}}
					catch(Exception p){
					System.out.println("NO");
					}}
			}
		});
		b2.setFont(new Font("Tahoma", Font.ITALIC, 15));
		b2.setBounds(95, 10, 75, 46);
		panel_2.add(b2);
		
		JButton b3 = new JButton("UPDATE");
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
						String sql = "DELETE FROM inft where id=?";
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
		b4.setFont(new Font("Tahoma", Font.ITALIC, 15));
		b4.setBounds(288, 10, 98, 46);
		panel_2.add(b4);
		
		JButton b5 = new JButton("RESET");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setText(" ");
				t2.setText(" ");
				t3.setText(" ");
				t4.setText(" ");
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(376, 85, 322, 217);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Teacher's Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setBounds(10, 0, 302, 25);
		panel_1.add(lblNewLabel_1);
		
		t5 = new JTextField();
		t5.setBounds(10, 35, 302, 25);
		panel_1.add(t5);
		t5.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 302, 137);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				""
			}
		));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Admin\\Pictures\\wallpapersden.com_goku-new-dragon-ball-z-art_2400x1350.jpg"));
		lblNewLabel_2.setBounds(0, 0, 708, 429);
		contentPane.add(lblNewLabel_2);
	}
}
