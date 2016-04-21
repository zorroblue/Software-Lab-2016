package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controllers.Controller;

public class GetCourseName extends JFrame  {

	
	 protected JTextField textField;
	 protected Controller c=new Controller();
	 int i;
/*	 public GetCourseName()
	 {
		 initialize();
	 }*/
	 public GetCourseName(int i)
	 {
		 initialize();
		 this.i=i;
		 
	 }
	 
	/**
	 * Create the application.
	 */
	
	/**
	 * Initialize the contents of the this.
	 */
	protected void initialize() {
		
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblEnterCourseName = new JLabel("Enter course name:");
		lblEnterCourseName.setBounds(50, 103, 150, 15);
		this.getContentPane().add(lblEnterCourseName);
		
		textField = new JTextField();
		textField.setBounds(210, 101, 220, 19);
		this.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("GO");
		btnNewButton.setBounds(146, 143, 117, 25);
		this.getContentPane().add(btnNewButton);
		
		ImageIcon icon=new ImageIcon(getClass().getResource("home.png"));
		JButton btnGoHome = new JButton("Home",icon);
		btnGoHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	new HomePage().setVisible(true);
				GetCourseName.this.setVisible(false);
			}
		});
		
		btnGoHome.setBounds(135, 180, 150, 40);
		
		this.getContentPane().add(btnGoHome);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(validateCourse())
				{
					setTheCourseName();
					if(i==1)
					{
						new CreateParticipant(textField.getText(),null,false).setVisible(true); //create
					}
					else if(i==2)
						new DisplayParticipant(textField.getText()).setVisible(true);
					else if(i==3)
						new CreateFaculty(textField.getText(),null,false).setVisible(true);
					else if(i==4)
						new EditCourseMenu(1,textField.getText()).setVisible(true);
					else if(i==5)
						new EditCourseMenu(2,textField.getText()).setVisible(true);
					GetCourseName.this.setVisible(false);
				}
				else
				{
					new ErrorDialog().invoke("No such course exists");
				}
			}
		});
	}
	public void setTheCourseName()
	{
		c.setCourseName(textField.getText());
	}
	
	public boolean validateCourse()
	{
		if(c.getCourseByName(textField.getText())==null)
			return false;
		else
			return true;
	}
}
