package dev.mega.afterromeimpl.object.menu.choice;

import com.megadev.afterrome.object.menu.item.MenuItem;
import dev.mega.afterrome.menu.AbstractMenu;
import dev.mega.afterrome.user.Profession;
import dev.mega.afterrome.user.User;
import dev.mega.afterromeimpl.object.item.HeadBuilder;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class ChoiceMenu extends AbstractMenu {
    public ChoiceMenu(User user) {
        super(user, 3);
    }

    @Override
    protected void setMenuItems() {
        fillItems();
//
//        setItem(new HeadBuilder(mainConfig.getAgronomistTexture())
//                        .setName(mainConfig.getAgronomistName())
//                        .setLore(mainConfig.getAgronomistLore())
//                        .toMenuItem()
//                        .addClickAction(event -> clickAction(new Agronomist())),
//                9);
//
//        setItem(new HeadBuilder(mainConfig.getArtisanTexture())
//                        .setName(mainConfig.getArtisanName())
//                        .setLore(mainConfig.getArtisanLore())
//                        .toMenuItem()
//                        .addClickAction(event -> clickAction(new Artisan())),
//                11);
//
//        setItem(new HeadBuilder(mainConfig.getSonOfMarsTexture())
//                        .setName(mainConfig.getSonOfMarsName())
//                        .setLore(mainConfig.getSonOfMarsLore())
//                        .toMenuItem()
//                        .addClickAction(event -> clickAction(new SonOfMars())),
//                13);
//
//        setItem(new HeadBuilder(mainConfig.getForesterTexture())
//                        .setName(mainConfig.getForesterName())
//                        .setLore(mainConfig.getForesterLore())
//                        .toMenuItem()
//                        .addClickAction(event -> clickAction(new Forester())),
//                15);
//
//        setItem(new HeadBuilder(mainConfig.getAesculapiusTexture())
//                        .setName(mainConfig.getAesculapiusName())
//                        .setLore(mainConfig.getAesculapiusLore())
//                        .toMenuItem()
//                        .addClickAction(event -> clickAction(new Aesculapius())),
//                17);

        //TODO Ставить головы в меню
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

    @Override
    public String getMenuName() {
        return "";
    }

    private void clickAction(Profession profession) {
        //TODO менять профессию игроку
        close();
    }

    private void fillItems() {
        for (int i = 0; i < getSize(); i++) {
            if (i % 2 == 0) setItem(new MenuItem(Material.WHITE_STAINED_GLASS_PANE).setName("&c"), i);
            else setItem(new MenuItem(Material.BLACK_STAINED_GLASS_PANE).setName("&c"), i);
        }
    }
}
