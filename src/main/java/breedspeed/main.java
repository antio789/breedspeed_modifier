package breedspeed;


import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.event.entity.living.BabyEntitySpawnEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static breedspeed.Config.ConfigHandler.Change_Durations.*;

@Mod(
        modid = "breedspeed",
        name = "villager breedingspeed modifier",
        version = "1.2",
        acceptedMinecraftVersions = "[1.12.2]"
)
public class main {
    @Mod.Instance
    public static main instance;
    public static final String MODID = "breedspeed";
    public static final String NAME = "villager breedingspeed modifier";
    public static final String VERSION = "1.2";

    public main() {
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ConfigManager.sync("breedspeed", Config.Type.INSTANCE);
    }

    @SubscribeEvent
    public void breedingtime(LivingEvent event){
        if(event.getEntityLiving() !=null && event.getEntityLiving().getTags().contains(Updatetag)) {
            event.getEntityLiving().removeTag(Updatetag);
            if (event.getEntityLiving() instanceof EntityVillager) {
                EntityVillager villager = (EntityVillager) event.getEntityLiving();
                if (villager.getGrowingAge() >= 0) {
                    villager.setGrowingAge(getBreeding_cooldown());
                } else
                    villager.setGrowingAge(getBabyvillager_to_grow_up());

            } else if (event.getEntityLiving() instanceof EntityAnimal) {
                EntityAnimal animal = (EntityAnimal) event.getEntityLiving();
                if (animal.getGrowingAge() >= 0) {
                    animal.setGrowingAge(getAnimal_breeding_cooldown());
                } else
                    animal.setGrowingAge(getBaby_animal_to_grow_up());

            } else if (event.getEntityLiving() instanceof EntityAgeable) {
                EntityAgeable animal = (EntityAgeable) event.getEntityLiving();
                if (animal.getGrowingAge() >= 0) {
                    animal.setGrowingAge(getAgeable_breeding_cooldown());
                } else
                    animal.setGrowingAge(getBaby_ageable_to_grow_up());

            }
        }
    }


    private String Updatetag = "needupdate";

    @SubscribeEvent
    public void breedevent(BabyEntitySpawnEvent event){
        if(event.getParentA() instanceof EntityVillager){
            event.setCanceled(isVillager_breeding_on());
            event.getParentA().addTag(Updatetag);
            event.getParentB().addTag(Updatetag);
            if(event.getChild()!=null)
                event.getChild().addTag(Updatetag);

        }
        else if(animalchanger_on && event.getParentA() instanceof EntityAnimal){
            event.setCanceled(isAnimal_breeding_on());
            event.getParentA().addTag(Updatetag);
            event.getParentB().addTag(Updatetag);
            if(event.getChild()!=null)
                event.getChild().addTag(Updatetag);
        }
        else if(ageablechanger_on && event.getParentA() instanceof EntityAgeable){
            event.getParentA().addTag(Updatetag);
            event.getParentB().addTag(Updatetag);
            if(event.getChild()!=null)
                event.getChild().addTag(Updatetag);
        }
    }

    @SubscribeEvent
    public void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals("breedspeed")) {
            ConfigManager.sync("breedspeed", Config.Type.INSTANCE);
        }

    }
}
