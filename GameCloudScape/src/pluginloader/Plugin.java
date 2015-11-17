package pluginloader;

import java.util.ArrayList;

public interface Plugin
{
	/**
	 * @return the name of the plugin
	 */
	public String getPluginName();
	
	/**
	 * 
	 * @return the name of the author
	 */
	public String getAuthorName();
	
	/**
	 * What does your plugin add/do
	 * 
	 * @return is the descriptions of the Plugin
	 */
	public String getDescription();
	
	/**
	 * 
	 * @return the list of plugins that need to be loaded before this can be run
	 */
	public ArrayList<String> getRequiredPlugins();
	
	/**
	 * The method that is called to start your plugin
	 * Use this to add events, blocks, items etc...
	 */
	public void initialization();
}
