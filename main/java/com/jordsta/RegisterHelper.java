package com.jordsta;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterHelper {

	public static void registerBlock(Block block){
		GameRegistry.registerBlock(block, Reference.MODID + " " + block.getUnlocalizedName().substring(5));
	}

	public static void registerItem(Item item){
		GameRegistry.registerItem(item, Reference.MODID + " " + item.getUnlocalizedName().substring(5));
	}

	public static void registerOreDict(Item item, String name){
		OreDictionary.registerOre(name, new ItemStack(item));
	}
}
