package com.github.avatarkorra.minecraft.kingofcloa.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.github.avatarkorra.minecraft.kingofcloa.KingOfCloaPlugin;

public class CloakExecutor implements CommandExecutor {

    KingOfCloaPlugin plugin;

    public CloakExecutor(final KingOfCloaPlugin plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String ... args) {
        final Player player = (Player) sender;

        final PotionEffect cloakingPotion = new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1);
        if (player.hasPotionEffect(PotionEffectType.INVISIBILITY)) {            
            player.removePotionEffect(PotionEffectType.INVISIBILITY);
        }
        else {
            player.addPotionEffect(cloakingPotion);
        }

        System.out.println("Cloaked...");
        
        return true;
    }
}
