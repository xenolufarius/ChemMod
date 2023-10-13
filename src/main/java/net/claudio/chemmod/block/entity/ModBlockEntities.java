package net.claudio.chemmod.block.entity;

import net.claudio.chemmod.ChemMod;
import net.claudio.chemmod.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ChemMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<DeconstructorBlockEntity>> DECONSTRUCTOR_BLOCK =
            BLOCK_ENTITIES.register("deconstructor_block", () ->
                    BlockEntityType.Builder.of(DeconstructorBlockEntity::new,
                            ModBlocks.DECONSTRUCTOR_BLOCK.get()).build(null));

    public static final RegistryObject<BlockEntityType<ReconstructorBlockEntity>> RECONSTRUCTOR_BLOCK =
            BLOCK_ENTITIES.register("reconstructor_block", () ->
                    BlockEntityType.Builder.of(ReconstructorBlockEntity::new,
                            ModBlocks.RECONSTRUCTOR_BLOCK.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
