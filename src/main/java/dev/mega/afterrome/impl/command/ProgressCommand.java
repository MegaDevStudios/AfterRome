package dev.mega.afterrome.impl.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import dev.mega.afterrome.core.api.AfterRomeAPI;
import dev.mega.afterrome.core.user.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Optional;

public class ProgressCommand extends BaseCommand {
    @CommandAlias("progress|prog")
    public void onCommand(Player player) {
        Optional<User> optionalUser = AfterRomeAPI.getUser(player);
        if (optionalUser.isEmpty()) return;
        User user = optionalUser.get();

        int points = user.getPoints();

        Bukkit.getPlayer(user.getUuid()).sendMessage("У вас " + points + " поинтов");
    }
}
