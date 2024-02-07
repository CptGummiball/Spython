package org.cptgum.spython.GetData;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Teleport {

    // Method to teleport a player to specific coordinates in a world
    public static void teleportPlayer(String playerName, double x, double y, double z, String worldName) {
        Player player = Bukkit.getPlayerExact(playerName);
        if (player != null) {
            World world = Bukkit.getWorld(worldName);
            if (world != null) {
                Location location = new Location(world, x, y, z);
                player.teleport(location);
            }
        }
    }

    // Method to teleport a player to another player
    public static void teleportPlayerToPlayer(String playerName, String targetPlayerName) {
        Player player = Bukkit.getPlayerExact(playerName);
        Player targetPlayer = Bukkit.getPlayerExact(targetPlayerName);

        if (player != null && targetPlayer != null) {
            player.teleport(targetPlayer.getLocation());
        }
    }

    // Method to teleport all players to specific coordinates in a world
    public static void teleportAllPlayers(double x, double y, double z, String worldName) {
        World world = Bukkit.getWorld(worldName);
        if (world != null) {
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                Location location = new Location(world, x, y, z);
                onlinePlayer.teleport(location);
            }
        }
    }
    // Method to teleport all players to a specific player
    public static void teleportAllPlayersToPlayer(String targetPlayerName) {
        Player targetPlayer = Bukkit.getPlayerExact(targetPlayerName);
        if (targetPlayer != null) {
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                onlinePlayer.teleport(targetPlayer.getLocation());
            }
        }
    }

}
