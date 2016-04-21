package view;

import javax.swing.JApplet;

import controller.Controller;

public class MainFrame extends JApplet{
	
	@Override
	public void init()
	{
		new Controller().setAppletContext(this);
		new Controller().readTheFile();
		getContentPane().add(new Home());
		getContentPane().setBounds(10, 10, 800, 800);
	}
	
	@Override
	public void finalize()
	{
		destroy();
	}
}
