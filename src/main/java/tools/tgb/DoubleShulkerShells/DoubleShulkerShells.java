package tools.tgb.DoubleShulkerShells;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class DoubleShulkerShells extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getLogger().info("Double Shulker Shells Enabled!");
        getServer().getPluginManager().registerEvents(this, this);

    }

    @Override
    public void onDisable() {
        getLogger().info("Double Shulker Shells Disabled!");
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {

        Entity entity = event.getEntity();

        if(entity.getType() == EntityType.SHULKER) {
            event.getDrops().clear();
            ItemStack shulkerStack = new ItemStack(Material.SHULKER_SHELL, 2);
            event.getEntity().getWorld().dropItemNaturally(entity.getLocation(), shulkerStack);
        }
    }
}
