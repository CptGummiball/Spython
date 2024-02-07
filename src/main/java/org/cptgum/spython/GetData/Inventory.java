package org.cptgum.spython.GetData;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Inventory {

    // Method to get players inventory items
    public static List<String> getPlayerInventoryItems(String playerName) {
        List<String> items = new ArrayList<>();
        Player player = Bukkit.getPlayerExact(playerName);
        if (player != null) {
            PlayerInventory inventory = player.getInventory();
            for (ItemStack itemStack : inventory.getContents()) {
                if (itemStack != null) {
                    items.add(itemStack.toString());
                } else {
                    items.add("AIR");
                }
            }
        }
        return items;
    }

    // Method, to get player inventory data
    public static List<ItemStack> getPlayerInventoryData(String playerName) {
        List<ItemStack> items = new ArrayList<>();
        Player player = Bukkit.getPlayerExact(playerName);
        if (player != null) {
            PlayerInventory inventory = player.getInventory();
            for (ItemStack itemStack : inventory.getContents()) {
                if (itemStack != null) {
                    items.add(itemStack.clone());
                } else {
                    items.add(null);
                }
            }
        }
        return items;

    }

    // Method to obtain the NBT data of a player's inventory items
    public static List<String> getPlayerInventoryNBT(String playerName) {
        List<String> nbtDataList = new ArrayList<>();
        Player player = Bukkit.getPlayerExact(playerName);
        if (player != null) {
            PlayerInventory inventory = player.getInventory();
            for (ItemStack itemStack : inventory.getContents()) {
                if (itemStack != null) {
                    String nbtData = getNBTData(itemStack);
                    nbtDataList.add(nbtData);
                } else {
                    nbtDataList.add("{}");
                }
            }
        }
        return nbtDataList;
    }

    // Method to get chest inventory items
    public static List<String> getChestInventoryItems(int x, int y, int z, String worldName) {
        List<String> items = new ArrayList<>();
        Location chestLocation = new Location(Bukkit.getWorld(worldName), x, y, z);
        Block block = chestLocation.getBlock();

        if (block.getState() instanceof Chest) {
            Chest chest = (Chest) block.getState();
            org.bukkit.inventory.Inventory chestInventory = chest.getInventory();

            for (ItemStack itemStack : chestInventory.getContents()) {
                if (itemStack != null) {
                    items.add(itemStack.toString());
                } else {
                    items.add("AIR");
                }
            }
        } else {
            items.add("No chest found at the specified location.");
        }

        return items;
    }

    // Method to get chest inventory data
    public static List<ItemStack> getChestInventoryData(int x, int y, int z, String worldName) {
        List<ItemStack> items = new ArrayList<>();
        Location chestLocation = new Location(Bukkit.getWorld(worldName), x, y, z);
        Block block = chestLocation.getBlock();

        if (block.getState() instanceof Chest) {
            Chest chest = (Chest) block.getState();
            org.bukkit.inventory.Inventory chestInventory = chest.getInventory();

            for (ItemStack itemStack : chestInventory.getContents()) {
                if (itemStack != null) {
                    items.add(itemStack.clone());
                } else {
                    items.add(null);
                }
            }
        } else {
            items.add(null);
        }

        return items;
    }

    // Method to obtain the NBT data of a chest inventory
    public static List<String> getChestInventoryNBT(int x, int y, int z, String worldName) {
        List<String> nbtDataList = new ArrayList<>();
        Location chestLocation = new Location(Bukkit.getWorld(worldName), x, y, z);
        Block block = chestLocation.getBlock();

        if (block.getState() instanceof Chest) {
            Chest chest = (Chest) block.getState();
            org.bukkit.inventory.Inventory chestInventory = chest.getInventory();

            for (ItemStack itemStack : chestInventory.getContents()) {
                if (itemStack != null) {
                    String nbtData = getNBTData(itemStack);
                    nbtDataList.add(nbtData);
                } else {
                    nbtDataList.add("{}");
                }
            }
        } else {
            nbtDataList.add("No chest found at the specified location.");
        }

        return nbtDataList;
    }

    private static String getNBTData(ItemStack itemStack) {
        Map<String, Object> serialized = itemStack.serialize();
        return serialized.toString();
    }

}
