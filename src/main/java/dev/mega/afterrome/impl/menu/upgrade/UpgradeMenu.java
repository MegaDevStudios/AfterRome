package dev.mega.afterrome.impl.menu.upgrade;

import dev.mega.afterrome.core.config.Config;
import dev.mega.afterrome.core.config.data.ConfigData;
import dev.mega.afterrome.core.config.data.ProfessionSection;
import dev.mega.afterrome.core.config.menu.item.MenuItemSection;
import dev.mega.afterrome.core.user.Profession;
import dev.mega.afterrome.core.user.User;
import dev.mega.afterrome.impl.menu.AbstractMenu;
import dev.mega.megacore.config.SubFolder;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class UpgradeMenu extends AbstractMenu {
    String name;
    Profession profession;

    public UpgradeMenu(User user, Profession profession) {
        super(user, 3);
        this.profession = profession;
        ConfigData configData = SubFolder.getConfigManager().getConfig(Config.class).getConfigData();

        for (ProfessionSection professionSection : configData.getProfessions()) {
            if (professionSection.getName().equals(getUser().getProfession().getName())) {
                this.name = professionSection.getMenuSection().getUpgradeMenuSection().getMenuName();
                return;
            }
        }

        this.name = "check your config";
    }

    @Override
    public String getTitle() {
        return name;
    }

    @Override
    protected void setMenuItems() {
        ConfigData configData = SubFolder.getConfigManager().getConfig(Config.class).getConfigData();
        List<MenuItemSection> menuItemSections = new ArrayList<>();



        for (ProfessionSection professionSection : configData.getProfessions()) {
            if (professionSection.getName().equals(getUser().getProfession().getName())) {
                menuItemSections = professionSection.getMenuSection().getUpgradeMenuSection().getItems();
            }
        }



        for (MenuItemSection menuItemSection : menuItemSections) {
            setItem(menuItemSection.getItem()
                            .setName(menuItemSection.getName())
                            .setLore(menuItemSection.getLore())
                            .addClickAction(event -> {
                                ItemStack itemStack = event.getCurrentItem();
                                if (itemStack == null) return;
                                if (!menuItemSection.getExecute().isClicked()) return;
                                menuItemSection
                                        .getExecute()
                                        .getItemExecute()
                                        .execute(getUser(), itemStack, menuItemSection.getSkillName());
                            }),
                    menuItemSection.getSlot());
        }
    }
}
