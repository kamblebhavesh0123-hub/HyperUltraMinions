package io.github.hyperultraminions.managers;

import io.github.hyperultraminions.Main;
import io.github.hyperultraminions.minions.Minion;
import java.util.ArrayList;
import java.util.List;

public class MinionManager {

    private final Main plugin;
    private final List<Minion> activeMinions;

    public MinionManager(Main plugin) {
        this.plugin = plugin;
        this.activeMinions = new ArrayList<>();
    }

    public void registerMinion(Minion minion) {
        minion.spawn();
        activeMinions.add(minion);
    }

    public void unregisterMinion(Minion minion) {
        minion.remove();
        activeMinions.remove(minion);
    }

    public void tickMinions() {
        for (Minion minion : activeMinions) {
            minion.performAction();
        }
    }

    public void removeAll() {
        for (Minion minion : activeMinions) {
            minion.remove();
        }
        activeMinions.clear();
    }

    public List<Minion> getActiveMinions() {
        return activeMinions;
    }
              }
      
