package screen.load;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;

public class LoadButton extends JButton
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * When this button is clicked, it opens a File Chooser.
	 * Once the file is selected it Loads it
	 * 
	 * @author pplluumm
	 */
	public LoadButton()
	{
		this.setText("Load");
		this.setFocusable(false);
		this.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				JFileChooser loadFile = new LoadFileChooser(new File("Saves"));
				loadFile.showOpenDialog(null);
			}
		});
	}
	
}
