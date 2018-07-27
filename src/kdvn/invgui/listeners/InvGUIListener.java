package kdvn.invgui.listeners;

import java.util.Map;

import kdvn.invgui.gui.InvGUI;
import kdvn.invgui.gui.InvGUIUtil;
import kdvn.invgui.interfaces.ClickAction;
import kdvn.invgui.main.MainInventoryGUI;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;

public class InvGUIListener implements Listener {
	
	@EventHandler
	public void onGUIClicked(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();
		if (InvGUIUtil.hasCurrentGUI(player)) {
			// CHECK
			if (e.getClickedInventory() != player.getOpenInventory().getTopInventory()) {
				if (e.getClick() == ClickType.SHIFT_LEFT || e.getClick() == ClickType.SHIFT_RIGHT) {
					e.setCancelled(true);
				}
				return;
			}
			InvGUI gui = InvGUIUtil.getCurrentGUI(player);
			// CHECK CLICK TYPE
			if (!gui.getAllowedClickType().contains(e.getClick())) {
				e.setCancelled(true);
			}
			// ACTION
			int slot = e.getSlot();
			Map<Integer, ClickAction> actions = gui.getClickActions();
			if (actions.containsKey(slot)) {
				actions.get(slot).run(gui, e.getInventory(), player, slot, e);
			}
		}
	}
	
	@EventHandler
	public void onGUIDrag(InventoryDragEvent e) {
		Player player = (Player) e.getWhoClicked();
		if (InvGUIUtil.hasCurrentGUI(player)) e.setCancelled(true);
	}
	
	@EventHandler
	public void onGUIClosed(InventoryCloseEvent e) {
		Player player = (Player) e.getPlayer();
		if (InvGUIUtil.hasCurrentGUI(player)) {
			InvGUI gui = InvGUIUtil.getCurrentGUI(player);
			// CHECK CLOSE ACTION
			if (gui.getCloseAction() != null) {
				gui.getCloseAction().run(gui, player, e.getInventory(), e);
			}
			// REMOVE DATA
			player.removeMetadata(InvGUIUtil.METADATA, MainInventoryGUI.plugin);
		}
	}
	
}
