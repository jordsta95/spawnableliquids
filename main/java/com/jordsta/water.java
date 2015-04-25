package com.jordsta;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class water extends ItemAxe {
	public water(int i, ToolMaterial mat) {
		super(mat);
     	setUnlocalizedName("water");
 		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
 		setCreativeTab(CreativeTabs.tabTools);
        RegisterHelper.registerItem(this);
	}
	
	

	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float px, float py, float pz) {
		ForgeDirection dir = ForgeDirection.getOrientation(side);
		int newX = x + dir.offsetX;
		int newY = y + dir.offsetY;
		int newZ = z + dir.offsetZ;
		if(world.isAirBlock(newX, newY, newZ)){
		world.setBlock(newX, newY, newZ, Blocks.water, 0 ,2);
		}
		return false;
	}

	 
	    


	    @SideOnly(Side.CLIENT)
	    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	    {
	        par3List.add("This can be used to spawn water infinitely");
	    }
}
