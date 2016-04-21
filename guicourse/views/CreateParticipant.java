package views;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.PartialResultException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controllers.Controller;
import model.Course;
import model.Participant;

//used for both creating or editing a faculty
public class CreateParticipant extends JFrame
{

	
	
	
	
	Controller c=new Controller();
	JTextField tfName;
	JTextField tfAddress;
	JTextField tfMobileNumber;
	JTextField tfOrganisation;
	JTextField tfEmailAddress;
	String courseName;
	String participantName;
	boolean edit=false;
	/**
	

	/**
	 * Create the application.
	 */
	public CreateParticipant(String courseName,String participantName,boolean edit) {
		this.courseName=courseName;
		this.edit=edit;
		this.participantName=participantName;
		initialize();
		
	}


	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 500, 700);
		
		this.setTitle("CREATE/EDIT PARTICIPANT");
		JLabel lName=new JLabel("Participant name: ",SwingConstants.CENTER);
		lName.setBounds(12, 12, 142, 15);
		tfName=new JTextField();
		tfName.setBounds(180, 12, 239,25);
		JLabel lAddress=new JLabel("Address: ",SwingConstants.CENTER);
		lAddress.setBounds(12, 234, 109, 15);
		tfAddress=new JTextField();
		tfAddress.setBounds(180, 234, 239, 25);
		JLabel lMobileNumber=new JLabel("Mobile number: ",SwingConstants.CENTER);
		lMobileNumber.setBounds(12, 345, 156, 15);
		tfMobileNumber=new JTextField();
		tfMobileNumber.setBounds(180, 345, 239, 25);
		JLabel lOrganisation=new JLabel("Organisation : ",SwingConstants.CENTER);
		lOrganisation.setBounds(12, 123, 139, 25);
		tfOrganisation=new JTextField();
		tfOrganisation.setBounds(180, 123, 239, 25);
		JLabel lEmailAddress=new JLabel("Email address: ",SwingConstants.CENTER);
		lEmailAddress.setBounds(12, 456, 151, 15);
		tfEmailAddress=new JTextField();
		tfEmailAddress.setBounds(180, 456, 239, 25);
		JButton bSubmit=new JButton("SAVE");
		bSubmit.setBounds(233, 618, 69, 25);
		bSubmit.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.getContentPane().setLayout(null);
		this.getContentPane().add(lName);
		this.getContentPane().add(lOrganisation);
		this.getContentPane().add(lAddress);
		this.getContentPane().add(lMobileNumber);
		this.getContentPane().add(lEmailAddress);
		this.getContentPane().add(tfName);
		this.getContentPane().add(tfOrganisation);
		this.getContentPane().add(tfAddress);
		this.getContentPane().add(tfMobileNumber);
		this.getContentPane().add(tfEmailAddress);
		this.getContentPane().add(bSubmit);
		
		Course course=c.getCourseByName(courseName);
		if(course==null)
			{
				new ErrorDialog().invoke("No such dialog");
				return;
			}
		final Participant p;
		if(edit)
		{
			p=c.getParticipantByName(course,participantName);
			tfName.setText(p.getName());
			tfOrganisation.setText(p.getOrganizationName());
			tfAddress.setText(p.getAddress());
			tfEmailAddress.setText(p.getEmailAddress());
			tfMobileNumber.setText(p.getMobileNumber());
		}
		else
			p=new Participant();
		
		
		bSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(checkNull() )
				{
					p.setAddress(tfAddress.getText());
					p.setEmailAddress(tfEmailAddress.getText());
					p.setMobileNumber(tfMobileNumber.getText());
					p.setName(tfName.getText());
					p.setOrganizationName(tfOrganisation.getText());
					if(!edit)
					{
						c.getCourseByName(courseName).addParticipant(p);
						System.out.println("Added participant");
					}
					new Controller().getFileWriter().writeToFile(c.getCourses(), c.getFaculty(), c.getParticipants());
					CreateParticipant.this.setVisible(false);
				
				}
					
				
			}
			
			public boolean checkNull()
			{
				if(tfName.getText().length()==0 ||tfAddress.getText().length()==0 ||tfMobileNumber.getText().length()==0 ||tfOrganisation.getText().length()==0 ||tfEmailAddress.getText().length()==0 )
				{
					new ErrorDialog().invoke("Enter all values");
					return false;
				}
				return true;
			}
		});
	}

}
