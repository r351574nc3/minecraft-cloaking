package com.github.avatarkorra.minecraft.kingofcloa.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.avatarkorra.minecraft.kingofcloa.KingOfCloaPlugin;

public class TeleportExecutor implements CommandExecutor {

    static final Double GPS_X_LOCATION = 32.235682;
    static final Double GPS_Z_LOCATION = -110.95170000000002;
    static final Integer CONVERSION_SCALE = 100000;

    KingOfCloaPlugin plugin;

    public TeleportExecutor(final KingOfCloaPlugin plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String ... args) {
        final Player player = (Player) sender;

        final World world = player.getWorld();
        final Double lat = Double.parseDouble(args[0]);
        final Double lng = Double.parseDouble(args[1]);
         
        final Location to = convertFromGps(world, lat, lng);

        player.teleport(to);
        
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
