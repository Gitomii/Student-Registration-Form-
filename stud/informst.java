package stud;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;

public class informst extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					informst frame = new informst();
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
	public informst() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SEARCH TEACHER");
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel.setBounds(246, 26, 282, 42);
		contentPane.add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Search Teacher ID Wise");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButton.setBounds(145, 74, 187, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnSearchTeacherName = new JRadioButton("Search Teacher Name Wise");
		rdbtnSearchTeacherName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnSearchTeacherName.setBounds(388, 74, 211, 21);
		contentPane.add(rdbtnSearchTeacherName);
		
		JPanel panel = new JPanel();
		panel.setBounds(70, 116, 704, 121);
		contentPane.add(panel);
	}

}
