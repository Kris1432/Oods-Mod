package oodmod.item.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSpade;
import oodmod.main.MainClass;

public class KroostylShovelClass extends ItemSpade {

	public KroostylShovelClass(ToolMaterial material) {
		super(material);
		
		setCreativeTab(MainClass.OodModTab);
		setTextureName(MainClass.MODID + ":KroostylShovel");
		
	}

}