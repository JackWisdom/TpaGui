package nl.galaxias.tpagui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Galaxias on 11-04-15 (18:44).
 * This file is part of TpaGui in the package nl.galaxias.tpagui.
 */
public class TpaCommand implements CommandExecutor {
    private ChestGui gui = new ChestGui();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("tpa")) {
            if (sender.hasPermission("tpagui.tpa")) {
                gui.openGUI(player, Bukkit.getOnlinePlayers().toArray(new Player[Bukkit.getOnlinePlayers().size()]), 1, new ItemStack(Material.SKULL_ITEM, 1, (byte) 3));
            }

            return true;
        }
        return false;
    }
}