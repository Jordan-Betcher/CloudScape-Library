package start;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class StartButton extends JButton
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String text = "Start";
	
	public StartButton()
	{
		super(text);
		this.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				//TODO create GameScreen, start that
			}
		});
	}
	
}
