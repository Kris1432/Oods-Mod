package oodmod.block.crop;

import java.util.Random;

import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import oodmod.item.ItemClass;
import oodmod.main.MainClass;

public class OnionCropClass extends BlockCrops {
	
	private IIcon[] iconArray;
	
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.iconArray = new IIcon[4];
		
		for (int i = 0; i < this.iconArray.length; i++) {
			this.iconArray[i] = iconRegister.registerIcon(MainClass.MODID + ":" + this.getUnlocalizedName().substring(5) + (i + 1));
		}
	}
	
	public IIcon getIcon(int side, int metadata) {
		if (metadata < 7) {
			if (metadata == 6) {
				metadata = 5;
			}
			
			return this.iconArray[metadata >> 1];
			
		}
		
		return this.iconArray[3];
		
	}
	
	public int quantityDropped (Random random) {
		return 1;
	}
	
	protected Item func_149866_i() {
		return ItemClass.OnionSeeds;
	}
	
	protected Item func_149865_P() {
		return ItemClass.Onion;
	}

}
