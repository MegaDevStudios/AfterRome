package com.megadev.afterrome.object.menu;

import com.megadev.afterrome.manager.ConfigManager;
import com.megadev.afterrome.manager.MenuManager;
import com.megadev.afterrome.object.menu.item.MenuItem;

import com.megadev.afterrome.object.user.User;
import lombok.Getter;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractMenu implements Menu {
    @Getter
    private final User user;
    @Getter
    private final ConfigManager configManager;
    private final InventoryType type;
    private MenuItem[] items;
    private Inventory inventory;
    private boolean allowClicks = true;

    public AbstractMenu(User user, int rows) {
        this.user = user;
        this.items = new MenuItem[rows * 9];
        this.type = InventoryType.CHEST;
        this.configManager = ConfigManager.getInstance();
    }

    public AbstractMenu(User user, InventoryType type) {
        this.user = user;
        this.type = type;
        this.configManager = ConfigManager.getInstance();
    }

    @Override
    public void handleClick(InventoryClickEvent event) {
        if (!allowClicks) event.setCancelled(true);

        MenuItem item = items[event.getSlot()];

        if (item == null) return;

        item.doClickActions(event);

        event.setCancelled(true);
    }

    @Override
    public @NotNull Inventory getInventory() {
        inventory = type == InventoryType.CHEST
                ? Bukkit.createInventory(this, getSize(), ChatColor.translateAlternateColorCodes('&', getMenuName()))
                : Bukkit.createInventory(this, type, ChatColor.translateAlternateColorCodes('&', getMenuName()));
        update();

        return inventory;
    }

    @Override
    public void open() {
        Player player = user.getPlayer();
        player.openInventory(getInventory());

        if (updateTime() <= 0) return;

        if (MenuManager.containsPlayer(user)) {
            MenuManager.cancelTask(user);
            MenuManager.remove(user);
        }

        MenuManager.put(user, Bukkit.getScheduler().runTaskTimer(MenuManager.getPlugin(), () -> {
            if (!player.getOpenInventory().getTitle().equals(ChatColor.translateAlternateColorCodes('&', getMenuName()))) {
                MenuManager.cancelTask(user);
                MenuManager.remove(user);
                return;
            }
            update();
        }, updateTime(), updateTime()));
    }

    public void update() {
        items = new MenuItem[this.items.length];
        setMenuItems();
        inventory.setContents(convertToItemStacks(items));
    }

    public void handleOpen(InventoryOpenEvent event) {}

    public void handleClose(InventoryCloseEvent event) {}

    public int getSize() {
        return items.length;
    }

    public int updateTime() {
        return 20;
    }

    protected void setItem(MenuItem item, int index) {
        items[index] = item;
    }

    protected void setItems(MenuItem item, int... indexes) {
        for (int index : indexes) {
            setItem(item, index);
        }
    }

    protected void setItems(MenuItem item, List<Integer> indexes) {
        for (int index : indexes) {
            setItem(item, index);
        }
    }

    protected abstract void setMenuItems();

    public abstract String getMenuName();

    public void disallowClicks()
    {
        this.allowClicks = false;
    }

    private static ItemStack[] convertToItemStacks(MenuItem[] items) {
        return Arrays.stream(items)
                .map(item -> item == null ? new ItemStack(Material.AIR) : item.toItemStack())
                .toArray(ItemStack[]::new);
    }
}
