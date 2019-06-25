package sk.dipo.money.utils;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Config {

	public static boolean shouldMobsDropMoney;
	public static boolean allowVillager;

	public static int emeraldValue;
	public static int zombieDropMin;
	public static int zombieDropMax;
	public static int skeletonDropMin;
	public static int skeletonDropMax;
	public static int spiderDropMin;
	public static int spiderDropMax;
	public static int creeperDropMin;
	public static int creeperDropMax;
	public static int silverfishDropMin;
	public static int silverfishDropMax;
	public static int slimeSDropMin;
	public static int slimeSDropMax;
	public static int slimeMDropMin;
	public static int slimeMDropMax;
	public static int slimeLDropMin;
	public static int slimeLDropMax;
	public static int caveSpiderDropMin;
	public static int caveSpiderDropMax;
	public static int huskDropMin;
	public static int huskDropMax;
	public static int strayDropMin;
	public static int strayDropMax;
	public static int ghastDropMin;
	public static int ghastDropMax;
	public static int blazeDropMin;
	public static int blazeDropMax;
	public static int pigZombieDropMin;
	public static int pigZombieDropMax;
	public static int endermanDropMin;
	public static int endermanDropMax;
	public static int witchDropMin;
	public static int witchDropMax;
	public static int guardianDropMin;
	public static int guardianDropMax;
	public static int polarBearDropMin;
	public static int polarBearDropMax;
	public static int shulkerDropMin;
	public static int shulkerDropMax;
	public static int skeletonHorseDropMin;
	public static int skeletonHorseDropMax;
	public static int zombieHorseDropMin;
	public static int zombieHorseDropMax;
	public static int vexDropMin;
	public static int vexDropMax;
	public static int magmaCubeSDropMin;
	public static int magmaCubeSDropMax;
	public static int magmaCubeMDropMin;
	public static int magmaCubeMDropMax;
	public static int magmaCubeLDropMin;
	public static int magmaCubeLDropMax;
	public static int zombieVillagerDropMin;
	public static int zombieVillagerDropMax;
	public static int witherSkeletonDropMin;
	public static int witherSkeletonDropMax;
	public static int elderGuardianDropMin;
	public static int elderGuardianDropMax;
	public static int endermiteDropMin;
	public static int endermiteDropMax;
	public static int evokerDropMin;
	public static int evokerDropMax;
	public static int vindicatorDropMin;
	public static int vindicatorDropMax;
	public static int witherDropMin;
	public static int witherDropMax;
	public static int enderDragonDropMin;
	public static int enderDragonDropMax;

	public static void loadConfiguration(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();

		allowVillager = config.getBoolean("allowVillager", Configuration.CATEGORY_GENERAL, true, "Allow custom villager to trade emerald for money");
		emeraldValue = config.getInt("emeraldValue", Configuration.CATEGORY_GENERAL, 500, 1, 50000,
				"Value of emerald in cents when trading with villager [ALLOWED VALUES: 1, 2, 5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000, 20000, 50000]");

		shouldMobsDropMoney = config.getBoolean("shouldMobsDropMoney", "Mobs", true, "Allow mobs to drop money when killed");
		zombieDropMin = config.getInt("zombieDropMin", "Mobs.Zombie", 1, 0, 500000, "Minimum amount of money dropped by zombie (value is in cents)");
		zombieDropMax = config.getInt("zombieDropMax", "Mobs.Zombie", 2, 0, 500000, "Maximum amount of money dropped by zombie (value is in cents)");

		skeletonDropMin = config.getInt("skeletonDropMin", "Mobs.Skeleton", 1, 0, 500000, "Minimum amount of money dropped by skeleton (value is in cents)");
		skeletonDropMax = config.getInt("skeletonDropMax", "Mobs.Skeleton", 2, 0, 500000, "Maximum amount of money dropped by skeleton (value is in cents)");

		spiderDropMin = config.getInt("spiderDropMin", "Mobs.Spider", 1, 0, 500000, "Minimum amount of money dropped by spider (value is in cents)");
		spiderDropMax = config.getInt("spiderDropMax", "Mobs.Spider", 2, 0, 500000, "Maximum amount of money dropped by spider (value is in cents)");

		creeperDropMin = config.getInt("creeperDropMin", "Mobs.Creeper", 1, 0, 500000, "Minimum amount of money dropped by creeper (value is in cents)");
		creeperDropMax = config.getInt("creeperDropMax", "Mobs.Creeper", 2, 0, 500000, "Maximum amount of money dropped by creeper (value is in cents)");

		silverfishDropMin = config.getInt("silverfishDropMin", "Mobs.Silverfish", 1, 0, 500000,
				"Minimum amount of money dropped by silverfish (value is in cents)");
		silverfishDropMax = config.getInt("silverfishDropMax", "Mobs.Silverfish", 2, 0, 500000,
				"Maximum amount of money dropped by silverfish (value is in cents)");

		slimeSDropMin = config.getInt("slimeSDropMin", "Mobs.Slime", 1, 0, 500000, "Minimum amount of money dropped by small slime (value is in cents)");
		slimeSDropMax = config.getInt("slimeSDropMax", "Mobs.Slime", 2, 0, 500000, "Maximum amount of money dropped by small slime (value is in cents)");
		slimeMDropMin = config.getInt("slimeMDropMin", "Mobs.Slime", 2, 0, 500000, "Minimum amount of money dropped by middle slime (value is in cents)");
		slimeMDropMax = config.getInt("slimeMDropMax", "Mobs.Slime", 3, 0, 500000, "Maximum amount of money dropped by middle slime (value is in cents)");
		slimeLDropMin = config.getInt("slimeLDropMin", "Mobs.Slime", 3, 0, 500000, "Minimum amount of money dropped by large slime (value is in cents)");
		slimeLDropMax = config.getInt("slimeLDropMax", "Mobs.Slime", 5, 0, 500000, "Maximum amount of money dropped by large slime (value is in cents)");

		caveSpiderDropMin = config.getInt("caveSpiderDropMin", "Mobs.CaveSpider", 2, 0, 500000,
				"Minimum amount of money dropped by cave spider (value is in cents)");
		caveSpiderDropMax = config.getInt("caveSpiderDropMax", "Mobs.CaveSpider", 5, 0, 500000,
				"Maximum amount of money dropped by cave spider (value is in cents)");

		huskDropMin = config.getInt("huskDropMin", "Mobs.Husk", 2, 0, 500000, "Minimum amount of money dropped by husk (value is in cents)");
		huskDropMax = config.getInt("huskDropMax", "Mobs.Husk", 5, 0, 500000, "Maximum amount of money dropped by husk (value is in cents)");

		strayDropMin = config.getInt("strayDropMin", "Mobs.Stray", 2, 0, 500000, "Minimum amount of money dropped by stray (value is in cents)");
		strayDropMax = config.getInt("strayDropMax", "Mobs.Stray", 5, 0, 500000, "Maximum amount of money dropped by stray (value is in cents)");

		ghastDropMin = config.getInt("ghastDropMin", "Mobs.Ghast", 5, 0, 500000, "Minimum amount of money dropped by ghast (value is in cents)");
		ghastDropMax = config.getInt("ghastDropMax", "Mobs.Ghast", 10, 0, 500000, "Maximum amount of money dropped by ghast (value is in cents)");

		blazeDropMin = config.getInt("blazeDropMin", "Mobs.Blaze", 5, 0, 500000, "Minimum amount of money dropped by blaze (value is in cents)");
		blazeDropMax = config.getInt("blazeDropMax", "Mobs.Blaze", 10, 0, 500000, "Maximum amount of money dropped by blaze (value is in cents)");

		pigZombieDropMin = config.getInt("pigZombieDropMin", "Mobs.PigZombie", 5, 0, 500000,
				"Minimum amount of money dropped by pig zombie (value is in cents)");
		pigZombieDropMax = config.getInt("pigZombieDropMax", "Mobs.PigZombie", 10, 0, 500000,
				"Maximum amount of money dropped by pig zombie (value is in cents)");

		endermanDropMin = config.getInt("endermanDropMin", "Mobs.Enderman", 10, 0, 500000, "Minimum amount of money dropped by enderman (value is in cents)");
		endermanDropMax = config.getInt("endermanDropMax", "Mobs.Enderman", 20, 0, 500000, "Maximum amount of money dropped by enderman (value is in cents)");

		witchDropMin = config.getInt("witchDropMin", "Mobs.Witch", 10, 0, 500000, "Minimum amount of money dropped by witch (value is in cents)");
		witchDropMax = config.getInt("witchDropMax", "Mobs.Witch", 20, 0, 500000, "Maximum amount of money dropped by witch (value is in cents)");

		guardianDropMin = config.getInt("guardianDropMin", "Mobs.Guardian", 10, 0, 500000, "Minimum amount of money dropped by guardian (value is in cents)");
		guardianDropMax = config.getInt("guardianDropMax", "Mobs.Guardian", 20, 0, 500000, "Maximum amount of money dropped by guardian (value is in cents)");

		polarBearDropMin = config.getInt("polarBearDropMin", "Mobs.PolarBear", 10, 0, 500000,
				"Minimum amount of money dropped by polar bear (value is in cents)");
		polarBearDropMax = config.getInt("polarBearDropMax", "Mobs.PolarBear", 20, 0, 500000,
				"Maximum amount of money dropped by polar bear (value is in cents)");

		shulkerDropMin = config.getInt("shulkerDropMin", "Mobs.Shulker", 10, 0, 500000, "Minimum amount of money dropped by shulker (value is in cents)");
		shulkerDropMax = config.getInt("shulkerDropMax", "Mobs.Shulker", 20, 0, 500000, "Maximum amount of money dropped by shulker (value is in cents)");

		skeletonHorseDropMin = config.getInt("skeletonHorseDropMin", "Mobs.SkeletonHorse", 10, 0, 500000,
				"Minimum amount of money dropped by skeleton horse (value is in cents)");
		skeletonHorseDropMax = config.getInt("skeletonHorseDropMax", "Mobs.SkeletonHorse", 20, 0, 500000,
				"Maximum amount of money dropped by skeleton horse (value is in cents)");

		zombieHorseDropMin = config.getInt("zombieHorseDropMin", "Mobs.ZombieHorse", 10, 0, 500000,
				"Minimum amount of money dropped by zombie horse (value is in cents)");
		zombieHorseDropMax = config.getInt("zombieHorseDropMax", "Mobs.ZombieHorse", 20, 0, 500000,
				"Maximum amount of money dropped by zombie horse (value is in cents)");

		vexDropMin = config.getInt("vexDropMin", "Mobs.Vex", 10, 0, 500000, "Minimum amount of money dropped by vex (value is in cents)");
		vexDropMax = config.getInt("vexDropMax", "Mobs.Vex", 20, 0, 500000, "Maximum amount of money dropped by vex (value is in cents)");

		magmaCubeSDropMin = config.getInt("magmaCubeSDropMin", "Mobs.MagmaCube", 10, 0, 500000,
				"Minimum amount of money dropped by small magma cube (value is in cents)");
		magmaCubeSDropMax = config.getInt("magmaCubeSDropMax", "Mobs.MagmaCube", 12, 0, 500000,
				"Maximum amount of money dropped by small magma cube (value is in cents)");
		magmaCubeMDropMin = config.getInt("magmaCubeMDropMin", "Mobs.MagmaCube", 12, 0, 500000,
				"Minimum amount of money dropped by middle magma cube (value is in cents)");
		magmaCubeMDropMax = config.getInt("magmaCubeMDropMax", "Mobs.MagmaCube", 15, 0, 500000,
				"Maximum amount of money dropped by middle magma cube (value is in cents)");
		magmaCubeLDropMin = config.getInt("magmaCubeLDropMin", "Mobs.MagmaCube", 15, 0, 500000,
				"Minimum amount of money dropped by large magma cube (value is in cents)");
		magmaCubeLDropMax = config.getInt("magmaCubeLDropMax", "Mobs.MagmaCube", 20, 0, 500000,
				"Maximum amount of money dropped by large magma cube (value is in cents)");

		zombieVillagerDropMin = config.getInt("zombieVillagerDropMin", "Mobs.ZombieVillager", 10, 0, 500000,
				"Minimum amount of money dropped by zombie villager (value is in cents)");
		zombieVillagerDropMax = config.getInt("zombieVillagerDropMax", "Mobs.ZombieVillager", 20, 0, 500000,
				"Maximum amount of money dropped by zombie villager (value is in cents)");

		witherSkeletonDropMin = config.getInt("witherSkeletonDropMin", "Mobs.WitherSkeleton", 10, 0, 500000,
				"Minimum amount of money dropped by wither skeleton (value is in cents)");
		witherSkeletonDropMax = config.getInt("witherSkeletonDropMax", "Mobs.WitherSkeleton", 20, 0, 500000,
				"Maximum amount of money dropped by wither skeleton (value is in cents)");

		elderGuardianDropMin = config.getInt("elderGuardianDropMin", "Mobs.ElderGuardian", 20, 0, 500000,
				"Minimum amount of money dropped by elder guardian (value is in cents)");
		elderGuardianDropMax = config.getInt("elderGuardianDropMax", "Mobs.ElderGuardian", 50, 0, 500000,
				"Maximum amount of money dropped by elder guardian (value is in cents)");

		endermiteDropMin = config.getInt("endermiteDropMin", "Mobs.Endermite", 20, 0, 500000,
				"Minimum amount of money dropped by endermite (value is in cents)");
		endermiteDropMax = config.getInt("endermiteDropMax", "Mobs.Endermite", 50, 0, 500000,
				"Maximum amount of money dropped by endermite (value is in cents)");

		evokerDropMin = config.getInt("evokerDropMin", "Mobs.Evoker", 20, 0, 500000, "Minimum amount of money dropped by evoker (value is in cents)");
		evokerDropMax = config.getInt("evokerDropMax", "Mobs.Evoker", 50, 0, 500000, "Maximum amount of money dropped by evoker (value is in cents)");

		vindicatorDropMin = config.getInt("vindicatorDropMin", "Mobs.Vindicator", 20, 0, 500000,
				"Minimum amount of money dropped by vindicator (value is in cents)");
		vindicatorDropMax = config.getInt("vindicatorDropMax", "Mobs.Vindicator", 50, 0, 500000,
				"Maximum amount of money dropped by vindicator (value is in cents)");

		witherDropMin = config.getInt("witherDropMin", "Mobs.Wither", 20, 0, 500000, "Minimum amount of money dropped by wither (value is in cents)");
		witherDropMax = config.getInt("witherDropMax", "Mobs.Wither", 50, 0, 500000, "Maximum amount of money dropped by wither (value is in cents)");

		enderDragonDropMin = config.getInt("enderDragonDropMin", "Mobs.EnderDragon", 50, 0, 500000,
				"Minimum amount of money dropped by ender dragon (value is in cents)");
		enderDragonDropMax = config.getInt("enderDragonDropMax", "Mobs.EnderDragon", 100, 0, 500000,
				"Maximum amount of money dropped by ender dragon (value is in cents)");

		config.save();
	}
}