package com.jordsta;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;

import com.jordsta.proxies.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MODID, version = Reference.VERSION)
public class Main {
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.COMMON_PROXY)
	public static CommonProxy proxy;
	
	public static Item water;
	public static Item lava;
	public static Block hydrator;
	public static final Item.ToolMaterial TOOL = EnumHelper.addToolMaterial("TOOL", 0, 1, 0.0F, 1.0F, 0);
	
	 @EventHandler
	    public void preInit(FMLPreInitializationEvent event){
		 
		 water = new water(1, TOOL);
		 lava = new lava(1, TOOL);
		 
		 hydrator = new hydrator();
	     RegisterHelper.registerBlock(hydrator);
		 
	      GameRegistry.addRecipe(new ItemStack(water), new Object[]{
              " B ","BS ","  S",'S',Items.stick,'B',Items.water_bucket
      });
	      GameRegistry.addRecipe(new ItemStack(lava), new Object[]{
              "B  "," S ","  S",'S',Items.stick,'B',Items.lava_bucket
      });
	      GameRegistry.addRecipe(new ItemStack(hydrator), new Object[]{
              "BBB","BWB","BBB",'B',Blocks.iron_bars,'W',Items.water_bucket
      });
		 
	      OreDictionary.registerOre("listAllWater", water);
	 }

}
