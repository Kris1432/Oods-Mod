package oodmod.worldgen;

import java.util.Random;

import oodmod.block.BlockClass;
import oodmod.main.MainClass;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.util.ForgeDirection;

public class OrangeTreeGenerationClass extends WorldGenAbstractTree
{
  private final int minTreeHeight;
  private final int randomTreeHeight;
  
  private final boolean vinesGrow;
  
  private final Block wood;
  private final Block leaves;
  
  private final int metaWood;
  private final int metaLeaves;

  public OrangeTreeGenerationClass(Block wood, Block leaves, int metaWood, int metaLeaves)
  {
    this(wood, leaves, metaWood, metaLeaves, false, 4, 3, false);
  }

  public OrangeTreeGenerationClass(Block wood, Block leaves, int metaWood, int metaLeaves, boolean doBlockNotify, int minTreeHeight, int randomTreeHeight, boolean vinesGrow)
  {
    super(doBlockNotify);
    
    this.wood = wood;
    this.leaves = leaves;
    this.minTreeHeight = minTreeHeight;
    this.randomTreeHeight = randomTreeHeight;
    this.metaWood = metaWood;
    this.metaLeaves = metaLeaves;
    this.vinesGrow = vinesGrow;
  }

  public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
  {
    int l = par2Random.nextInt(3) + this.minTreeHeight;
    boolean flag = true;

    if ((par4 >= 1) && (par4 + l + 1 <= 256))
    {
      for (int i1 = par4; i1 <= par4 + 1 + l; i1++)
      {
        byte b0 = 1;

        if (i1 == par4)
        {
          b0 = 0;
        }

        if (i1 >= par4 + 1 + l - 2)
        {
          b0 = 2;
        }

        for (int j1 = par3 - b0; (j1 <= par3 + b0) && (flag); j1++)
        {
          for (int k1 = par5 - b0; (k1 <= par5 + b0) && (flag); k1++)
          {
            if ((i1 >= 0) && (i1 < 256))
            {
              Block block = par1World.getBlock(j1, i1, k1);

              if (!isReplaceable(par1World, j1, i1, k1))
              {
                flag = false;
              }
            }
            else
            {
              flag = false;
            }
          }
        }
      }

      if (!flag)
      {
        return false;
      }

      Block block2 = par1World.getBlock(par3, par4 - 1, par5);

      boolean isSoil = block2.canSustainPlant(par1World, par3, par4 - 1, par5, ForgeDirection.UP, (BlockSapling)BlockClass.Sapling);
      if ((isSoil) && (par4 < 256 - l - 1))
      {
        block2.onPlantGrow(par1World, par3, par4 - 1, par5, par3, par4, par5);
        byte b0 = 3;
        byte b1 = 0;

        for (int k1 = par4 - b0 + l; k1 <= par4 + l; k1++)
        {
          int i3 = k1 - (par4 + l);
          int l1 = b1 + 1 - i3 / 2;

          for (int i2 = par3 - l1; i2 <= par3 + l1; i2++)
          {
            int j2 = i2 - par3;

            for (int k2 = par5 - l1; k2 <= par5 + l1; k2++)
            {
              int l2 = k2 - par5;

              if ((Math.abs(j2) != l1) || (Math.abs(l2) != l1) || ((par2Random.nextInt(2) != 0) && (i3 != 0)))
              {
                Block block1 = par1World.getBlock(i2, k1, k2);

                if ((block1.isAir(par1World, i2, k1, k2)) || (block1.isLeaves(par1World, i2, k1, k2)))
                {
                  setBlockAndNotifyAdequately(par1World, i2, k1, k2, BlockClass.Leaves, this.metaLeaves);
                }
              }
            }
          }
        }

        int k1;
		for (k1 = 0; k1 < l; k1++)
        {
          Block block = par1World.getBlock(par3, par4 + k1, par5);

          if ((block.isAir(par1World, par3, par4 + k1, par5)) || (block.isLeaves(par1World, par3, par4 + k1, par5)))
          {
            setBlockAndNotifyAdequately(par1World, par3, par4 + k1, par5, BlockClass.Log, this.metaWood);

            if ((this.vinesGrow) && (k1 > 0))
            {
              if ((par2Random.nextInt(3) > 0) && (par1World.isAirBlock(par3 - 1, par4 + k1, par5)))
              {
                setBlockAndNotifyAdequately(par1World, par3 - 1, par4 + k1, par5, Blocks.vine, 8);
              }

              if ((par2Random.nextInt(3) > 0) && (par1World.isAirBlock(par3 + 1, par4 + k1, par5)))
              {
                setBlockAndNotifyAdequately(par1World, par3 + 1, par4 + k1, par5, Blocks.vine, 2);
              }

              if ((par2Random.nextInt(3) > 0) && (par1World.isAirBlock(par3, par4 + k1, par5 - 1)))
              {
                setBlockAndNotifyAdequately(par1World, par3, par4 + k1, par5 - 1, Blocks.vine, 1);
              }

              if ((par2Random.nextInt(3) > 0) && (par1World.isAirBlock(par3, par4 + k1, par5 + 1)))
              {
                setBlockAndNotifyAdequately(par1World, par3, par4 + k1, par5 + 1, Blocks.vine, 4);
              }
            }
          }
        }

        if (this.vinesGrow)
        {
          for (k1 = par4 - 3 + l; k1 <= par4 + l; k1++)
          {
            int i3 = k1 - (par4 + l);
            int l1 = 2 - i3 / 2;

            for (int i2 = par3 - l1; i2 <= par3 + l1; i2++)
            {
              for (int j2 = par5 - l1; j2 <= par5 + l1; j2++)
              {
                if (par1World.getBlock(i2, k1, j2).isLeaves(par1World, i2, k1, j2))
                {
                  if ((par2Random.nextInt(4) == 0) && (par1World.getBlock(i2 - 1, k1, j2).isAir(par1World, i2 - 1, k1, j2)))
                  {
                    growVines(par1World, i2 - 1, k1, j2, 8);
                  }

                  if ((par2Random.nextInt(4) == 0) && (par1World.getBlock(i2 + 1, k1, j2).isAir(par1World, i2 + 1, k1, j2)))
                  {
                    growVines(par1World, i2 + 1, k1, j2, 2);
                  }

                  if ((par2Random.nextInt(4) == 0) && (par1World.getBlock(i2, k1, j2 - 1).isAir(par1World, i2, k1, j2 - 1)))
                  {
                    growVines(par1World, i2, k1, j2 - 1, 1);
                  }

                  if ((par2Random.nextInt(4) == 0) && (par1World.getBlock(i2, k1, j2 + 1).isAir(par1World, i2, k1, j2 + 1)))
                  {
                    growVines(par1World, i2, k1, j2 + 1, 4);
                  }
                }
              }
            }
          }

          if ((par2Random.nextInt(5) == 0) && (l > 5))
          {
            for (k1 = 0; k1 < 2; k1++)
            {
              for (int i3 = 0; i3 < 4; i3++)
              {
                if (par2Random.nextInt(4 - k1) == 0)
                {
                  int l1 = par2Random.nextInt(3);
                  setBlockAndNotifyAdequately(par1World, par3 + net.minecraft.util.Direction.offsetX[net.minecraft.util.Direction.rotateOpposite[i3]], par4 + l - 5 + k1, par5 + net.minecraft.util.Direction.offsetZ[net.minecraft.util.Direction.rotateOpposite[i3]], Blocks.cocoa, l1 << 2 | i3);
                }
              }
            }
          }
        }

        return true;
      }

      return false;
    }

    return false;
  }

  private void growVines(World par1World, int par2, int par3, int par4, int par5)
  {
    setBlockAndNotifyAdequately(par1World, par2, par3, par4, Blocks.vine, par5);
    int i1 = 4;
    while (true)
    {
      par3--;

      if ((par1World.getBlock(par2, par3, par4).isAir(par1World, par2, par3, par4)) || (i1 <= 0))
      {
        return;
      }

      setBlockAndNotifyAdequately(par1World, par2, par3, par4, Blocks.vine, par5);
      i1--;
    }
  }
}