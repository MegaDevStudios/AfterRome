package dev.mega.afterromeimpl.manager;

import dev.mega.afterrome.user.User;
import dev.mega.megacore.MegaCore;
import dev.mega.megacore.inventory.builder.menu.ClickAction;
import dev.mega.megacore.manager.Manager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class SaleTransactionManager extends Manager {
    public SaleTransactionManager(MegaCore megaCore) {
        super(megaCore);
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
        Player player = Bukkit.getPlayer(user.getUuid());
        ItemStack resultItem = clickedItem.clone();
        resultItem.setAmount(clickedItem.getAmount() - saleItem.getAmount());
        player.getInventory().setItem(slot, resultItem);
        user.setPoints(user.getPoints() + points);
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
