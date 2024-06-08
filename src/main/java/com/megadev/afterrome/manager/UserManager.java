package com.megadev.afterrome.manager;

import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.config.user.ConfigUserManager;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;
import com.megadev.afterrome.object.profession.*;
import com.megadev.afterrome.object.skill.XSkill;
import com.megadev.afterrome.object.user.AfterRomeUser;
import com.megadev.afterrome.object.user.User;

import dev.mega.megacore.MegaCore;
import dev.mega.megacore.config.serializer.JsonSerializer;
import dev.mega.megacore.manager.Manager;
import lombok.Getter;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.*;

@Getter
public class UserManager extends Manager {
    private final Set<User> users = new HashSet<>();

    public UserManager(MegaCore megaCore) {
        super(megaCore);
    }

    public void serializeUser(User user) {
        List<Skill> skillList = user.getProfession().getSkills();
        List<XSkill> xSkills = new ArrayList<>();
        skillList.forEach(skill -> xSkills.add(new XSkill(skill.getSkillType(), skill.getLevel())));

        XProfession xProfession = new XProfession(user.getProfession().getProfessionType(), xSkills);

        AfterRomeUser afterRomeUser = (AfterRomeUser) user;
        XUser xUser = new XUser(user.getUuid().toString(), xProfession, afterRomeUser.getHealths(), afterRomeUser.getPoints());

        JsonSerializer.serialize(new File("data/" + user.getUuid().toString()), xUser);
    }

    public Profession getProfessionOf(XProfession xProfession) {
//        List<Skill> skillList = new ArrayList<>();
//        xProfession.getSkill().forEach(xSkill -> skillList.add(new S));

        ///FUCKKKKKKKKKKKKKKKKKKKKKKKKKK
        //I don't want to implement that's all...................

        return switch (xProfession.getProfessionType()) {
            case DEFAULT -> new DefaultProfession();
            case AESCULAPIUS -> new Aesculapius();
            case AGRONOMIST -> new Agronomist();
            case ARTISAN -> new Artisan();
            case ENGINEER -> new Engineer();
            case FORESTER -> new Forester();
            case INITIATED -> new Initiated();
            case MAFIA -> new Mafia();
            case SANTA -> new Santa();
            case SHERIFF -> new Sheriff();
            case SON_OF_MARS -> new SonOfMars();
        };
    }

    public void loadUsers() {
        ConfigManager configManager = ConfigManager.getInstance();
        ConfigUserManager configUserManager = configManager.getConfig(ConfigUserManager.class);

        for (Player player : Bukkit.getOnlinePlayers()) {
            if (configUserManager.userExist(player.getUniqueId())) {
                XUser xUser = (XUser) JsonSerializer.deserialize(new File("data/" + player.getUniqueId()), XUser.class);

                if (xUser == null) {
                    saveUser(player);
                } else {
                    //TODO: Fuck, do it, fucking implement your SHITCODE
//                    saveUser(new AfterRomeUser(UUID.fromString(xUser.getUuid()), xUser.getProfession(), xUser.getHealths(), xUser.getPoints()));
                }


            } else {
                saveUser(player);
            }
        }
    }

    public void saveUser(Player player) {
        saveUser(new AfterRomeUser(player));
    }

    public void saveUser(AfterRomeUser afterRomeUser) {
        users.add(afterRomeUser);
    }

    public boolean userExist(Player player) {
        return getUser(player) != null;
    }

    public User getUser(Player player) {
        return users.stream()
                .filter(user -> user.getUuid().equals(player.getUniqueId()))
                .findFirst().orElse(null);
    }

    public void printUsers() {
        System.out.println("==================================================================");
        for (User user : users)
            System.out.println(user + " " + user.getPlayer().getName());
        System.out.println("==================================================================");
    }

    @Override
    public void enable() {
        loadUsers();
        setRunning(true);
    }

    @Override
    public void disable() {
        setRunning(false);
    }
}
