package org.cptgum.spython.GetData;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.cptgum.spython.Spython;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Server {

    // Method to get server IP
    public static String getServerIP() {
        try {
            URL url = new URL("http://checkip.amazonaws.com");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            return br.readLine().trim();
        } catch (IOException e) {
            Spython.getInstance().getLogger().severe("Error fetching external IP" + e.getMessage());
            return null;
        }
    }

    // Method to get the server port
    public static int getServerPort() {
        return Bukkit.getServer().getPort();
    }

    public static String getServerAddress() {
        String serverIP = getServerIP();
        int serverPort = getServerPort();

        if (serverIP != null) {
            return serverIP + ":" + serverPort;
        } else {
            // Return a default value or handle the case when server IP is not available
            return "Unknown";
        }
    }

    // Method to get online players
    public static List<String> getOnlinePlayers() {
        List<String> onlinePlayers = new ArrayList<>();
        for (Player player : Bukkit.getOnlinePlayers()) {
            onlinePlayers.add(player.getName());
        }
        return onlinePlayers;
    }

    // Method to get server Motd
    public static String getServerMotd() {
        return Bukkit.getServer().getMotd();
    }

    // Method to set server Motd
    public static void setServerMotd(String motd) {
        Bukkit.getServer().setMotd(motd);
    }
}
