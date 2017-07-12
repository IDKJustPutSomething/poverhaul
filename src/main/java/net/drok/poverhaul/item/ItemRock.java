package net.drok.poverhaul.item;

import javax.annotation.Nullable;

import net.drok.poverhaul.ModBlocks;
import net.drok.poverhaul.ModTabs;
import net.drok.poverhaul.POHMod;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemElytra;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class ItemRock extends Item {

	private final int spacing = 25;
	
	public ItemRock() {
		this.setRegistryName(new ResourceLocation(POHMod.MODID, "rock"));
		this.setMaxDamage(110);
		this.setMaxStackSize(1);
		this.setCreativeTab(ModTabs.TABSTONEAGE);
		
		this.addPropertyOverride(new ResourceLocation("sharpness"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return (int)Math.floor(stack.getMetadata() / spacing);
            }
        });
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		IBlockState state = world.getBlockState(pos);
		Block block = state.getBlock();
		RayTraceResult result = world.rayTraceBlocks(player.getPositionVector(), new Vec3d(pos.getX(), pos.getY(), pos.getZ()));
		ItemStack item = block.getPickBlock(state, result, world, pos, player);
		int[] ids = OreDictionary.getOreIDs(item);
		
		for(int id : ids)
		{
			String oreDict = OreDictionary.getOreName(id);
			if(oreDict == "basalt" || oreDict == "sandstone") {
				player.getHeldItemMainhand().damageItem(POHMod.RAND.nextInt(5) + 1, player);
				return EnumActionResult.SUCCESS;
			}
		}
		
        return EnumActionResult.FAIL;
    }
	
	@Override
	public boolean showDurabilityBar(ItemStack stack)
    {
        return false;
    }
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
        return "item." 
        		+ POHMod.getUnlocalizedNameBase(this.getRegistryName().getResourcePath()) 
        		+ "_" + (int)Math.floor(stack.getMetadata() / spacing);
    }
	
	@SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
    {
        if (this.isInCreativeTab(tab))
        {
        	items.add(new ItemStack(this, 1, 0));
        	items.add(new ItemStack(this, 1, 25));
        	items.add(new ItemStack(this, 1, 50));
        	items.add(new ItemStack(this, 1, 75));
        	items.add(new ItemStack(this, 1, 100));
        }
    }
	
}
