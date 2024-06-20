package dev.mega.afterrome.config.menu.item.execute;

import dev.mega.afterrome.user.User;
import org.bukkit.inventory.ItemStack;

public interface ItemExecute {
    void execute(User user, ItemStack itemStack, String ID);
}
