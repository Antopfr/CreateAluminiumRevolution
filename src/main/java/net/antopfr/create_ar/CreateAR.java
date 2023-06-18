package net.antopfr.create_ar;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.antopfr.create_ar.registry.ARBlocks;
import net.antopfr.create_ar.registry.ARItems;
import net.antopfr.create_ar.registry.ARBlockEntityTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CreateAR.MOD_ID)
public class CreateAR {
    public static final String MOD_ID = "create_ar";
    public static final String NAME = "Create: Aluminium Revolution";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);
    private static final CreateRegistrate REGISTRATE = CreateRegistrate.create(CreateAR.MOD_ID);

    public static final CreativeModeTab itemGroup = new CreativeModeTab(MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ARItems.ALUMINUM_INGOT.get());
        }
    };

    public CreateAR()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        CreateAR.REGISTRATE.registerEventListeners(eventBus);

        ARBlocks.register();
        ARItems.register();
        ARBlockEntityTypes.register();
    }

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
    private void setup(final FMLCommonSetupEvent event) {}

    public static CreateRegistrate registrate() {
        return REGISTRATE;
    }
}