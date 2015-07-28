package com.github.avatarkorra.minecraft.kingofcloa.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import com.github.avatarkorra.minecraft.kingofcloa.KingOfCloaPlugin;

public class LaunchExecutor implements CommandExecutor {

    KingOfCloaPlugin plugin;

    public LaunchExecutor(final KingOfCloaPlugin plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String ... args) {
        final Player player = (Player) sender;
        final Player toLaunch =  getPlayerFrom(player.getWorld(), args);

        player.getItemInHand().addEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
        
        final Arrow arrow = player.launchProjectile(Arrow.class);
        arrow.setPassenger(toLaunch != null ? toLaunch : player);
        
        return true;
    }

    protected Player getPlayerFrom(final World world, final String ... args) {
        if (args == null || args.length < 1) {
            return null;
        }
        final String playerName = args[0];
        for (final Player source : world.getPlayers()) {
            if (source.getName().equals(playerName)) {
                return source;
            }
        }
        return null;
    }
}
