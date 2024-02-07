package org.cptgum.spython.GetData;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scoreboard {

    // Method to get player score from scoreboard
    public static int getPlayerScore(String playerName, String objectiveName) {
        Player player = Bukkit.getPlayerExact(playerName);
        if (player != null) {
            Objective objective = player.getScoreboard().getObjective(objectiveName);
            if (objective != null) {
                return objective.getScore(player.getName()).getScore();
            }
        }
        return 0; // Default value if player or objective is not found
    }

    // Method to get a list of all scoreboards on the server
    public static List<String> getAllScoreboards() {
        List<String> scoreboardNames = new ArrayList<>();

        for (Player player : Bukkit.getOnlinePlayers()) {
            for (Objective objective : player.getScoreboard().getObjectives()) {
                scoreboardNames.add(objective.getDisplayName());
            }
        }

        return scoreboardNames;
    }
}

