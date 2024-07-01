package dev.mega.afterrome.impl.menu;

import dev.mega.afterrome.core.api.AfterRomeAPI;
import dev.mega.afterrome.core.user.User;
import dev.mega.megacore.inventory.builder.menu.MenuItemBuilder;
import dev.mega.megacore.inventory.builder.object.MegaStack;
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
import java.util.Objects;
import java.util.Optional;

@Getter
public abstract class AbstractMenu implements Menu {
    private final User user;
    private final InventoryType type;
    private MenuItemBuilder[] items;
    private Inventory inventory;
    protected boolean allowClicks = true;

    public AbstractMenu(User user, int rows) {
        this.user = user;
        this.items = new MenuItemBuilder[rows * 9];
        this.type = InventoryType.CHEST;

    }

    public void update() {
        items = new MenuItemBuilder[this.items.length];
        setMenuItems();
        inventory.setContents(convertToItemStacks(items));
    }

    public int getSize() {
        return items.length;
    }

    @Override
    public @NotNull Inventory getInventory() {
        inventory = type == InventoryType.CHEST
                ? Bukkit.createInventory(this, getSize(), Color.getTranslated(getTitle()))
                : Bukkit.createInventory(this, type, Color.getTranslated(getTitle()));
        update();

        return inventory;
    }

    @Override
    public void open() {
        Player player = Bukkit.getPlayer(user.getUuid());
        assert player != null;
        player.openInventory(getInventory());
    }

    @Override
    public void close() {
        Objects.requireNonNull(Bukkit.getPlayer(user.getUuid())).closeInventory();
    }

    @Override
    public void handleClick(InventoryClickEvent event) {
        MenuItemBuilder item = items[event.getSlot()];

        if (item == null) return;

        item.doClickActions(event);

        event.setCancelled(true);
    }

    @Override
    public void handleOpen(InventoryOpenEvent event) {}

    @Override
    public void handleClose(InventoryCloseEvent event) {}

    protected void setItem(MenuItemBuilder item, int index) {
        items[index] = item;
    }

    protected abstract void setMenuItems();

    private static ItemStack[] convertToItemStacks(MenuItemBuilder[] items) {
        return Arrays.stream(items)
                .map(item -> item == null ? new ItemStack(Material.AIR) : item.toItemStack())
                .toArray(ItemStack[]::new);
    }
}
