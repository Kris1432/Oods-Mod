package oodmod.item.tools;

import oodmod.main.MainClass;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class KroostylPickaxeClass extends ItemPickaxe {

	public KroostylPickaxeClass(ToolMaterial material) {
		super(material);
		
		setCreativeTab(MainClass.OodModTab);
		setTextureName(MainClass.MODID + ":KroostylPickaxe");
		
	}

}
