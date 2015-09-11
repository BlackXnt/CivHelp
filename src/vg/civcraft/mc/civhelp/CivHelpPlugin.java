package vg.civcraft.mc.civhelp;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import vg.civcraft.mc.civhelp.civguide.CivGuide;

public class CivHelpPlugin extends JavaPlugin{
	private static CivHelpPlugin instance;
	private static CivGuide civGuide;

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (sender instanceof Player && (label.equalsIgnoreCase("guide") || label.equalsIgnoreCase("gui"))){
			civGuide.onCommand((Player)sender, args);
			return true;
		}
		return false;
	}

	@Override
	public void onDisable() {
		civGuide.onDisable(); civGuide = null;
		
	}

	@Override
	public void onEnable() {
		instance = this;
		civGuide = new CivGuide();
		civGuide.onEnable();
	}

	public static CivHelpPlugin getInstance() {
		return instance;
	}
	
	public CivGuide getCivGuide(){
		return civGuide;
	}
}
