package oodmod.main;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import oodmod.achievements.KroostylCraftEventClass;
import oodmod.achievements.KroostylMineEventClass;
import oodmod.block.BlockClass;
import oodmod.block.CompressedVegClass;
import oodmod.block.KroostylBlocksClass;
import oodmod.block.KroostylStairsClass;
import oodmod.block.KroostylOreClass;
import oodmod.block.crop.BeetrootCropClass;
import oodmod.block.crop.BroccoliCropClass;
import oodmod.block.crop.CauliflowerCropClass;
import oodmod.block.crop.GarlicCropClass;
import oodmod.block.crop.LeekCropClass;
import oodmod.block.crop.OnionCropClass;
import oodmod.block.trees.LeavesBlockClass;
import oodmod.block.trees.LeavesClass;
import oodmod.block.trees.LogBlockClass;
import oodmod.block.trees.LogClass;
import oodmod.block.trees.PlankClass;
import oodmod.block.trees.SaplingBlockClass;
import oodmod.block.trees.SaplingClass;
import oodmod.creativetabs.OodModTab;
import oodmod.item.ItemClass;
import oodmod.item.KroostylClass;
import oodmod.item.SeedsClass;
import oodmod.item.armour.KroostylArmour;
import oodmod.item.armour.ReinforcedKroostylArmour;
import oodmod.item.food.FruitClass;
import oodmod.item.food.VegClass;
import oodmod.item.tools.KroostylAxeClass;
import oodmod.item.tools.KroostylHoeClass;
import oodmod.item.tools.KroostylPickaxeClass;
import oodmod.item.tools.KroostylShovelClass;
import oodmod.item.tools.KroostylSwordClass;
import oodmod.worldgen.OreGenerationClass;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.Metadata;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = MainClass.MODID, name = MainClass.NAME, version = MainClass.VERSION)
public class MainClass {
	
	@SidedProxy(clientSide = "oodmod.main.ClientProxy", serverSide = "oodmod.main.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance(MainClass.MODID)
    	public static MainClass modInstance;
	
		//Mod Info
		public static final String MODID = "oodmod";
		public static final String NAME = "Ood's Mod";
		public static final String VERSION = "1.90";
		
		//Achievements
		public static Achievement achievementKroostyl;
		public static Achievement achievementKroostylPick;
		
		//Creative Tabs
		public static CreativeTabs OodModTab = new OodModTab(CreativeTabs.getNextID(), "OodModTab");
		
		//Generation
		public static OreGenerationClass KroostylWorldGen = new OreGenerationClass();
		
	@EventHandler
	public void PreInit(FMLPreInitializationEvent preEvent){
	
		BlockClass.blockRegistry();
		ItemClass.itemRegistry();
    		CraftingClass.craftingManager();
		
	}
		
	@EventHandler
	public void Init(FMLInitializationEvent Event){
		
		//Achievements
		achievementKroostyl = new Achievement("achievement.MineKroostyl", "MineKroostyl", 0, 0, BlockClass.KroostylOre, AchievementList.diamonds).registerStat();
		achievementKroostylPick = new Achievement("achievement.KroostylPick", "KroostylPick", 2, 1, ItemClass.KroostylPickaxe, achievementKroostyl).registerStat();
		
		AchievementPage.registerAchievementPage(new AchievementPage("Ood's Mod", new Achievement[]{achievementKroostyl, achievementKroostylPick}));
		
		FMLCommonHandler.instance().bus().register(new KroostylMineEventClass());
		FMLCommonHandler.instance().bus().register(new KroostylCraftEventClass());
		
		//World Generation
		GameRegistry.registerWorldGenerator(KroostylWorldGen, 1);
		
		//Ore Registration
		OreDictionary.registerOre("oreKroostyl", new ItemStack(BlockClass.KroostylOre));
		OreDictionary.registerOre("gemKroostyl", new ItemStack(ItemClass.Kroostyl));
		
		//Seed Dropping
		MinecraftForge.addGrassSeed(new ItemStack(ItemClass.BroccoliSeeds), 1);
		MinecraftForge.addGrassSeed(new ItemStack(ItemClass.OnionSeeds), 1);
		MinecraftForge.addGrassSeed(new ItemStack(ItemClass.BeetrootSeeds), 1);
		MinecraftForge.addGrassSeed(new ItemStack(ItemClass.CauliflowerSeeds), 1);
		MinecraftForge.addGrassSeed(new ItemStack(ItemClass.LeekSeeds), 1);
		MinecraftForge.addGrassSeed(new ItemStack(ItemClass.GarlicSeeds), 1);
		
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent postEvent){
		
	}
	
}
