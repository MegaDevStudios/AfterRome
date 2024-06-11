package dev.mega.afterromeimpl.object.menu.upgrade;

import dev.mega.afterrome.user.Profession;
import dev.mega.afterrome.user.User;
import dev.mega.afterromeimpl.object.menu.AbstractMenu;
import dev.mega.megacore.inventory.MegaInventory;
import org.bukkit.Bukkit;

public abstract class AbstractUpgradeMenu extends AbstractMenu {
    User user;
    Profession profession;

    public AbstractUpgradeMenu(User user, Profession profession) {
        super(user, 3);
        this.profession = profession;
    }

    public void close() {
        Bukkit.getPlayer(user.getUuid()).closeInventory();
    }

    @Override
    public void open() {
        super.open();
    }

    @Override
    protected void setMenuItems() {
//        for (int i = 0; i < getSize(); i++)
////            setItem(profession.getBackgroundItem(), i);
//
//        int i = 1;
//        for (Skill skill : profession.getSkills()) {
////            setItem(skill.getMenuItem(), i);
//            if (i == 7) i += 12;
//            else i += 3;
//        }
    }
}
