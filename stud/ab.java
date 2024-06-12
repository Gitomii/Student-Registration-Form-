package stud;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ab extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTable table;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ab frame = new ab();
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
	public ab() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		t1 = new JTextField();
		t1.setBounds(303, 90, 175, 28);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setBounds(303, 141, 175, 28);
		contentPane.add(t2);
		t2.setColumns(10);
		
		JButton b1 = new JButton("New button");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model=(DefaultTableModel)table.getModel();
				 model.addRow(new Object[] {Integer.parseInt(t1.getText()),t2.getText()});
			}
		});
		b1.setBounds(333, 355, 122, 47);
		contentPane.add(b1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(241, 198, 346, 127);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				 "roll","name"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
	}

}
