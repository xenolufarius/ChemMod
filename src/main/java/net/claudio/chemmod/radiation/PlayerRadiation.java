package net.claudio.chemmod.radiation;

import net.minecraft.nbt.CompoundTag;

public class PlayerRadiation {

    private int rads;
    private final int MIN_RADS = 0;
    private final int MAX_RADS = 10;

    public int getRads()
    {
        return rads;
    }

    //wont go over 10
    public void addRads(int add)
    {
        this.rads = Math.min((rads + add), 10);
    }

    //wont go below 0
    public void subRads(int sub)
    {
        this.rads = Math.max((rads - sub), MIN_RADS);
    }

    public void copyfrom(PlayerRadiation source)
    {
        this.rads = source.rads;
    }

    public void saveNBTDatat(CompoundTag nbt)
    {
        nbt.putInt("rads", rads);
    }

    public void loadNBTData(CompoundTag nbt)
    {
        rads = nbt.getInt("rads");
    }


}
