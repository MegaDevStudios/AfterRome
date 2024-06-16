package dev.mega.afterrome.manager;

import dev.mega.afterrome.config.data.ConfigData;
import dev.mega.afterrome.listener.ProfessionListener;
import dev.mega.afterrome.parser.Parser;
import dev.mega.afterrome.user.Profession;
import dev.mega.megacore.MegaCore;
import dev.mega.megacore.config.serializer.JsonSerializer;
import dev.mega.megacore.manager.Manager;
import dev.mega.megacore.util.MegaCoreUtil;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Class represents the manager to manage profession events.
 */
@Getter
public class ProfessionManager extends Manager {
    private final String dataFolder = megaCore.getDataFolder().getAbsolutePath() + File.separator + "xdev/";

    private ConfigData configData;
    private final List<Profession> professionListMap = new ArrayList<>();

    public ProfessionManager(MegaCore megaCore) {
        super(megaCore);
    }

    /**
     * Registers the listener for professions events.
     * @param events
     */
    public void registerEvents(List<String> events) {
        Bukkit.getPluginManager().registerEvents(new ProfessionListener(megaCore, events), megaCore);
    }

    /**
     * Adds the profession to list.
     * @param profession
     */
    public void add(Profession profession) {
        professionListMap.add(profession);
    }

    /**
     * Gets cloned default profession.
     * @return default profession.
     */
    public Profession getDefault() {
        if (!professionListMap.isEmpty())
            return Profession.copyOf(professionListMap.get(0));
        return Profession.of("default", new ArrayList<>());
    }

    /**
     * Gets profession by name.
     * @return profession.
     */
    public Profession getProfession(String professionName) {
        Optional<Profession> optionalProfession = professionListMap
                .stream()
                .filter(profession -> professionName.equals(profession.getName()))
                .findAny();

        return optionalProfession.orElseGet(() -> Profession.copyOf(professionListMap.get(0)));
    }

    /**
     * Calls when manager enables.
     */
    @Override
    public void enable() {

        configData = (ConfigData) JsonSerializer.deserialize(
                new File(dataFolder + File.separator + "professions.json"), ConfigData.class);


        MegaCoreUtil.getLogger().warning("Profession config file not found");

        Bukkit.getScheduler().runTaskLater(megaCore,
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        professionListMap.addAll(Parser.getInstance().getProfessions());

                    }
                }, 40);

    }

    /**
     * Calls when manager disables.
     */
    @Override
    public void disable() {

    }
}
