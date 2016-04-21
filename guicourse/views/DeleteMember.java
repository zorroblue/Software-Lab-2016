package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controllers.Controller;
import model.Course;
import model.Faculty;
import model.Participant;

public class DeleteMember extends JFrame {

	private JTextField textField;
	String courseName;
	Controller c=new Controller();
	int i;
	
	/**
	 * Create the application.
	 */
	public DeleteMember(int i,String courseName) {
		this.i=i;
		this.courseName=courseName;
		initialize();
		
	}

	/**
	 * Initialize the contents of the this.
	 */
	public  void initialize() {
		
		this.setBounds(100, 100, 500, 500);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(39, 350, 200, 15);
		this.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(232, 350, 114, 19);
		this.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("DELETE");
		btnNewButton.setBounds(136, 380, 117, 33);
		this.getContentPane().add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(33, 31, 384, 300);
		this.getContentPane().add(textArea);
		textArea.setEditable(false);
		
		if(i==1)
		{
			this.setTitle("DELETE FACULTY");
			int k=0; 
			lblNewLabel.setText("Enter the faculty name");
			StringBuilder textAreaMatter=new StringBuilder("FACULTY LIST\n");
			if(c.getCourseByName(courseName).getFaculty().size()==0)
			{
				textArea.setText("No faculty have registered for this course");
				
			}
			else
			{
				for(Faculty f: c.getCourseByName(courseName).getFaculty())
					textAreaMatter.append(++k +". "+f.getName()+"\n");
				textArea.setText(textAreaMatter.toString());
			}
		}
		else
		{
			this.setTitle("DELETE PARTICIPANT");
			int k=0;
			lblNewLabel.setText("Enter the faculty name");
			StringBuilder textAreaMatter=new StringBuilder("PARTICIPANTS\n\n");
			if(c.getCourseByName(courseName).getParticipants().size()==0)
			{
				textArea.setText("No participants have registered for this course");
				
			}
			for(Participant p: c.getCourseByName(courseName).getParticipants())
				{
				System.out.println("haha");
				textAreaMatter.append(++k +". "+p.getName()+"\n");
				}
			textArea.setText(textAreaMatter.toString());
		}
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Course course=c.getCourseByName(courseName);
				if(i==2)
				{
					
					if(c.getParticipantByName(course,textField.getText())!=null && course.getParticipants().contains(c.getParticipantByName(course,textField.getText())))
					{
						course.deleteParticipant(c.getParticipantByName(course, textField.getText()));
						DeleteMember.this.setVisible(false);
						new ErrorDialog().invoke("Deleted successfully");
						new Controller().getFileWriter().writeToFile(c.getCourses(), c.getFaculty(), c.getParticipants());
					}
					else
					{
						new ErrorDialog().invoke("No such participant exists!");
					}
					//new HomePage().setVisible(true);
					DeleteMember.this.setVisible(false);
				}
				if(i==1)
				{
					if(c.getFacultyByName(course,textField.getText())!=null && course.getFaculty().contains(c.getFacultyByName(course,textField.getText())))
					{
						course.deleteFaculty(c.getFacultyByName(course, textField.getText()));
						new ErrorDialog().invoke("Deleted successfully");
						new Controller().getFileWriter().writeToFile(c.getCourses(), c.getFaculty(), c.getParticipants());
					}
					else
					{
						new ErrorDialog().invoke("No such faculty exists!");
					}
				//	new HomePage().setVisible(true);
					DeleteMember.this.setVisible(false);
				}
			}
		});
	}
	
	
}
