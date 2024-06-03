package com.megadev.afterrome.listener.skill;

import com.megadev.afterrome.manager.UserManager;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.SkillType;
import com.megadev.afterrome.object.profession.Agronomist;
import com.megadev.afterrome.object.profession.Profession;
import dev.mega.megacore.manager.MegaManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;

public class SpawnListener implements Listener {
    @EventHandler
    public void onSpawn(PlayerEggThrowEvent event) {
        Profession profession = MegaManager.getManager(UserManager.class).getUser(event.getPlayer()).getProfession();
        if (!(profession instanceof Agronomist)) {
            return;
        }

        profession.getSkill(SkillType.HATCHER).execute(event);
    }
}
