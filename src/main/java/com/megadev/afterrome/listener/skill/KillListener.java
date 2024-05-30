package com.megadev.afterrome.listener.skill;

import com.megadev.afterrome.manager.UserManager;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.SkillType;
import com.megadev.afterrome.object.profession.Agronomist;
import com.megadev.afterrome.object.profession.Profession;
import org.bukkit.Material;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class KillListener implements Listener {
    @EventHandler
    public void onKill(EntityDeathEvent event) {
        Entity entity = event.getEntity();

        boolean isCattle = entity instanceof Animals;

        if (!isCattle) {
            return;
        }

        Profession profession = UserManager.getInstance().getUser(event.getEntity().getKiller()).getProfession();
        if (!(profession instanceof Agronomist)) {
            return;
        }

        if (event.getDrops().stream().anyMatch(drop -> drop.getType().equals(Material.BEEF))) {
            profession.getSkill(SkillType.BUTCHER).execute(event);
        } else if (event.getDrops().stream().anyMatch(drop -> drop.getType().equals(Material.LEATHER))) {
            profession.getSkill(SkillType.TANNER).execute(event);
        }
    }
}
