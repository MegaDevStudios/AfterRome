package com.megadev.afterrome.listener.skill;

import com.megadev.afterrome.manager.UserManager;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.SkillType;
import com.megadev.afterrome.object.profession.Agronomist;
import com.megadev.afterrome.object.profession.Profession;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDropItemEvent;

public class BlockListener implements Listener {
    @EventHandler
    public void onCropBreak(BlockDropItemEvent event) {
        if (event.getItems().isEmpty()) return;

        Block block = event.getBlock();

        Profession profession = UserManager.getInstance().getUser(event.getPlayer()).getProfession();

        if (!(profession instanceof Agronomist)) return;

        if (block.getBlockData() instanceof Ageable) {
            profession.getSkill(SkillType.FARMER).execute(event);
        }
    }
}
