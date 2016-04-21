package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.Controller;
import model.CasualFriend;
import model.PersonalFriend;
import model.ProfessionalFriend;
import model.Relative;

public class DeleteDialog extends JApplet {


	private JTextField textField;
	Controller c=new Controller();
	ImageIcon icon=new ImageIcon(getClass().getResource("home.png"));
	JButton btnGoHome = new JButton("Home",icon);
	
	/**
	 * Create the application.
	 */
	public DeleteDialog() {
		initialize();
	}

	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {
		
		this.setBounds(100, 100, 450, 300);
	
		this.getContentPane().setLayout(null);
		
		JLabel lblEnterName = new JLabel("Enter name ");
		lblEnterName.setBounds(67, 100, 100, 15);
		this.getContentPane().add(lblEnterName);
		
		textField = new JTextField();
		textField.setBounds(213, 100, 114, 19);
		this.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setBounds(135, 152, 117, 25);
		this.getContentPane().add(btnNewButton);
		
		
		
		btnGoHome.setBounds(120, 217, 140, 40);
		this.getContentPane().add(btnGoHome);
		
		btnGoHome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DeleteDialog.this.setVisible(false);
		
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(textField.getText().length()==0)
				{
					new ErrorDialog().invoke("Please enter a valid input");
				}
				else
				{
					Relative rel=c.getRelativeByName(textField.getText());
					PersonalFriend per=c.getPersonalFriendByName(textField.getText());
					ProfessionalFriend pro=c.getProfessionalFriendByName(textField.getText());
					CasualFriend cas=c.getCasualFriendByName(textField.getText());
					if(rel==null && pro==null && per==null && cas==null)
					{
						new ErrorDialog().invoke("No such acquaintance exists!");
						return ;
					}
					else 
					{
						if(rel!=null)
						{
							c.getRelatives().remove(rel);
							c.writeToFile();
							new ErrorDialog().invoke("Deleted "+rel.getName()+" "+"Type:Relative");
							DeleteDialog.this.setVisible(false);
							return;
						}
						if(cas!=null)
						{
							c.getCasualFriends().remove(cas);
							c.writeToFile();
							new ErrorDialog().invoke("Deleted "+cas.getName()+" "+"Type:Casual Friend");
							DeleteDialog.this.setVisible(false);
							return;
						}
						if(per!=null)
						{
							c.getPersonalFriends().remove(per);
							c.writeToFile();
							new ErrorDialog().invoke("Deleted "+per.getName()+" "+"Type:Personal Friend");
							DeleteDialog.this.setVisible(false);
							return;
						}
						if(pro!=null)
						{
							c.getProfessionalFriends().remove(pro);
							c.writeToFile();
							new ErrorDialog().invoke("Deleted "+pro.getName()+" "+"Type: Professional Friend");
							DeleteDialog.this.setVisible(false);
							return;
						}
					}
				}
			}
			
		});
	}
}
