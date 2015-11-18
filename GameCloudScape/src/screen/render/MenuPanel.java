package screen.render;

import filehelper.Save;
import game.worldmap.WorldMap;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuPanel extends JMenuBar
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private WorldMap map;
	
	public MenuPanel(WorldMap map)
	{
		createMenuBar();
		this.map = map;
	}
	
	 private void createMenuBar() {


	        JMenu fileMenu = new JMenu("File");

	        JMenuItem eMenuItem = new JMenuItem("Save");
	        eMenuItem.setToolTipText("SavesWorld");
	        eMenuItem.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent event) {
	                Save.map(map, "test");
	            }
	        });

	        fileMenu.add(eMenuItem);
	        this.add(fileMenu);
	    }
	
}
