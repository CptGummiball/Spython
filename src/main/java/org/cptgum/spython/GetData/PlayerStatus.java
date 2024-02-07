package org.cptgum.spython.GetData;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerStatus {

    // Method to get player status
    public static Map<String, Object> getPlayerStatus(String playerName) {
        Map<String, Object> playerStatus = new HashMap<>();
        Player player = Bukkit.getPlayerExact(playerName);
        if (player != null) {
            // Gamemode
            playerStatus.put("gamemode", player.getGameMode().toString());

            // Health
            playerStatus.put("health", player.getHealth());

            // Food
            playerStatus.put("food", player.getFoodLevel());

            // EXP
            playerStatus.put("experience", player.getExp());
        }
        return playerStatus;
    }

    // Method to get player gamemode
    public static String getPlayerGamemode(String playerName) {
        Map<String, Object> playerStatus = getPlayerStatus(playerName);
        return playerStatus.get("gamemode").toString();
    }

    // Method to get player health
    public static double getPlayerHealth(String playerName) {
        Map<String, Object> playerStatus = getPlayerStatus(playerName);
        return (double) playerStatus.get("health");
    }

    // Method to get player food level
    public static int getPlayerFoodLevel(String playerName) {
        Map<String, Object> playerStatus = getPlayerStatus(playerName);
        return (int) playerStatus.get("food");
    }

    // Method to get player experience
    public static float getPlayerExperience(String playerName) {
        Map<String, Object> playerStatus = getPlayerStatus(playerName);
        return (float) playerStatus.get("experience");
    }

    // Methode to get player positions
    public static List<Double> getPlayerPosition(String playerName) {
        List<Double> position = new ArrayList<>();
        Player player = Bukkit.getPlayerExact(playerName);
        if (player != null) {
            position.add(player.getLocation().getX());
            position.add(player.getLocation().getY());
            position.add(player.getLocation().getZ());
        }
        return position;
    }
}
