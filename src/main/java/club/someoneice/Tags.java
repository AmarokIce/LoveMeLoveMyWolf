package club.someoneice;

import club.someoneice.togocup.tags.Tag;
import club.someoneice.togocup.tags.TagsManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityWolf;

public class Tags {
    static final Tag<Class<? extends Entity>> PET = TagsManager.manager().registerTagWithClass("entity_pet", EntityWolf.class, EntityOcelot.class, EntityHorse.class);
}
