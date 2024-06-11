package dev.mega.afterromeimpl.object.menu.choice;

import com.megadev.afterrome.object.menu.item.MenuItem;
import dev.mega.afterrome.config.ClassChoiceConfig;
import dev.mega.afterrome.config.Config;
import dev.mega.afterrome.config.ConfigManager;
import dev.mega.afterrome.config.menu.ClassChoiceMenuData;
import dev.mega.afterrome.config.menu.HeadSection;
import dev.mega.afterrome.user.Profession;
import dev.mega.afterrome.user.User;
import dev.mega.afterromeimpl.object.menu.AbstractMenu;
import dev.mega.megacore.inventory.builder.HeadBuilder;
import dev.mega.megacore.inventory.builder.menu.MenuItemBuilder;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class ChoiceMenu extends AbstractMenu {
    public ChoiceMenu(User user) {
        super(user, 3, "");
    }

    @Override
    protected void setMenuItems() {
        ClassChoiceMenuData data = ConfigManager.getInstance().getConfig(ClassChoiceConfig.class).getClassChoiceMenuData();

        fillItems();

        for (HeadSection headSection : data.getHeadSections()) {
            setItem(new HeadBuilder(headSection.getTexture())
                    .setName(headSection.getName())
                    .setLore(headSection.getLore())
                    .toMenuItem()
                    .addClickAction(event -> clickAction(Profession.of(Profession.Type.AGRONOMIST))),
                headSection.getSlot());
        }
    }

    @Override
    public void handleClose(InventoryCloseEvent event) {
//        if (!(event.getPlayer() instanceof Player player)) return;
//
//        com.megadev.afterrome.object.user.User user = MegaManager.getManager(UserManager.class).getUser(player);
//        if (user == null) return;
//
//        if (!(event.getInventory().getHolder() instanceof com.megadev.afterrome.object.menu.choice.ChoiceMenu)) return;
//        if (!(user.getProfession() instanceof DefaultProfession)) return;
//
//        Bukkit.getScheduler().runTaskLater(megaCore, () -> {
//            Menu choiceMenu = new com.megadev.afterrome.object.menu.choice.ChoiceMenu(user, megaCore);
//            choiceMenu.open();
//        }, 1L);
        //TODO Сделать чтобы не закрывалось окно
    }

    private void clickAction(Profession profession) {
        //TODO менять профессию игроку
        close();
    }

    private void fillItems() {
        for (int i = 0; i < getSize(); i++) {
            if (i % 2 == 0) setItem(new MenuItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName("&c"), i);
            else setItem(new MenuItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName("&c"), i);
        }
    }
}
