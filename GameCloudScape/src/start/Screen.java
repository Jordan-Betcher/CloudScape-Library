package start;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Screen extends JFrame
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Screen()
	{
		
		JPanel panel = new JPanel();
		this.setSize(960, 640);
		getContentPane().add(panel, BorderLayout.CENTER);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JButton Start = new StartButton();
		Component StartToLoadSpace = Box.createHorizontalStrut(20);
		JButton Load = new LoadButton();
		
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		getContentPane().add(Start);
		getContentPane().add(StartToLoadSpace);
		getContentPane().add(Load);
		
		this.setVisible(true);
	}
	
	public void end()
	{
		this.dispose();
	}
	
}
