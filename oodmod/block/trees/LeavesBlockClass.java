package oodmod.block.trees;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import oodmod.main.MainClass;

public class LeavesBlockClass extends ItemBlock {

	public static final String[] leaves = new String[] {"Orange"};
	
	public LeavesBlockClass(Block block) {
		super(block);
		this.setHasSubtypes(true);
		
	}
	
	public String getUnlocalizedName(ItemStack itemstack) {
		int i = itemstack.getItemDamage();
		if (i < 0 || i >= leaves.length) {
			i = 0;
		}
		
		return super.getUnlocalizedName() + "." + leaves[i];
		
	}
	
	public int getMetadata (int meta) {
		return meta;
	}
	
}
