package com.megadev.afterrome.manager;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MenuManager {
    @Getter
    private static MenuManager instance;
    private Plugin plugin;
    @Getter
    private Inventory inventory;

    private MenuManager(Plugin plugin) {
        this.plugin = plugin;

        loadContent();
        startUpdating();
        reopenInventoryForPlayers();
    }

    public static void init(Plugin plugin) {
        if (instance == null) {
            instance = new MenuManager(plugin);
        }
    }

    public void loadContent() {
        try {
            inventory = Bukkit.createInventory(null, 27, "name");
        } catch (IllegalArgumentException exception) {
            Bukkit.getLogger().severe("Invalid menu row value. Must be between 3 and 6.");
            Bukkit.getServer().getPluginManager().disablePlugin(plugin);
            return;
        }

        fillEmpties();
    }

    private void fillEmpties() {
        for (int i = 0; i < 27; i++) {
            ItemStack item = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
            ItemMeta itemMeta = item.getItemMeta();

            itemMeta.setDisplayName("§0");
            item.setItemMeta(itemMeta);

            inventory.setItem(i, item);
        }
    }

    private void reopenInventoryForPlayers() {
        Inventory loadedInventory = null;
        try {
//            loadedInventory = InventoryStateHandler.loadInventoryAndDeleteFile(plugin);
        } catch (IllegalStateException ignored) {
        }

//        if (loadedInventory == null) {
//            return;
//        }

        Set<Player> playersToReopen = new HashSet<>();
        for (Player player : Bukkit.getOnlinePlayers()) {
            Inventory playerInventory = player.getOpenInventory().getTopInventory();
            if (inventoriesEqual(playerInventory, loadedInventory)) {
                playersToReopen.add(player);
            }
        }

        for (Player player : playersToReopen) {
            player.closeInventory();
            player.openInventory(inventory);
        }
    }

    private boolean inventoriesEqual(Inventory inv1, Inventory inv2) {
        if (inv1.getSize() != inv2.getSize()) {
            return false;
        }
        for (int i = 0; i < inv1.getSize(); i++) {
            ItemStack item1 = inv1.getItem(i);
            ItemStack item2 = inv2.getItem(i);
            if ((item1 == null && item2 != null) || (item1 != null && !item1.equals(item2))) {
                return false;
            }
        }
        return true;
    }

    public void startUpdating() {
    }

    private void fillHeads(List<ItemStack> targetHeads) {
    }
}
