package org.cptgum.spython;

import java.io.File;
public class FolderUtil {
    public static void createScriptFolder() {
        // Set Paths
        File pluginFolder = Spython.getInstance().getDataFolder();
        File scriptFolder = new File(pluginFolder, "scripts");

        // Create the script folder if it doesn't exist
        if (!scriptFolder.exists()) {
            if (scriptFolder.mkdirs()) {
                Spython.getInstance().getLogger().info("Script folder created successfully.");
            } else {
                Spython.getInstance().getLogger().warning("Failed to create script folder.");
            }
        } else {
            Spython.getInstance().getLogger().info("Script folder already exists.");
        }
    }
}
