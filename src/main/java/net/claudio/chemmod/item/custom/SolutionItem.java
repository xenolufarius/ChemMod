package net.claudio.chemmod.item.custom;



import net.claudio.chemmod.ChemMod;
import net.claudio.chemmod.item.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtIo;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class SolutionItem extends Item {
    public static final String ITEM_CHEMMOD = "item.chemmod.";

    //Temp variables that can be called upon for desc.
    //Actual values are added in via next method
    //AMU,CF,RAD,STAB
    //Anything else?
    //Maybe short Description


    //Exclusive for solutionsvvvvv
    private double cVOL;
    private ChemicalItem cCHEM1;
    private double cMCHEM1;
    private ChemicalItem cCHEM2;
    private double cMCHEM2;
    private ChemicalItem cCHEM3;
    private double cMCHEM3;
    private ChemicalItem cCHEM4;
    private double cMCHEM4;
    private ChemicalItem cCHEM5;
    private double cMCHEM5;
    private ChemicalItem cCHEM6;
    private double cMCHEM6;

    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    private int cSTAB;
    private String cDESC;
    private String cSDS;
    //possible constructor for solutions vvvvvv
    /*
    public SolutionItem(Properties properties, double VOL, ChemicalItem CHEM1, double MCHEM1, ChemicalItem CHEM2, double MCHEM2,
                        ChemicalItem CHEM3, double MCHEM3, ChemicalItem CHEM4, double MCHEM4, ChemicalItem CHEM5, double MCHEM5,
                        ChemicalItem CHEM6, double MCHEM6, int STAB, String DESC, String SDS) {
        super(properties);

        this.cVOL = VOL;
        this.cCHEM1 = CHEM1;
        this.cMCHEM1 = MCHEM1;
        this.cCHEM2 = CHEM2;
        this.cMCHEM2 = MCHEM2;
        this.cCHEM3 = CHEM3;
        this.cMCHEM3 = MCHEM3;
        this.cCHEM4 = CHEM4;
        this.cMCHEM4 = MCHEM4;
        this.cCHEM5 = CHEM5;
        this.cMCHEM5 = MCHEM5;
        this.cCHEM6 = CHEM6;
        this.cMCHEM6 = MCHEM6;

        this.cSTAB = STAB;
        this.cDESC = DESC;
        this.cSDS = SDS;
    }


     */

    public SolutionItem(Properties properties){
        super(properties);
    }

    private static final String VOL = "Volume";
    private static final String CHEM1NAME = "Chemical1Name";
    private static final String CHEM1MOLE = "Chemical1MoleAmount";
    private static final String CHEM2NAME = "Chemical2Name";
    private static final String CHEM2MOLE = "Chemical2MoleAmount";
    private static final String CHEM3NAME = "Chemical3Name";
    private static final String CHEM3MOLE = "Chemical3MoleAmount";
    private static final String CHEM4NAME = "Chemical4Name";
    private static final String CHEM4MOLE = "Chemical4MoleAmount";
    private static final String CHEM5NAME = "Chemical5Name";
    private static final String CHEM5MOLE = "Chemical5MoleAmount";
    private static final String CHEM6NAME = "Chemical6Name";
    private static final String CHEM6MOLE = "Chemical7MoleAmount";
    private static final String TEMPCHEM = "TemporaryChem";

    public ItemStack createNewBeaker() {
        ItemStack replacement = new ItemStack(this);
        // Add any additional data or properties to the new beaker item
        // For example, copy the NBT data or other properties you need
        // ...
        CompoundTag nbt = new CompoundTag();

        //Half a liter of water
        nbt.putDouble("SoluteMoles",27.7469);
        nbt.putDouble(CHEM1MOLE,0.0);
        nbt.putDouble(CHEM2MOLE,0.0);
        nbt.putDouble(CHEM3MOLE,0.0);
        nbt.putDouble(CHEM4MOLE,0.0);
        nbt.putDouble(CHEM5MOLE,0.0);
        nbt.putDouble(CHEM6MOLE,0.0);
        nbt.putString(CHEM1NAME,"N/A");
        nbt.putString(CHEM2NAME,"N/A");
        nbt.putString(CHEM3NAME,"N/A");
        nbt.putString(CHEM4NAME,"N/A");
        nbt.putString(CHEM5NAME,"N/A");
        nbt.putString(CHEM6NAME,"N/A");
        nbt.putString(TEMPCHEM,"Empty");



        replacement.setTag(nbt);

        return replacement;
    }

    //todo: works so far. optimistic. need to expand it now
    //Changed from void to have it return the new beaker to wherever it was
    public ItemStack addChemicalToBeaker(ItemStack beaker, ChemicalItem chemical)
    {
        CompoundTag nbt = beaker.getTag();
        if(nbt == null)
        {
            beaker = createNewBeaker();
            nbt = beaker.getTag();
            //nbt = new CompoundTag();
        }
        String chem1 = nbt.getString(CHEM1NAME);
        String chem2 = nbt.getString(CHEM2NAME);
        String chem3 = nbt.getString(CHEM3NAME);
        String chem4 = nbt.getString(CHEM4NAME);
        String chem5 = nbt.getString(CHEM5NAME);
        String chem6 = nbt.getString(CHEM6NAME);

        if("Water".equals(chemical.getName()))
        {
            Double currentMole = nbt.getDouble("SoluteMoles");
            Double newMole = currentMole + 1.0;
            nbt.putDouble("SoluteMoles", newMole);
        }
        if(chem1.equals(chemical.getName()))
        {
            Double currentMole = nbt.getDouble(CHEM1MOLE);
            Double newMole = currentMole + 1.0;
            nbt.putDouble(CHEM1MOLE, newMole);
        }
        else if(chem1.isBlank() || chem1.equals("N/A")) {
            nbt.putString(CHEM1NAME, chemical.getName());
            Double currentMole = nbt.getDouble(CHEM1MOLE);
            Double newMole = currentMole + 1.0;
            nbt.putDouble(CHEM1MOLE, newMole);
        }
        else {
            if(chem2.equals(chemical.getName()))
            {
                Double currentMole = nbt.getDouble(CHEM2MOLE);
                Double newMole = currentMole + 1.0;
                nbt.putDouble(CHEM2MOLE, newMole);
            }
            else if(chem2.isBlank() || chem2.equals("N/A")) {
                nbt.putString(CHEM2NAME, chemical.getName());
                Double currentMole = nbt.getDouble(CHEM2MOLE);
                Double newMole = currentMole + 1.0;
                nbt.putDouble(CHEM2MOLE, newMole);
            }
            else {
                if(chem3.equals(chemical.getName()))
                {
                    Double currentMole = nbt.getDouble(CHEM3MOLE);
                    Double newMole = currentMole + 1.0;
                    nbt.putDouble(CHEM3MOLE, newMole);
                }
                else if(chem3.isBlank() || chem3.equals("N/A")) {
                    nbt.putString(CHEM3NAME, chemical.getName());
                    Double currentMole = nbt.getDouble(CHEM3MOLE);
                    Double newMole = currentMole + 1.0;
                    nbt.putDouble(CHEM3MOLE, newMole);
                }
                else {
                    if(chem4.equals(chemical.getName()))
                    {
                        Double currentMole = nbt.getDouble(CHEM4MOLE);
                        Double newMole = currentMole + 1.0;
                        nbt.putDouble(CHEM4MOLE, newMole);
                    }
                    else if(chem4.isBlank() || chem4.equals("N/A")) {
                        nbt.putString(CHEM4NAME, chemical.getName());
                        Double currentMole = nbt.getDouble(CHEM4MOLE);
                        Double newMole = currentMole + 1.0;
                        nbt.putDouble(CHEM4MOLE, newMole);
                    }
                    else {
                        if(chem5.equals(chemical.getName()))
                        {
                            Double currentMole = nbt.getDouble(CHEM5MOLE);
                            Double newMole = currentMole + 1.0;
                            nbt.putDouble(CHEM5MOLE, newMole);
                        }
                        else if(chem5.isBlank() || chem5.equals("N/A")) {
                            nbt.putString(CHEM5NAME, chemical.getName());
                            Double currentMole = nbt.getDouble(CHEM5MOLE);
                            Double newMole = currentMole + 1.0;
                            nbt.putDouble(CHEM5MOLE, newMole);
                        }else {
                            if(chem6.equals(chemical.getName()))
                            {
                                Double currentMole = nbt.getDouble(CHEM6MOLE);
                                Double newMole = currentMole + 1.0;
                                nbt.putDouble(CHEM6MOLE, newMole);
                            }
                            else if(chem6.isBlank() || chem6.equals("N/A")) {
                                nbt.putString(CHEM6NAME, chemical.getName());
                                Double currentMole = nbt.getDouble(CHEM6MOLE);
                                Double newMole = currentMole + 1.0;
                                nbt.putDouble(CHEM6MOLE, newMole);
                            }
                        }
                    }
                }
            }
        }


        ItemStack newBeaker = beaker.copy();


        newBeaker.setTag(nbt);

        //testing getChemical method
        //ItemStack newBeaker = new ItemStack(getChemical(chemical.getName()));
        return newBeaker;
    }

    public ItemStack removeChemicalFromBeaker(ItemStack beaker)
    {
        CompoundTag nbt = beaker.getTag();
        if(nbt == null)
        {
            nbt = new CompoundTag();
        }
        String chem1 = nbt.getString(CHEM1NAME);
        String chem2 = nbt.getString(CHEM2NAME);
        String chem3 = nbt.getString(CHEM3NAME);
        String chem4 = nbt.getString(CHEM4NAME);
        String chem5 = nbt.getString(CHEM5NAME);
        String chem6 = nbt.getString(CHEM6NAME);

        ChemicalItem che = getChemical(chem1);
        if(getChemical(chem1).getcSOL() == 2)
        {
            Double currentMole = nbt.getDouble(CHEM1MOLE);
            Double newMole = Math.max(0,currentMole - 1.0);
            nbt.putDouble(CHEM1MOLE, newMole);
            if(nbt.getDouble(CHEM1MOLE) == 0)
            {
                nbt.putString(CHEM1NAME, "N/A");
            }
            nbt.putString(TEMPCHEM, chem1);
        }
        else {
            if (getChemical(chem2).getcSOL() == 2) {
                Double currentMole = nbt.getDouble(CHEM2MOLE);
                Double newMole = Math.max(0, currentMole - 1.0);
                nbt.putDouble(CHEM2MOLE, newMole);
                if (nbt.getDouble(CHEM2MOLE) == 0) {
                    nbt.putString(CHEM2NAME, "N/A");
                }
                nbt.putString(TEMPCHEM, chem2);
            }
            else {
                if (getChemical(chem3).getcSOL() == 2) {
                    Double currentMole = nbt.getDouble(CHEM3MOLE);
                    Double newMole = Math.max(0, currentMole - 1.0);
                    nbt.putDouble(CHEM3MOLE, newMole);
                    if (nbt.getDouble(CHEM3MOLE) == 0) {
                        nbt.putString(CHEM3NAME, "N/A");
                    }
                    nbt.putString(TEMPCHEM, chem3);
                }
                else {
                    if (getChemical(chem4).getcSOL() == 2) {
                        Double currentMole = nbt.getDouble(CHEM4MOLE);
                        Double newMole = Math.max(0, currentMole - 1.0);
                        nbt.putDouble(CHEM4MOLE, newMole);
                        if (nbt.getDouble(CHEM4MOLE) == 0) {
                            nbt.putString(CHEM4NAME, "N/A");
                        }
                        nbt.putString(TEMPCHEM, chem4);
                    }
                    else {
                        if (getChemical(chem5).getcSOL() == 2) {
                            Double currentMole = nbt.getDouble(CHEM5MOLE);
                            Double newMole = Math.max(0, currentMole - 1.0);
                            nbt.putDouble(CHEM5MOLE, newMole);
                            if (nbt.getDouble(CHEM5MOLE) == 0) {
                                nbt.putString(CHEM5NAME, "N/A");
                            }
                            nbt.putString(TEMPCHEM, chem5);
                        }
                        else {
                            if (getChemical(chem6).getcSOL() == 2) {
                                Double currentMole = nbt.getDouble(CHEM6MOLE);
                                Double newMole = Math.max(0, currentMole - 1.0);
                                nbt.putDouble(CHEM6MOLE, newMole);
                                if (nbt.getDouble(CHEM6MOLE) == 0) {
                                    nbt.putString(CHEM6NAME, "N/A");
                                }
                                nbt.putString(TEMPCHEM, chem6);
                            }
                        }
                    }
                }
            }
        }





        ItemStack newBeaker = beaker.copy();

        beaker = createNewBeaker();
        newBeaker.setTag(nbt);

        return newBeaker;
    }

    public ItemStack getChemicalFromBeaker(ItemStack beaker)
    {
        CompoundTag nbt = beaker.getTag();
        if(nbt == null)
        {
            nbt = new CompoundTag();
        }
        String temp = nbt.getString(TEMPCHEM);

        ChemicalItem che = getChemical(temp);
        ItemStack chemical = new ItemStack(che);

        nbt.putString(TEMPCHEM, "Empty");
        beaker.setTag(nbt);


        return chemical;
    }

    //STAB = Stability Index. Essentially reactivity. Number can be used to pass a check to see if it reacts with other possible chemicals??
    //OR, can be used as a sort of timer to determine decomposition. Same concept, but applied differently.
    public int getcSTAB() {
        return cSTAB;
    }
    //DESC = Description. Optional description for adding in facts about item
    public String getcDESC(){return cDESC;}
    //FOOD = String that will be put through an even to handle custom eating properties
    public String getcSDS(){return cSDS;}

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if (Screen.hasShiftDown())
        {
            CompoundTag nbt = stack.getTag();
            if (nbt == null)
                stack = createNewBeaker();
            nbt = stack.getTag();
            if(nbt != null) {

                String contents = "";

                contents = nbt.getString(CHEM1NAME) + ", " + nbt.getString(CHEM2NAME) +
                        ", " + nbt.getString(CHEM3NAME) +
                        ", " + nbt.getString(CHEM4NAME) +
                        ", " + nbt.getString(CHEM5NAME) +
                        ", " + nbt.getString(CHEM6NAME);
                String[] contentParts = contents.split(", ");
                contents = "";
                for(int x = 0; x<contentParts.length; x++)
                {
                    if(!contentParts[x].equals("N/A"))
                    {
                         contents = contents + contentParts[x] + ", ";

                    }
                }
                if (contents.length() > 2)
                {
                    contents = contents.substring(0,contents.length()-2);
                }
                String soluteContent = "Water: " + nbt.getDouble("SoluteMoles") + "\n";
                String molarContent = nbt.getString(CHEM1NAME) + ": " + nbt.getDouble(CHEM1MOLE) + "mol\n" +
                        nbt.getString(CHEM2NAME) + ": " + nbt.getDouble(CHEM2MOLE) + "mol\n" +
                        nbt.getString(CHEM3NAME) + ": " + nbt.getDouble(CHEM3MOLE) + "mol\n" +
                        nbt.getString(CHEM4NAME) + ": " + nbt.getDouble(CHEM4MOLE) + "mol\n" +
                        nbt.getString(CHEM5NAME) + ": " + nbt.getDouble(CHEM5MOLE) + "mol\n" +
                        nbt.getString(CHEM6NAME) + ": " + nbt.getDouble(CHEM6MOLE) + "mol";

                //use split
                molarContent.replaceAll(": 0.0", "");
                molarContent.replaceAll("N/A", "");
                components.add(Component.literal("Contents: " +
                        //getName(new ItemStack(getcCHEM1())).getString() +
                        //getcCHEM1().getName() +
                        contents +
                        "\nNumber of Moles:\n" +
                        soluteContent +
                        //molarContent
                        molarContent
                                //+
                        //getcMCHEM1()  +
                        //"\nStability: " + getcSTAB() +
                        //getcDESC() + contents
                ).withStyle(ChatFormatting.AQUA));
            }
        }
        else
        {
            components.add(Component.literal("Right Click to add something!\nPress SHIFT to see contents.").withStyle(ChatFormatting.DARK_GREEN));
        }
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND && !player.isCrouching())
        {
            if(player.getOffhandItem().getItem().getClass().equals(ChemicalItem.class)) {
                ChemicalItem OffHand = (ChemicalItem) player.getOffhandItem().getItem();
                SolutionItem MainHand = (SolutionItem) player.getMainHandItem().getItem();
                player.setItemInHand(InteractionHand.MAIN_HAND, MainHand.addChemicalToBeaker(player.getMainHandItem(), OffHand));
                //player.setItemInHand(InteractionHand.MAIN_HAND, MainHand.removeChemicalFromBeaker(player.getMainHandItem()));
                if(player.getOffhandItem().getCount()>1) {
                    player.getOffhandItem().setCount(player.getOffhandItem().getCount() - 1);
                    player.setItemInHand(InteractionHand.OFF_HAND, player.getOffhandItem());
                }
                else {
                    player.setItemInHand(InteractionHand.OFF_HAND, ItemStack.EMPTY);
                }
            }
        }

        else if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND && player.isCrouching())
        {
                ChemicalItem OffHand = (ChemicalItem) player.getOffhandItem().getItem();
                SolutionItem MainHand = (SolutionItem) player.getMainHandItem().getItem();
                //player.setItemInHand(InteractionHand.MAIN_HAND, MainHand.addChemicalToBeaker(player.getMainHandItem(), OffHand));
                player.setItemInHand(InteractionHand.MAIN_HAND, MainHand.removeChemicalFromBeaker(player.getMainHandItem()));
                ItemStack temp = MainHand.getChemicalFromBeaker(player.getMainHandItem());
                if(player.getOffhandItem().isEmpty()) {
                    player.setItemInHand(InteractionHand.OFF_HAND, MainHand.getChemicalFromBeaker(player.getMainHandItem()));
                }
                else if(player.getOffhandItem().getItem().equals(temp.getItem()))
                {
                    if(player.getOffhandItem().getCount()<64) {
                        player.getOffhandItem().setCount(player.getOffhandItem().getCount() + 1);
                        player.setItemInHand(InteractionHand.OFF_HAND, player.getOffhandItem());
                    }
                    else
                    {
                        player.drop(temp, true, false);
                    }
                }
                else
                {
                    //MainHand.getChemicalFromBeaker(player.getMainHandItem()).
                    player.drop(temp, true, false);
                }
        }

        return super.use(level, player, hand);
    }
    //Solutions getters and setters

    public String getName()
    {
        String rawName = getName(new ItemStack(getcCHEM1())).getString();
        //String[] choppedID = rawName.split(".");
        String lowcaseName = rawName.replaceAll("item.chemmod.","");
        String[] choppedName = lowcaseName.split("_");
        for (int n = 0; n < choppedName.length; n++)
        {
            //to capitalize
            String letter = choppedName[n].substring(0,1);
            String rest = choppedName[n].substring(1);
            letter = letter.toUpperCase();
            choppedName[n] = letter + rest;
        }
        String cookedName = "";
        for (int l = 0; l < choppedName.length; l++)
        {
            cookedName = cookedName + choppedName[l];
        }
        return cookedName;
    }

    public ChemicalItem getChemical(String name)
    {
        /*
        String[] choppedName = name.split(" ");
        for (int n = 0; n < choppedName.length; n++)
        {

            //to lower case
            String letter = choppedName[n].substring(0,1);
            String rest = choppedName[n].substring(1);
            letter = letter.toLowerCase();
            choppedName[n] = letter + rest;
        }
        String ogName = "item.chemmod.";

        for (int l = 0; l < choppedName.length; l++)
        {

            if (l!=choppedName.length-1)
                ogName = ogName + choppedName[l] + "_";
            else
                ogName = ogName + choppedName[l];
        }

         */
        ChemicalItem chemicalItem = (ChemicalItem) ModItems.getByName(name).get().asItem();
        return chemicalItem;
    }


    public ChemicalItem getcCHEM1() {
        return cCHEM1;
    }

}
