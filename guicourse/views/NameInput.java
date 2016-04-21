package views;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controllers.Controller;
import model.Faculty;
import model.Participant;
import javax.swing.JTextArea;

public class NameInput extends JFrame{

	
	private JTextField textField;
	ImageIcon icon=new ImageIcon(getClass().getResource("home.png"));
	JButton btnGoHome = new JButton("Home",icon);	
	Controller controller=new Controller();
	int type;
	/**
	 * Create the application.
	 */
	public NameInput(int type) {
		this.type=type;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		this.setBounds(100, 100, 500, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblEnterName = new JLabel("Enter name");
		lblEnterName.setBounds(58, 400, 120, 15);
		this.getContentPane().add(lblEnterName);
		
		textField = new JTextField();
		textField.setBounds(225, 400, 114, 19);
		this.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("GO");
		btnNewButton.setBounds(158, 470, 117, 25);
		this.getContentPane().add(btnNewButton);
		
		
		
		btnGoHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	new HomePage().setVisible(true);
				NameInput.this.setVisible(false);
			}
		});
		btnGoHome.setBounds(140, 510, 150, 40);
		this.getContentPane().add(btnGoHome);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 23, 476, 344);
		getContentPane().add(textArea);
		textArea.setEditable(false);
		if(type==1) //populate with faculty
		{
			int k=0;
			ArrayList<Faculty> facList=controller.getCourseByName(controller.getCourseName()).getFaculty();
			if(facList.size()==0)
			{
				textArea.setText("No faculty registered yet!");
			}
			else
			{
				StringBuilder builder=new StringBuilder("FACULTY\n");
				
			
				for(Faculty f: facList)
				{
					builder.append("\n"+ ++k+". "+f.getName());
				}
				textArea.setText(builder.toString());
			}
		}
		else
		{
			int k=0;
			ArrayList<Participant> partList=controller.getCourseByName(controller.getCourseName()).getParticipants();
			if(partList.size()==0)
			{
				textArea.setText("No faculty registered yet!");
			}
			else
			{
				StringBuilder builder=new StringBuilder("FACULTY\n");
				
			
				for(Participant f: partList)
				{
					builder.append("\n"+ ++k+". "+f.getName());
				}
				textArea.setText(builder.toString());
			}
		}
		btnNewButton.addActionListener(new ActionListener() { //edit
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method s
				if(type==2)
				{
				Participant p=controller.getParticipantByName(controller.getCourseByName(controller.getCourseName()),textField.getText() );
				if(p==null)
				{
					new ErrorDialog().invoke("No such participant found!");
					return;
				}
				else
				{
					controller.setParticipantName(textField.getText());
					new CreateParticipant(controller.getCourseName(), controller.getParticipantName(), true).setVisible(true);
					NameInput.this.setVisible(false);
				}
				}
				else
				{
					Faculty f=controller.getFacultyByName(controller.getCourseByName(controller.getCourseName()),textField.getText());
					if(f==null)
					{
						new ErrorDialog().invoke("No such faculty found!");
						return;
					}
					else
					{
						controller.setFacultyName(textField.getText());
						new CreateFaculty(controller.getCourseName(),textField.getText(),true).setVisible(true);;
						NameInput.this.setVisible(false);
					}
				}
			}
		});
		
	}
}
