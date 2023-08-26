package net.claudio.chemmod.radiation;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerRadiationProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

    public static Capability<PlayerRadiation> PLAYER_RADS = CapabilityManager.get(new CapabilityToken<PlayerRadiation>(){
    });

    private PlayerRadiation rads = null;
    private final LazyOptional<PlayerRadiation> optional = LazyOptional.of(this::createPlayerRadiation);

    private PlayerRadiation createPlayerRadiation() {
        if(this.rads == null)
        {
            this.rads = new PlayerRadiation();
        }
        return this.rads;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == PLAYER_RADS)
        {
            return optional.cast();
        }


        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerRadiation().saveNBTDatat(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPlayerRadiation().loadNBTData(nbt);
    }
}
