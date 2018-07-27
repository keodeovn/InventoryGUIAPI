package kdvn.invgui.gui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kdvn.invgui.interfaces.ClickAction;
import kdvn.invgui.interfaces.CloseAction;

import org.bukkit.event.inventory.ClickType;

public class InvGUI {
	
	private String name;
	private String title;
	private int rows;
	private List<ClickType> allowedClickType = new ArrayList<ClickType> ();
	private Map<Integer, ClickAction> clickActions = new HashMap<Integer, ClickAction> ();
	private Map<Integer, InvGUISlot> guiSlots = new HashMap<Integer, InvGUISlot> ();
	private CloseAction closeAction;
	
	// ONLY CREATED BY MANAGER
	
	private InvGUI(String name, String title, int rows, List<ClickType> allowedClickType, Map<Integer, ClickAction> clickActions, Map<Integer, InvGUISlot> guiSlots, CloseAction action) {
		setName(name);
		setTitle(title);
		setRows(rows);
		setAllowedClickType(allowedClickType);
		setClickActions(clickActions);
		setGuiSlots(guiSlots);
		setCloseAction(action);
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}
	
	public String getTitle() {
		return title;
	}

	private void setTitle(String title) {
		this.title = title;
	}

	public int getRows() {
		return rows;
	}

	private void setRows(int rows) {
		this.rows = rows;
	}

	public Map<Integer, ClickAction> getClickActions() {
		return clickActions;
	}

	private void setClickActions(Map<Integer, ClickAction> clickActions) {
		this.clickActions = clickActions;
	}

	public List<ClickType> getAllowedClickType() {
		return allowedClickType;
	}

	public void setAllowedClickType(List<ClickType> allowedClickType) {
		this.allowedClickType = allowedClickType;
	}

	public CloseAction getCloseAction() {
		return closeAction;
	}

	private void setCloseAction(CloseAction closeAction) {
		this.closeAction = closeAction;
	}
	
	public Map<Integer, InvGUISlot> getGuiSlots() {
		return guiSlots;
	}

	public void setGuiSlots(Map<Integer, InvGUISlot> guiSlots) {
		this.guiSlots = guiSlots;
	}
	
	// MANAGER
	
	private static List<InvGUI> guiList = new ArrayList<InvGUI> ();
	
	public static void createGUI(String name, String title, int rows, List<ClickType> allowedClickType, Map<Integer, ClickAction> clickActions, Map<Integer, InvGUISlot> guiSlots, CloseAction action) {
		InvGUI gui = new InvGUI(name, title, rows, allowedClickType, clickActions, guiSlots, action);
		guiList.add(gui);
	}
	
	public static void removeGUI(String name) {
		int pos = 0;
		for (int i = 0 ; i < guiList.size() ; i++) {
			if (guiList.get(i).getName().equals(name)) {
				pos = i;
				break;
			}
		}
		guiList.remove(pos);
	}
	
	public static InvGUI getGUI(String name) {
		for (InvGUI gui : guiList) {
			if (gui.getName().equals(name)) return gui;
		}
		
		return null;
	}
	
	public static List<InvGUI> getGUIList() {
		return guiList;
	}
	
	public static void clearGUI() {
		guiList.clear();
	}
}
