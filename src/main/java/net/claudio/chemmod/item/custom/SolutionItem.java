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
import net.minecraft.world.item.Items;
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
    private static final String SOLVENTNAME = "SolventName";
    private static final String SOLVENTMOLE = "SolventMoleAmount";
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

        // a liter of water
        //nbt.putDouble(SOLVENTMOLE,55.4939);
        nbt.putDouble(SOLVENTMOLE, 0.0);
        nbt.putDouble(CHEM1MOLE,0.0);
        nbt.putDouble(CHEM2MOLE,0.0);
        nbt.putDouble(CHEM3MOLE,0.0);
        nbt.putDouble(CHEM4MOLE,0.0);
        nbt.putDouble(CHEM5MOLE,0.0);
        nbt.putDouble(CHEM6MOLE,0.0);
        nbt.putString(SOLVENTNAME,"N/A");
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
        String solv = nbt.getString(SOLVENTNAME);

        if("Water".equals(chemical.getName()))
        {
            Double currentMole = nbt.getDouble(SOLVENTMOLE);
            Double newMole = currentMole + 1.0;
            nbt.putDouble(SOLVENTMOLE, newMole);
            if(solv.equals("N/A"))
            {
                nbt.putString(SOLVENTNAME, "Water");
            }

        }
        else if (getChemical(chemical.getName()).asItem().equals(ModItems.ONE_LITRE.get().asItem()))
        {
            Double currentMole = nbt.getDouble(SOLVENTMOLE);
            Double newMole = currentMole + 55.4939;
            nbt.putDouble(SOLVENTMOLE, newMole);
            if(solv.equals("N/A"))
            {
                nbt.putString(SOLVENTNAME, "Water");
            }
        }
        else {
            if (chem1.equals(chemical.getName())) {
                Double currentMole = nbt.getDouble(CHEM1MOLE);
                Double newMole = currentMole + 1.0;
                nbt.putDouble(CHEM1MOLE, newMole);
            } else if ((chem1.isBlank() || chem1.equals("N/A")) && !("One Litre".equals(chemical.getName())) && !chem1.equals(solv)) {
                nbt.putString(CHEM1NAME, chemical.getName());
                Double currentMole = nbt.getDouble(CHEM1MOLE);
                Double newMole = currentMole + 1.0;
                nbt.putDouble(CHEM1MOLE, newMole);
            } else {
                if (chem2.equals(chemical.getName())) {
                    Double currentMole = nbt.getDouble(CHEM2MOLE);
                    Double newMole = currentMole + 1.0;
                    nbt.putDouble(CHEM2MOLE, newMole);
                } else if (chem2.isBlank() || chem2.equals("N/A")) {
                    nbt.putString(CHEM2NAME, chemical.getName());
                    Double currentMole = nbt.getDouble(CHEM2MOLE);
                    Double newMole = currentMole + 1.0;
                    nbt.putDouble(CHEM2MOLE, newMole);
                } else {
                    if (chem3.equals(chemical.getName())) {
                        Double currentMole = nbt.getDouble(CHEM3MOLE);
                        Double newMole = currentMole + 1.0;
                        nbt.putDouble(CHEM3MOLE, newMole);
                    } else if (chem3.isBlank() || chem3.equals("N/A")) {
                        nbt.putString(CHEM3NAME, chemical.getName());
                        Double currentMole = nbt.getDouble(CHEM3MOLE);
                        Double newMole = currentMole + 1.0;
                        nbt.putDouble(CHEM3MOLE, newMole);
                    } else {
                        if (chem4.equals(chemical.getName())) {
                            Double currentMole = nbt.getDouble(CHEM4MOLE);
                            Double newMole = currentMole + 1.0;
                            nbt.putDouble(CHEM4MOLE, newMole);
                        } else if (chem4.isBlank() || chem4.equals("N/A")) {
                            nbt.putString(CHEM4NAME, chemical.getName());
                            Double currentMole = nbt.getDouble(CHEM4MOLE);
                            Double newMole = currentMole + 1.0;
                            nbt.putDouble(CHEM4MOLE, newMole);
                        } else {
                            if (chem5.equals(chemical.getName())) {
                                Double currentMole = nbt.getDouble(CHEM5MOLE);
                                Double newMole = currentMole + 1.0;
                                nbt.putDouble(CHEM5MOLE, newMole);
                            } else if (chem5.isBlank() || chem5.equals("N/A")) {
                                nbt.putString(CHEM5NAME, chemical.getName());
                                Double currentMole = nbt.getDouble(CHEM5MOLE);
                                Double newMole = currentMole + 1.0;
                                nbt.putDouble(CHEM5MOLE, newMole);
                            } else {
                                if (chem6.equals(chemical.getName())) {
                                    Double currentMole = nbt.getDouble(CHEM6MOLE);
                                    Double newMole = currentMole + 1.0;
                                    nbt.putDouble(CHEM6MOLE, newMole);
                                } else if (chem6.isBlank() || chem6.equals("N/A")) {
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
        String solv = nbt.getString(SOLVENTNAME);

        int solventPotency = switch (solv) {
            case "Water" -> 1;
            case "Ethanol" -> 2;
            case "Diethyl Ether" -> 3;
            case "Acetone" -> 4;
            case "Hydrochloric Acid Dil" -> 5;
            case "Sulfuric Acid Dil" -> 6;
            case "Ammonia" -> 11;
            default -> 1;
        };

        //ChemicalItem che = getChemical(chem1);
        if(getChemical(chem1).getcSOL() > solventPotency)
        {
            Double currentMole = nbt.getDouble(CHEM1MOLE);
            Double newMole = Math.max(0,currentMole - 1.0);
            nbt.putDouble(CHEM1MOLE, newMole);
            if(nbt.getDouble(CHEM1MOLE) == 0)
            {
                nbt.putString(CHEM1NAME, "N/A");
                sortChemicals(beaker);
            }
            nbt.putString(TEMPCHEM, chem1);
        }
        else {
            if (getChemical(chem2).getcSOL() > solventPotency) {
                Double currentMole = nbt.getDouble(CHEM2MOLE);
                Double newMole = Math.max(0, currentMole - 1.0);
                nbt.putDouble(CHEM2MOLE, newMole);
                if (nbt.getDouble(CHEM2MOLE) == 0) {
                    nbt.putString(CHEM2NAME, "N/A");
                    sortChemicals(beaker);
                }
                nbt.putString(TEMPCHEM, chem2);
            }
            else {
                if (getChemical(chem3).getcSOL() > solventPotency) {
                    Double currentMole = nbt.getDouble(CHEM3MOLE);
                    Double newMole = Math.max(0, currentMole - 1.0);
                    nbt.putDouble(CHEM3MOLE, newMole);
                    if (nbt.getDouble(CHEM3MOLE) == 0) {
                        nbt.putString(CHEM3NAME, "N/A");
                        sortChemicals(beaker);
                    }
                    nbt.putString(TEMPCHEM, chem3);
                }
                else {
                    if (getChemical(chem4).getcSOL() > solventPotency) {
                        Double currentMole = nbt.getDouble(CHEM4MOLE);
                        Double newMole = Math.max(0, currentMole - 1.0);
                        nbt.putDouble(CHEM4MOLE, newMole);
                        if (nbt.getDouble(CHEM4MOLE) == 0) {
                            nbt.putString(CHEM4NAME, "N/A");
                            sortChemicals(beaker);
                        }
                        nbt.putString(TEMPCHEM, chem4);
                    }
                    else {
                        if (getChemical(chem5).getcSOL() > solventPotency) {
                            Double currentMole = nbt.getDouble(CHEM5MOLE);
                            Double newMole = Math.max(0, currentMole - 1.0);
                            nbt.putDouble(CHEM5MOLE, newMole);
                            if (nbt.getDouble(CHEM5MOLE) == 0) {
                                nbt.putString(CHEM5NAME, "N/A");
                                sortChemicals(beaker);
                            }
                            nbt.putString(TEMPCHEM, chem5);
                        }
                        else {
                            if (getChemical(chem6).getcSOL() > solventPotency) {
                                Double currentMole = nbt.getDouble(CHEM6MOLE);
                                Double newMole = Math.max(0, currentMole - 1.0);
                                nbt.putDouble(CHEM6MOLE, newMole);
                                if (nbt.getDouble(CHEM6MOLE) == 0) {
                                    nbt.putString(CHEM6NAME, "N/A");
                                    sortChemicals(beaker);
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

    public ItemStack sortChemicals(ItemStack beaker)
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
        int pos1 = 1;
        int pos2 = 2;
        int pos3 = 3;
        int pos4 = 4;
        int pos5 = 5;
        int pos6 = 6;

        if(chem1.equals("N/A"))
            pos1 = 0;
        if(chem2.equals("N/A"))
            pos2 = 0;
        if(chem3.equals("N/A"))
            pos3 = 0;
        if(chem4.equals("N/A"))
            pos4 = 0;
        if(chem5.equals("N/A"))
            pos5 = 0;
        if(chem6.equals("N/A"))
            pos6 = 0;
        int[] positions = {pos1,pos2,pos3,pos4,pos5,pos6};

        for(int x = pos2; x > 1; x--)
        {
            if (positions[x-2] == 0)
            {
                pos2 = x - 1;
                break;
            }
        }
        for(int x = pos3; x > 1; x--)
        {
            if (positions[x-2] == 0)
            {
                pos3 = x - 1;
            }
        }
        for(int x = pos4; x > 1; x--)
        {
            if (positions[x-2] == 0)
            {
                pos4 = x - 1;
            }
        }
        for(int x = pos5; x > 1; x--)
        {
            if (positions[x-2] == 0)
            {
                pos5 = x - 1;
            }
        }
        for(int x = pos6; x > 1; x--)
        {
            if (positions[x-2] == 0)
            {
                pos6 = x - 1;
            }
        }
        if (pos1 != 0)
        {

        }
        else
        {
            if (pos2 != 0)
            {
                nbt.putString(CHEM1NAME, chem2);
                nbt.putString(CHEM2NAME, "N/A");
            }
            else
            {
                switch (pos3){
                    case 1: nbt.putString(CHEM1NAME, chem3);
                        nbt.putString(CHEM3NAME, "N/A");
                        break;
                    case 2:nbt.putString(CHEM2NAME, chem3);
                        nbt.putString(CHEM3NAME, "N/A");
                        break;
                    case 3:
                        break;
                }
                switch (pos4){
                    case 1: nbt.putString(CHEM1NAME, chem4);
                        nbt.putString(CHEM4NAME, "N/A");
                        break;
                    case 2:nbt.putString(CHEM2NAME, chem4);
                        nbt.putString(CHEM4NAME, "N/A");
                        break;
                    case 3:nbt.putString(CHEM3NAME, chem4);
                        nbt.putString(CHEM4NAME, "N/A");
                        break;
                    case 4:
                        break;
                }
                switch (pos5){
                    case 1: nbt.putString(CHEM1NAME, chem5);
                        nbt.putString(CHEM5NAME, "N/A");
                        break;
                    case 2:nbt.putString(CHEM2NAME, chem5);
                        nbt.putString(CHEM5NAME, "N/A");
                        break;
                    case 3:nbt.putString(CHEM3NAME, chem5);
                        nbt.putString(CHEM5NAME, "N/A");
                        break;
                    case 4:nbt.putString(CHEM4NAME, chem5);
                        nbt.putString(CHEM5NAME, "N/A");
                        break;
                    case 5:
                        break;
                }
                switch (pos6){
                    case 1: nbt.putString(CHEM1NAME, chem6);
                        nbt.putString(CHEM6NAME, "N/A");
                        break;
                    case 2:nbt.putString(CHEM2NAME, chem6);
                        nbt.putString(CHEM6NAME, "N/A");
                        break;
                    case 3:nbt.putString(CHEM3NAME, chem6);
                        nbt.putString(CHEM6NAME, "N/A");
                        break;
                    case 4:nbt.putString(CHEM4NAME, chem6);
                        nbt.putString(CHEM6NAME, "N/A");
                        break;
                    case 5:nbt.putString(CHEM5NAME, chem6);
                        nbt.putString(CHEM6NAME, "N/A");
                        break;
                    case 6:
                        break;
                }
            }
        }

        return beaker;
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

                int solventPotency = switch (nbt.getString(SOLVENTNAME)) {
                    case "Water" -> 1;
                    case "Ethanol" -> 2;
                    case "Diethyl Ether" -> 3;
                    case "Acetone" -> 4;
                    case "Hydrochloric Acid Dil" -> 5;
                    case "Sulfuric Acid Dil" -> 6;
                    case "Ammonia" -> 11;
                    default -> 1;
                };
                String chem1name = nbt.getString(CHEM1NAME);
                String chem2name = nbt.getString(CHEM2NAME);
                String chem3name = nbt.getString(CHEM3NAME);
                String chem4name = nbt.getString(CHEM4NAME);
                String chem5name = nbt.getString(CHEM5NAME);
                String chem6name = nbt.getString(CHEM6NAME);


                contents = chem1name + ", " + chem2name +
                        ", " + chem3name +
                        ", " + chem4name +
                        ", " + chem5name +
                        ", " + chem6name;
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
                String chem1State = "";
                String chem2State = "";
                String chem3State = "";
                String chem4State = "";
                String chem5State = "";
                String chem6State = "";

                if(!chem1name.equals("N/A"))
                {
                    if(getChemical(chem1name).getcSOL() > solventPotency)
                        chem1State = " (s)";
                    else
                        chem1State = " (aq)";
                }
                if(!chem2name.equals("N/A"))
                {
                    if(getChemical(chem2name).getcSOL() > solventPotency)
                        chem2State = " (s)";
                    else
                        chem2State = " (aq)";
                }
                if(!chem3name.equals("N/A"))
                {
                    if(getChemical(chem3name).getcSOL() > solventPotency)
                        chem3State = " (s)";
                    else
                        chem3State = " (aq)";
                }
                if(!chem4name.equals("N/A"))
                {
                    if(getChemical(chem4name).getcSOL() > solventPotency)
                        chem4State = " (s)";
                    else
                        chem4State = " (aq)";
                }
                if(!chem5name.equals("N/A"))
                {
                    if(getChemical(chem5name).getcSOL() > solventPotency)
                        chem5State = " (s)";
                    else
                        chem5State = " (aq)";
                }
                if(!chem6name.equals("N/A"))
                {
                    if(getChemical(chem6name).getcSOL() > solventPotency)
                        chem6State = " (s)";
                    else
                        chem6State = " (aq)";
                }


                String chem1molarcontent = "";
                String chem2molarcontent = "";
                String chem3molarcontent = "";
                String chem4molarcontent = "";
                String chem5molarcontent = "";
                String chem6molarcontent = "";
                if (!chem1name.equals("N/A"))
                {
                    chem1molarcontent = chem1name + chem1State + ": " + nbt.getDouble(CHEM1MOLE) + "mol\n";
                }
                if (!chem2name.equals("N/A"))
                {
                    chem2molarcontent = chem2name + chem2State + ": " + nbt.getDouble(CHEM2MOLE) + "mol\n";
                }
                if (!chem3name.equals("N/A"))
                {
                    chem3molarcontent = chem3name + chem3State + ": " + nbt.getDouble(CHEM3MOLE) + "mol\n";
                }
                if (!chem4name.equals("N/A"))
                {
                    chem4molarcontent = chem4name + chem4State + ": " + nbt.getDouble(CHEM4MOLE) + "mol\n";
                }
                if (!chem5name.equals("N/A"))
                {
                    chem5molarcontent = chem5name + chem5State + ": " + nbt.getDouble(CHEM5MOLE) + "mol\n";
                }
                if (!chem6name.equals("N/A"))
                {
                    chem6molarcontent = chem6name + chem6State + ": " + nbt.getDouble(CHEM6MOLE) + "mol";
                }

                String soluteContent = "Solvent: \n" + nbt.getString(SOLVENTNAME) + ": " + nbt.getDouble(SOLVENTMOLE) + "\n";
                String molarContent = chem1molarcontent +
                        chem2molarcontent +
                        chem3molarcontent +
                        chem4molarcontent +
                        chem5molarcontent +
                        chem6molarcontent;







                components.add(Component.literal("Contents: " +
                        //getName(new ItemStack(getcCHEM1())).getString() +
                        //getcCHEM1().getName() +
                        contents + "\n" +
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
            if(player.getOffhandItem().getItem().getClass().equals(ChemicalItem.class) || player.getOffhandItem().getItem().equals(Items.WATER_BUCKET.asItem())) {
                ChemicalItem OffHand = (ChemicalItem) ModItems.EMPTY.get();
                if(player.getOffhandItem().getItem().getClass().equals(ChemicalItem.class))
                {
                    OffHand = (ChemicalItem) player.getOffhandItem().getItem();
                }
                else if (player.getOffhandItem().getItem().equals(Items.WATER_BUCKET.asItem()))
                {
                    OffHand = (ChemicalItem) ModItems.ONE_LITRE.get();
                }
                SolutionItem MainHand = (SolutionItem) player.getMainHandItem().getItem();
                player.setItemInHand(InteractionHand.MAIN_HAND, MainHand.addChemicalToBeaker(player.getMainHandItem(), OffHand));
                //player.setItemInHand(InteractionHand.MAIN_HAND, MainHand.removeChemicalFromBeaker(player.getMainHandItem()));
                if(player.getOffhandItem().getCount()>1) {
                    player.getOffhandItem().setCount(player.getOffhandItem().getCount() - 1);
                    player.setItemInHand(InteractionHand.OFF_HAND, player.getOffhandItem());
                }
                else {
                    if (!player.getOffhandItem().getItem().equals(Items.WATER_BUCKET.asItem()))
                        player.setItemInHand(InteractionHand.OFF_HAND, ItemStack.EMPTY);
                    else
                        player.setItemInHand(InteractionHand.OFF_HAND, new ItemStack(Items.BUCKET));
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
