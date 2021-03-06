package oodmod.block.trees;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import oodmod.main.MainClass;

public class PlankClass extends Block
{
  public static final String[] planks = {"Orange"};

  @SideOnly(Side.CLIENT)
  private IIcon[] field_150095_b;

  public PlankClass() {
    super(Material.wood);
    
    setCreativeTab(MainClass.OodModTab);
    setHardness(2.0F);
    setResistance(5.0F);
    setStepSound(soundTypeWood);
	setHarvestLevel("axe", 0);
    
  }

  @SideOnly(Side.CLIENT)
  public IIcon getIcon(int par1, int par2) {
    if ((par2 < 0) || (par2 >= this.field_150095_b.length)) {
      par2 = 0;
    }
    return this.field_150095_b[par2];
  }

  public int damageDropped(int par1)
  {
    return par1;
  }

  @SideOnly(Side.CLIENT)
	public void getSubBlocks (Item item, CreativeTabs tabs, List list) {
		for (int i = 0; i < planks.length; i++) {
			list.add(new ItemStack(item, 1, i));
		}
		
  }

  @SideOnly(Side.CLIENT)
  public void registerBlockIcons(IIconRegister iconRegister) {
    this.field_150095_b = new IIcon[planks.length];

    for (int i = 0; i < this.field_150095_b.length; i++)
      this.field_150095_b[i] = iconRegister.registerIcon(MainClass.MODID + ":" + planks[i] + "Planks");
  }
  
}