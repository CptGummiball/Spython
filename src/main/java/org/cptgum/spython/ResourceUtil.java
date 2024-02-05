package org.cptgum.spython;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ResourceUtil {

    public static void copyResourceFolder(String resourceName, String destinationPath) {
        try {
            // Set Paths
            Path resourcePath = Paths.get(Spython.getInstance().getDataFolder().getParent(), "resources", resourceName);
            Path destinationFolderPath = Paths.get(Spython.getInstance().getDataFolder().getAbsolutePath(), destinationPath);

            // copy resource folder
            FileUtils.copyDirectory(resourcePath.toFile(), destinationFolderPath.toFile());

            Spython.getInstance().getLogger().info("Resource folder '" + resourceName + "' copied to '" + destinationPath + "'.");
        } catch (IOException e) {
            Spython.getInstance().getLogger().severe("Failed to copy resource folder '" + resourceName + "'." + e.getMessage());
        }
    }
}
