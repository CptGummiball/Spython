package org.cptgum.spython;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class VersionChecker {

    public static void checkVersion() {
        try {
            // Read the version from the jar file
            InputStream jarVersionStream = VersionChecker.class.getResourceAsStream("/version.yml");
            int jarVersion = readVersionFromStream(jarVersionStream);

            // Read the version from the plugin file
            File pluginVersionFile = new File(Spython.getInstance().getDataFolder(), "version.yml");

            // Check if the plugin version file exists
            if (!pluginVersionFile.exists()) {
                Spython.getInstance().getLogger().info("No version.yml found. Performing initial setup...");
                ResourceUtil.copyResourceFolder("libraries", "libs");
                FolderUtil.createScriptFolder();
                Spython.getInstance().saveResource("version.yml", true);
                Spython.getInstance().getLogger().info("Initial setup completed successfully.");
                return; // No need to proceed with version comparison
            }

            int pluginVersion = readVersionFromFile(pluginVersionFile.toPath());

            // Compare the versions
            if (jarVersion > pluginVersion) {
                Spython.getInstance().getLogger().info("Updating files...");
                ResourceUtil.copyResourceFolder("libraries", "libs");
                Spython.getInstance().saveResource("version.yml", true);
                Spython.getInstance().getLogger().info("Files updated successfully.");
            } else {
                Spython.getInstance().getLogger().info("Plugin version is up to date.");
            }
        } catch (Exception e) {
            Spython.getInstance().getLogger().severe("Failed to check version." + e.getMessage());
        }
    }

    private static int readVersionFromStream(InputStream inputStream) {
        try {
            if (inputStream != null) {
                Yaml yaml = new Yaml();
                Integer version = yaml.load(inputStream);
                return (version != null) ? version : 0;
            }
        } catch (Exception e) {
            Spython.getInstance().getLogger().severe("Failed to read version from stream." + e.getMessage());
        }
        return 0;
    }

    private static int readVersionFromFile(Path filePath) {
        try {
            if (Files.exists(filePath)) {
                Yaml yaml = new Yaml();
                Integer version = yaml.load(Files.newBufferedReader(filePath));
                return (version != null) ? version : 0;
            }
        } catch (Exception e) {
            Spython.getInstance().getLogger().severe("Failed to read version from file." + e.getMessage());
        }
        return 0;
    }
}
