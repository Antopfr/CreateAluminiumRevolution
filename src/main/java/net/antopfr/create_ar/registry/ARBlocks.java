package net.antopfr.create_ar.registry;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllSpriteShifts;
import com.simibubi.create.content.decoration.encasing.CasingBlock;
import com.simibubi.create.content.decoration.encasing.EncasingRegistry;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogCTBehaviour;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogwheelBlock;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedShaftBlock;
import com.simibubi.create.foundation.data.BuilderTransformers;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.utility.Couple;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.antopfr.create_ar.CreateAR;
import net.antopfr.create_ar.ARSpriteShifts;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.NotNull;


import static com.simibubi.create.foundation.data.BlockStateGen.axisBlock;
import static com.simibubi.create.foundation.data.BlockStateGen.simpleCubeAll;
import static com.simibubi.create.foundation.data.TagGen.*;

public class ARBlocks {
    private static final CreateRegistrate REGISTRATE = CreateAR.registrate()
            .creativeModeTab(() -> CreateAR.itemGroup);

    // - https://github.com/Creators-of-Create/Create/blob/mc1.18/dev/src/main/java/com/simibubi/create/AllBlocks.java

        public static final BlockEntry<Block> ALUMINUM_BLOCK = REGISTRATE.block("aluminum_block", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .properties(ARBlocks::aluminumProperties)
            .properties(p -> p.requiresCorrectToolForDrops())
            .transform(pickaxeOnly())
            .blockstate(simpleCubeAll("aluminum_block"))
            .tag(BlockTags.NEEDS_IRON_TOOL)
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .tag(BlockTags.BEACON_BASE_BLOCKS)
            .transform(tagBlockAndItem("storage_blocks/aluminum"))
            .tag(Tags.Items.STORAGE_BLOCKS)
            .build()
            .lang("Block of Aluminium")
            .register();

    public static final BlockEntry<Block> BAUXITE_BLOCK = REGISTRATE.block("bauxite_block", Block::new)
            .initialProperties(() -> Blocks.IRON_ORE)
            .properties(p -> p.color(MaterialColor.PODZOL))
            .properties(p -> p.requiresCorrectToolForDrops())
            .transform(pickaxeOnly())
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .tag(BlockTags.NEEDS_IRON_TOOL)
            .lang("Block of Bauxite")
            .transform(tagBlockAndItem("storage_blocks/bauxite"))
            .tag(Tags.Items.STORAGE_BLOCKS)
            .build()
            .register();



//   Aluminum Casing
    public static final BlockEntry<CasingBlock> ALUMINUM_CASING = REGISTRATE.block("aluminum_casing", CasingBlock::new)
            .properties(ARBlocks::aluminumProperties)
            .transform(BuilderTransformers.casing(() -> ARSpriteShifts.ALUMINUM_CASING))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<EncasedShaftBlock> ALUMINUM_ENCASED_SHAFT = REGISTRATE
            .block("aluminum_encased_shaft", p -> new EncasedShaftBlock(p, ARBlocks.ALUMINUM_CASING::get))
            .properties(ARBlocks::aluminumProperties)
            .transform(BuilderTransformers.encasedShaft("aluminum", () -> ARSpriteShifts.ALUMINUM_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.SHAFT))
            .transform(axeOrPickaxe())
            .register();
    public static final BlockEntry<EncasedCogwheelBlock> ALUMINUM_ENCASED_COGWHEEL = REGISTRATE
            .block("aluminum_encased_cogwheel", p -> new EncasedCogwheelBlock(p, false, ARBlocks.ALUMINUM_CASING::get))
            .properties(ARBlocks::aluminumProperties)
            .transform(BuilderTransformers.encasedCogwheel("aluminum", () -> ARSpriteShifts.ALUMINUM_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.COGWHEEL))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(ARSpriteShifts.ALUMINUM_CASING,
                    Couple.create(ARSpriteShifts.ALUMINUM_ENCASED_COGWHEEL_SIDE,
                            ARSpriteShifts.ALUMINUM_ENCASED_COGWHEEL_OTHERSIDE))))
            .transform(axeOrPickaxe())
            .register();


    public static final BlockEntry<EncasedCogwheelBlock> ALUMINUM_ENCASED_LARGE_COGWHEEL = REGISTRATE
            .block("aluminum_encased_large_cogwheel",
                    p -> new EncasedCogwheelBlock(p, true, ARBlocks.ALUMINUM_CASING::get))
            .properties(ARBlocks::aluminumProperties)
            .transform(BuilderTransformers.encasedLargeCogwheel("aluminum", () -> ARSpriteShifts.ALUMINUM_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.LARGE_COGWHEEL))
            .transform(axeOrPickaxe())
            .register();

    public static BlockBehaviour.@NotNull Properties aluminumProperties(BlockBehaviour.Properties properties) {
        return properties.sound(SoundType.METAL).strength(6, 6).color(MaterialColor.WOOL);
    }

    public static void register() {}
}
