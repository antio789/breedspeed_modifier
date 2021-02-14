package breedspeed.Config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.*;

public class ConfigHandler {
    public ConfigHandler() {
    }

    @Config(
            modid = "breedspeed",
            type = Config.Type.INSTANCE,
            name = "change durations"
    )
    public static class Change_Durations {
        @RangeInt(
                min = 1,
                max = 3600
        )
        @Comment({"cooldown for the villager between having a baby and be able to mate again \n in seconds (default: 300)"})
        public static int breeding_cooldown = 150;
        @RangeInt(
                min = 1,
                max = 3600
        )
        @Comment({"time for a baby villager to grow up \n in seconds (default: 1200)"})
        public static int babyvillager_to_grow_up = 500;


        @Comment({"deactivate the ability of villagers to breed when put on false"})
        public static boolean villager_breeding_on = true;
        @RangeInt(
                min = 1,
                max = 3600
        )
        @Comment({"cooldown between having a baby and be able to mate again \n in seconds (default: 300)"})
        public static int animal_breeding_cooldown = 150;
        @RangeInt(
                min = 1,
                max = 3600
        )
        @Comment({"cooldown between having a baby and be able to mate again \n in seconds (default: 300)"})
        public static int ageable_breeding_cooldown = 150;
        @RangeInt(
                min = 1,
                max = 3600
        )
        @Comment({"time for a baby to grow up \n in seconds (default: 1200)"})
        public static int baby_animal_to_grow_up = 500;
        @RangeInt(
                min = 1,
                max = 3600
        )
        @Comment({"time for a baby to grow up \n in seconds (default: 1200)"})
        public static int baby_ageable_to_grow_up = 500;

        @Comment({"put on true to have the animals breed and grow up on a custom speed"})
        public static boolean animalchanger_on = false;
        @Comment({"same as animalchanger but for customs mobs if animalchanger does not work"})
        public static boolean ageablechanger_on = false;
        @Comment({"deactivate the ability of animals to breed when put on false"})
        public static boolean animal_breeding_on = true;

        public static boolean isAnimal_breeding_on() {
            return !animal_breeding_on;
        }

        public static boolean isVillager_breeding_on() {
            return !villager_breeding_on;
        }

        public Change_Durations() {
        }

        public static int getBreeding_cooldown() {
            return breeding_cooldown * 20;
        }

        public static int getAnimal_breeding_cooldown() {
            return animal_breeding_cooldown * 20;
        }

        public static int getAgeable_breeding_cooldown() {
            return ageable_breeding_cooldown * 20;
        }

        public static int getBaby_ageable_to_grow_up() {
            return -baby_ageable_to_grow_up * 20;
        }

        public static int getBabyvillager_to_grow_up() {
            return -babyvillager_to_grow_up * 20;
        }

        public static int getBaby_animal_to_grow_up() {
            return -baby_animal_to_grow_up * 20;
        }
    }
}
