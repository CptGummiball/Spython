package org.cptgum.spython.GetData;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.World.Environment;
public class WorldControl {

    // Method to set weather in a world
    public static void setWeather(String worldName, String weatherType) {
        World world = Bukkit.getWorld(worldName);
        if (world != null) {
            if (weatherType.equalsIgnoreCase("clear")) {
                world.setStorm(false);
                world.setThundering(false);
            } else if (weatherType.equalsIgnoreCase("rain")) {
                world.setStorm(true);
                world.setThundering(false);
            } else if (weatherType.equalsIgnoreCase("thunderstorm")) {
                world.setStorm(true);
                world.setThundering(true);
            }
        }
    }

    // Method to set time in a world
    public static void setTime(String worldName, long time) {
        World world = Bukkit.getWorld(worldName);
        if (world != null) {
            world.setTime(time);
        }
    }

    // Method to create a new world
    public static void createWorld(String worldName, WorldType worldType, Environment environment) {
        WorldCreator worldCreator = new WorldCreator(worldName);
        worldCreator.type(worldType);
        worldCreator.environment(environment);
        Bukkit.createWorld(worldCreator);
    }

    // Method to delete a world
    public static void deleteWorld(String worldName) {
        World world = Bukkit.getWorld(worldName);
        if (world != null) {
            Bukkit.unloadWorld(world, false);
            java.nio.file.Path worldPath = world.getWorldFolder().toPath();
            try {
                java.nio.file.Files.walk(worldPath)
                        .sorted(java.util.Comparator.reverseOrder())
                        .map(java.nio.file.Path::toFile)
                        .forEach(java.io.File::delete);
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to get weather in a world
    public static String getWeather(String worldName) {
        World world = Bukkit.getWorld(worldName);
        if (world != null) {
            if (world.hasStorm()) {
                return world.isThundering() ? "thunderstorm" : "rain";
            } else {
                return "clear";
            }
        }
        return "unknown";
    }

    // Method to get time in a world
    public static long getTime(String worldName) {
        World world = Bukkit.getWorld(worldName);
        if (world != null) {
            return world.getTime();
        }
        return -1;
    }
}
