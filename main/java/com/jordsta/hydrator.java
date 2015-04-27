package com.jordsta;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class hydrator extends Block {
	public hydrator(){
		super(Material.rock);
		setBlockName("hydrator");
		setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabTools);
		setHardness(5.0f);
		setResistance(3.0f);
		setHarvestLevel("pickaxe", 1);
	}
	
	@Override
	public Material getMaterial(){
		StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        	if(stack[2].getClassName().equals("net.minecraft.block.BlockFarmland"))
            		return Material.water;
        	return super.getMaterial();
	}
	
	 public void onNeighborBlockChange(World world, int posX, int posY, int posZ, Block neighbourBlock){
		 if(world.isAirBlock(posX, posY + 1, posZ)){
		 if(world.getBlock(posX, posY + 1, posZ) == Blocks.obsidian){ 
		 world.setBlock(posX, posY+1, posZ, Blocks.lava,0,2);
		 } else if(world.getBlock(posX, posY - 1, posZ) == Blocks.obsidian){
			 world.setBlock(posX, posY+1, posZ, Blocks.lava,0,2);
			 world.setBlock(posX, posY - 1, posZ, Blocks.air);
		 }
		 if(world.getBlock(posX, posY , posZ + 1) == Blocks.obsidian){
			 world.setBlock(posX, posY+1, posZ, Blocks.lava,0,2);
			 world.setBlock(posX, posY, posZ+1, Blocks.air);
		 }
		 if(world.getBlock(posX, posY , posZ - 1) == Blocks.obsidian){
			 world.setBlock(posX, posY+1, posZ, Blocks.lava,0,2);
			 world.setBlock(posX, posY, posZ-1, Blocks.air);
		 }
		 
		 if(world.getBlock(posX + 1, posY , posZ) == Blocks.obsidian){
			 world.setBlock(posX, posY+1, posZ, Blocks.lava,0,2);
			 world.setBlock(posX+1, posY, posZ, Blocks.air);
		 }
		 if(world.getBlock(posX - 1, posY , posZ) == Blocks.obsidian){
			 world.setBlock(posX, posY+1, posZ, Blocks.lava,0,2);
			 world.setBlock(posX-1, posY, posZ, Blocks.air);
		 }
		 
	 }
	
	 }
	

}
