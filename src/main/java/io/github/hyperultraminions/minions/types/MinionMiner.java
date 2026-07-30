package io.github.hyperultraminions.minions.types;

import io.github.hyperultraminions.minions.Minion;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import java.util.UUID;

public class MinionMiner extends Minion {

    private final Material targetBlock;

    public MinionMiner(UUID ownerUUID, Location location, int level, Material targetBlock) {
        super(ownerUUID, location, level);
        this.targetBlock = targetBlock;
    }

    @Override
    public void performAction() {
        // Target block directly 1 block in front of the minion
        Location targetLoc = getLocation().clone().add(getLocation().getDirection().multiply(1));
        Block block = targetLoc.getBlock();

        if (block.getType() == targetBlock) {
            // Mine/Break the block
            block.setType(Material.AIR);
            // (Later we will direct the drops into the minion's internal chest inventory!)
        } else if (block.getType() == Material.AIR) {
            // Re-place target resource block
            block.setType(targetBlock);
        }
    }

    public Material getTargetBlock() {
        return targetBlock;
    }
          }
                   
