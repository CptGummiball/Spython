package org.cptgum.spython.GetData;

import org.bukkit.Bukkit;

public class RunCommand {

    // FUNCTION: Execute a command as the console
    public static void executeConsoleCommand(String command) {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
    }

    // FUNCTION: Execute a command as a player
    public static void executePlayerCommand(String playerName, String command) {
        Bukkit.dispatchCommand(Bukkit.getPlayerExact(playerName), command);
    }
}
