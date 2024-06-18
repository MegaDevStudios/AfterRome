package dev.mega.afterromeimpl;

import dev.mega.afterrome.AfterRome;
import dev.mega.afterrome.api.AfterRomeAPI;
import dev.mega.afterrome.config.data.ConfigData;
import dev.mega.afterrome.manager.ProfessionManager;
import dev.mega.afterrome.manager.UserManager;
import dev.mega.afterrome.parser.Parser;
import dev.mega.afterromeimpl.api.ArAPIHandler;
import dev.mega.afterromeimpl.listener.ChoiceClassListener;
import dev.mega.afterromeimpl.listener.MenuListener;
import dev.mega.afterromeimpl.parser.ArParserHandler;
import dev.mega.megacore.manager.MegaManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class AfterRomeImpl extends AfterRome {
    public AfterRomeImpl() {
        super("dev.mega.afterromeimpl.manager", "dev.mega.afterromeimpl.listener");
    }

    @Override
    protected void enableImpl() {
        AfterRomeAPI.setApi(new ArAPIHandler(this));
        AfterRomeAPI.setAfterRomeImpl(this);

        MegaManager.getManager(UserManager.class) .loadUsers();

        tryToInitializeParser();

        registerListeners();
    }

    private void tryToInitializeParser() {
        if (!Parser.getInstance().isInitialized()) {
            ConfigData configData = MegaManager.getManager(ProfessionManager.class).getConfigData();

            if (configData != null) {
                Parser.getInstance().setParserHandler(new ArParserHandler(configData));
            }
        }
    }

    private void registerListeners() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new ChoiceClassListener(this), this);
        pluginManager.registerEvents(new MenuListener(), this);
    }

    @Override
    protected void disableImpl() {
    }
}
