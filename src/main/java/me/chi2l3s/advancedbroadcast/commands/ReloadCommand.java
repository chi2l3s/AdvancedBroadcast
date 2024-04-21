package me.chi2l3s.advancedbroadcast.commands;

import me.chi2l3s.advancedbroadcast.AdvancedBroadcast;
import me.chi2l3s.advancedbroadcast.utils.ColorUtil;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand implements CommandExecutor {

    private final AdvancedBroadcast plugin;

    public ReloadCommand(AdvancedBroadcast plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player){
            if (player.hasPermission("advancedbroadcast.admin")){
                plugin.reloadConfig();
                player.sendMessage(ColorUtil.message(ChatColor.translateAlternateColorCodes('&',plugin.getConfig().getString("config-reload"))));
            }else{
                player.sendMessage(ColorUtil.message(ChatColor.translateAlternateColorCodes('&',plugin.getConfig().getString("no-permission"))));
            }
        }

        return true;
    }
}
