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
    FileConfiguration config = getConfig();

    public void onEnable() {
        plugin = this;

        config.addDefault("tpa-command", "tpa !player! !to!");

        config.options().copyDefaults(true);
        saveConfig();

        registerEvents(this, new ChestGui());

        getCommand("tpa").setExecutor(new TpaCommand());
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