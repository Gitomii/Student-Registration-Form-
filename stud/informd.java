package stud;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class informd extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					informd frame = new informd();
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
	public informd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setForeground(Color.LIGHT_GRAY);
		panel.setBounds(41, 85, 371, 213);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel l1 = new JLabel("Department ID:");
		l1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l1.setBounds(10, 10, 106, 19);
		panel.add(l1);
		
		JLabel l2 = new JLabel("Department Name:");
		l2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l2.setBounds(10, 50, 130, 19);
		panel.add(l2);
		
		JLabel l3 = new JLabel("Contact No.:");
		l3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l3.setBounds(10, 91, 106, 19);
		panel.add(l3);
		
		JLabel l4 = new JLabel("Head Of Dept:");
		l4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l4.setBounds(10, 136, 106, 19);
		panel.add(l4);
		
		t1 = new JTextField();
		t1.setBounds(150, 12, 151, 19);
		panel.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(150, 52, 151, 19);
		panel.add(t2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(150, 93, 151, 19);
		panel.add(t3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(150, 138, 151, 19);
		panel.add(t4);
		
		JLabel lblNewLabel = new JLabel("NEW DEPARTMENT REGISTERATION FORM");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 25));
		lblNewLabel.setBounds(89, 10, 517, 65);
		contentPane.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(422, 85, 235, 213);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Search Department By:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(33, 10, 158, 19);
		panel_1.add(lblNewLabel_1);
		
		JRadioButton r1 = new JRadioButton("ID");
		r1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonGroup.add(r1);
		r1.setBounds(6, 51, 103, 21);
		panel_1.add(r1);
		
		JRadioButton r2 = new JRadioButton("NAME");
		r2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonGroup.add(r2);
		r2.setBounds(111, 51, 103, 21);
		panel_1.add(r2);
		
		JComboBox cb = new JComboBox();
		cb.setFont(new Font("Dialog", Font.PLAIN, 15));
		cb.setModel(new DefaultComboBoxModel(new String[] {"Computer Science", "Mathematics", "Electronics"}));
		cb.setBounds(35, 102, 156, 21);
		panel_1.add(cb);
		
		JButton b6 = new JButton("Add Course");
		b6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b6.setBounds(61, 150, 109, 27);
		panel_1.add(b6);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(103, 327, 503, 62);
		contentPane.add(panel_2);
		
		JButton b1 = new JButton("SAVE");
		b1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		b1.setBounds(10, 10, 75, 46);
		panel_2.add(b1);
		
		JButton b2 = new JButton("UPDATE");
		b2.setFont(new Font("Tahoma", Font.ITALIC, 15));
		b2.setBounds(95, 10, 98, 46);
		panel_2.add(b2);
		
		JButton b3 = new JButton("DELETE");
		b3.setFont(new Font("Tahoma", Font.ITALIC, 15));
		b3.setBounds(203, 10, 98, 46);
		panel_2.add(b3);
		
		JButton b4 = new JButton("RESET");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setText(" ");
				t2.setText(" ");
				t3.setText(" ");
				t4.setText(" ");
				JOptionPane.showMessageDialog(null, "RESETED SUCCESSFULLY","  ",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		b4.setFont(new Font("Tahoma", Font.ITALIC, 15));
		b4.setBounds(311, 10, 89, 46);
		panel_2.add(b4);
		
		JButton b5 = new JButton("EXIT");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		b5.setFont(new Font("Tahoma", Font.ITALIC, 15));
		b5.setBounds(410, 10, 75, 46);
		panel_2.add(b5);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Admin\\Pictures\\wallpapersden.com_goku-new-dragon-ball-z-art_2400x1350.jpg"));
		lblNewLabel_2.setBounds(0, 0, 701, 426);
		contentPane.add(lblNewLabel_2);
	}
}
