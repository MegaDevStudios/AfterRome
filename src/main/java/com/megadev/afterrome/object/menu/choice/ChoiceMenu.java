package com.megadev.afterrome.object.menu.choice;

import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.config.MainConfig;
import com.megadev.afterrome.config.user.ConfigUserManager;
import com.megadev.afterrome.config.user.UserConfig;
import com.megadev.afterrome.manager.UserManager;
import com.megadev.afterrome.object.item.HeadBuilder;
import com.megadev.afterrome.object.menu.AbstractMenu;
import com.megadev.afterrome.object.menu.Menu;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.profession.*;
import com.megadev.afterrome.object.user.User;

import dev.mega.megacore.MegaCore;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class ChoiceMenu extends AbstractMenu {
    UserManager userManager = UserManager.getInstance();
    ConfigManager configManager = ConfigManager.getInstance();
    ConfigUserManager configUserManager = configManager.getConfig(ConfigUserManager.class);
    private final MegaCore megaCore;

    public ChoiceMenu(User user, MegaCore megaCore) {
        super(user, 3);
        this.megaCore = megaCore;
    }

    @Override
    public void open() {
        User user = getUser();
        Player player = user.getPlayer();
        player.openInventory(getInventory());
    }

    @Override
    protected void setMenuItems() {
        MainConfig mainConfig = getConfigManager().getConfig(MainConfig.class);

        fillItems();

        setItem(new HeadBuilder(mainConfig.getAgronomistTexture())
                .setName(mainConfig.getAgronomistName())
                .setLore(mainConfig.getAgronomistLore())
                .toMenuItem()
                .addClickAction(event -> clickAction(new Agronomist(megaCore))),
                9);

        setItem(new HeadBuilder(mainConfig.getArtisanTexture())
                .setName(mainConfig.getArtisanName())
                .setLore(mainConfig.getArtisanLore())
                .toMenuItem()
                .addClickAction(event -> clickAction(new Artisan())),
                11);

        setItem(new HeadBuilder(mainConfig.getSonOfMarsTexture())
                .setName(mainConfig.getSonOfMarsName())
                .setLore(mainConfig.getSonOfMarsLore())
                .toMenuItem()
                .addClickAction(event -> clickAction(new SonOfMars())),
                13);

        setItem(new HeadBuilder(mainConfig.getForesterTexture())
                .setName(mainConfig.getForesterName())
                .setLore(mainConfig.getForesterLore())
                .toMenuItem()
                .addClickAction(event -> clickAction(new Forester())),
                15);

        setItem(new HeadBuilder(mainConfig.getAesculapiusTexture())
                .setName(mainConfig.getAesculapiusName())
                .setLore(mainConfig.getAesculapiusLore())
                .toMenuItem()
                .addClickAction(event -> clickAction(new Aesculapius())),
                17);
    }

    @Override
    public void handleClose(InventoryCloseEvent event) {
        if (!(event.getPlayer() instanceof Player player)) return;

        User user = UserManager.getInstance().getUser(player);
        if (user == null) return;

        if (!(event.getInventory().getHolder() instanceof ChoiceMenu)) return;
        if (!(user.getProfession() instanceof DefaultProfession)) return;

        Bukkit.getScheduler().runTaskLater(megaCore, () -> {
            Menu choiceMenu = new ChoiceMenu(user, megaCore);
            choiceMenu.open();
        }, 1L);
    }

    @Override
    public String getMenuName() {
        return getConfigManager().getConfig(MainConfig.class).getChoiceMenuName();
    }

    private void clickAction(Profession profession) {
        if (!(getUser().getProfession() instanceof DefaultProfession)) return;
        getUser().setProfession(profession);

        UserConfig userConfig = configUserManager.getAfterRomeUserConfig(getUser().getPlayer().getUniqueId());
        userConfig.saveData(userManager.getUser(getUser().getPlayer()).serialize());
        close();
    }

    private void fillItems() {
        for (int i = 0; i < getSize(); i++) {
            if (i % 2 == 0) setItem(new MenuItem(Material.WHITE_STAINED_GLASS_PANE).setName("&c"), i);
            else setItem(new MenuItem(Material.BLACK_STAINED_GLASS_PANE).setName("&c"), i);
        }
    }
}
