package org.cptgum.spython;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ExecutePythonCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player) && args.length < 1) {
            sender.sendMessage(ChatColor.YELLOW + "Please specify a script to execute.");
            return true;
        }
        // Check if the player has permission to execute the command
        if (!sender.hasPermission("spython.executepython")) {
            sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command.");
            return true;
        }

        String scriptName = args[0];
        // Call the Python script executor
        PythonExecutor.executeScript(scriptName, sender);
        sender.sendMessage(ChatColor.GREEN + "Python script '" + scriptName + "' executed.");
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            // Autocomplete script names from the specified directory
            File scriptDir = new File("./plugins/spython/scripts");
            String[] scriptFiles = scriptDir.list((dir, name) -> name.endsWith(".py"));
            if (scriptFiles != null) {
                List<String> scriptNames = new ArrayList<>();
                for (String scriptFile : scriptFiles) {
                    scriptNames.add(scriptFile.replace(".py", ""));
                }
                return scriptNames;
            }
        }
        return null;
    }
}
