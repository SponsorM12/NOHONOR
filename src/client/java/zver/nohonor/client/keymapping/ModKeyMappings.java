package zver.nohonor.client.keymapping;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;
import zver.nohonor.NOHONOR;

public class ModKeyMappings {

    public static final KeyMapping KEYMAPPING = KeyMappingHelper.registerKeyMapping(
            new KeyMapping("key.nohonor.keymapping",
                    InputConstants.Type.KEYSYM,
                    GLFW.GLFW_KEY_H, KeyMapping.Category.MISC
            ));

    public static void initialize() {
        NOHONOR.LOGGER.info("Registering KeyMappings for " + NOHONOR.MOD_ID);
    }

}
