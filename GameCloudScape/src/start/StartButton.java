package start;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class StartButton extends JButton implements ActionListener
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String text = "Start";
	
	private start.Screen startScreen;
	
	public StartButton(start.Screen startScreen)
	{
		super(text);
		
		this.startScreen = startScreen;
		
		this.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		new game.Screen();
		
		this.startScreen.dispose();
	}
	
}
