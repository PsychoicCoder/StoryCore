package net.iristeam.storycore.client;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.iristeam.storycore.client.gui.testScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StoryCoreClient implements ClientModInitializer {
    public static final String MOD_ID = "storycore";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final MinecraftClient MC = MinecraftClient.getInstance();
    private static final KeyBinding CONTROL = new KeyBinding("key.storycore.test", GLFW.GLFW_KEY_G, "key.categories.misc");
    @Override
    public void onInitializeClient() {
        KeyBindingHelper.registerKeyBinding(CONTROL);
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (CONTROL.wasPressed() && MC.currentScreen == null) {
                client.setScreen(new testScreen(Text.literal("a"),false));
            }
        });
    }
}
