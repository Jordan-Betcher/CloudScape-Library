package screen.start;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import screen.Start;

public class StartButton extends JButton implements ActionListener
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String text = "Start";
	
	private screen.Start startScreen;
	
	/**
	 * On Pressed creates game.Screen
	 * 
	 * @author pplluumm
	 * @param startScreen is the screen the game starts on, this button will close it after this button is pushed
	 */
	public StartButton(screen.Start startScreen)
	{
		super(text);
		
		this.startScreen = startScreen;
		
		this.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		//new screen.Render();
		
		this.startScreen.dispose();
	}
	
}
