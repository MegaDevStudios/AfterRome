package dev.mega.afterromeimpl.object.menu.upgrade;

import dev.mega.afterrome.menu.AbstractMenu;
import dev.mega.afterrome.user.Profession;
import dev.mega.afterrome.user.User;

public abstract class AbstractUpgradeMenu extends AbstractMenu {
    Profession profession;

    public AbstractUpgradeMenu(User user, Profession profession) {
        super(user, 3);
        this.profession = profession;
    }

    @Override
    public void open() {
        super.open();
    }

    @Override
    protected void setMenuItems() {
//        for (int i = 0; i < getSize(); i++)
//            setItem(profession.getBackgroundItem(), i); TODO: Получать задний предмет профессии

//        int i = 1;
//        for (Skill skill : profession.getSkills()) { TODO: Ставить предметы прокачки
//            setItem(skill.getMenuItem(), i);
//            if (i == 7) i += 12;
//            else i += 3;
//        }
    }
}
