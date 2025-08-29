package com.jasonpegasus.oreon.block;

import com.jasonpegasus.oreon.Oreon;
import com.jasonpegasus.oreon.item.OreonItems;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class OreonBlocks
{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Oreon.MODID);

    public static final DeferredBlock<Block> LEAD_BLOCK = AddBlock("lead_block", null, null, null, UniformInt.of(5, 100));






    //registres the block and their item
    private static DeferredBlock<Block> AddBlock(String id, List<DeferredItem<Item>> tab, Item.Properties itemProperties, BlockBehaviour.Properties blockProperties, IntProvider xp)
    {
        BlockBehaviour.Properties defaultProperties = BlockBehaviour.Properties.ofFullCopy(Blocks.STONE);

        DeferredBlock<Block> tempBlock;

        if (xp == null)
        {tempBlock = BLOCKS.register(id, () -> new Block((blockProperties != null) ? blockProperties : defaultProperties));}
        else
        {tempBlock = BLOCKS.register(id, () -> new DropExperienceBlock(xp, (blockProperties != null) ? blockProperties : defaultProperties));}

        OreonItems.AddBlockItem(id, tab, itemProperties, tempBlock);
        return tempBlock;
    }

    public static void register(IEventBus eventBus){BLOCKS.register(eventBus);}
}
