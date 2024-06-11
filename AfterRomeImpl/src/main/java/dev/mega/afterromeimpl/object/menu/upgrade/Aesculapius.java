package dev.mega.afterromeimpl.object.menu.upgrade;

import com.megadev.afterrome.object.item.ItemBuilder;
import dev.mega.afterrome.user.Profession;
import dev.mega.afterrome.user.User;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Aesculapius extends AbstractUpgradeMenu {
    public Aesculapius(User user, Profession profession) {
        super(user, profession);
    }

    @Override
    public String getMenuName() {
        ItemBuilder itemBuilder = new ItemBuilder(new ItemStack(Material.ACACIA_LEAVES));
        itemBuilder.setName("asiodjaoisdja");

        ItemBuilder itemBuilder2 = itemBuilder.setName("sasdasd").getThis();

        return "";

    }
}
