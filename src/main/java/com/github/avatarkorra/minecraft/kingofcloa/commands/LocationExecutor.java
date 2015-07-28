package com.github.avatarkorra.minecraft.kingofcloa.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.avatarkorra.minecraft.kingofcloa.KingOfCloaPlugin;

public class LocationExecutor implements CommandExecutor {

    static final Double GPS_X_LOCATION = 32.235682;
    static final Double GPS_Z_LOCATION = -110.95170000000002;
    static final Integer CONVERSION_SCALE = 100000;
 
    KingOfCloaPlugin plugin;

    public LocationExecutor(final KingOfCloaPlugin plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String ... args) {
        final Player player = (Player) sender;
        final int x = player.getLocation().getBlockX();
        final int z = player.getLocation().getBlockZ();

        final Location spawnLocation = player.getWorld().getSpawnLocation();
        
        sender.sendMessage(String.format("At (%s,%s) (%s,%s)", x, z, spawnLocation.getBlockX(), spawnLocation.getBlockZ()));
        return true;
    }


    protected Location convertFromGps(final World world, final Double lat, final Double lng) {
        final Location spawnLocation = world.getSpawnLocation();
        final Double x = (lat - GPS_X_LOCATION) * CONVERSION_SCALE; 
        final Double z = (lng - GPS_Z_LOCATION) * CONVERSION_SCALE;
        
        final Location retval = new Location(world,
                                             spawnLocation.getBlockX() + x,
                                             spawnLocation.getBlockY(),
                                             spawnLocation.getBlockZ() + z);
        return retval;
    }
}
