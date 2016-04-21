package view;

import javax.swing.JOptionPane;

import controller.Controller;

public class ErrorDialog {

	public void invoke(String errorMessage)
	{
		JOptionPane.showMessageDialog(new Controller().getAppletContext(), errorMessage,"Dialog",JOptionPane.INFORMATION_MESSAGE);
	}
	
}
