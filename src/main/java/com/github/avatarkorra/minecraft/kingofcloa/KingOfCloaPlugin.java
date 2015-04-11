package com.github.quorawr.minecraft;

import com.firebase.client.Firebase;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;


/**
 * Entry point for Cloaking plugin
 *
 */
public class KingOfCloaPlugin extends JavaPlugin {
    final Firebase fb;

    public KingOfCloaPlugin() {
        fb = new Firebase("https://kingofcloa.firebaseio.com");
    }

    public void onLoad() {


    }

    public void onDisable() {

    }
    
    public void onEnable() {
    }

    public boolean onCommand(final CommandSender sender, 
    						 final Command command,
    						 final String label,
    						 final String ... args) {

        if (label.toLowerCase().indexOf("hello") > -1) {
            final String message = "Hello";
            getServer().broadcastMessage(message);
            return true;
        }
        return false;
    }
}