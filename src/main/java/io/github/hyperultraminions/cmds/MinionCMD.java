package io.github.hyperultraminions.cmds;

import io.github.hyperultraminions.Main;
import io.github.hyperultraminions.minions.types.MinionMiner;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MinionCMD implements CommandExecutor {

    private final Main plugin;

    public MinionCMD(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("§cOnly players can run this command!");
            return true;
        }

        if (!player.hasPermission("hyperultraminions.admin")) {
            player.sendMessage("§cYou don't have permission to use this command!");
            return true;
        }

        if (args.length > 0 && args[0].equalsIgnoreCase("spawn")) {
            // Spawn a Cobblestone Miner minion right where the player is standing
            MinionMiner miner = new MinionMiner(player.getUniqueId(), player.getLocation(), 1, Material.COBBLESTONE);
            plugin.getMinionManager().registerMinion(miner);
            player.sendMessage("§a[HyperUltraMinions] Successfully spawned a Lvl 1 Cobblestone Minion!");
            return true;
        }

        player.sendMessage("§eUsage: /minion spawn");
        return true;
    }
          }
              
