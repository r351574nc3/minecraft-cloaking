package com.github.avatarkorra.minecraft.kingofcloa;

import com.firebase.client.Firebase;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.avatarkorra.minecraft.kingofcloa.commands.CloakExecutor;
import com.github.avatarkorra.minecraft.kingofcloa.commands.LaunchExecutor;
import com.github.avatarkorra.minecraft.kingofcloa.commands.LightArrowExecutor;
import com.github.avatarkorra.minecraft.kingofcloa.commands.LocationExecutor;
import com.github.avatarkorra.minecraft.kingofcloa.commands.TeleportExecutor;


/**
 * Entry point for Cloaking plugin
 *
 */
public class KingOfCloaPlugin extends JavaPlugin {
    final Firebase fb;

    static final String LOCATION_COMMAND = "location";
    static final String CLOAK_COMMAND    = "cloak";
    static final String TELEPORT_COMMAND = "teleport";
    static final String LAUNCH_COMMAND   = "launch";
    static final String LIGHTARROW_COMMAND = "lightarrow";

    public KingOfCloaPlugin() {
        fb = new Firebase("https://kingofcloa.firebaseio.com");
    }

    public void onLoad() {


    }

    public void onDisable() {

    }

    @Override
    public void onEnable() {
        getCommand(LOCATION_COMMAND).setExecutor(new LocationExecutor(this));
        getCommand(CLOAK_COMMAND).setExecutor(new CloakExecutor(this));
        getCommand(TELEPORT_COMMAND).setExecutor(new TeleportExecutor(this));
        getCommand(LAUNCH_COMMAND).setExecutor(new LaunchExecutor(this));
        getCommand(LIGHTARROW_COMMAND).setExecutor(new LightArrowExecutor(this));
    }

}
