package net.claudio.chemmod.client;

public class ClientRadiationData {
    private static int playerRads;

    public static void set(int rads)
    {
        ClientRadiationData.playerRads = rads;
    }

    public static int getPlayerRads()
    {
        return playerRads;
    }



}
