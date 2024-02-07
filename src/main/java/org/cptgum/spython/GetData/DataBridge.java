package org.cptgum.spython.GetData;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldType;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Map;

@SuppressWarnings({"unused", "SpellCheckingInspection"})
public class DataBridge {

    // DATA: Get Server IP
    public static String getServerIP() {
        return Server.getServerIP();
    }

    // DATA: Get Server Port
    public static int getServerPort() {
        return Server.getServerPort();
    }

    // DATA: Get Server Address
    public static String getServerAddress() {
        return Server.getServerAddress();
    }

    // DATA: Get Server Motd
    public static String getServerMotd() {
        return Server.getServerMotd();
    }

    // FUNCTION: set server Motd
    public static void setServerMotd(String motd) {
        Server.setServerMotd(motd);
    }

    // DATA: Get Player Score
    public static int getPlayerScore(String playerName, String objectiveName) {
        return Scoreboard.getPlayerScore(playerName, objectiveName);
    }

    // DATA: Get All Scoreboards
    public static List<String> getAllScoreboards() {
        return Scoreboard.getAllScoreboards();
    }


    // DATA: Get Player List
    public static List<String> getOnlinePlayers() {
        return Server.getOnlinePlayers();
    }

    // DATA: Get Player Position
    public static List<Double> getPlayerPosition(String playerName) {
        return PlayerStatus.getPlayerPosition(playerName);
    }

    // DATA: Get Player Inventory Items
    public static List<String> getPlayerInventoryItems(String playerName) {
        return Inventory.getPlayerInventoryItems(playerName);
    }

    // DATA: Get Player Inventory Data
    public static List<ItemStack> getPlayerInventoryData(String playerName) {
        return Inventory.getPlayerInventoryData(playerName);
    }

    // DATA: Get Player Inventory NBT
    public static List<String> getPlayerInventoryNBT(String playerName) {
        return Inventory.getPlayerInventoryNBT(playerName);
    }

    // DATA: Get Chest Inventory Items
    public static List<String> getChestInventoryItems(int x, int y, int z, String worldName) {
        return Inventory.getChestInventoryItems(x, y, z, worldName);
    }

    // DATA: Get Chest Inventory Data
    public static List<ItemStack> getChestInventoryData(int x, int y, int z, String worldName) {
        return Inventory.getChestInventoryData(x, y, z, worldName);
    }

    // DATA: Get Chest Inventory NBT
    public static List<String> getChestInventoryNBT(int x, int y, int z, String worldName) {
        return Inventory.getChestInventoryNBT(x, y, z, worldName);
    }

    // DATA: get player gamemode
    public static String getPlayerGamemode(String playerName) {
        return PlayerStatus.getPlayerGamemode(playerName);
    }

    // DATA: get player health
    public static double getPlayerHealth(String playerName) {
        return (double) PlayerStatus.getPlayerHealth(playerName);
    }

    // DATA: get player food level
    public static int getPlayerFoodLevel(String playerName) {
        return (int) PlayerStatus.getPlayerFoodLevel(playerName);
    }

    // DATA: get player experience
    public static float getPlayerExperience(String playerName) {
        return (float) PlayerStatus.getPlayerExperience(playerName);
    }

    // DATA: get all gamerules
    public static Map<String, Object> getAllGamerules(String worldName) {
        return GameruleManager.getAllGamerules(worldName);
    }

    // DATA: get a gamerule
    public static Object getGamerule(String worldName, String gamerule) {
        return GameruleManager.getGamerule(worldName, gamerule);
    }

    // FUNCTION: set a gamerule
    public static void setGamerule(String worldName, String gamerule, Object value) {
        GameruleManager.setGamerule(worldName, gamerule, value);
    }

    // FUNCTION: set weather in a world
    public static void setWeather(String worldName, String weatherType) {
        WorldControl.setWeather(worldName, weatherType);
    }

    // DATA: get weather in a world
    public static String getWeather(String worldName) {
        return WorldControl.getWeather(worldName);
    }

    // FUNCTION: set time in a world
    public static void setTime(String worldName, long time) {
        WorldControl.setTime(worldName, time);
    }

    // DATA: get time in a world
    public static long getTime(String worldName) {
        return WorldControl.getTime(worldName);
    }

    // FUNCTION: create a new world
    public static void createWorld(String worldName, WorldType worldType, World.Environment environment) {
        WorldControl.createWorld(worldName, worldType, environment);
    }

    // FUNCTION: delete a world
    public static void deleteWorld(String worldName) {
        WorldControl.deleteWorld(worldName);
    }

    // FUNCTION: teleport a player to specific coordinates in a world
    public static void teleportPlayer(String playerName, double x, double y, double z, String worldName) {
        Teleport.teleportPlayer(playerName, x, y, z, worldName);
    }

    // FUNCTION: teleport a player to another player
    public static void teleportPlayerToPlayer(String playerName, String targetPlayerName) {
        Teleport.teleportPlayerToPlayer(playerName, targetPlayerName);
    }

    // FUNCTION: teleport all players to specific coordinates in a world
    public static void teleportAllPlayers(double x, double y, double z, String worldName) {
        Teleport.teleportAllPlayers(x, y, z, worldName);
    }

    // FUNCTION: teleport all players to a specific player
    public static void teleportAllPlayersToPlayer(String targetPlayerName) {
        Teleport.teleportAllPlayersToPlayer(targetPlayerName);
    }

    // FUNCTION: kick a player
    public static void kickPlayer(String playerName, String kickMessage) {
        KickBan.kickPlayer(playerName, kickMessage);
    }

    // FUNCTION: ban a player
    public static void banPlayer(String playerName, String banMessage) {
        KickBan.banPlayer(playerName, banMessage);
    }

    // DATA: query data from file
    public static Object queryData(String filePath, Files.FileType fileType) {
        return Files.queryData(filePath, fileType);
    }

    // FUNCTION: write data to file
    public static void writeData(String filePath, Files.FileType fileType, Object data) {
        Files.writeData(filePath, fileType, data);
    }

    // FUNCTION: Execute a command as the console
    public static void executeConsoleCommand(String command) {
        RunCommand.executeConsoleCommand(command);
    }

    // FUNCTION: Execute a command as a player
    public static void executePlayerCommand(String playerName, String command) {
        RunCommand.executePlayerCommand(playerName, command);
    }
}
