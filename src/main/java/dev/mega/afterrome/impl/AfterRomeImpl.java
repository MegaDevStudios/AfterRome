package dev.mega.afterrome.impl;

import dev.mega.afterrome.core.AfterRome;
import dev.mega.afterrome.core.api.AfterRomeAPI;
import dev.mega.afterrome.core.config.data.ConfigData;
import dev.mega.afterrome.core.manager.ConfigDataManager;
import dev.mega.afterrome.core.manager.ProfessionManager;
import dev.mega.afterrome.core.manager.UserManager;
import dev.mega.afterrome.core.parser.Parser;
import dev.mega.afterrome.impl.api.ArAPIHandler;
import dev.mega.afterrome.impl.listener.ChoiceClassListener;
import dev.mega.afterrome.impl.listener.MenuListener;
import dev.mega.afterrome.impl.parser.ArParserHandler;
import dev.mega.megacore.manager.MegaManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class AfterRomeImpl extends AfterRome {
    public AfterRomeImpl() {
        super("dev.mega.afterrome.impl.manager", "dev.mega.afterrome.impl.listener");
    }

    @Override
    protected void enableImpl() {
        AfterRomeAPI.setApi(new ArAPIHandler(this));
        AfterRomeAPI.setAfterRomeImpl(this);

        MegaManager.getManager(UserManager.class).loadUsers();

        tryToInitializeParser();

        MegaManager.getManager(ProfessionManager.class).loadProfessions();

        registerListeners();
    }

    private void tryToInitializeParser() {
            if (!Parser.getInstance().isInitialized()) {
            ConfigData configData = MegaManager.getManager(ConfigDataManager.class).getConfigData();

            if (configData != null) {
                Parser.getInstance().setParserHandler(new ArParserHandler(configData));
            }
        }
    }

    private void registerListeners() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new ChoiceClassListener(this), this);
        pluginManager.registerEvents(new MenuListener(this), this);
    }

    @Override
    protected void disableImpl() {
    }
}
