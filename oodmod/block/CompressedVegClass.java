package oodmod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import oodmod.main.MainClass;

public class CompressedVegClass extends Block {

	public CompressedVegClass() {
		super(Material.grass);
		
		setCreativeTab(MainClass.OodModTab);
		setHardness(0.5F);
		setResistance(1.0F);
		setStepSound(soundTypeGrass);
		
	}

}
