package kdvn.invgui.gui;

import kdvn.invgui.main.MainInventoryGUI;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.metadata.FixedMetadataValue;

public class InvGUIUtil {
	
	public static final String METADATA = "openingInvGUI";
	
	public static void openGUI(Player player, InvGUI gui) {
		Inventory inv = Bukkit.createInventory(null, gui.getRows() * 9, gui.getTitle());
		player.openInventory(inv);
		// ADD INV DATA TO PLAYER
		player.setMetadata(METADATA, new FixedMetadataValue(MainInventoryGUI.plugin, gui));
		// LOAD ITEM
		Bukkit.getScheduler().runTaskAsynchronously(MainInventoryGUI.plugin, () -> {
			gui.getGuiSlots().forEach((slot, invSlot) -> {
				inv.setItem(slot, invSlot.getItem());
			});
		});
	}
	
	public static void openGUI(Player player, String guiName) {
		InvGUI gui = InvGUI.getGUI(guiName);
		openGUI(player, gui);
	}
	
	public static boolean hasCurrentGUI(Player player) {
		return player.hasMetadata(METADATA);
	}
	
	public static InvGUI getCurrentGUI(Player player) {
		if (!hasCurrentGUI(player)) return null;
		InvGUI gui = (InvGUI) player.getMetadata(METADATA).get(0).value();
		
		return gui;
	}
}
