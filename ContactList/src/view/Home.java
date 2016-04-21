package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;

import controller.Controller;

public class Home extends JFrame{

	static Controller c=new Controller();
	
	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the this.
	 */
	public static void main(String[] args)
	{
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				// TODO Auto-generated method stub
				Home home=new Home();
				home.setVisible(true);
			}
		});
	}
	
	private void initialize() {
		c.readTheFile();
		this.setBounds(100, 100, 450, 380);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JButton bCreate = new JButton("Create new acquaintance");
		bCreate.setBounds(41, 44, 220, 25);
		this.getContentPane().add(bCreate);
		
		JButton bDel = new JButton("Delete acquaintance");
		bDel.setBounds(41, 92, 220, 25);
		this.getContentPane().add(bDel);
		
		JButton bView = new JButton("View all acquaintances");
		bView.setBounds(41, 142, 220, 25);
		this.getContentPane().add(bView);
		
		JButton bCategory = new JButton("View by category");
		bCategory.setBounds(41, 192, 220, 25);
		this.getContentPane().add(bCategory);
		
		JButton bSearch = new JButton("Search for acquaintance");
		bSearch.setBounds(41, 242, 220, 25);
		this.getContentPane().add(bSearch);
		
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBounds(300, 110, 100, 40);
		this.getContentPane().add(btnExit);
		
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		bCreate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Menu(0).setVisible(true);

			}
		});
		
		bDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new DeleteDialog().setVisible(true);
			}
		});
		
		bView.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new DisplayAll(0).setVisible(true);
			}
		});
		
		bCategory.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Menu(1).setVisible(true);
				
			}
		});
		
		bSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new NameInput(1).setVisible(true);
				
			}
		});
	}
}
