package breedspeed.config;


import static breedspeed.config.confighandler.COMMON;

public class configvalues {




        public static class Change_Durations {
            //@Config.RangeInt(min=1,max=300)
            //@Config.Comment("cooldown for the villager between having a baby and be able to mate again \n in seconds (default: 300)")
            public static int breeding_cooldown = COMMON.Villager_breeding_cooldown.get();
            //@Config.RangeInt(min=1,max=1200)
            //@Config.Comment("time for a baby villager to grow up \n in seconds (default: 1200)")
            public static int babyvillager_to_grow_up = COMMON.Babyvillager_to_grow_up.get();

            //@Config.Comment("on of by default because it probably will change the values for custom mobs(not only animals) \n so be careful if you use it")
            public static boolean animalchanger_on = COMMON.Animalchanger_on.get();

            //@Config.Comment("larger version of the animal changer in case you want this for a non animal type \n or a custom animal where this doesn't work")
            public static boolean ageablechanger_on = COMMON.Ageablechanger_on.get();

            //@Config.RangeInt(min=1,max=300)
            //@Config.Comment("cooldown between having a baby and be able to mate again \n in seconds (default: 300)")
            public static int animal_breeding_cooldown = COMMON.Animal_breeding_cooldown.get();


            //@Config.RangeInt(min=1,max=300)
            //@Config.Comment("cooldown between having a baby and be able to mate again \n in seconds (default: 300)")
            public static int ageable_breeding_cooldown = COMMON.Ageable_breeding_cooldown.get();


            //@Config.RangeInt(min=1,max=1200)
            //@Config.Comment("time for a baby to grow up \n in seconds (default: 1200)")
            public static int baby_animal_to_grow_up = COMMON.Baby_animal_to_grow_up.get();

            //@Config.RangeInt(min=1,max=1200)
            //@Config.Comment("time for a baby to grow up \n in seconds (default: 1200)")
            public static int baby_ageable_to_grow_up = COMMON.Baby_ageable_to_grow_up.get();

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
