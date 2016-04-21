package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;
import model.Relative;

public class InputRelative extends JPanel {

	private JTextField tfName;
	private JTextField tfEmail;
	private JTextField tfMobile;
	private JTextField tfDOB;
	private JTextField tfLastMet;

	Controller c=new Controller();

	/**
	 * Create the application.
	 */
	public InputRelative() {
		initialize();
	}

	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {
		//this.setBounds(100, 100, 450, 300);
		//this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(28, 23, 150, 15);
		this.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email Address");
		lblNewLabel_1.setBounds(28, 50, 150, 15);
		this.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mobile number");
		lblNewLabel_2.setBounds(28, 77, 150, 15);
		this.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Birthday");
		lblNewLabel_3.setBounds(28, 104, 150, 15);
		this.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Date of last meeting");
		lblNewLabel_4.setBounds(28, 131, 150, 15);
		this.add(lblNewLabel_4);
		
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
		
		tfDOB = new JTextField();
		tfDOB.setBounds(197, 104, 114, 19);
		this.add(tfDOB);
		tfDOB.setColumns(10);
		
		tfLastMet = new JTextField();
		tfLastMet.setBounds(197, 131, 114, 19);
		this.add(tfLastMet);
		tfLastMet.setColumns(10);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setBounds(149, 228, 117, 25);
		this.add(btnNewButton);
	
	
	btnNewButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			// TODO Auto-generated method stub
			if(checkForNull())
			{
				Relative rel=new Relative();
					rel.setName(tfName.getText());
				
					if(c.parseAndGetDate(tfDOB.getText())==null)
					{
						new ErrorDialog().invoke("Please enter a valid string in dd/mm/yyyy format");
						return;
					}
					else
					{
						rel.setBirthday(c.parseAndGetDate(tfDOB.getText()));
					}
					if(c.parseAndGetDate(tfLastMet.getText())!=null)
					{
					rel.setLastMet(c.parseAndGetDate(tfLastMet.getText()));
				
					}
					else
					{
						new ErrorDialog().invoke("Please enter a valid string in dd/mm/yyyy format");
						return;
					}
					try
					{
						int i=Integer.parseInt(tfMobile.getText());
						rel.setMobileNumber(tfMobile.getText());
					}
					catch(Exception exc)
					{
						new ErrorDialog().invoke("Please enter a valid mobile number");
						return;
					}
					rel.setEmailAddress(tfEmail.getText());
					c.getRelatives().add(rel);
					c.writeToFile();
					new ErrorDialog().invoke("Successfully added relative");
					//InputRelative.this.setVisible(false);
					MainFrame frame=new Controller().getAppletContext();
					frame.setContentPane(new Home());
					frame.revalidate();
					frame.repaint();
			}
			
		}
			public boolean checkForNull()
			{
			if(tfName.getText().length()==0||tfMobile.getText().length()==0||tfEmail.getText().length()==0||tfDOB.getText().length()==0||tfLastMet.getText().length()==0)
			{
				new ErrorDialog().invoke("Please enter all values");
				return false;
				
			}
			return true;
			}
		});
	}
}
