package oodmod.item.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSword;
import oodmod.main.MainClass;

public class KroostylSwordClass extends ItemSword {

	public KroostylSwordClass(ToolMaterial material) {
		super(material);
		
		setCreativeTab(MainClass.OodModTab);
		setTextureName(MainClass.MODID + ":KroostylSword");
		
	}

}