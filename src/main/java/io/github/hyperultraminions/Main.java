package io.github.hyperultraminions;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        getLogger().info("HyperUltraMinions v6.0.0 by Bhavesh has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("HyperUltraMinions has been disabled.");
    }

    public static Main getInstance() {
        return instance;
    }
}
