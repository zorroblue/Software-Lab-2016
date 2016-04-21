package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JSplitPane;

import controllers.Controller;
import model.Course;

import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class HomePage extends JFrame{

	/**1
	 * Create the application.
	 */
	public HomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {

		this.setBounds(100, 100, 450, 350);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		this.setTitle("Course Management Software");
		JButton btnCreateNewCourse = new JButton("Create new Course");
		btnCreateNewCourse.setBounds(12, 40, 200, 25);
		this.getContentPane().add(btnCreateNewCourse);
		
		JButton btnDisplayCourse = new JButton("Display Course");
		btnDisplayCourse.setBounds(12, 70, 200, 25);
		this.getContentPane().add(btnDisplayCourse);
		
		
		JButton btnCreateParticipant = new JButton("Create Participant");
		btnCreateParticipant.setBounds(12, 100, 200, 25);
		this.getContentPane().add(btnCreateParticipant);
		
		JButton btnDisplayParticipant = new JButton("Display Participant");
		btnDisplayParticipant.setBounds(12, 130, 200, 25);
		this.getContentPane().add(btnDisplayParticipant);
		
		JButton btnEditCourse = new JButton("Edit Course");
		btnEditCourse.setBounds(12, 160, 200, 25);
		this.getContentPane().add(btnEditCourse);
		
		JButton btnDeleteCourseDetails = new JButton("Delete Course details");
		btnDeleteCourseDetails.setBounds(12, 190, 200, 25);
		this.getContentPane().add(btnDeleteCourseDetails);
		
		JButton btnCreateFaculty = new JButton("Create Faculty");
		btnCreateFaculty.setBounds(12, 220, 200, 25);
		this.getContentPane().add(btnCreateFaculty);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 238, 224);
		this.getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("EXIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(307, 130, 117, 25);
		this.getContentPane().add(btnNewButton);
	
		Controller c=new Controller();
		//action listeners
		btnCreateNewCourse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new CreateCoursePage(null).setVisible(true);
				
			//	HomePage.this.setVisible(false);
				
			}
		});
	btnDisplayCourse.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub			
			new DisplayCourse().setVisible(true);
			//HomePage.this.setVisible(false);
		}
	});
	
	btnCreateParticipant.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new GetCourseName(1).setVisible(true);
		}
	});
	
	btnDisplayParticipant.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new GetCourseName(2).setVisible(true);
		}
	});
	
	btnCreateFaculty.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new GetCourseName(3).setVisible(true);
		}
	});
	
	btnEditCourse.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new GetCourseName(4).setVisible(true);
		}
	});
	
	btnDeleteCourseDetails.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new GetCourseName(5).setVisible(true);
		}
	});
	
	}
}
