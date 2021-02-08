package Breedingspeed;


import Breedingspeed.config.configvalues;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

import static Breedingspeed.config.configvalues.Change_Durations.*;

import Breedingspeed.config.confighandler;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod("breedingspeed")
public class breedspeed {
    public static breedspeed instance;
    public final String modid="breedingspeed";

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


        @SubscribeEvent
        public void breedingtime(LivingEvent event){

            if(event.getEntityLiving() instanceof VillagerEntity){
                VillagerEntity villager = (VillagerEntity) event.getEntityLiving();
                if(villager.getGrowingAge()> getBreeding_cooldown()){
                    villager.setGrowingAge(getBreeding_cooldown());
                } else if(villager.getGrowingAge()<getBabyvillager_to_grow_up()){
                    villager.setGrowingAge(getBabyvillager_to_grow_up());
                }
            }
            else if(animalchanger_on && event.getEntityLiving() instanceof AnimalEntity){
                AgeableEntity animal = (AnimalEntity)event.getEntityLiving();
                if(animal.getGrowingAge()>getAnimal_breeding_cooldown()){
                    animal.setGrowingAge(getAnimal_breeding_cooldown());
                } else if(animal.getGrowingAge()<getBaby_animal_to_grow_up()){
                    animal.setGrowingAge(getBaby_animal_to_grow_up());
                }
            }
            else if(ageablechanger_on && event.getEntityLiving() instanceof AgeableEntity){
                AgeableEntity animal = (AgeableEntity)event.getEntityLiving();
                if(animal.getGrowingAge()>getAgeable_breeding_cooldown()){
                    animal.setGrowingAge(getAgeable_breeding_cooldown());
                } else if(animal.getGrowingAge()<getBaby_ageable_to_grow_up()){
                    animal.setGrowingAge(getBaby_ageable_to_grow_up());
                }
            }
        }

    private void setup(final FMLCommonSetupEvent event)
    {

    }

    private void doClientStuff(final FMLClientSetupEvent event) {

    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {

    }

    private void processIMC(final InterModProcessEvent event)
    {

    }

}
