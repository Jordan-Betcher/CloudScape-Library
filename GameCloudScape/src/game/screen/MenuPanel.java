package game.screen;

import game.worldmap.WorldMap;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MenuPanel extends JMenuBar
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MenuPanel(WorldMap worldMap)
	{
		createMenuBar();
	}
	
	 private void createMenuBar() {


	        JMenu fileMenu = new JMenu("File");

	        JMenuItem eMenuItem = new JMenuItem("Save");
	        eMenuItem.setToolTipText("SavesWorld");
	        eMenuItem.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent event) {
	                System.exit(0);
	            }
	        });

	        fileMenu.add(eMenuItem);
	        this.add(fileMenu);
	    }
	
}
