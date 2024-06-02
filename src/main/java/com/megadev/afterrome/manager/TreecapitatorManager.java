package com.megadev.afterrome.manager;

import com.megadev.afterrome.util.TreeCapitator;
import dev.mega.megacore.MegaCore;
import dev.mega.megacore.manager.Manager;
import lombok.Getter;
import org.bukkit.block.Block;

public class TreecapitatorManager extends Manager {
    public TreecapitatorManager(MegaCore megaCore) {
        super(megaCore);
    }

    @Override
    public void enable() {
        setRunning(true);
    }

    @Override
    public void disable() {
        setRunning(false);
    }

    public void treeCapitate(Block block) {
        TreeCapitator treeCapitator = new TreeCapitator(megaCore, block.getLocation(), block.getType());
        treeCapitator.treeCapitate();
    }
}
