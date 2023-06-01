package net.antopfr.create_ar.registry;

import static com.simibubi.create.AllTags.AllItemTags.CREATE_INGOTS;
import static com.simibubi.create.AllTags.forgeItemTag;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.antopfr.create_ar.CreateAR;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;

public class ARItems {
    private static final CreateRegistrate REGISTRATE = CreateAR.registrate()
            .creativeModeTab(() -> CreateAR.itemGroup);

    public static final ItemEntry<Item> ALUMINUM_INGOT = taggedIngredient("aluminum_ingot", forgeItemTag("ingots/aluminum"), CREATE_INGOTS.tag);

    public static void register(IEventBus eventBus) {

    }

    @SafeVarargs
    private static ItemEntry<Item> taggedIngredient(String name, TagKey<Item>... tags) {
        return REGISTRATE.item(name, Item::new)
                .tag(tags)
                .register();
    }
}