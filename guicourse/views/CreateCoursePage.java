package views;

import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controllers.Controller;
import model.Course;
import model.Faculty;

public class CreateCoursePage extends JFrame{

	JTextField tfCourseName;
	JTextField tfCourseDate;
	JTextField tfCourseDuration;
	JTextField tfCourseFee;
	
	JTextField tfCourseCoordinatorName;
	JTextField tfCCDept;
	JTextField tfCCAddress;
	JTextField tfCCMobileNumber;
	JTextField tfCCEmailAddress;
	
	//a Department to which he is affiliated, his name, address, mobile number, and e-mail address
	Controller c=new Controller();
	Course course;
	/**
	 * Create the application.
	 */
	public CreateCoursePage(Course course) {
		this.course=course;
		initialize();
	}

	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {
		
		//components
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		tfCourseName=new JTextField();
		JLabel tpCourseName=new JLabel("Enter course name",SwingConstants.CENTER);
		tfCourseDate=new JTextField();
		JLabel tpCourseDate=new JLabel("Enter course date",SwingConstants.CENTER);
		tfCourseDuration=new JTextField();
		JLabel tpCourseDuration=new JLabel("Enter course duration",SwingConstants.CENTER);
		tfCourseFee=new JTextField();
		JLabel tpCourseFee=new JLabel("Enter course fee",SwingConstants.CENTER);
		tfCourseCoordinatorName=new JTextField();
		JLabel tpCourseCoordinator=new JLabel("Enter course coordinator",SwingConstants.CENTER);
		tfCCAddress=new JTextField();
		tfCCDept=new JTextField();
		tfCCEmailAddress=new JTextField();
		tfCCMobileNumber=new JTextField();
		
		JLabel tpCCDept=new JLabel("Enter department",SwingConstants.CENTER);
		JLabel tpCCAddress=new JLabel("Enter address",SwingConstants.CENTER);
		JLabel tpCCMobileNumber=new JLabel("Enter mobile number",SwingConstants.CENTER);
		JLabel tpCCEmailAddress=new JLabel("Enter email address",SwingConstants.CENTER);
		//fill in details for edit
		if(course!=null)
		{
			tfCourseName.setText(course.getCourseName());
			//tfCourseDate.setText();  	//TODO
			tfCourseDuration.setText(course.getCourseDuration().toString());
			tfCourseFee.setText(course.getCourseFee().toString());
			tfCourseCoordinatorName.setText(course.getCourseCoordinator().getName());
			tfCourseDate.setText(new SimpleDateFormat("dd/MM/yyyy").format(course.getDate()));
			Faculty f=course.getCourseCoordinator();
			tfCCAddress.setText(f.getAddress());
			tfCCDept.setText(f.getDepartmentName());
			tfCCEmailAddress.setText(f.getEmailAddress());
			tfCCMobileNumber.setText(f.getMobileNumber());
		}
		
		
		JButton bSubmit=new JButton("SAVE");
		Font font = new Font("Verdana", Font.BOLD, 12);
		
		bSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				validateDataAndPush();
			}

			public void validateDataAndPush() {
				// TODO Auto-generated method stub
				int duration;
				if(checkNull())
				{
					try
					{
						duration=Integer.parseInt(tfCourseDuration.getText());
					}
					catch(NumberFormatException e)
					{
						new ErrorDialog().invoke("Please enter proper integer less than or equal to 14 for duration");
						return;
					}
					if(duration>14 || duration<0)
						{
							new ErrorDialog().invoke("Please enter proper integer less than or equal to 14 for duration");
							return;
						}
					Date date=c.validateDate(tfCourseDate.getText());
					if(date==null)
						return;
					int fee;
					try
					{
						fee=Integer.parseInt(tfCourseFee.getText());
					}
					catch(NumberFormatException e)
					{
						new ErrorDialog().invoke("Please enter proper integer value for fees");
						return;
					}
					Course course=new Course();
					Faculty courseCoordinator=new Faculty();
					courseCoordinator.setName(tfCourseName.getText());
					courseCoordinator.setAddress(tfCCAddress.getText());
					courseCoordinator.setDepartmentName(tfCCDept.getText());
					courseCoordinator.setMobileNumber(tfCCMobileNumber.getText());
					courseCoordinator.setEmailAddress(tfCCEmailAddress.getText());
					course.setCourseCoordinator(courseCoordinator);
					course.setCourseDuration(Integer.parseInt(tfCourseDuration.getText()));
					try
					{
					course.setCourseFee(Integer.parseInt(tfCourseFee.getText()));
					}
					catch(Exception e)
					{
						//do nothing
						//exception already handled at Course class
					}
					course.setCourseName(tfCourseName.getText());
					course.setDate(date);
					c.addCourse(course);
					new Controller().getFileWriter().writeToFile(c.getCourses(), c.getFaculty(), c.getParticipants());
					System.out.println("Added course");
					CreateCoursePage.this.setVisible(false);
				}
				
				
			}
			
			public boolean checkNull()
			{
				if(tfCourseCoordinatorName.getText().length()==0 ||tfCCAddress.getText().length()==0 || tfCCDept.getText().length()==0 || tfCCEmailAddress.getText().length()==0 || tfCCMobileNumber.getText().length()==0 || tfCourseName.getText().length()==0 ||tfCourseFee.getText().length()==0 ||tfCourseDate.getText().length()==0 ||tfCourseDuration.getText().length()==0 )
				{
					new ErrorDialog().invoke("Please enter all values");
					return false;
					
				}
				return true;
			}
		});
		
		
		this.setBounds(100, 100, 450, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("CREATE/EDIT COURSE");
		JSeparator sep=new JSeparator();
	
		
		GroupLayout groupLayout = new GroupLayout(this.getContentPane());
		groupLayout.setAutoCreateGaps(true);
		groupLayout.setAutoCreateContainerGaps(true);
		groupLayout.setVerticalGroup(groupLayout.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup()
						.addComponent(tpCourseName)
						.addComponent(tfCourseName)
						)
				.addGroup(groupLayout.createParallelGroup()
						.addComponent(tpCourseDate)
						.addComponent(tfCourseDate)
						)
				.addGroup(groupLayout.createParallelGroup()
						.addComponent(tpCourseFee)
						.addComponent(tfCourseFee)
						)
				.addGroup(groupLayout.createParallelGroup()
						.addComponent(tpCourseDuration)
						.addComponent(tfCourseDuration)
						)
				.addGap(10)
				.addComponent(sep)
				.addGroup(groupLayout.createParallelGroup()
						.addComponent(tpCourseCoordinator)
						.addComponent(tfCourseCoordinatorName)
						)
				.addGroup(groupLayout.createParallelGroup()
						.addComponent(tpCCDept)
						.addComponent(tfCCDept)
						)
				.addGroup(groupLayout.createParallelGroup()
						.addComponent(tpCCAddress)
						.addComponent(tfCCAddress)
						)
				.addGroup(groupLayout.createParallelGroup()
						.addComponent(tpCCMobileNumber)
						.addComponent(tfCCMobileNumber)
						)
				.addGroup(groupLayout.createParallelGroup()
						.addComponent(tpCCEmailAddress)
						.addComponent(tfCCEmailAddress)
						)
				.addComponent(bSubmit)			
				
				);
		
		groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup()
						.addComponent(tpCourseName)
						.addComponent(tpCourseDate)
						.addComponent(tpCourseFee)
						.addComponent(tpCourseDuration)
						.addComponent(tpCourseCoordinator)
						.addGap(30)
						.addComponent(sep)
						.addComponent(tpCourseCoordinator)
						.addComponent(tpCCDept)
						.addComponent(tpCCAddress)
						.addComponent(tpCCMobileNumber)
						.addComponent(tpCCEmailAddress)
						)
				.addGroup(groupLayout.createParallelGroup()
						.addComponent(tfCourseName)
						.addComponent(tfCourseDate)
						.addComponent(tfCourseFee)
						.addComponent(tfCourseDuration)
						.addComponent(tfCourseCoordinatorName)
						.addComponent(tfCCDept)
						.addComponent(tfCCAddress)
						.addComponent(tfCCMobileNumber)
						.addComponent(tfCCEmailAddress)
				.addComponent(bSubmit)
						)
				);
		
			
		this.getContentPane().setLayout(groupLayout);
	}
}
