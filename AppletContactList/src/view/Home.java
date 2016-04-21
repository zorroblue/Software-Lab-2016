package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Controller;

public class Home extends JPanel{

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
	/*public static void main(String[] args)
	{
		c.readTheFile();
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Home home=new Home();
				home.setVisible(true);
			}
		});
	}*/
	
	private void initialize() {
		//this.setBounds(100, 100, 450, 380);
		//this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		Box box=Box.createVerticalBox();
		JButton bCreate = new JButton("Create new acquaintance");
		bCreate.setBounds(41, 44, 220, 25);
		this.add(bCreate);
		
		JButton bDel = new JButton("Delete acquaintance");
		bDel.setBounds(41, 92, 220, 25);
		this.add(bDel);
		
		JButton bView = new JButton("View all acquaintances");
		bView.setBounds(41, 142, 220, 25);
		this.add(bView);
		
		JButton bCategory = new JButton("View by category");
		bCategory.setBounds(41, 192, 220, 25);
		this.add(bCategory);
		
		JButton bSearch = new JButton("Search for acquaintance");
		bSearch.setBounds(41, 242, 220, 25);
		this.add(bSearch);
		
		
	//	JButton btnExit = new JButton("EXIT");
	//	btnExit.setBounds(300, 110, 100, 40);
	//	this.add(btnExit);
		/*
		box.add(bCreate);
		box.add(bDel);
		box.add(bView);
		box.add(bCategory);
		box.add(bSearch);
		box.add(btnExit);
		
		add(box);*/
		
		/*btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});*/
		
		bCreate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//new Menu(0).setVisible(true);
			//	new Controller().getAppletContext().getContentPane().removeAll();
				MainFrame frame=new Controller().getAppletContext();
				frame.setContentPane(new Menu(0));
				frame.revalidate();
				frame.repaint();
			}
		});
		
		bDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//new DeleteDialog().setVisible(true);
				MainFrame frame=new Controller().getAppletContext();
				frame.setContentPane(new DeleteDialog());
				frame.revalidate();
				frame.repaint();
			}
		});
		
		bView.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//new DisplayAll(0).setVisible(true);
				MainFrame frame=new Controller().getAppletContext();
				frame.setContentPane(new DisplayAll(0));
				frame.revalidate();
				frame.repaint();
			}
		});
		
		bCategory.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//Menu newMenu=new Menu(1);
				//Home.this.add(newMenu);
				//System.out.println("here");
				MainFrame frame=new Controller().getAppletContext();
				frame.setContentPane(new Menu(1));
				frame.revalidate();
				frame.repaint();
			}
		});
		
		bSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//new NameInput(1).setVisible(true);
				MainFrame frame=new Controller().getAppletContext();
				frame.setContentPane(new NameInput(1));
				frame.revalidate();
				frame.repaint();
			}
		});
	}
}
