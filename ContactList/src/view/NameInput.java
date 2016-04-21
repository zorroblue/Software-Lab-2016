package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.Controller;
import model.CasualFriend;
import model.PersonalFriend;
import model.ProfessionalFriend;
import model.Relative;

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
		
		final JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 23, 476, 344);
		getContentPane().add(textArea);
		textArea.setEditable(false);
	
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(textField.getText().length()==0)
				{
					new ErrorDialog().invoke("Please enter a non null input");
					return ;
				}
				String input=textField.getText();
				Relative relative =controller.getRelativeByName(input);
				PersonalFriend per=controller.getPersonalFriendByName(input);
				ProfessionalFriend prof=controller.getProfessionalFriendByName(input);
				CasualFriend cas=controller.getCasualFriendByName(input);
				if(relative==null && cas==null && prof==null && cas==null)
				{
					new ErrorDialog().invoke("There is no such acquaintance!");
					textArea.setText("");
					return;
				}
				else
				{
					int k=0;
					StringBuilder builder=new StringBuilder("SEARCH RESULTS: \n\n");
					if(relative!=null)
					{
						builder.append("RELATIVES:\n\n");
						k=0;
						for(Relative r: controller.getRelatives())
						{
							if(r.getName().equals(input))
								builder.append(++k + ". "+r.getName()+"\n");
						}
					}
					if(per!=null)
					{
						builder.append("PERSONAL FRIENDS:\n\n");
						for(PersonalFriend per1: controller.getPersonalFriends())
						{
							if(per1.getName().equals(input))
								builder.append(++k +". "+per1.getName());
						}
					}
					if(prof!=null)
					{
						builder.append("PROFESSIONAL FRIENDS:\n\n");
						for(ProfessionalFriend pro: controller.getProfessionalFriends())
						{
							if(pro.getName().equals(input))
								builder.append(++k + ". "+pro.getName());
						}
					}
					if(cas!=null)
					{
						builder.append("CASUAL FRIENDS:\n\n");
						for(CasualFriend cas1: controller.getCasualFriends())
						{
							if(cas1.getName().equals(input))
								builder.append(++k + ". "+cas1.getName())
;						}
					}
					textArea.setText(builder.toString());
				}
				
			}
		});
		
	}
}
