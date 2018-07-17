package nl.galaxias.tpagui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.ChatColor;

/**
 * Created by Galaxias on 11-04-15 (18:42).
 * This file is part of TpaGui in the package nl.galaxias.tpagui.
 */
public class ChestGui implements Listener ,InventoryHolder {
    private Inventory youtubers;

    public void openGUI(Player p,  ItemStack item)
    {
        ItemStack i = item;
        ItemMeta m = i.getItemMeta();
        int count=0;
        youtubers = Bukkit.createInventory(this, 9*TpaGui.getPlugin().getConfig().getInt("rows"),   TpaGui.getPlugin().getConfig().getString("gui-title"));
        for(Player pp:Bukkit.getOnlinePlayers())
        {
            m.setDisplayName(pp.getName());
            i.setItemMeta(m);
            youtubers.setItem(count, i);
            count=count+1;
        }
        p.openInventory(youtubers);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event)
    {
        if(event.getInventory().getHolder() instanceof ChestGui)
        {
            if(event.getCurrentItem() != null && event.getCurrentItem().getType() != null)
            {
                event.setCancelled(true);
                Player p = (Player) event.getWhoClicked();
                if(event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().hasDisplayName())
                {
                    Player c = Bukkit.getPlayer(event.getCurrentItem().getItemMeta().getDisplayName().trim());
                    if(c != null)
                    {
                        p.chat("/tpa "+c.getName());
                         }
                }
            }
        }
    }

    @Override
    public Inventory getInventory() {
        return null;
    }
}
