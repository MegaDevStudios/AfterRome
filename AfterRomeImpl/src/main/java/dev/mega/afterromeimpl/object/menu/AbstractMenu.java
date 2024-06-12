package dev.mega.afterromeimpl.object.menu;

import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.object.menu.item.MenuItem;
import dev.mega.afterrome.user.User;
import dev.mega.megacore.inventory.builder.menu.MenuItemBuilder;
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
import java.util.List;

@Getter
public abstract class AbstractMenu implements Menu {
    private final User user;
    private final ConfigManager configManager;
    private final InventoryType type;
    private MenuItemBuilder[] items;
    private Inventory inventory;
    private String title;

    public AbstractMenu(User user, int size) {
        this.user = user;
        this.items = new MenuItemBuilder[size * 9];
        this.type = InventoryType.CHEST;
        this.configManager = ConfigManager.getInstance();
    }

    public AbstractMenu(User user, int size, String title) {
        this.user = user;
        this.items = new MenuItemBuilder[size * 9];
        this.type = InventoryType.CHEST;
        this.configManager = ConfigManager.getInstance();
        this.title = title;
    }

    @Override
    public @NotNull Inventory getInventory() {
        inventory = type == InventoryType.CHEST
                ? Bukkit.createInventory(this, getSize(), Color.getTranslated(getTitle()))
                : Bukkit.createInventory(this, type, Color.getTranslated(getTitle()));
        update();

        return inventory;
    }

    public int getSize() {
        return items.length;
    }

    public void update() {
        items = new MenuItemBuilder[this.items.length];
        setMenuItems();
        inventory.setContents(convertToItemStacks(items));
    }

    @Override
    public void open() {
        Player player = Bukkit.getPlayer(user.getUuid());
        player.openInventory(getInventory());
    }

    @Override
    public void close() {
        Player player = Bukkit.getPlayer(user.getUuid());
        if (player == null) return;
        player.closeInventory();
    }

    @Override
    public void handleOpen(InventoryOpenEvent event) {}

    @Override
    public void handleClose(InventoryCloseEvent event) {}

    @Override
    public void handleClick(InventoryClickEvent event) {
        MenuItemBuilder item = items[event.getSlot()];

        if (item == null) return;

        item.doClickActions(event);

        event.setCancelled(true);
    }



    protected void setItem(MenuItemBuilder item, int index) {
        items[index] = item;
    }

    protected void setItems(MenuItemBuilder item, int... indexes) {
        for (int index : indexes) {
            setItem(item, index);
        }
    }

    protected void setItems(MenuItemBuilder item, List<Integer> indexes) {
        for (int index : indexes) {
            setItem(item, index);
        }
    }

    protected abstract void setMenuItems();

    private static ItemStack[] convertToItemStacks(MenuItemBuilder[] items) {
        return Arrays.stream(items)
                .map(item -> item == null ? new ItemStack(Material.AIR) : item.toItemStack())
                .toArray(ItemStack[]::new);
    }
}
