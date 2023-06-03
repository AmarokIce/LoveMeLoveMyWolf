package club.someoneice;

import club.someoneice.togocup.tags.Tag;
import club.someoneice.togocup.tags.TagsManager;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityOwnable;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

@Mod(modid = LoveWolf.MOD_ID)
public class LoveWolf {
    public static final String MOD_ID = "love_wolf";

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void modHurtEvent(LivingHurtEvent event) {
        Entity entity = event.entityLiving;
        Entity entityAttacker = event.source.getEntity();
        if (entity instanceof IEntityOwnable && entityAttacker instanceof EntityPlayer) event.setCanceled(true);
        if (Loader.isModLoaded("pieapple_tags")) {
            final Tag<Class<? extends Entity>> pet = TagsManager.manager().registerTagWithClass("entity_pet", EntityWolf.class, EntityOcelot.class, EntityHorse.class);
            if (pet.has(entity.getClass()) && entityAttacker instanceof EntityPlayer) event.setCanceled(true);
        }
    }
}
