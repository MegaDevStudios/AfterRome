package dev.mega.afterrome.impl.menu.choice;

import dev.mega.afterrome.core.api.AfterRomeAPI;
import dev.mega.afterrome.core.config.menu.ClassChoiceConfig;
import dev.mega.afterrome.core.config.Config;
import dev.mega.afterrome.core.config.data.ConfigData;
import dev.mega.afterrome.core.config.data.ProfessionSection;
import dev.mega.afterrome.core.config.menu.item.HeadSection;
import dev.mega.afterrome.core.config.menu.item.MenuItemSection;
import dev.mega.afterrome.core.manager.ProfessionManager;
import dev.mega.afterrome.core.user.Profession;
import dev.mega.afterrome.core.user.User;
import dev.mega.afterrome.impl.menu.AbstractMenu;
import dev.mega.afterrome.impl.menu.Menu;
import dev.mega.megacore.MegaCore;
import dev.mega.megacore.config.SubFolder;
import dev.mega.megacore.inventory.builder.HeadBuilder;
import dev.mega.megacore.manager.MegaManager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;

import java.util.Optional;

public class ChoiceMenu extends AbstractMenu {
    private final MegaCore megaCore;

    public ChoiceMenu(User user, MegaCore megaCore) {
        super(user, 3);
        this.megaCore = megaCore;
    }

    @Override
    protected void setMenuItems() {
        ConfigData configData = SubFolder.getConfigManager().getConfig(Config.class).getConfigData();
        fillItems(configData);

        for (ProfessionSection professionSection : configData.getProfessions()) {
            HeadSection headSection = professionSection.getHeadSection();

            if (professionSection.isHidden()) continue;

            setItem(new HeadBuilder(headSection.getTexture())
                            .setName(headSection.getName())
                            .setLore(headSection.getLore())
                            .toMenuItem()
                            .addClickAction(event -> clickAction(MegaManager.getManager(ProfessionManager.class)
                            .getProfession(professionSection.getName()))),
                    headSection.getSlot());
        }

    }

    @Override
    public String getTitle() {
        return SubFolder.getConfigManager().getConfig(ClassChoiceConfig.class).getClassChoiceMenuData().getTitle();
    }

    @Override
    public void handleClose(InventoryCloseEvent event) {
        Optional<User> optionalUser = AfterRomeAPI.getUser((Player) event.getPlayer());
        if (optionalUser.isEmpty()) return;
        User user = optionalUser.get();

        if (!(event.getInventory().getHolder() instanceof ChoiceMenu)) return;
        if (!(user.getProfession().getName().equalsIgnoreCase("default"))) return;

        Bukkit.getScheduler().runTaskLater(megaCore, () -> {
            Menu choiceMenu = new ChoiceMenu(getUser(), megaCore);
            choiceMenu.open();
        }, 1L);
    }

    private void clickAction(Profession profession) {
        AfterRomeAPI.setProfession(getUser(), profession);
        close();
    }

    private void fillItems(ConfigData configData) {
        for (MenuItemSection menuItemSection : configData.getChoiceClassMenu().getBackgroundItems()) {
            setItem(menuItemSection.getItem()
                            .setName(menuItemSection.getName())
                            .setLore(menuItemSection.getLore()),
                    menuItemSection.getSlot());
        }
    }
}
