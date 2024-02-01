package net.claudio.chemmod.item.custom;



import net.claudio.chemmod.item.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class SolutionItem extends Item {

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
    //I have to fix the set methods
    //Make the rest of the elements into this type
    //Get rid of / maybe add diatoms, like H2 gas
    //^^^^^Would the simply H be useful? I guess protons for later on. Could be useful.
    //But would any other one?
    // OH wait!! I guess I might need to add ions and stuff
    //Nahh

    //STAB = Stability Index. Essentially reactivity. Number can be used to pass a check to see if it reacts with other possible chemicals??
    //OR, can be used as a sort of timer to determine decomposition. Same concept, but applied differently.
    public int getcSTAB() {
        return cSTAB;
    }
    //DESC = Description. Optional description for adding in facts about item
    public String getcDESC(){return cDESC;}
    //FOOD = String that will be put through an even to handle custom eating properties
    public String getcSDS(){return cSDS;}



    String SDSInfo = "";

    //Maybe make custom registry for food properties? Apply properties to items.
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {

        SDSInfo = "";
        String[] SDSfragments = getcSDS().split(",");
        for(String sds : SDSfragments)
        {
            //TOXIC
            if (sds.equals("T")) {
                if (SDSInfo.equals(""))
                    SDSInfo = "Toxic";
                else
                    SDSInfo = SDSInfo + ", " + "Toxic";
            }
            //CORROSIVE
            if (sds.equals("C")) {
                if (SDSInfo.equals(""))
                    SDSInfo = "Corrosive";
                else
                    SDSInfo = SDSInfo + ", " + "Corrosive";
            }
            //HEALTH HAZARD
            if (sds.equals("H")) {
                if (SDSInfo.equals(""))
                    SDSInfo = "Health Hazard";
                else
                    SDSInfo = SDSInfo + ", " + "Health Hazard";
            }
            //EXCLAMATION MARK
            if (sds.equals("I")) {
                if (SDSInfo.equals(""))
                    SDSInfo = "Irritant";
                else
                    SDSInfo = SDSInfo + ", " + "Irritant";
            }
            //GAS CYLINDER
            if (sds.equals("G")) {
                if (SDSInfo.equals(""))
                    SDSInfo = "Gas Under Pressure";
                else
                    SDSInfo = SDSInfo + ", " + "Gas Under Pressure";
            }
            //EXPLODING BOMB
            if (sds.equals("E")) {
                if (SDSInfo.equals(""))
                    SDSInfo = "Explosive";
                else
                    SDSInfo = SDSInfo + ", " + "Explosive";
            }
            //FLAMMABLE
            if (sds.equals("F")) {
                if (SDSInfo.equals(""))
                    SDSInfo = "Flammable";
                else
                    SDSInfo = SDSInfo + ", " + "Flammable";
            }
            //OXIDIZER
            if (sds.equals("O")) {
                if (SDSInfo.equals(""))
                    SDSInfo = "Oxidizer";
                else
                    SDSInfo = SDSInfo + ", " + "Oxidizer";
            }
            //HARMFUL TO ENVIRONMENT
            if (sds.equals("A")) {
                if (SDSInfo.equals(""))
                    SDSInfo = "Harmful To Environment";
                else
                    SDSInfo = SDSInfo + ", " + "Harmful To Environment";
            }
        }



        if (Screen.hasShiftDown())
        {
            String contents = "";
            if (!getcCHEM1().equals(ModItems.EMPTY.get()))
                contents = contents + getcCHEM1().getName();
            if (!getcCHEM2().equals(ModItems.EMPTY.get()) && contents.equals(""))
                contents = contents + getcCHEM2().getName();
            else if (!getcCHEM2().equals(ModItems.EMPTY.get()))
                contents = contents + ", " + getcCHEM2().getName();
            if (!getcCHEM3().equals(ModItems.EMPTY.get()) && contents.equals(""))
                contents = contents + getcCHEM3().getName();
            else if (!getcCHEM3().equals(ModItems.EMPTY.get()))
                contents = contents + ", " + getcCHEM3().getName();
            if (!getcCHEM4().equals(ModItems.EMPTY.get()) && contents.equals(""))
                contents = contents + getcCHEM4().getName();
            else if (!getcCHEM4().equals(ModItems.EMPTY.get()))
                contents = contents + ", " + getcCHEM4().getName();
            if (!getcCHEM5().equals(ModItems.EMPTY.get()) && contents.equals(""))
                contents = contents + getcCHEM5().getName();
            else if (!getcCHEM5().equals(ModItems.EMPTY.get()))
                contents = contents + ", " + getcCHEM5().getName();
            if (!getcCHEM6().equals(ModItems.EMPTY.get()) && contents.equals(""))
                contents = contents + getcCHEM6().getName();
            else if (!getcCHEM6().equals(ModItems.EMPTY.get()))
                contents = contents + ", " + getcCHEM6().getName();


            String molarContent = "\n";
            if (!getcCHEM1().equals(ModItems.EMPTY.get()))
                molarContent = molarContent + getcCHEM1().getcCF() + ": " + getcMCHEM1();
            if (!getcCHEM2().equals(ModItems.EMPTY.get()) && molarContent.equals("\n"))
                molarContent = molarContent + getcCHEM2().getcCF() + ": " + getcMCHEM2();
            else if (!getcCHEM2().equals(ModItems.EMPTY.get()))
                molarContent = molarContent + "\n" + getcCHEM2().getcCF() + ": " + getcMCHEM2();
            if (!getcCHEM3().equals(ModItems.EMPTY.get()) && molarContent.equals("\n"))
                molarContent = molarContent + getcCHEM3().getcCF() + ": " + getcMCHEM3();
            else if (!getcCHEM3().equals(ModItems.EMPTY.get()))
                molarContent = molarContent + "\n" + getcCHEM3().getcCF() + ": " + getcMCHEM3();
            if (!getcCHEM4().equals(ModItems.EMPTY.get()) && molarContent.equals("\n"))
                molarContent = molarContent + getcCHEM4().getcCF() + ": " + getcMCHEM4();
            else if (!getcCHEM4().equals(ModItems.EMPTY.get()))
                molarContent = molarContent + "\n" + getcCHEM4().getcCF() + ": " + getcMCHEM4();
            if (!getcCHEM5().equals(ModItems.EMPTY.get()) && molarContent.equals("\n"))
                molarContent = molarContent + getcCHEM5().getcCF() + ": " + getcMCHEM5();
            else if (!getcCHEM5().equals(ModItems.EMPTY.get()))
                molarContent = molarContent + "\n" + getcCHEM5().getcCF() + ": " + getcMCHEM5();
            if (!getcCHEM6().equals(ModItems.EMPTY.get()) && molarContent.equals("\n"))
                molarContent = molarContent + getcCHEM6().getcCF() + ": " + getcMCHEM6();
            else if (!getcCHEM6().equals(ModItems.EMPTY.get()))
                molarContent = molarContent + "\n" + getcCHEM6().getcCF() + ": " + getcMCHEM6();

            components.add(Component.literal("Contents: " +
                    //getName(new ItemStack(getcCHEM1())).getString() +
                    //getcCHEM1().getName() +
                    contents +
                    "\nNumber of Moles:" +
                    molarContent +
                    //getcMCHEM1()  +
                    "\nStability: " + getcSTAB() +
                    getcDESC() + contents).withStyle(ChatFormatting.AQUA));

        }
        else if (Screen.hasControlDown()) {
            //\n is freaking out for some reason
            //Good enough for now
            if(SDSInfo.equals(""))
                components.add(Component.literal("Hazards: None").withStyle(ChatFormatting.YELLOW));
            else
                components.add(Component.literal("Hazards: " + SDSInfo).withStyle(ChatFormatting.YELLOW));
        }
        else
        {
            components.add(Component.literal("Press SHIFT for more info").withStyle(ChatFormatting.DARK_GREEN));
        }

        super.appendHoverText(stack, level, components, flag);
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
    public double getcVOL() {
        return cVOL;
    }

    public void setcVOL(double cVOL) {
        this.cVOL = cVOL;
    }

    public ChemicalItem getcCHEM1() {
        return cCHEM1;
    }

    public void setcCHEM1(ChemicalItem cCHEM1) {
        this.cCHEM1 = cCHEM1;
    }

    public double getcMCHEM1() {
        return cMCHEM1;
    }

    public void setcMCHEM1(double cMCHEM1) {
        this.cMCHEM1 = cMCHEM1;
    }

    public ChemicalItem getcCHEM2() {
        return cCHEM2;
    }

    public void setcCHEM2(ChemicalItem cCHEM2) {
        this.cCHEM2 = cCHEM2;
    }

    public double getcMCHEM2() {
        return cMCHEM2;
    }

    public void setcMCHEM2(double cMCHEM2) {
        this.cMCHEM2 = cMCHEM2;
    }

    public ChemicalItem getcCHEM3() {
        return cCHEM3;
    }

    public void setcCHEM3(ChemicalItem cCHEM3) {
        this.cCHEM3 = cCHEM3;
    }

    public double getcMCHEM3() {
        return cMCHEM3;
    }

    public void setcMCHEM3(double cMCHEM3) {
        this.cMCHEM3 = cMCHEM3;
    }


    public ChemicalItem getcCHEM4() {
        return cCHEM4;
    }

    public void setcCHEM4(ChemicalItem cCHEM4) {
        this.cCHEM4 = cCHEM4;
    }

    public double getcMCHEM4() {
        return cMCHEM4;
    }

    public void setcMCHEM4(double cMCHEM4) {
        this.cMCHEM4 = cMCHEM4;
    }

    public ChemicalItem getcCHEM5() {
        return cCHEM5;
    }

    public void setcCHEM5(ChemicalItem cCHEM5) {
        this.cCHEM5 = cCHEM5;
    }

    public double getcMCHEM5() {
        return cMCHEM5;
    }

    public void setcMCHEM5(double cMCHEM5) {
        this.cMCHEM5 = cMCHEM5;
    }

    public ChemicalItem getcCHEM6() {
        return cCHEM6;
    }

    public void setcCHEM6(ChemicalItem cCHEM6) {
        this.cCHEM6 = cCHEM6;
    }

    public double getcMCHEM6() {
        return cMCHEM6;
    }

    public void setcMCHEM6(double cMCHEM6) {
        this.cMCHEM6 = cMCHEM6;
    }

}
