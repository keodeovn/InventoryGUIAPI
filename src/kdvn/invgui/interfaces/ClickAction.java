package kdvn.invgui.interfaces;

import kdvn.invgui.gui.InvGUI;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public interface ClickAction {
	
	// RUN WHEN CLICK ON SLOT (NOT REQUIRE ITEM)
	public void run(InvGUI gui, Inventory inv, Player player, int slot, InventoryClickEvent e);
	
}
