package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controllers.Controller;

public class EditCourseMenu extends JFrame {

	private JTextField textField;
	Controller c=new Controller();
	int choice;
	String courseName;

	/**
	 * Create the application.
	 */
	public EditCourseMenu(int choice,String courseName) {
		this.choice=choice;
		this.courseName=courseName;
		initialize();
		
	}

	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {
		
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblCourse = new JLabel("1. Course");
		lblCourse.setBounds(39, 92, 70, 15);
		this.getContentPane().add(lblCourse);
		
		JLabel lblFaculty = new JLabel("2. Faculty");
		lblFaculty.setBounds(39, 125, 70, 15);
		this.getContentPane().add(lblFaculty);
		
		JLabel lblParticipant = new JLabel("3. Participant");
		lblParticipant.setBounds(39, 158, 100, 15);
		this.getContentPane().add(lblParticipant);
		
		textField = new JTextField();
		textField.setBounds(205, 187, 114, 19);
		this.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterChoice = new JLabel("Enter choice:");
		lblEnterChoice.setBounds(49, 189, 100, 15);
		this.getContentPane().add(lblEnterChoice);
		
		JLabel lblYouWantTo = new JLabel("You want to edit/delete?");
		lblYouWantTo.setBounds(138, 20, 200, 15);
		this.getContentPane().add(lblYouWantTo);
		
		JButton btnGo = new JButton("GO");
		btnGo.setBounds(126, 218, 117, 25);
		getContentPane().add(btnGo);
		
		
		btnGo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(textField.getText().length()==0)
					new ErrorDialog().invoke("Please enter all values");
				else
				{
					int i;
					try
					{
						 i=Integer.parseInt(textField.getText());
						
					}
					catch(NumberFormatException err)
					{
						new ErrorDialog().invoke("Enter proper choice (1-3)");
						return;
					}
					if(choice==1)
					{
						switch(i)
						{
						case 1:
							new CreateCoursePage(c.getCourseByName(c.getCourseName())).setVisible(true);
							EditCourseMenu.this.setVisible(false);
							break;
						case 2:
							//new CreateFaculty(c.getCourseName()).setVisible(true);
							new NameInput(1).setVisible(true);
							EditCourseMenu.this.setVisible(false);
							break;	
						case 3:
							new NameInput(2).setVisible(true);
							EditCourseMenu.this.setVisible(false);
							break;
					//		new CreateParticipant(c.getCourseName(),true).setVisible(true);
						}
					}
					else
					{
						//delete stuff
						switch(i)
						{
							case 1:
								c.removeCourse(c.getCourseByName(courseName));
								new ErrorDialog().invoke("Deleted course");
								EditCourseMenu.this.setVisible(false);
								break;
							case 2:
								//delete faculty
								new DeleteMember(1,courseName).setVisible(true);
								EditCourseMenu.this.setVisible(false);
								break;
							case 3:
								new DeleteMember(2,courseName).setVisible(true);
								EditCourseMenu.this.setVisible(false);
								break;
						}		
					}
				}
			}
		});
	}
}
