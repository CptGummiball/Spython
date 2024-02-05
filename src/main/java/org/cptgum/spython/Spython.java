package org.cptgum.spython;

import org.bukkit.plugin.java.JavaPlugin;

public final class Spython extends JavaPlugin {

    private static Spython instance;

    @Override
    public void onEnable() {
        instance = this;
        VersionChecker.checkVersion();
        getCommand("executepython").setExecutor(new ExecutePythonCommand());
        getLogger().info("Spython has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Spython has been disabled!");
    }

    public static Spython getInstance() {
        return instance;
    }
}
