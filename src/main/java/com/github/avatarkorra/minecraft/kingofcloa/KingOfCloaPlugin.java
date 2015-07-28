package com.github.avatarkorra.minecraft.kingofcloa;

import com.firebase.client.Firebase;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.avatarkorra.minecraft.kingofcloa.commands.CloakExecutor;
import com.github.avatarkorra.minecraft.kingofcloa.commands.LocationExecutor;


/**
 * Entry point for Cloaking plugin
 *
 */
public class KingOfCloaPlugin extends JavaPlugin {
    final Firebase fb;

    static final String LOCATION_COMMAND = "location";
    static final String CLOAK_COMMAND    = "cloak";

    public KingOfCloaPlugin() {
        fb = new Firebase("https://kingofcloa.firebaseio.com");
    }

    public void onLoad() {


    }

    public void onDisable() {

    }
    
    public void onEnable() {
        getCommand(LOCATION_COMMAND).setExecutor(new LocationExecutor(this));
        getCommand(CLOAK_COMMAND).setExecutor(new CloakExecutor(this));
    }

}
