package com.megadev.afterrome.object.menu.shop.upgrade.skill.artisan;

import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.config.shop.upgrade.ArtisanUpgradeShopConfig;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.SkillType;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.configuration.serialization.SerializableAs;
import org.bukkit.event.Event;

@Getter
@SerializableAs("fisherman")
public class Fisherman implements Skill {
    private final MenuItem menuItem = ConfigManager.getInstance().getConfig(ArtisanUpgradeShopConfig.class).getFishermanItem();
    @Setter
    private int level;

    public Fisherman(int level) {
        this.level = level;
    }

    @Override
    public String getName() {
        return ConfigManager.getInstance().getConfig(ArtisanUpgradeShopConfig.class).getFishermanName();
    }

    @Override
    public SkillType getSkillType() {
        return SkillType.FISHERMAN;
    }

    @Override
    public void execute(Event event) {

    }

    static {
        ConfigurationSerialization.registerClass(Fisherman.class);
    }
}
