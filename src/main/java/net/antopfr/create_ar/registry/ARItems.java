package net.antopfr.create_ar.registry;

import static com.simibubi.create.AllTags.AllItemTags.*;
import static com.simibubi.create.AllTags.forgeItemTag;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.antopfr.create_ar.CreateAR;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.Tags;

public class ARItems {
    private static final CreateRegistrate REGISTRATE = CreateAR.registrate()
            .creativeModeTab(() -> CreateAR.itemGroup);

    public static final ItemEntry<Item> ALUMINUM_INGOT = taggedIngredient("aluminum_ingot", forgeItemTag("ingots/aluminum"), CREATE_INGOTS.tag);

    public static final ItemEntry<Item> ALUMINUM_SHEET = taggedIngredient("aluminum_sheet", forgeItemTag("plates/aluminum"), PLATES.tag);

    public static final ItemEntry<Item> ALUMINUM_NUGGET = taggedIngredient("aluminum_nugget", forgeItemTag("nuggets/aluminum"), Tags.Items.NUGGETS);

    public static final ItemEntry<Item> CRUSHED_BAUXITE = taggedIngredient("crushed_raw_iron", CRUSHED_RAW_MATERIALS.tag);


    @SafeVarargs
    private static ItemEntry<Item> taggedIngredient(String name, TagKey<Item>... tags) {
        return REGISTRATE.item(name, Item::new)
                .tag(tags)
                .register();
    }

    public static void register() {}
}