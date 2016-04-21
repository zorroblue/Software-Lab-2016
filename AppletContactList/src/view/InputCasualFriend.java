package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;
import model.CasualFriend;

public class InputCasualFriend extends JPanel {

	private JTextField tfName;
	private JTextField tfEmail;
	private JTextField tfMobile;
	private JTextField tfWhen;
	private JTextField tfWhere;
	private JTextField tfOther,tfCircum;
	private Controller c=new Controller();

	/**
	 * Create the application.
	 */
	public InputCasualFriend() {
		initialize();
	}

	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {
	//	this.setTitle("Create casual friend");
	//	this.setBounds(100, 100, 450, 300);
	//	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	//	this.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(28, 23, 150, 15);
		this.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email Address");
		lblNewLabel_1.setBounds(28, 50, 150, 15);
		this.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mobile number");
		lblNewLabel_2.setBounds(28, 77, 150, 15);
		this.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("When you met");
		lblNewLabel_3.setBounds(28, 104, 150, 15);
		this.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Where you met");
		lblNewLabel_4.setBounds(28, 131, 150, 15);
		this.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Circumstance");
		lblNewLabel_5.setBounds(28, 158, 150, 15);
		this.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Other info");
		lblNewLabel_6.setBounds(28, 185, 150, 15);
		this.add(lblNewLabel_6);
		
		tfName = new JTextField();
		tfName.setBounds(197, 23, 114, 19);
		this.add(tfName);
		tfName.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(197, 50, 114, 19);
		this.add(tfEmail);
		tfEmail.setColumns(10);
		
		tfMobile = new JTextField();
		tfMobile.setBounds(197, 77, 114, 19);
		this.add(tfMobile);
		tfMobile.setColumns(10);
		
		tfWhen = new JTextField();
		tfWhen.setBounds(197, 104, 114, 19);
		this.add(tfWhen);
		tfWhen.setColumns(10);
		
		tfWhere = new JTextField();
		tfWhere.setBounds(197, 131, 114, 19);
		this.add(tfWhere);
		tfWhere.setColumns(10);
		
		tfCircum = new JTextField();
		tfCircum.setBounds(197, 158, 114, 19);
		this.add(tfCircum);
		tfCircum.setColumns(10);
		
		tfOther = new JTextField();
		tfOther.setBounds(197, 185, 114, 19);
		this.add(tfOther);
		tfOther.setColumns(10);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setBounds(149, 240, 117, 25);
		this.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(checkForNull())
				{
					CasualFriend casualFriend=new CasualFriend();
					casualFriend.setName(tfName.getText());
					casualFriend.setEmailAddress(tfEmail.getText());
					casualFriend.setMetCircumstance(tfCircum.getText());
					Date date=c.parseAndGetDate(tfWhen.getText());
					if(date==null)
						{
						new ErrorDialog().invoke("Please enter proper date in dd/mm/yyyy format");
						return;
						}
					else
					{
						casualFriend.setMetWhen(date);
					}
					casualFriend.setMetWhere(tfWhere.getText());
					casualFriend.setOther(tfOther.getText());
					try
					{
						int no=Integer.parseInt(tfMobile.getText());
						casualFriend.setMobileNumber(tfMobile.getText());
						
					}
					catch(NumberFormatException ex)
					{
						new ErrorDialog().invoke("Please enter a proper number for mobile number");
						return;
					}
					c.getCasualFriends().add(casualFriend);
					c.writeToFile();
				//	new ErrorDialog().invoke("Success!");
				//	InputCasualFriend.this.setVisible(false);
					MainFrame frame=new Controller().getAppletContext();
					frame.setContentPane(new Home());
					frame.revalidate();
					frame.repaint();
				}
			}
			public boolean checkForNull()
			{
				if(tfName.getText().length()==0||tfMobile.getText().length()==0||tfEmail.getText().length()==0||tfWhen.getText().length()==0||tfWhere.getText().length()==0||tfOther.getText().length()==0||tfCircum.getText().length()==0)
				{
					new ErrorDialog().invoke("Please enter all values");
					return false;
					
				}
				return true;
			}
		});
	}
	

}
