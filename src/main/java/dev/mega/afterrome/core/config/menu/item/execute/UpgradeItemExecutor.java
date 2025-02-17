package dev.mega.afterrome.core.config.menu.item.execute;

import dev.mega.afterrome.core.user.Skill;
import dev.mega.afterrome.core.user.User;
import org.bukkit.inventory.ItemStack;

public class UpgradeItemExecutor implements ItemExecute {
    @Override
    public void execute(User user, ItemStack itemStack, String ID) {
        if (user.getPoints() <= 0) return;

        for (Skill skill : user.getProfession().getSkills()) {
            if (skill.getName().equals(ID)) {
                user.setPoints(user.getPoints() - 1);
                skill.incrementAndGet();
            }
        }
    }
}
