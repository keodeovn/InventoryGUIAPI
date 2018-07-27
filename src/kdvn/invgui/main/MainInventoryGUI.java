package kdvn.invgui.main;

import kdvn.invgui.listeners.InvGUIListener;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class MainInventoryGUI extends JavaPlugin {
	
	public static MainInventoryGUI plugin;
	
	@Override
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("§2[InventoryGUI API] §bby KeoDeoVN");
		plugin = this;
		Bukkit.getPluginManager().registerEvents(new InvGUIListener(), MainInventoryGUI.plugin);
	}
	
}
