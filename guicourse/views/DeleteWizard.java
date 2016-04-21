package views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DeleteWizard extends JFrame{

	
	private JTextField textField;

	
	/**
	 * Create the application.
	 */
	public DeleteWizard() {
		initialize();
	}

	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
		this.setBounds(100, 100, 600, 400);
		this.setTitle("Menu");

		this.getContentPane().setLayout(null);
		
		JLabel lblcourse = new JLabel("1.Course");
		lblcourse.setBounds(48, 55, 70, 15);
		this.getContentPane().add(lblcourse);
		
		JLabel lblfaculty = new JLabel("2.Faculty");
		lblfaculty.setBounds(48, 82, 70, 15);
		this.getContentPane().add(lblfaculty);
		
		JLabel lblparticipant = new JLabel("3.Participant");
		lblparticipant.setBounds(48, 109, 120, 15);
		this.getContentPane().add(lblparticipant);
		
		JLabel lblEnterChoice = new JLabel("Enter choice");
		lblEnterChoice.setBounds(37, 202, 120, 15);
		this.getContentPane().add(lblEnterChoice);
		
		textField = new JTextField();
		textField.setBounds(150, 202, 114, 19);
		this.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		JButton btnGoHome = new JButton("GO");
		btnGoHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteWizard.this.setVisible(false);
			}
		});
		btnGoHome.setBounds(174, 250, 150, 40);
		this.getContentPane().add(btnGoHome);
	}
}
