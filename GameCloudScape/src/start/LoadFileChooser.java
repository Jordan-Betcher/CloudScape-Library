package start;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

public class LoadFileChooser extends JFileChooser implements ActionListener
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Creates a FileChooser to select the correct save file
	 * 
	 * @author pplluumm
	 * @param startDirectoryFile is the directory that the FileChooser will start at
	 */
	public LoadFileChooser(File startDirectoryFile)
	{
		super(startDirectoryFile);
		this.setFileSelectionMode(JFileChooser.FILES_ONLY);
		this.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent arg0)
	{
		File file = this.getSelectedFile();
		String directory = file.getAbsolutePath();
		Load.mapOfMaps(directory);
	}
	
}
