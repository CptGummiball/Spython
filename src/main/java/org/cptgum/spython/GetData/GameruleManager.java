package org.cptgum.spython.GetData;

import org.bukkit.Bukkit;
import org.bukkit.World;

import java.util.HashMap;
import java.util.Map;
public class GameruleManager {

    // Method to set a gamerule in a world
    public static void setGamerule(String worldName, String gamerule, Object value) {
        World world = Bukkit.getWorld(worldName);
        if (world != null) {
            if (value instanceof Integer) {
                world.setGameRuleValue(gamerule, Integer.toString((Integer) value));
            } else {
                world.setGameRuleValue(gamerule, value.toString());
            }
        }
    }

    // Method to get a gamerules value from a world
    public static Object getGamerule(String worldName, String gamerule) {
        World world = Bukkit.getWorld(worldName);
        if (world != null) {
            String value = world.getGameRuleValue(gamerule);
            if (value != null) {
                try {
                    return Integer.parseInt(value);
                } catch (NumberFormatException e) {
                    if (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false")) {
                        return Boolean.parseBoolean(value);
                    }
                }
            }
        }
        return null;
    }

    // Method to get all gamerules from a world
    public static Map<String, Object> getAllGamerules(String worldName) {
        Map<String, Object> gamerules = new HashMap<>();
        World world = Bukkit.getWorld(worldName);
        if (world != null) {
            for (String rule : world.getGameRules()) {
                String value = world.getGameRuleValue(rule);
                if (value != null) {
                    try {
                        gamerules.put(rule, Integer.parseInt(value));
                    } catch (NumberFormatException e) {
                        if (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false")) {
                            gamerules.put(rule, Boolean.parseBoolean(value));
                        } else {
                            gamerules.put(rule, value);
                        }
                    }
                }
            }
        }
        return gamerules;
    }
}
