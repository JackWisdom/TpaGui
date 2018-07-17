package nl.galaxias.tpagui;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Galaxias on 11-04-15 (18:41).
 * This file is part of TpaGui in the package nl.galaxias.tpagui.
 */
public class TpaGui extends JavaPlugin {
    private static Plugin plugin;
    public static ChestGui chestGui;
    FileConfiguration config = getConfig();

    public void onEnable() {
        chestGui=new ChestGui();
        plugin = this;
        config.addDefault("gui-title", "§c点击传送!");
        config.addDefault("rows", "6");
        config.options().copyDefaults(true);
        saveConfig();

        registerEvents(this, chestGui);

        getCommand("tpagui").setExecutor(new TpaCommand());
    }

    public void onDisable() {
        plugin = null;
    }

    public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }

    public static Plugin getPlugin() {
        return plugin;
    }
}
