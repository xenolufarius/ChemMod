package net.claudio.chemmod.item.custom;



import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/*
TO DO LIST*************************************
------------
1: ADD FUNCTIONALITY TO DECONSTRUCTOR
    1a. Add basic ability to turn item into elements (Maybe do molecules once those are added)
        1aa. How to resolve when deconstruction leads to unbalanced equation: H2O -> H2 and O, but needs to be O2?
            1aaa. Potentially need to input 2 H20 for correct output.
        1ab. Would it be a right click function? like right click on object in world, and it breaks into molecules?
            1aba. Maybe it is like a pickaxe that accesses a different loot table. Is possible? Maybe.

        1ac. Perhaps it is used via crafting. Water + deconstructor = H2 and O2. Maybe needs 2 water = 2H2 and O2. Balanced equation.
            1aca. How would it produce both elements?
                1acaa. Maybe 2 different types. One hand-held that gives most abundant element (H2 in this case)
********************1acaaa. Is it possible to get random element via crafting? Maybe use loot table. Probably not. If statement maybe? and rand function.
                1acab. One that is a block that can give either multiple or random (like modded smelting).
                    1acaba. If possible for random element via crafting, this block could give more components

    1b. How do you obtain this item?
        1ba. Maybe you can craft it? What would be the recipe? Too fantastical to be easily crafted
            1baa. If it can be crafted, could it be deconstructed?
                1baaa. Maybe it is made of radioactive elements lmao. It kills the player if done. I like this.
********************1baaaa. Which elements? Also would need radiation to be functional. Maybe do rad first.
                        1baaaaa. Lot of heavy elements decompose quickly, so maybe that.
********1bb. Trading? The chemist villager could have it for sale as its lowest level. Maybe.
            1bba. This is most likely solution.
                1bbaa. Also maybe not use emerald for trade currency.
        1bc. Chests? Wouldn't make sense.
        1bd. Players start with it? Too easy.


------------
2: ADD RADIATION
    2a. Tutorials can help with this.
    2b. RAD value will equate to potency? Maybe range? Both?
        2ba. Strength most likely. Range should be fixed.
????????2bb. How will exposure work? Will inflict if in inventory or just in world? How to resolve that?
            2bba. I want from inventory. To even hold uranium should mess you up.
            COMPLETE
                2bbaa. Safe handling? Baubles? Maybe potion for immunity? OH!
********************2bbaaa. Enchantment. Or hazmat suit with built-in enchantment for protection.
    2c. Rad bar above health to indicate exposure. Reverse of air bubbles underwater.
        2ca. When filled, inflicts rad poison status effect.
            2caa. Maybe strength of rad value will indicate strength of poison effect.
                2caaa. RAD 1 = poi lvl 1 (maybe doesn't kill)
                2caab. RAD 2 = poi lvl 2 (stronger, maybe kills)
                2caac. RAD 3 = poi lvl 3 (stronger, hurts more / faster?)
                2caad. RAD 4 = poi lvl 4 (Probably instantly kills) (Max RAD value)
                POISON EFFECT OUT OF REACH RN
        2cb. How to cure/lessen?
            2cba. Maybe no cure lmao.
            2cbb. Milk might be fine for now, but only for poison.
            2cbc. Maybe bar decreases over time. Reverse air bubble underwater.


------------
3: CHANGE CHEMICALS TO CHEMICALITEMS
    3a. Tedious lmao. Maybe AI can help?
    3b. Should do before adding in too many molecules. Too overwhelming then.
    3c. COMPLETE

------------
4: ADD MORE MOLECULES
    4a. Will occur with time.
    4b. Which should I begin with though?
        4ba. Build up?
        4bb. Or focus on deconstruction outputs?

------------
5: FOOD PROPERTIES
    5a. All items are edible now.
    5b. New parameter, SDS, handles custom events
        5ba. Includes when finished eating, so harmful things harm you now, and K explodes when ingested.
        COMPLETE

------------
6. STABILITY
    6a. Work in progress rn
    6b. Need to figure out how to update player inventory.
    6c. Need to figure out how to craft items in player inventory.
        6ca. Possible with if statements, but maybe want to use recipe files?

------------
7. DECONSTRUCTOR RECIPES
    7a. Tedious. Very Tedious.
    7b. Over 1000 items in vanilla

------------
999: NUCLEAR WAR
    999a. Idk lmao. I would need to research that, but might put me on watchlist

*/


public class ChemicalItem  extends Item {

    //Temp variables that can be called upon for desc.
    //Actual values are added in via next method
    //AMU,CF,RAD,STAB
    //Anything else?
    //Maybe short Description
    //private int cAMU;
    private double cAMU;
    private String cCF;
    private int cRAD;
    private int cSTAB;
    private String cDESC;
    private String cSDS;
    public ChemicalItem(Properties properties, double AMU, String CF, int RAD, int STAB, String DESC, String SDS) {
        super(properties);

        this.cAMU = AMU;
        this.cCF = CF;
        this.cRAD = RAD;
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


    //AMU = Molar Mass essentially. Not really useful to the player
    public double getcAMU() {
        return cAMU;
    }
    //CF = Chemical Formula. Useful to know
    public String getcCF() {
        return cCF;
    }
    //RAD = Radiation level. Useful to know for storage. Number can be used to determine radius/amount of radiation that it gives to player per second or something
    //Maybe highest is like instant full rads
    public int getcRAD() {
        return cRAD;
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
                SDSInfo = SDSInfo + ", " + "Toxic";
            }
            //CORROSIVE
            if (sds.equals("C")) {
                SDSInfo = SDSInfo + ", " + "Corrosive";
            }
            //HEALTH HAZARD
            if (sds.equals("H")) {
                SDSInfo = SDSInfo + ", " + "Health Hazard";
            }
            //EXCLAMATION MARK
            if (sds.equals("I")) {
                SDSInfo = SDSInfo + ", " + "Irritant";
            }
            //GAS CYLINDER
            if (sds.equals("G")) {
                SDSInfo = SDSInfo + ", " + "Gas Under Pressure";
            }
            //EXPLODING BOMB
            if (sds.equals("E")) {
                SDSInfo = SDSInfo + ", " + "Explosive";
            }
            //FLAMMABLE
            if (sds.equals("F")) {
                SDSInfo = SDSInfo + ", " + "Flammable";
            }
            //OXIDIZER
            if (sds.equals("O")) {
                SDSInfo = SDSInfo + ", " + "Oxidizer";
            }
            //HARMFUL TO ENVIRONMENT
            if (sds.equals("A")) {
                SDSInfo = SDSInfo + ", " + "Harmful To Environment";
            }
        }


        if(Screen.hasShiftDown())
        {
            components.add(Component.literal("AMU: " + getcAMU() +
                    "\nChemical Formula: " + getcCF()   +
                    "\nRadioactivity: " + getcRAD() +
                    "\nStability: " + getcSTAB() +
                    getcDESC()).withStyle(ChatFormatting.AQUA));

        } else if (Screen.hasControlDown()) {
            //\n is freaking out for some reason
            //Good enough for now
            components.add(Component.literal("Hazards: Handle With Caution" + SDSInfo).withStyle(ChatFormatting.YELLOW));
        } else
        {
            components.add(Component.literal("Press SHIFT for more info").withStyle(ChatFormatting.DARK_GREEN));
        }

        super.appendHoverText(stack, level, components, flag);
    }

    //Need to fix food. Maybe either through effect() or customFoodProperties





}
