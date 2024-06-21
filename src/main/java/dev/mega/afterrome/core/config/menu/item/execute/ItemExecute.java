package dev.mega.afterrome.core.config.menu.item.execute;

import dev.mega.afterrome.core.user.User;
import org.bukkit.inventory.ItemStack;

public interface ItemExecute {
    void execute(User user, ItemStack itemStack, String ID);
}
