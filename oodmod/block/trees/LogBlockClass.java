package oodmod.block.trees;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import oodmod.main.MainClass;

public class LogBlockClass extends ItemBlock {

	public static final String[] logs = new String[] {"Orange"};
	
	public LogBlockClass(Block block) {
		super(block);
		this.setHasSubtypes(true);
		
	}
	
	public String getUnlocalizedName(ItemStack itemstack) {
		int i = itemstack.getItemDamage();
		if (i < 0 || i >= logs.length) {
			i = 0;
		}
		
		return super.getUnlocalizedName() + "." + logs[i];
		
	}
	
	public int getMetadata (int meta) {
		return meta;
	}

}
