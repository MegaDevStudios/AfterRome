package com.megadev.afterrome.manager;

import com.megadev.afterrome.object.menu.action.ClickAction;
import com.megadev.afterrome.object.user.User;
import dev.mega.megacore.MegaCore;
import dev.mega.megacore.manager.Manager;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class SaleTransactionManager extends Manager {
    @Getter
    private static SaleTransactionManager instance;

    private SaleTransactionManager(MegaCore megaCore) {
        super(megaCore);
    }

    public static void init(MegaCore megaCore) {
        if (instance == null)
            instance = new SaleTransactionManager(megaCore);
    }

    public ClickAction getTransactionAction(User user, ItemStack saleItem, ItemStack clickedItem, int points, int slot) {
        return event -> transaction(user, saleItem, clickedItem, points, slot);
    }

    public ClickAction getAllTransactionAction(User user, ItemStack saleItem, ItemStack clickedItem, int points, int slot) {
        return event -> new BukkitRunnable() {
            @Override
            public void run() {
                if (!transaction(user, saleItem, clickedItem, points, slot))
                    cancel();
            }
        }.runTaskTimer(megaCore, 1, 1);
    }

    private boolean transaction(User user, ItemStack saleItem, ItemStack clickedItem, int points, int slot) {
        if (saleItem.getAmount() > clickedItem.getAmount()) return false;
        Player player = user.getPlayer();
        ItemStack resultItem = clickedItem.clone();
        resultItem.setAmount(clickedItem.getAmount() - saleItem.getAmount());
        player.getInventory().setItem(slot, resultItem);
        user.addPoints(points);
        return true;
    }

    @Override
    public void enable() {
        setRunning(true);
    }

    @Override
    public void disable() {
        setRunning(false);
    }
}
