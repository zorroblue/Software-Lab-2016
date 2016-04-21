package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controller.Controller;
import model.CasualFriend;
import model.PersonalFriend;
import model.ProfessionalFriend;
import model.Relative;

public class DisplayAll extends JPanel{

	ImageIcon icon=new ImageIcon(getClass().getResource("home.png"));
	JButton btnGoHome = new JButton("Home",icon);	
	Controller c=new Controller();
	int choice;
	/**
	 * Create the application.
	 */
	public DisplayAll(int choice) {
		this.choice=choice;
		initialize();		
	}

	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {
		//this.setBounds(100, 100, 450, 300);
		//this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 426, 193);
		this.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		btnGoHome.setBounds(147, 217, 117, 25);
		this.add(btnGoHome);
		
		btnGoHome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
	//			DisplayAll.this.setVisible(false);
				MainFrame frame=new Controller().getAppletContext();
				frame.setContentPane(new Home());
				frame.revalidate();
				frame.repaint();
			}
		});
		switch(choice)
		{
		case 0: //display all
			
			{
			StringBuilder builder=new StringBuilder("");
			int i=0;
			for(Relative r : c.getRelatives())
				builder.append(++i+". "+r.getName() +"  Type:Relative\n");
			for(PersonalFriend p: c.getPersonalFriends())
				builder.append(i++ + ". "+p.getName()+"  Type:Personal Friend\n");
			for(ProfessionalFriend p: c.getProfessionalFriends())
				builder.append(i++ +". "+p.getName()+ " Type:Professional Friend\n");
			for(CasualFriend cas: c.getCasualFriends())
				builder.append(i++ +". "+cas.getName()+" Type:Casual Friend\n");
			textArea.setText(builder.toString());
			break;
			}
		case 1: //display only relatives
		{
			StringBuilder builder1=new StringBuilder("");
			int i1=0;
			for(Relative r : c.getRelatives())
				builder1.append(++i1+". "+r.getName() +"  Type:Relative\n");
			textArea.setText(builder1.toString());
			break;
		}
		case 2:
		{
			StringBuilder builder1=new StringBuilder("");
			int i1=0;
			for(PersonalFriend p: c.getPersonalFriends())
				builder1.append(i1++ + ". "+p.getName()+"  Type:Personal Friend\n");
			textArea.setText(builder1.toString());
			break;
		}
		case 3:
		{
			StringBuilder builder=new StringBuilder("");
			int i=0;
			for(ProfessionalFriend p: c.getProfessionalFriends())
				builder.append(i++ +". "+p.getName()+ " Type:Professional Friend\n");
			textArea.setText(builder.toString());
			break;
		}
		case 4:
		{
			StringBuilder builder=new StringBuilder("");
			int i=0;
			for(CasualFriend cas: c.getCasualFriends())
				builder.append(i++ +". "+cas.getName()+" Type:Casual Friend\n");
			textArea.setText(builder.toString());
			break;
		}
		}
	}
}
