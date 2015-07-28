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
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

import com.github.avatarkorra.minecraft.kingofcloa.KingOfCloaPlugin;

public class LightArrowExecutor implements CommandExecutor {

    KingOfCloaPlugin plugin;

    public LightArrowExecutor(final KingOfCloaPlugin plugin) {
        this.plugin = plugin;

        plugin.getServer().getPluginManager().registerEvent(EntityDamageEvent.class,
                                                            new Listener() {
            @EventHandler(priority = EventPriority.HIGHEST)
            public void onLightningArrowDamage(final EntityDamageEvent event) {                
                if (event.getDamageCause().equals(EntityDamageEvent.DamageCause.PROJECTILE)) {
                }
            }
        },
    }

    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String ... args) {
        final Player player = (Player) sender;
        final Arrow arrow = player.launchProjectile(Arrow.class);

        try {
            Thread.sleep(1000);
        }
        catch (Exception e) {
        }

        sender.sendMessage(String.format("At (%s,%s) (%s,%s)", player.getLocation().getBlockX(),
                                         player.getLocation().getBlockZ(),
                                         arrow.getLocation().getBlockX(),
                                         arrow.getLocation().getBlockZ()));
        arrow.getWorld().strikeLightning(arrow.getLocation());
        
        return true;
    }

}
