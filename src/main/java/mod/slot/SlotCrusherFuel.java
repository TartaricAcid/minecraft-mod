package mod.slot;

import javax.annotation.Nullable;

import mod.tileentitys.TileEntityCrusher;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;

public class SlotCrusherFuel extends Slot{
	
	public SlotCrusherFuel(IInventory inventoryIn, int slotIndex, int xPosition, int yPosition)
    {
        super(inventoryIn, slotIndex, xPosition, yPosition);
    }

    public boolean isItemValid(@Nullable ItemStack stack)
    {
        return TileEntityFurnace.isItemFuel(stack) || isBucket(stack);
    }

    public int getItemStackLimit(ItemStack stack)
    {
        return isBucket(stack) ? 1 : super.getItemStackLimit(stack);
    }

    public static boolean isBucket(ItemStack stack)
    {
        return stack != null && stack.getItem() != null && stack.getItem() == Items.BUCKET;
    }
	
}
