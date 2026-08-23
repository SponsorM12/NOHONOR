package zver.nohonor;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zver.nohonor.block.ModBlocks;
import zver.nohonor.block.ModWoodTypes;
import zver.nohonor.block.entity.ModBlockEntities;
import zver.nohonor.custom_mechanics.avatar_layers.hanahaki.HanahakiVariants;
import zver.nohonor.effect.ModEffects;
import zver.nohonor.entity.ModEntityTypes;
import zver.nohonor.entity.boat.ModBoats;
import zver.nohonor.entity.villager.ModVillagers;
import zver.nohonor.fluid.ModFluids;
import zver.nohonor.init.*;
import zver.nohonor.item.ModItems;
import zver.nohonor.loot.ModLootTableModifiers;
import zver.nohonor.networking.ModPackets;
import zver.nohonor.particle.ModParticles;
import zver.nohonor.potion.ModPotions;
import zver.nohonor.sound.ModSounds;
import zver.nohonor.stat.ModStats;

public class NOHONOR implements ModInitializer {
	public static final String MOD_ID = "nohonor";
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	//        |
	//       \|/
	// Этот логгер используется для записи текста в консоль и лог-файл.
    // Рекомендуется использовать идентификатор вашего мода в качестве имени логгера.
	// Таким образом, будет понятно, какой мод записал информацию, предупреждения и ошибки.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		//         |
		//        \|/
		// Этот код выполняется, как только Minecraft переходит в состояние готовности к загрузке модов.
        // Однако некоторые вещи (например, ресурсы) могут оставаться неинициализированными.
        // Действуйте с осторожностью.

		//ТУТ ВАЖНО НЕ ОБОСРАТЬСЯ С ПОРЯДКОМ ЗАГРУЗКИ
		//Правило - common всегда раньше client
		ModBlocks.initialize();
		ModItems.initialize();
		ModFluids.initialize();

		ModParticles.initialize();
		ModWoodTypes.initialize();
		ModSounds.initialize();

		ModEntityTypes.registerModEntityTypes();
		ModEntityTypes.registerAttributes();
		ModVillagers.initialize();
		ModBoats.initialize();

		ModEffects.initialize();

		HanahakiVariants.initialize();

		ModCreativeTabs.initialize();
		ModFuels.initialize();
		ModPotions.initialize();
		ModPotionRecipes.initialize();
		ModCompostables.initialize();
		ModStats.initialize();
		ModLootTableModifiers.initialize();

		ModPackets.initialize();
		ModBlockEntities.initialize();

		//Класс попадает в onInitialize() явным вызовом,
		// если у него есть либо: 1. собственные static-поля с регистрацией,
		// либо 2. код с побочными эффектами, зависящий от уже готовых полей — своих или чужих.
		// У классов-типов блоков нет ни того, ни другого — они регистрируются не сами,
		// а как деталь регистрации ModBlocks.

		//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!IT WORKS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		//https://tenor.com/ru/view/back-to-the-future-marty-mcfly-doc-brown-michael-j-fox-celebrate-gif-13200069591323252833
		LOGGER.info("Hello Fabric world! From NOHONOR!!!");
	}
}