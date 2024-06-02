package com.megadev.afterrome.object.menu;

import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.manager.MenuManager;
import com.megadev.afterrome.manager.UserManager;
import com.megadev.afterrome.object.menu.item.MenuItem;

import com.megadev.afterrome.object.user.User;
import com.megadev.afterrome.manager.SaleTransactionManager;
import dev.mega.megacore.util.Color;
import lombok.Getter;

import org.bukkit.Bukkit;
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
import java.util.HashMap;
import java.util.List;

@Getter
public abstract class AbstractMenu implements Menu {
    private final User user;
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
    public void handleBottomInventoryClick(InventoryClickEvent event) {
        if (!allowClicks) event.setCancelled(true);

        User user = UserManager.getInstance().getUser((Player) event.getView());
        Inventory bottomInventory = event.getView().getBottomInventory();

        MenuItem clickedItem = new MenuItem(bottomInventory.getContents()[event.getSlot()]);

        HashMap<ItemStack, Integer> saleItems = user.getProfession().getSaleConfig().getSaleItems();

        for (ItemStack itemStack : saleItems.keySet()) {
            if (!itemStack.asOne().equals(clickedItem.toItemStack().asOne())) return;

            clickedItem.addClickAction(SaleTransactionManager.getInstance().getTransactionAction(
                    user, itemStack, clickedItem.toItemStack(),
                    saleItems.get(itemStack), event.getSlot()));

            clickedItem.addShiftClickAction(SaleTransactionManager.getInstance().getAllTransactionAction(
                    user, itemStack, clickedItem.toItemStack(),
                    saleItems.get(itemStack), event.getSlot()));

            clickedItem.doClickActions(event);
        }
    }

    @Override
    public @NotNull Inventory getInventory() {
        inventory = type == InventoryType.CHEST
                ? Bukkit.createInventory(this, getSize(), Color.getTranslated(getMenuName()))
                : Bukkit.createInventory(this, type, Color.getTranslated(getMenuName()));
        update();

        return inventory;
    }

    @Override
    public void open() {
        Player player = user.getPlayer();
        player.openInventory(getInventory());

        if (updateTime() <= 0) return;

        MenuManager menuManager = MenuManager.getInstance();

        if (menuManager.containsTaskForUser(user)) {
            menuManager.cancelTaskForUser(user);
            menuManager.removeTaskForUser(user);
        }

        menuManager.putTaskForUser(user, this);
    }

    @Override
    public void close() {
        user.getPlayer().closeInventory();
    }

    public void update() {
        items = new MenuItem[this.items.length];
        setMenuItems();
        inventory.setContents(convertToItemStacks(items));
    }

    @Override
    public void handleOpen(InventoryOpenEvent event) {}

    @Override
    public void handleClose(InventoryCloseEvent event) {

    }

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
