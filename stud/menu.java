package stud;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu frame = new menu();
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
	public menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 10, 917, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("FILE");
		menuBar.add(mnNewMenu);
		
		
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Add Student");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					inform frame = new inform();
					frame.setVisible(true);
				} catch (Exception q) {
					q.printStackTrace();
				}
			}
			
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Add Teacher");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					informt frame = new informt();
					frame.setVisible(true);
				} catch (Exception w) {
					w.printStackTrace();
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Add Course");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					informc frame = new informc();
					frame.setVisible(true);
				} catch (Exception y) {
					y.printStackTrace();
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_1 = new JMenu("OTHERS");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Add Subject");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Add Department");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Add Credit");
		mnNewMenu_1.add(mntmNewMenuItem_6);
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					informcr frame = new informcr();
					frame.setVisible(true);
				} catch (Exception d) {
					d.printStackTrace();
				}

			}
		});
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					informd frame = new informd();
					frame.setVisible(true);
				} catch (Exception t) {
					t.printStackTrace();
				}
			}
		});
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					informs frame = new informs();
					frame.setVisible(true);
				} catch (Exception r) {
					r.printStackTrace();
				}
			}
		});
		
		
		
		
		JMenu mnNewMenu_5 = new JMenu("HELP");
		menuBar.add(mnNewMenu_5);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Admin\\Pictures\\Saved Pictures\\CBCS.jpg"));
		lblNewLabel.setBounds(0, 42, 646, 497);
		contentPane.add(lblNewLabel);
	}
}
