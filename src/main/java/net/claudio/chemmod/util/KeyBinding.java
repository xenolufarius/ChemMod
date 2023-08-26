package net.claudio.chemmod.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {

    public static final String KEY_CATEGORY_CHEM = "key.category.chemmod.chem";
    public static final String KEY_STATUS = "key.chemmod.status";

    public static final KeyMapping STATUS_KEY = new KeyMapping(KEY_STATUS, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_Z, KEY_CATEGORY_CHEM);


}
