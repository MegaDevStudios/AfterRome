package com.megadev.afterrome.util;

import dev.mega.megacore.MegaCore;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Explosive;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.BlockIterator;

import java.util.ArrayList;
import java.util.List;

public class TreeCapitator {
    private final Location location;
    private final Material material;

    public TreeCapitator(Location location, Material material) {
        this.location = location;
        this.material = material;
    }

    public void treeCapitate() {
        List<Location> neighboringLocations = new ArrayList<>();

        for (int x = 0; x < 2; x++) {
            for (int y = 0; y < 2; y++) {
                for (int z = 0; z < 2; z++) {
                    neighboringLocations.add(location.clone().add(-1 + x, -1 + y, -1 + z));
                }
            }
        }

         neighboringLocations.stream()
                .filter(this::hasMaterial)
                .forEach(loc -> new BukkitRunnable() {
            @Override
            public void run() {
                loc.getWorld().getBlockAt(location).setType(Material.STONE);
                new TreeCapitator(loc, material).treeCapitate();
            }
        }.runTask(MegaCore.getInstance()));
    }

    private boolean hasMaterial(Location location) {
        return location.getBlock().getType().equals(material);
    }
}
