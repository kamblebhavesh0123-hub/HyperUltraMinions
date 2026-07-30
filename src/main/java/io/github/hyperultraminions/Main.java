package io.github.hyperultraminions;

import io.github.hyperultraminions.cmds.MinionCMD;
import io.github.hyperultraminions.managers.MinionManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;
    private MinionManager minionManager;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        // Initialize Managers
        this.minionManager = new MinionManager(this);

        // Register Commands
        if (getCommand("minion") != null) {
            getCommand("minion").setExecutor(new MinionCMD(this));
        }

        // Start Minion Ticking Thread (runs every 3 seconds)
        getServer().getScheduler().runTaskTimer(this, () -> {
            if (minionManager != null) {
                minionManager.tickMinions();
            }
        }, 60L, 60L);

        getLogger().info("HyperUltraMinions v6.0.0 by Bhavesh has been enabled!");
    }

    @Override
    public void onDisable() {
        if (minionManager != null) {
            minionManager.removeAll();
        }
        getLogger().info("HyperUltraMinions has been disabled.");
    }

    public static Main getInstance() {
        return instance;
    }

    public MinionManager getMinionManager() {
        return minionManager;
    }
}
