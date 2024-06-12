package stud;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class aaa extends JFrame {

	protected static final String DefaultTableModel = null;
	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTable table;
	private JScrollPane scrollPane;
	DefaultTableModel model;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					aaa frame = new aaa();
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
	public aaa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		t1 = new JTextField();
		t1.setBounds(184, 92, 160, 39);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setBounds(184, 141, 160, 39);
		contentPane.add(t2);
		t2.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(110, 205, 321, 133);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				 "roll","name"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		JButton b1 = new JButton("save");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 model=(DefaultTableModel)table.getModel();
				 model.addRow(new Object[] {t1.getText(),t2.getText()});
				 
			}
		});
		b1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b1.setBounds(218, 383, 117, 27);
		contentPane.add(b1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("a");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnNewRadioButton.setBounds(530, 250, 103, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnB = new JRadioButton("b");
		buttonGroup.add(rdbtnB);
		rdbtnB.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnB.setBounds(530, 303, 103, 21);
		contentPane.add(rdbtnB);
	}
}
