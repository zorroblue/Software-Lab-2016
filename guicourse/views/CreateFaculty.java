package views;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controllers.Controller;
import model.Faculty;
import model.Participant;

//used for both creating or editing a faculty
public class CreateFaculty extends JFrame {

	String courseName;
	JTextField tfName,tfAddress,tfMobileNumber,tfDep,tfEmailAddress;
	Controller c=new Controller();
	String facultyName;
	boolean edit=false;
	/**
	 * Create the application.
	 */
	public CreateFaculty(String courseName,String facultyName,boolean edit) {
		this.courseName=courseName;
		this.facultyName=facultyName;
		this.edit=edit;
		initialize();
		
	}

	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 500, 500);
		
		this.setTitle("CREATE/EDIT FACULTY");
		JLabel lName=new JLabel("Enter faculty name: ",SwingConstants.CENTER);
		lName.setBounds(12, 12, 142, 15);
		tfName=new JTextField();
		tfName.setBounds(180, 12, 239, 30);
		
		JLabel lAddress=new JLabel("Enter address: ",SwingConstants.CENTER);
		lAddress.setBounds(12, 62, 109, 15);
		tfAddress=new JTextField();
		tfAddress.setBounds(180, 62, 239, 30);
		JLabel lMobileNumber=new JLabel("Enter mobile number: ",SwingConstants.CENTER);
		lMobileNumber.setBounds(12, 112, 156, 15);
		tfMobileNumber=new JTextField();
		tfMobileNumber.setBounds(180, 112, 239, 30);
		JLabel lDep=new JLabel("Enter department : ",SwingConstants.CENTER);
		lDep.setBounds(12, 162, 139, 15);
		tfDep=new JTextField();
		tfDep.setBounds(180, 162, 239, 30);
		JLabel lEmailAddress=new JLabel("Enter email address: ",SwingConstants.CENTER);
		lEmailAddress.setBounds(12, 212, 151, 15);
		tfEmailAddress=new JTextField();
		tfEmailAddress.setBounds(180, 212, 239, 30);
		JButton bSubmit=new JButton("SAVE DETAILS");
		bSubmit.setBounds(150, 260, 200, 30);
		bSubmit.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.getContentPane().setLayout(null);
		this.getContentPane().add(lName);
		this.getContentPane().add(lDep);
		this.getContentPane().add(lAddress);
		this.getContentPane().add(lMobileNumber);
		this.getContentPane().add(lEmailAddress);
		this.getContentPane().add(tfName);
		this.getContentPane().add(tfDep);
		this.getContentPane().add(tfAddress);
		this.getContentPane().add(tfMobileNumber);
		this.getContentPane().add(tfEmailAddress);
		this.getContentPane().add(bSubmit);
		
		if(edit && facultyName!=null)
		{
			Faculty f=c.getFacultyByName(c.getCourseByName(courseName), facultyName);
			tfName.setText(f.getName());
			tfDep.setText(f.getDepartmentName());
			tfAddress.setText(f.getAddress());
			tfMobileNumber.setText(f.getMobileNumber());
			tfEmailAddress.setText(f.getEmailAddress());
		}
		
		bSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Faculty newFaculty;
				if(checkNull())
				{
					//no need of any validation
					if(!edit)
						newFaculty=new Faculty();
					else
						newFaculty=c.getFacultyByName(c.getCourseByName(courseName),facultyName);
					newFaculty.setName(tfName.getText());
					newFaculty.setAddress(tfAddress.getText());
					newFaculty.setDepartmentName(tfDep.getText());
					newFaculty.setMobileNumber(tfMobileNumber.getText());
					newFaculty.setEmailAddress(tfEmailAddress.getText());
					if(!edit)
						c.getCourseByName(courseName).getFaculty().add(newFaculty);
					new Controller().getFileWriter().writeToFile(c.getCourses(), c.getFaculty(), c.getParticipants());
					new HomePage().setVisible(true);
					CreateFaculty.this.setVisible(false);
				}
				else
				{
					new ErrorDialog().invoke("Please enter all values");
				}
			}

			private boolean checkNull() {
				if(tfAddress.getText().length()==0||tfDep.getText().length()==0||tfEmailAddress.getText().length()==0||tfMobileNumber.getText().length()==0||tfName.getText().length()==0)
					return false;
				return true;
			}
		});
	
	}

}
