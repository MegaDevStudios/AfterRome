package com.megadev.afterrome.listener;

import com.megadev.afterrome.AfterRome;
import com.megadev.afterrome.manager.MenuManager;
import com.megadev.afterrome.manager.UserManager;
import com.megadev.afterrome.object.menu.Menu;
import com.megadev.afterrome.object.menu.choice.ChoiceMenu;
import com.megadev.afterrome.object.user.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.Optional;

public class MenuListener implements Listener {
    @EventHandler(priority = EventPriority.NORMAL)
    public void onMenuClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;

        Inventory inventory = event.getView().getTopInventory();
        ItemStack item = event.getCurrentItem();

        InventoryHolder holder = event.getInventory().getHolder();
        if (!(holder instanceof Menu menu)) return;

        event.setCancelled(true);

        if (item == null) return;
        if (event.getClickedInventory() != inventory) return;

        menu.handleClick(event);
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onMenuOpen(InventoryOpenEvent event)
    {
        if (!(event.getPlayer() instanceof Player)) return;

        InventoryHolder holder = event.getView().getTopInventory().getHolder();
        if (!(holder instanceof Menu menu)) return;

        menu.handleOpen(event);
    }

//    @EventHandler(priority = EventPriority.NORMAL)
//    public void onMenuClose(InventoryCloseEvent event)
//    {
//        if (!(event.getPlayer() instanceof Player player)) return;
//
//        InventoryHolder holder = event.getView().getTopInventory().getHolder();
//        if (!(holder instanceof Menu menu)) return;
//
//        menu.handleClose(event);
//
//        Optional<User> optionalUser = UserManager.getInstance().getUser(player);
//        if (optionalUser.isPresent()) {
//            User user = optionalUser.get();
//
//            if (MenuManager.getRefreshingMenus().containsKey(user)) {
//                MenuManager.getRefreshingMenus().get(user).cancel();
//                MenuManager.getRefreshingMenus().remove(user);
//            }
//        }
//
//
//    }

    @EventHandler
    public void onMenuClose(InventoryCloseEvent event) {
        if (!(event.getPlayer() instanceof Player player)) return;

        Optional<User> optionalUser = UserManager.getInstance().getUser(player);
        if (optionalUser.isEmpty()) return;
        User user = optionalUser.get();

        if (!(event.getInventory().getHolder() instanceof ChoiceMenu)) return;

        Bukkit.getScheduler().runTaskLater(AfterRome.getInstance(), () -> {
            Menu choiceMenu = new ChoiceMenu(user);
            choiceMenu.open();
            }, 1L);
    }
}
