package modloader;

import java.util.ArrayList;

public interface Mod
{
	public String getName();
	public ArrayList<String> requiredMods();
	
	public void starting();
	public void stopping();
}
