package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Menu extends JFrame{

	private JTextField textField;
	int i;
	/**
	 * Create the application.
	 */
	public Menu(int i) {
		this.i=i;
		initialize();
		
	}

	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {
		this.setBounds(100, 100, 450, 400);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Select type");
		lblNewLabel_4.setBounds(189, 12, 100, 15);
		this.getContentPane().add(lblNewLabel_4);
		
		
		JLabel lblNewLabel_1 = new JLabel("1. Relative");
		lblNewLabel_1.setBounds(32, 50, 200, 15);
		this.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("2. Personal Friend");
		lblNewLabel_2.setBounds(32, 100, 200, 15);
		this.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("3. Professional Friend");
		lblNewLabel_3.setBounds(32, 150, 200, 15);
		this.getContentPane().add(lblNewLabel_3);
		

		JLabel lblNewLabel = new JLabel("4. Casual Friend ");
		lblNewLabel.setBounds(32, 200, 200, 15);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel5 = new JLabel("Enter choice ");
		lblNewLabel5.setBounds(32, 260, 100, 15);
		this.getContentPane().add(lblNewLabel5);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBounds(170, 300, 117, 25);
		this.getContentPane().add(btnSubmit);
		
		textField = new JTextField();
		textField.setBounds(169, 260, 114, 19);
		this.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int choice;
				try
				{
					choice=Integer.parseInt(textField.getText());
				}
				catch(Exception ex)
				{
					new ErrorDialog().invoke("Please enter a valid integer 1-4");
					return;
				}
				if(choice!=1 && choice!=2 && choice!=3 && choice!=4 )
					{
						new ErrorDialog().invoke("Please enter a valid integer 1-5");
						return ;
					}
				if(i==1)
				{
					//particular category only
					System.out.println("Haah"+choice);
					Menu.this.setVisible(false);
					new DisplayAll(choice).setVisible(true);
					return;
				}
				
				if(choice==1)
				{
					Menu.this.setVisible(false);
					new InputRelative().setVisible(true);	
					return;
				}
				else if(choice==2)
				{
					Menu.this.setVisible(false);
					new InputPersonalFriend().setVisible(true);
					
					return;
				}
				else if(choice==3)
				{
					Menu.this.setVisible(false);
					new InputProfessionalFriend().setVisible(true);
					return;
				}
				else if(choice==4)
				{
					Menu.this.setVisible(false);
					new InputCasualFriend().setVisible(true);
				
					return;
				}
			}
		});
		
	}
}
