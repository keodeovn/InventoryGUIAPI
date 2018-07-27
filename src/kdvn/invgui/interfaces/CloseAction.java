package kdvn.invgui.interfaces;

import kdvn.invgui.gui.InvGUI;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

public interface CloseAction {
	
	public void run(InvGUI gui, Player player, Inventory inv, InventoryCloseEvent e);
	
}
