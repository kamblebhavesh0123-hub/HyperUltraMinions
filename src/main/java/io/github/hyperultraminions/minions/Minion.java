package io.github.hyperultraminions.minions;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import java.util.UUID;

public abstract class Minion {

    private final UUID minionId;
    private final UUID ownerUUID;
    private final Location location;
    private ArmorStand armorStand;
    private int level;
    private long lastActionTime;

    public Minion(UUID ownerUUID, Location location, int level) {
        this.minionId = UUID.randomUUID();
        this.ownerUUID = ownerUUID;
        this.location = location;
        this.level = level;
        this.lastActionTime = System.currentTimeMillis();
    }

    public void spawn() {
        if (location.getWorld() == null) return;

        // Spawn small invisible Armor Stand for the minion body
        this.armorStand = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        armorStand.setVisible(false);
        armorStand.setGravity(false);
        armorStand.setSmall(true);
        armorStand.setCustomNameVisible(true);
        armorStand.setCustomName("§aMinion Lvl " + level);

        // Equip custom head
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        armorStand.getEquipment().setHelmet(head);
    }

    public abstract void performAction(); // Logic for breaking blocks, killing mobs, etc.

    public void remove() {
        if (armorStand != null && !armorStand.isDead()) {
            armorStand.remove();
        }
    }

    public UUID getMinionId() { return minionId; }
    public UUID getOwnerUUID() { return ownerUUID; }
    public Location getLocation() { return location; }
    public ArmorStand getArmorStand() { return armorStand; }
    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }
          }
          
