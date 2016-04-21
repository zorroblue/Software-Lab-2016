package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.Controller;
import model.PersonalFriend;
import model.ProfessionalFriend;

public class InputProfessionalFriend extends JFrame {

	private JTextField tfName;
	private JTextField tfEmail;
	private JTextField tfMobile;
	private JTextField tfInterests;

	ImageIcon icon=new ImageIcon(getClass().getResource("home.png"));
	JButton btnGoHome = new JButton("Home",icon);	
	Controller c=new Controller();
	

	/**
	 * Create the application.
	 */
	public  InputProfessionalFriend() {
		initialize();
	}

	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {
		this.setBounds(100, 100, 550, 300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(29, 41, 150, 15);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email Address");
		lblNewLabel_1.setBounds(29, 68, 150, 15);
		this.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mobile number");
		lblNewLabel_2.setBounds(29, 95, 150, 15);
		this.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Interests");
		lblNewLabel_3.setBounds(29, 122, 150, 15);
		this.getContentPane().add(lblNewLabel_3);
		
		
		
		tfName = new JTextField();
		tfName.setBounds(180, 41, 114, 19);
		this.getContentPane().add(tfName);
		tfName.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(180, 68, 114, 19);
		this.getContentPane().add(tfEmail);
		tfEmail.setColumns(10);
		
		tfMobile = new JTextField();
		tfMobile.setBounds(180, 95, 114, 19);
		this.getContentPane().add(tfMobile);
		tfMobile.setColumns(10);
		
		tfInterests = new JTextField();
		tfInterests.setBounds(180, 122, 114, 19);
		this.getContentPane().add(tfInterests);
		tfInterests.setColumns(10);
		
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBounds(140, 214, 100, 25);
		getContentPane().add(btnSubmit);
		
		
		btnGoHome.setBounds(350, 104, 110, 50);
		getContentPane().add(btnGoHome);
	
		btnGoHome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InputProfessionalFriend.this.setVisible(false);
				new Home().setVisible(true);
			}
		});
		
		btnSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(checkForNull())
				{
					ProfessionalFriend pro=new ProfessionalFriend();
					pro.setName(tfName.getText());
					
					pro.setEmailAddress(tfEmail.getText());
					pro.setCommonInterests(tfInterests.getText());
					
					try
					{
						int i=Integer.parseInt(tfMobile.getText());
						
					}
					catch(NumberFormatException ex)
					{
						new ErrorDialog().invoke("Please enter a valid phone number");
						return;
					}
					pro.setMobileNumber(tfMobile.getText());
					c.getProfessionalFriends().add(pro);
					c.writeToFile();
					new ErrorDialog().invoke("Successfully added friend");
					InputProfessionalFriend.this.setVisible(false);
				}
			}
			public boolean checkForNull()
			{
				if(tfName.getText().length()==0||tfMobile.getText().length()==0||tfEmail.getText().length()==0||tfInterests.getText().length()==0)
				{
					new ErrorDialog().invoke("Please enter all values");
					return false;
					
				}
				return true;
			}
		});
	}
		
}
