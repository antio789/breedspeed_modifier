package breedspeed;


import breedspeed.config.confighandler;
import net.minecraft.block.Block;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.BabyEntitySpawnEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static breedspeed.config.configvalues.Change_Durations.*;


@Mod("breedspeed")
public class breedspeed
{
    // Directly reference a log4j logger.

    public static breedspeed instance;
    public final String modid="breedspeed";

    public breedspeed() {
        instance =this;
        ModLoadingContext modLoadingContext = ModLoadingContext.get();
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        modLoadingContext.registerConfig(ModConfig.Type.COMMON, confighandler.COMMON_SPEC);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code

    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client

    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod

    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods

    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void breedingtime(LivingEvent event){
    if(event.getEntityLiving() !=null && event.getEntityLiving().getTags().contains(Updatetag)) {
        event.getEntityLiving().removeTag(Updatetag);
        if (event.getEntityLiving() instanceof VillagerEntity) {
            VillagerEntity villager = (VillagerEntity) event.getEntityLiving();
            if (villager.getGrowingAge() >= 0) {
                villager.setGrowingAge(getBreeding_cooldown());
            } else
                villager.setGrowingAge(getBabyvillager_to_grow_up());

        } else if (event.getEntityLiving() instanceof AnimalEntity) {
            AgeableEntity animal = (AnimalEntity) event.getEntityLiving();
            if (animal.getGrowingAge() >= 0) {
                animal.setGrowingAge(getAnimal_breeding_cooldown());
            } else
                animal.setGrowingAge(getBaby_animal_to_grow_up());

        } else if (event.getEntityLiving() instanceof AgeableEntity) {
            AgeableEntity animal = (AgeableEntity) event.getEntityLiving();
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
        if(event.getParentA() instanceof VillagerEntity){
            event.getParentA().addTag(Updatetag);
            event.getParentB().addTag(Updatetag);
            if(event.getChild()!=null)
            event.getChild().addTag(Updatetag);

        }
        else if(animalchanger_on && event.getParentA() instanceof AnimalEntity){
            event.getParentA().addTag(Updatetag);
            event.getParentB().addTag(Updatetag);
            if(event.getChild()!=null)
            event.getChild().addTag(Updatetag);
        }
        else if(ageablechanger_on && event.getParentA() instanceof AgeableEntity){
            event.getParentA().addTag(Updatetag);
            event.getParentB().addTag(Updatetag);
            if(event.getChild()!=null)
            event.getChild().addTag(Updatetag);
        }
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus= Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
    }
}