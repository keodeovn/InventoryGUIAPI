package kdvn.invgui.gui;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.inventory.ItemStack;

public class InvGUISlot {
	
	private ItemStack item;
	private Map<String, Object> dataMap = new HashMap<String, Object> ();
	
	public InvGUISlot(ItemStack item) {
		setItem(item);
	}
	
	public InvGUISlot(ItemStack item, Map<String, Object> dataMap) {
		setItem(item);
		this.dataMap = dataMap;
	}

	public ItemStack getItem() {
		return item;
	}

	private void setItem(ItemStack item) {
		this.item = item;
	}

	public void setData(String key, Object value) {
		this.dataMap.put(key, value);
	}
	
	public boolean hasData(String data) {
		return dataMap.containsKey(data);
	}
	
	public Object getDate(String key) {
		return dataMap.get(key);
	}
	
}
