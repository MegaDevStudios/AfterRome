package com.megadev.afterrome.manager;

import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.config.manager.ShopManager;
import com.megadev.afterrome.config.shop.ShopConfig;
import com.megadev.afterrome.listener.MenuTrait;
import dev.mega.megacore.MegaCore;
import dev.mega.megacore.manager.Manager;
import lombok.Getter;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.Plugin;

public class NPCManager extends Manager {
    private final ShopConfig shopConfig = ConfigManager.getInstance().getManager(ShopManager.class).getConfig(ShopConfig.class);

    @Getter
    private static NPCManager instance;
    private Location location;
    private NPC npc;

    private NPCManager(MegaCore megaCore) {
        super(megaCore);
    }

    public static void init(MegaCore plugin) {
        if (instance == null)
            instance = new NPCManager(plugin);
    }

    @Override
    public void reload() {
        disable();
        spawnNPC();
    }

    public void spawnNPC() {
        location = shopConfig.getNpcLocation();
        spawnNPCAt(location);
    }

    public void spawnNPCAt(Location location) {
        String name = shopConfig.getNpcName();

        npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, name);
        npc.addTrait(MenuTrait.class);

        npc.spawn(location);
    }

    @Override
    public void disable() {
        npc.destroy();
    }
}
