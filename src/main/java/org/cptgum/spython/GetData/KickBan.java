package org.cptgum.spython.GetData;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class KickBan {

    // Method to kick a player
    public static void kickPlayer(String playerName, String kickMessage) {
        Player player = Bukkit.getPlayerExact(playerName);
        if (player != null) {
            player.kickPlayer(kickMessage);
        }
    }

    // Method to ban a player
    public static void banPlayer(String playerName, String banMessage) {
        Player player = Bukkit.getPlayerExact(playerName);
        if (player != null) {
            player.kickPlayer(banMessage);
        }
    }
}
