package breedspeed.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.tuple.Pair;


@Mod.EventBusSubscriber
public class confighandler {

    public static final CommonConfig COMMON;
    public static final ForgeConfigSpec COMMON_SPEC;

    static {
        final Pair<CommonConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(CommonConfig::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }

    public static class CommonConfig {



        public final ForgeConfigSpec.IntValue Villager_breeding_cooldown;
        public final ForgeConfigSpec.IntValue Babyvillager_to_grow_up;
        public final ForgeConfigSpec.BooleanValue Animalchanger_on;
        public final ForgeConfigSpec.BooleanValue Ageablechanger_on;
        public final ForgeConfigSpec.IntValue Animal_breeding_cooldown;
        public final ForgeConfigSpec.IntValue Ageable_breeding_cooldown;
        public final ForgeConfigSpec.IntValue Baby_animal_to_grow_up;
        public final ForgeConfigSpec.IntValue Baby_ageable_to_grow_up;
        public final ForgeConfigSpec.IntValue Minspawndelay;
        public final ForgeConfigSpec.IntValue Maxspawndelay;
        public final ForgeConfigSpec.BooleanValue breeding_on;
        public final ForgeConfigSpec.BooleanValue villager_breeding_on;


        CommonConfig(ForgeConfigSpec.Builder server) {
            server.push("values");
            Villager_breeding_cooldown = server.comment("cooldown for the villager between having a baby and be able to mate again in seconds (game default: 300)")
                    .defineInRange("values.villager_CD", 150, 1, 299*5);

            Babyvillager_to_grow_up = server.comment("time for a baby villager to grow up in seconds (game default: 1200)")
                    .defineInRange("values.villager_baby", 600, 1, 1199*5);

            Animal_breeding_cooldown = server.comment("cooldown between having a baby and be able to mate again in seconds (default: 300)")
                    .defineInRange("values.animal_CD", 150, 1, 299*5);

            Ageable_breeding_cooldown = server.comment("cooldown between having a baby and be able to mate again in seconds (default: 300)")
                    .defineInRange("values.ageable_CD", 150, 1, 299*5);

            Baby_animal_to_grow_up = server.comment("time for a baby to grow up in seconds (default: 1200)")
                    .defineInRange("values.animal_baby", 600, 1, 1199*5);

            Baby_ageable_to_grow_up = server.comment("time for a baby to grow up in seconds (default: 1200)")
                    .defineInRange("values.ageable_baby", 600, 1, 1199*5);

            Minspawndelay = server.comment("the minimum time for mobs to spawn from a mobspawner, make sure it is smaller that the maxspawndelay. 10 is the default game time")
                    .defineInRange("values.minspawndelay",10,1,2000);
            Maxspawndelay = server.comment("see minspawndelay. 40 is the default game time")
                    .defineInRange("values.maxspawndelay",40,1,4000);

            Animalchanger_on = server.comment("put on true to have animals breed and grow at a custom speed")
                    .define("values.animal_on", false);

            Ageablechanger_on = server.comment("use for custom animals if animalchanger doesnt work")
                    .define("values.ageable_on", false);
            breeding_on = server.comment("deactivate the ability of animals to breed when put on false")
                    .define("values.breeding_on",true);
            villager_breeding_on = server.comment("deactivate the ability of villagers to breed when put on false")
                    .define("values.villager_breeding_on",true);

            server.pop();

        }

    }



}
