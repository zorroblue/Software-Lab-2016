package views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import controllers.Controller;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public abstract class DisplayStuff extends JFrame //abstract class so as to reuse code for both participants and courses
{

	
	private final JLabel lblNewLabel = new JLabel("REQUIRED LIST");
	JScrollPane scrollPane = new JScrollPane();
	ImageIcon icon=new ImageIcon(getClass().getResource("home.png"));
	JButton btnGoHome = new JButton("Home",icon);	
	JTextArea textArea = new JTextArea();
	Controller c=new Controller();
	
	/**
	 * Create the application.
	 */
	public DisplayStuff() {
		initialize();
	}
	
	

	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {
	
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		textArea.setEditable(false);
		this.setBounds(100, 100, 500, 500);
		
	
		this.getContentPane().setLayout(null);
		lblNewLabel.setBounds(174, 2, 152, 24);
		lblNewLabel.setFont(new Font(lblNewLabel.getFont().getName(), Font.PLAIN, getBestSize(lblNewLabel)));
		this.getContentPane().add(lblNewLabel);
		
		
		scrollPane.setBounds(12, 38, 426, 319);
		this.getContentPane().add(scrollPane);
		
		textArea.setFont(new Font(lblNewLabel.getFont().getName(), Font.PLAIN, getBestSize(lblNewLabel)-3));
		scrollPane.setViewportView(textArea);
		
		btnGoHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	new HomePage().setVisible(true);
				DisplayStuff.this.setVisible(false);
			}
		});
		btnGoHome.setBounds(174, 398, 150, 40);
		this.getContentPane().add(btnGoHome);
		
	
	}
	
	
	public abstract void populateTextArea();



	public int getBestSize(JLabel label) //gets the best viewable size wrt the textlabel's size
	{
		Font labelFont = label.getFont();
		String labelText = label.getText();

		int stringWidth = label.getFontMetrics(labelFont).stringWidth(labelText);
		int componentWidth = label.getWidth();

		// Find out how much the font can grow in width.
		double widthRatio = (double)componentWidth / (double)stringWidth;

		int newFontSize = (int)(labelFont.getSize() * widthRatio);
		int componentHeight = label.getHeight();

		// Pick a new font size so it will not be larger than the height of label.
		int fontSizeToUse = Math.min(newFontSize, componentHeight);
		return fontSizeToUse;
	}
	
}

