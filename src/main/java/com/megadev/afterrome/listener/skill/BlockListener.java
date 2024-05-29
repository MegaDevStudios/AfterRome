package com.megadev.afterrome.listener.skill;

import com.megadev.afterrome.manager.UserManager;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.SkillType;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.agronomist.AgronomistSkill;
import com.megadev.afterrome.object.profession.Agronomist;
import com.megadev.afterrome.object.profession.Profession;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockListener implements Listener {
    @EventHandler
    public void onCropBreak(BlockBreakEvent event) {
        if (!event.isDropItems()) {
            return;
        }

        Player player = event.getPlayer();

        Block block = event.getBlock();

        Profession profession = UserManager.getInstance().getUser(player).getProfession();

        if (!(profession instanceof Agronomist)) {
            return;
        }

        if (block.getBlockData() instanceof Ageable) {
            profession.getSkill(SkillType.FARMER).execute(event);
        }
    }
}
