package org.cptgum.spython;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

        String fullPath = args[0];
        // Call the Python script executor
        PythonExecutor.executeScript(fullPath);
        sender.sendMessage(ChatColor.GREEN + "Python script '" + fullPath + "' executed.");
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            String input = args[0].toLowerCase();

            File pluginsDir = new File("./plugins");
            if (pluginsDir.exists() && pluginsDir.isDirectory()) {
                completions.addAll(findScripts(pluginsDir, input));
            }
        }

        return completions;
    }

    private List<String> findScripts(File directory, String input) {
        List<String> scripts = new ArrayList<>();

        if (directory.exists() && directory.isDirectory()) {
            scripts.addAll(Arrays.stream(directory.listFiles())
                    .filter(file -> file.getName().endsWith(".py"))
                    .map(file -> file.toPath().toString().replace("\\", "/"))
                    .map(scriptName -> scriptName.replace("./plugins/", ""))
                    .map(scriptName -> scriptName.toLowerCase().startsWith(input) ? scriptName : null)
                    .filter(scriptName -> scriptName != null)
                    .toList());

            scripts.addAll(Arrays.stream(directory.listFiles(File::isDirectory))
                    .filter(subdir -> !shouldIgnore(subdir))
                    .flatMap(subdir -> findScripts(subdir, input).stream())
                    .collect(Collectors.toList())
            );
        }

        return scripts;
    }

    private boolean shouldIgnore(File dir) {
        String dirName = dir.getName().toLowerCase();
        return dirName.equals("libs") || dirName.equals("libary") || dirName.equals("libaries");
    }
}
