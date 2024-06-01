package com.megadev.afterrome.util;

import dev.mega.megacore.MegaCore;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public class TreeCapitator {
    private final Location location;
    private final Material material;
    private final MegaCore megaCore;

    public TreeCapitator(Location location, Material material, MegaCore megaCore) {
        this.location = location;
        this.megaCore = megaCore;
        this.material = material;
    }

    public void treeCapitate() {
        Queue<Location> woodLocations = new LinkedList<>();
        Set<Location> processedLocations = new HashSet<>();

        if (hasMaterial(location)) {
            woodLocations.add(location);
        }

        new BukkitRunnable() {
            @Override
            public void run() {
                if (woodLocations.isEmpty()) {
                    cancel();
                    return;
                }

                Location currentLocation = woodLocations.poll();
                if (currentLocation != null) {
                    currentLocation.getBlock().setType(Material.AIR);
                    currentLocation.getWorld().dropItemNaturally(
                            currentLocation.clone(), new ItemStack(material)
                    );
                    processedLocations.add(currentLocation);

                    for (Location neighbor : getNeighboringLocations(currentLocation)) {
                        if (hasMaterial(neighbor) && !processedLocations.contains(neighbor)) {
                            woodLocations.add(neighbor);
                            processedLocations.add(neighbor);
                        }
                    }
                }
            }
        }.runTaskTimer(megaCore, 1, 1);
    }

    private List<Location> getNeighboringLocations(Location location) {
        List<Location> neighboringLocations = new ArrayList<>();

        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    if (x == 0 && y == 0 && z == 0) continue;
                    neighboringLocations.add(location.clone().add(x, y, z));
                }
            }
        }

        return neighboringLocations;
    }

    private boolean hasMaterial(Location location) {
        return location.getBlock().getType().equals(material);
    }
}
