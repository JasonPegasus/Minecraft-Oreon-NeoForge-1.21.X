package com.jasonpegasus.oreon.item;

import com.jasonpegasus.oreon.Oreon;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

public class OreonItems
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Oreon.MODID); //objeto registrador de items
    // TABS //
    public static final List<DeferredItem<Item>> tab_INGREDIENTS = new ArrayList<>();
    public static final List<DeferredItem<Item>> tab_BUILDING = new ArrayList<>();

    // ITEMS //
    public static final DeferredItem<Item> LEAD_INGOT = AddItem("lead_ingot", null, null);
    public static final DeferredItem<Item> RAW_LEAD = AddItem("raw_lead", null, null);






    // add items //

    private static DeferredItem<Item> AddItem(String id, List<DeferredItem<Item>> tab, Item.Properties properties)
    {
        DeferredItem<Item> tempItem = ITEMS.register(id, () -> new Item((properties != null) ? properties : new Item.Properties()));
        if (tab != null){tab.add(tempItem);}
        return tempItem;
    }

    public static <T extends Block> DeferredItem<Item> AddBlockItem(String id, List<DeferredItem<Item>> tab, Item.Properties properties, DeferredBlock<T> block)
    {
        DeferredItem<Item> tempItem = ITEMS.register(id, () -> new BlockItem(block.get(),(properties != null) ? properties : new Item.Properties()));
        if (tab != null){tab.add(tempItem);}
        return tempItem;
    }

    public static void register(IEventBus eventBus){ITEMS.register(eventBus);}
}
