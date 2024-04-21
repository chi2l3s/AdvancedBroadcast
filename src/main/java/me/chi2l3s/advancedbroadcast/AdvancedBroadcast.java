package me.chi2l3s.advancedbroadcast;

import me.chi2l3s.advancedbroadcast.commands.BroadcastCommand;
import me.chi2l3s.advancedbroadcast.commands.ReloadCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class AdvancedBroadcast extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getCommand("broadcast").setExecutor(new BroadcastCommand(this));
        getCommand("advancedbrodcast").setExecutor(new ReloadCommand(this));

    }

}
