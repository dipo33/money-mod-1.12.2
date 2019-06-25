package sk.dipo.money.handler;

import java.util.ArrayList;

import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityElderGuardian;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.entity.monster.EntityEvoker;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.monster.EntityHusk;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.monster.EntityShulker;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.entity.monster.EntityVex;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.entity.passive.EntitySkeletonHorse;
import net.minecraft.entity.passive.EntityZombieHorse;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import sk.dipo.money.utils.Config;
import sk.dipo.money.utils.Utils;

public class EventHandlerDipo {

	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onEntityDropEvent(LivingDropsEvent event) {
		if (!Config.shouldMobsDropMoney)
			return;

		if (event.getEntity() instanceof EntityZombie) {
			ArrayList<EntityItem> itemsToDrop = Utils.randomCoinValue(event, Config.zombieDropMin, Config.zombieDropMax);
			event.getDrops().addAll(itemsToDrop);
		} else if (event.getEntity() instanceof EntityZombieVillager) {
			ArrayList<EntityItem> itemsToDrop = Utils.randomCoinValue(event, Config.zombieVillagerDropMin, Config.zombieVillagerDropMax);
			event.getDrops().addAll(itemsToDrop);
		} else if (event.getEntity() instanceof EntitySkeleton) {
			ArrayList<EntityItem> itemsToDrop = Utils.randomCoinValue(event, Config.skeletonDropMin, Config.skeletonDropMax);
			event.getDrops().addAll(itemsToDrop);
		} else if (event.getEntity() instanceof EntityWitherSkeleton) {
			ArrayList<EntityItem> itemsToDrop = Utils.randomCoinValue(event, Config.witherSkeletonDropMin, Config.witherSkeletonDropMax);
			event.getDrops().addAll(itemsToDrop);
		} else if (event.getEntity() instanceof EntitySpider) {
			ArrayList<EntityItem> itemsToDrop = Utils.randomCoinValue(event, Config.spiderDropMin, Config.spiderDropMax);
			event.getDrops().addAll(itemsToDrop);
		} else if (event.getEntity() instanceof EntityCreeper) {
			ArrayList<EntityItem> itemsToDrop = Utils.randomCoinValue(event, Config.creeperDropMin, Config.creeperDropMax);
			event.getDrops().addAll(itemsToDrop);
		} else if (event.getEntity() instanceof EntitySilverfish) {
			ArrayList<EntityItem> itemsToDrop = Utils.randomCoinValue(event, Config.silverfishDropMin, Config.silverfishDropMax);
			event.getDrops().addAll(itemsToDrop);
		} else if (event.getEntity() instanceof EntitySlime) {
			if (event.getEntity() instanceof EntityMagmaCube) {
				if (((EntityMagmaCube) event.getEntity()).getSlimeSize() == 1) {
					ArrayList<EntityItem> itemsToDrop = Utils.randomCoinValue(event, Config.magmaCubeSDropMin, Config.magmaCubeSDropMax);
					event.getDrops().addAll(itemsToDrop);
				} else if (((EntityMagmaCube) event.getEntity()).getSlimeSize() == 4) {
					ArrayList<EntityItem> itemsToDrop = Utils.randomCoinValue(event, Config.magmaCubeLDropMin, Config.magmaCubeLDropMax);
					event.getDrops().addAll(itemsToDrop);
				} else {
					ArrayList<EntityItem> itemsToDrop = Utils.randomCoinValue(event, Config.magmaCubeMDropMin, Config.magmaCubeMDropMax);
					event.getDrops().addAll(itemsToDrop);
				}
			} else {
				if (((EntitySlime) event.getEntity()).getSlimeSize() == 1) {
					ArrayList<EntityItem> itemsToDrop = Utils.randomCoinValue(event, Config.slimeSDropMin, Config.slimeSDropMax);
					event.getDrops().addAll(itemsToDrop);
				} else if (((EntitySlime) event.getEntity()).getSlimeSize() == 4) {
					ArrayList<EntityItem> itemsToDrop = Utils.randomCoinValue(event, Config.slimeLDropMin, Config.slimeLDropMax);
					event.getDrops().addAll(itemsToDrop);
				} else {
					ArrayList<EntityItem> itemsToDrop = Utils.randomCoinValue(event, Config.slimeMDropMin, Config.slimeMDropMax);
					event.getDrops().addAll(itemsToDrop);
				}
			}
		} else if (event.getEntity() instanceof EntityCaveSpider) {
			ArrayList<EntityItem> itemsToDrop = Utils.randomCoinValue(event, Config.caveSpiderDropMin, Config.caveSpiderDropMax);
			event.getDrops().addAll(itemsToDrop);
		} else if (event.getEntity() instanceof EntityGhast) {
			ArrayList<EntityItem> itemsToDrop = Utils.randomCoinValue(event, Config.ghastDropMin, Config.ghastDropMax);
			event.getDrops().addAll(itemsToDrop);
		} else if (event.getEntity() instanceof EntityBlaze) {
			ArrayList<EntityItem> itemsToDrop = Utils.randomCoinValue(event, Config.blazeDropMin, Config.blazeDropMax);
			event.getDrops().addAll(itemsToDrop);
		} else if (event.getEntity() instanceof EntityPigZombie) {
			ArrayList<EntityItem> itemsToDrop = Utils.randomCoinValue(event, Config.pigZombieDropMin, Config.pigZombieDropMax);
			event.getDrops().addAll(itemsToDrop);
		} else if (event.getEntity() instanceof EntityEnderman) {
			ArrayList<EntityItem> itemsToDrop = Utils.randomCoinValue(event, Config.endermanDropMin, Config.endermanDropMax);
			event.getDrops().addAll(itemsToDrop);
		} else if (event.getEntity() instanceof EntityWitch) {
			ArrayList<EntityItem> itemsToDrop = Utils.randomCoinValue(event, Config.witchDropMin, Config.witchDropMax);
			event.getDrops().addAll(itemsToDrop);
		} else if (event.getEntity() instanceof EntityWither) {
			ArrayList<EntityItem> itemsToDrop = Utils.randomCoinValue(event, Config.witherDropMin, Config.witherDropMax);
			event.getDrops().addAll(itemsToDrop);
		} else if (event.getEntity() instanceof EntityDragon) {
			ArrayList<EntityItem> itemsToDrop = Utils.randomCoinValue(event, Config.enderDragonDropMin, Config.enderDragonDropMax);
			event.getDrops().addAll(itemsToDrop);
		} else if (event.getEntity() instanceof EntityElderGuardian) {
			ArrayList<EntityItem> itemsToDrop = Utils.randomCoinValue(event, Config.elderGuardianDropMin, Config.elderGuardianDropMax);
			event.getDrops().addAll(itemsToDrop);
		} else if (event.getEntity() instanceof EntityEndermite) {
			ArrayList<EntityItem> itemsToDrop = Utils.randomCoinValue(event, Config.endermiteDropMin, Config.endermiteDropMax);
			event.getDrops().addAll(itemsToDrop);
		} else if (event.getEntity() instanceof EntityEvoker) {
			ArrayList<EntityItem> itemsToDrop = Utils.randomCoinValue(event, Config.evokerDropMin, Config.evokerDropMax);
			event.getDrops().addAll(itemsToDrop);
		} else if (event.getEntity() instanceof EntityGuardian) {
			ArrayList<EntityItem> itemsToDrop = Utils.randomCoinValue(event, Config.guardianDropMin, Config.guardianDropMax);
			event.getDrops().addAll(itemsToDrop);
		} else if (event.getEntity() instanceof EntityHusk) {
			ArrayList<EntityItem> itemsToDrop = Utils.randomCoinValue(event, Config.huskDropMin, Config.huskDropMax);
			event.getDrops().addAll(itemsToDrop);
		} else if (event.getEntity() instanceof EntityPolarBear) {
			ArrayList<EntityItem> itemsToDrop = Utils.randomCoinValue(event, Config.polarBearDropMin, Config.polarBearDropMax);
			event.getDrops().addAll(itemsToDrop);
		} else if (event.getEntity() instanceof EntityShulker) {
			ArrayList<EntityItem> itemsToDrop = Utils.randomCoinValue(event, Config.shulkerDropMin, Config.shulkerDropMax);
			event.getDrops().addAll(itemsToDrop);
		} else if (event.getEntity() instanceof EntitySkeletonHorse) {
			ArrayList<EntityItem> itemsToDrop = Utils.randomCoinValue(event, Config.skeletonHorseDropMin, Config.skeletonHorseDropMax);
			event.getDrops().addAll(itemsToDrop);
		} else if (event.getEntity() instanceof EntityStray) {
			ArrayList<EntityItem> itemsToDrop = Utils.randomCoinValue(event, Config.strayDropMin, Config.strayDropMax);
			event.getDrops().addAll(itemsToDrop);
		} else if (event.getEntity() instanceof EntityVex) {
			ArrayList<EntityItem> itemsToDrop = Utils.randomCoinValue(event, Config.vexDropMin, Config.vexDropMax);
			event.getDrops().addAll(itemsToDrop);
		} else if (event.getEntity() instanceof EntityZombieHorse) {
			ArrayList<EntityItem> itemsToDrop = Utils.randomCoinValue(event, Config.zombieHorseDropMin, Config.zombieHorseDropMax);
			event.getDrops().addAll(itemsToDrop);
		}
	}
}