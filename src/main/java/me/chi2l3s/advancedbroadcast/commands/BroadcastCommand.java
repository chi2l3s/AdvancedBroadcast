package me.chi2l3s.advancedbroadcast.commands;

import me.chi2l3s.advancedbroadcast.AdvancedBroadcast;
import me.chi2l3s.advancedbroadcast.utils.ColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BroadcastCommand implements CommandExecutor {

    private final AdvancedBroadcast plugin;

    public BroadcastCommand(AdvancedBroadcast plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player){
            if (player.hasPermission("advancedbroadcast.send")){
                if (args.length == 0){
                    String noArgsMessage = plugin.getConfig().getString("no-args");
                    player.sendMessage(ColorUtil.message(ChatColor.translateAlternateColorCodes('&',noArgsMessage)));
                }else{
                    StringBuilder builder = new StringBuilder();
                    for(int i = 0; i < args.length; i++){
                        builder.append(args[i]);
                        builder.append(" ");
                    }
                    String message = builder.toString().stripTrailing();
                    String playerName = player.getDisplayName();
                    String broadcastMessage = plugin.getConfig().getString("broadcast");
                    broadcastMessage = broadcastMessage.replaceAll("%message%", message);
                    broadcastMessage = broadcastMessage.replaceAll("%sender%", playerName);
                    Bukkit.broadcastMessage(ColorUtil.message(ChatColor.translateAlternateColorCodes('&',broadcastMessage)));
                }
            }else{
                player.sendMessage(ColorUtil.message(ChatColor.translateAlternateColorCodes('&',plugin.getConfig().getString("no-permission"))));
            }
        }

        return true;
    }
}
