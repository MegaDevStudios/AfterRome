package com.megadev.afterrome.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import com.megadev.afterrome.manager.UserManager;
import com.megadev.afterrome.object.user.PointsHolder;
import com.megadev.afterrome.object.user.User;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.Optional;

public class ProgCommand extends BaseCommand {
    @CommandAlias("progress|prog")
    public void onCommand(Player player) {
        Optional<User> optionalUser = UserManager.getInstance().getUser(player);

        if (optionalUser.isEmpty()) return;

        PointsHolder pointsHolder = (PointsHolder) optionalUser.get();
        int points = pointsHolder.getPoints();
//
    }
}
