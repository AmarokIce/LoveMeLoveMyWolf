package club.someoneice;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.AttackEntityEvent;

@Mod(modid = "love_wolf")
public class LoveWolf {
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void PlayerAttackEvent(AttackEntityEvent event) {
        Entity entity = event.entityLiving;
        if (entity instanceof EntityTameable) event.setCanceled(true);
        if (Loader.isModLoaded("pieapple_tags"))
            if (Tags.PET.has(entity.getClass()) || Tags.PET.hasAssignableFrom(entity.getClass()))
                event.setCanceled(true);
    }
}
