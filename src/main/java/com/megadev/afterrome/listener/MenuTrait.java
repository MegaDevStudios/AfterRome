package com.megadev.afterrome.listener;

import dev.mega.megacore.MegaCore;
import dev.mega.megacore.util.MegaCoreUtil;
import net.citizensnpcs.api.trait.Trait;
import net.citizensnpcs.api.trait.TraitName;
import org.bukkit.event.EventHandler;

@TraitName("menutrait")
public class MenuTrait extends Trait {
    private final MegaCore megaCore;

    public MenuTrait(MegaCore megaCore) {
        super("menutrait");
        this.megaCore = megaCore;
    }

    @EventHandler
    public void onSpawn() {
        MegaCoreUtil.getLogger().info("NPC just spawned!");
    }

    @EventHandler
    public void onDespawn() {
        MegaCoreUtil.getLogger().info("NPC despaired!");
    }

    @EventHandler
    public void click(net.citizensnpcs.api.event.NPCRightClickEvent event){
        if (event.getNPC() != this.getNPC()) return;

        MegaCoreUtil.getLogger().info(event.getClicker().getName() + " clicked at NPC");
    }
}
