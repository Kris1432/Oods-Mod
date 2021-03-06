package oodmod.block;

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
import oodmod.block.trees.PlankBlockClass;
import oodmod.block.trees.PlankClass;
import oodmod.block.trees.SaplingBlockClass;
import oodmod.block.trees.SaplingClass;
import oodmod.main.MainClass;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockClass {
	
    public static void blockRegistry(){
    	initBlocks();
    	registerBlocks();
    }
    
    	//Crops
  		public static Block BroccoliCrop;
  		public static Block OnionCrop;
  		public static Block BeetrootCrop;
  		public static Block CauliflowerCrop;
  		public static Block LeekCrop;
  		public static Block GarlicCrop;
  		
  		//Veg
  		public static Block CompressedBroccoli;
  		public static Block CompressedOnion;
  		public static Block CompressedBeetroot;
  		public static Block CompressedCauliflower;
  		public static Block CompressedLeek;
  		public static Block CompressedGarlic;
  		
  		//Ores
  		public static Block KroostylOre;
  		
  		//Decorative Blocks
  		public static Block KroostylBlock;
  		public static Block KroostylBricks;
  		public static Block KroostylChiseledBricks;
  		public static Block KroostylBrickStairs;

  		public static Block Plank;
  		
  		//Trees
  		public static Block Log;
  		public static Block Leaves;
  		public static Block Sapling;
    
  		
    public static void initBlocks(){
    	
    	//Crops
  		BroccoliCrop = new BroccoliCropClass().setBlockName("BroccoliCrop");
  		OnionCrop = new OnionCropClass().setBlockName("OnionCrop");
  		BeetrootCrop = new BeetrootCropClass().setBlockName("BeetrootCrop");
  		CauliflowerCrop = new CauliflowerCropClass().setBlockName("CauliflowerCrop");
  		LeekCrop = new LeekCropClass().setBlockName("LeekCrop");
  		GarlicCrop = new GarlicCropClass().setBlockName("GarlicCrop");
  		
  		//Veg
  		CompressedBroccoli = new CompressedVegClass().setBlockName("CompressedBroccoli").setBlockTextureName(MainClass.MODID + ":CompressedBroccoli");
  		CompressedOnion = new CompressedVegClass().setBlockName("CompressedOnion").setBlockTextureName(MainClass.MODID + ":CompressedOnion");
  		CompressedBeetroot = new CompressedVegClass().setBlockName("CompressedBeetroot").setBlockTextureName(MainClass.MODID + ":CompressedBeetroot");
  		CompressedCauliflower = new CompressedVegClass().setBlockName("CompressedCauliflower").setBlockTextureName(MainClass.MODID + ":CompressedCauliflower");
  		CompressedLeek = new CompressedVegClass().setBlockName("CompressedLeek").setBlockTextureName(MainClass.MODID + ":CompressedLeek");
  		CompressedGarlic = new CompressedVegClass().setBlockName("CompressedGarlic").setBlockTextureName(MainClass.MODID + ":CompressedGarlic");
  		
  		//Ores
  		KroostylOre = new KroostylOreClass(Material.rock).setBlockName("KroostylOre");
  		
  		//Decorative Blocks
  		KroostylBlock = new KroostylBlocksClass().setBlockName("KroostylBlock").setBlockTextureName(MainClass.MODID + ":KroostylBlock");
  		KroostylBricks = new KroostylBlocksClass().setBlockName("KroostylBricks").setBlockTextureName(MainClass.MODID + ":KroostylBricks");
  		KroostylChiseledBricks = new KroostylBlocksClass().setBlockName("KroostylChiseledBricks").setBlockTextureName(MainClass.MODID + ":KroostylChiseledBricks");
  		KroostylBrickStairs = new KroostylStairsClass(KroostylBricks, 0).setBlockName("KroostylBrickStairs");

  		Plank = new PlankClass().setBlockName("Plank");
  		
  		//Trees
  		Log = new LogClass().setBlockName("Log");
  		Leaves = new LeavesClass().setBlockName("Leaves");
  		Sapling = new SaplingClass().setBlockName("Sapling");
    	
    }
    
    
    public static void registerBlocks(){
    	
    	//Crops
    	GameRegistry.registerBlock(BroccoliCrop, "BroccoliCrop");
    	GameRegistry.registerBlock(OnionCrop, "OnionCrop");
    	GameRegistry.registerBlock(BeetrootCrop, "BeetrootCrop");
    	GameRegistry.registerBlock(CauliflowerCrop, "CauliflowerCrop");
    	GameRegistry.registerBlock(LeekCrop, "LeekCrop");
    	GameRegistry.registerBlock(GarlicCrop, "GarlicCrop");
    			
    	//Veg
    	GameRegistry.registerBlock(CompressedBroccoli, "CompressedBroccoli");
    	GameRegistry.registerBlock(CompressedOnion, "CompressedOnion");;
    	GameRegistry.registerBlock(CompressedBeetroot, "CompressedBeetroot");
    	GameRegistry.registerBlock(CompressedCauliflower, "CompressedCauliflower");
    	GameRegistry.registerBlock(CompressedLeek, "CompressedLeek");
    	GameRegistry.registerBlock(CompressedGarlic, "CompressedGarlic");
    			
    	//Ores
    	GameRegistry.registerBlock(KroostylOre, "KroostylOre");
    			
    	//Decorative Blocks
    	GameRegistry.registerBlock(KroostylBlock, "KroostylBlock");
    	GameRegistry.registerBlock(KroostylBricks, "KroostylBricks");
    	GameRegistry.registerBlock(KroostylChiseledBricks, "KroostylChiseledBricks");
    	GameRegistry.registerBlock(KroostylBrickStairs, "KroostylBrickStairs");

    	GameRegistry.registerBlock(Plank, PlankBlockClass.class, Plank.getUnlocalizedName().substring(5));
    			
    	//Trees
    	GameRegistry.registerBlock(Log, LogBlockClass.class, Log.getUnlocalizedName().substring(5));
    	GameRegistry.registerBlock(Leaves, LeavesBlockClass.class, Leaves.getUnlocalizedName().substring(5));
    	GameRegistry.registerBlock(Sapling, SaplingBlockClass.class, Sapling.getUnlocalizedName().substring(5));
    	
    }
    
}