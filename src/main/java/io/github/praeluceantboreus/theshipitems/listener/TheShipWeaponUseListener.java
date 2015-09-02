package io.github.praeluceantboreus.theshipitems.listener;

import io.github.praeluceantboreus.theshipitems.items.ItemFactory;
import io.github.praeluceantboreus.theshipitems.items.TheShipItem;
import io.github.praeluceantboreus.theshipitems.items.TheShipItemMeta;
import io.github.praeluceantboreus.theshipitems.items.TheShipMetaValue;
import io.github.praeluceantboreus.theshipitems.items.properties.TheShipWeaponOption;
import io.github.praeluceantboreus.theshipitems.main.TheShipItemsPlugin;
import io.github.praeluceantboreus.theshipitems.manager.ItemMetaTagManager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.projectiles.ProjectileSource;

public class TheShipWeaponUseListener implements Listener
{
	private ItemMetaTagManager manager;
	private TheShipItemsPlugin plugin;
	private ItemFactory factory;

	public TheShipWeaponUseListener(ItemMetaTagManager manager, TheShipItemsPlugin plugin, ItemFactory factory)
	{
		this.manager = manager;
		this.plugin = plugin;
		this.factory = factory;
	}

	@EventHandler
	public void onWeaponUse(PlayerInteractEntityEvent pie)
	{
		/*
		 * if (pie instanceof PlayerInteractEvent || pie instanceof
		 * PlayerInteractEntityEvent) {
		 */
		TheShipItemMeta meta = manager.getMeta(pie.getPlayer().getItemInHand());
		if (meta == null)
			return;
		/*
		 * if (pie instanceof PlayerInteractEvent) { PlayerInteractEvent event =
		 * (PlayerInteractEvent) pie; event.setCancelled(true); } else
		 */
		{
			PlayerInteractEntityEvent event = (PlayerInteractEntityEvent) pie;
			if (event.getRightClicked() instanceof LivingEntity)
			{
				LivingEntity entity = (LivingEntity) event.getRightClicked();
				int damage = Integer.parseInt(meta.getAdditionalData(TheShipWeaponOption.DAMAGE.toString()));
				entity.damage(damage, pie.getPlayer());
			}
			event.setCancelled(true);
		}
	}

	// }

	@EventHandler
	public void onShootWeapon(PlayerInteractEvent pie)
	{
		if (pie.getAction().equals(Action.LEFT_CLICK_AIR))
		{
			TheShipItemMeta meta = manager.getMeta(pie.getPlayer().getItemInHand());
			if (meta == null)
				return;
			if (!meta.getAdditionalData(TheShipWeaponOption.TYPE.toString()).equalsIgnoreCase(TheShipItem.Type.SHOT_WEAPON.toString()))
				return;
			int muni = Integer.parseInt(meta.getAdditionalData(TheShipWeaponOption.MUNITION.toString()));
			if (muni > 0)
			{
				muni--;
				meta.setAdditionalData(TheShipWeaponOption.MUNITION.toString(), "" + muni);
				factory.updateLore(pie.getItem(), pie.getPlayer());
				pie.getPlayer().launchProjectile(Fireball.class);
			}
			pie.setCancelled(true);
		}
	}

	@EventHandler
	public void onProjectileLaunch(ProjectileLaunchEvent ple)
	{
		if (ple.getEntity().getShooter() instanceof Player)
		{
			Player player = (Player) ple.getEntity().getShooter();
			TheShipItemMeta meta = manager.getMeta(player.getItemInHand());
			if (meta == null)
				return;
			if (!meta.getAdditionalData(TheShipWeaponOption.TYPE.toString()).equalsIgnoreCase(TheShipItem.Type.SHOT_WEAPON.toString()))
				return;
			Projectile projectile = ple.getEntity();
			projectile.setVelocity(player.getLocation().getDirection().clone().multiply(10));
			projectile.setMetadata("source", new TheShipMetaValue(meta, player.getItemInHand(), plugin));
			if (projectile instanceof Fireball)
			{
				Fireball fireball = (Fireball) projectile;
				fireball.setBounce(false);
				fireball.setYield(0);
			}
		}
	}

	/*
	 * @EventHandler public void onProjectileHit(ProjectileHitEvent phe) { if
	 * (phe.getEntity().getMetadata("source").isEmpty() ||
	 * !(phe.getEntity().getMetadata("source").get(0) instanceof
	 * TheShipMetaValue)) return; TheShipItemMeta meta =
	 * ((TheShipMetaValue)phe.getEntity().getMetadata("source").get(0)).value();
	 * if(phe.getEntity().) }
	 */

	@EventHandler
	public void damage(EntityDamageByEntityEvent ede)
	{
		if (ede.getDamager().hasMetadata("source"))
		{
			TheShipMetaValue val = (TheShipMetaValue) ede.getDamager().getMetadata("source").get(0);
			ede.setDamage(Integer.parseInt(val.value().getAdditionalData(TheShipWeaponOption.DAMAGE.toString())));
		}
		if (ede.getDamager().hasMetadata("weapon"))
		{
			TheShipMetaValue val = (TheShipMetaValue) ede.getDamager().getMetadata("weapon").get(0);
			ede.setDamage(Integer.parseInt(val.value().getAdditionalData(TheShipWeaponOption.THROW_DAMAGE.toString())));
		}
	}

	@EventHandler
	public void onRightClick(PlayerInteractEvent pie)
	{
		if (pie.getAction().equals(Action.RIGHT_CLICK_AIR) || pie.getAction().equals(Action.RIGHT_CLICK_BLOCK))
		{
			if (!manager.isTheShipItem(pie.getItem()))
				return;
			ItemStack item = pie.getItem();
			if (item.getAmount() == 1)
				pie.getPlayer().getInventory().remove(item);
			else
				item.setAmount(item.getAmount() - 1);
			pie.getPlayer().updateInventory();
			pie.getPlayer().setMetadata("thrown", new TheShipMetaValue(manager.getMeta(item), item, plugin));
			pie.getPlayer().launchProjectile(Snowball.class);
		}
	}

	@EventHandler
	public void onWeaponThrowAway(ProjectileLaunchEvent ple)
	{
		ProjectileSource ent = ple.getEntity().getShooter();
		if (!(ent instanceof Player))
			return;
		Player player = (Player) ent;
		if (!player.hasMetadata("thrown"))
			return;
		TheShipMetaValue meta = (TheShipMetaValue) player.getMetadata("thrown").get(0);
		player.removeMetadata("thrown", plugin);
		// TheShipItemMeta itemMeta = meta.value();
		Projectile ball = ple.getEntity();
		Entity stack = player.getWorld().dropItem(ball.getLocation(), meta.getItem());
		ball.setPassenger(stack);
		ball.setMetadata("weapon", new TheShipMetaValue(manager.getMeta(meta.getItem()), meta.getItem(), plugin));
	}

	@EventHandler
	public void onDeath(EntityDamageByEntityEvent ede)
	{
		Bukkit.broadcastMessage(ede.getEntityType() + " hat " + ede.getDamage() + " Schaden erlitten");
		if (ede.getEntity().isDead())
			Bukkit.broadcastMessage(ede.getEntityType() + " ist von " + ede.getDamager().getName() + " kaltblütig niedergemetzelt worden");
	}
}
