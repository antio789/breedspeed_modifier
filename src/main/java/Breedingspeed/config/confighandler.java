package Breedingspeed.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraft.advancements.Advancement;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.tuple.Pair;

import java.io.File;


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


        CommonConfig(ForgeConfigSpec.Builder server) {
            server.push("values");
            Villager_breeding_cooldown = server.comment("cooldown for the villager between having a baby and be able to mate again in seconds (game default: 300)")
                    .defineInRange("values.villager_CD", 150, 10, 299);

            Babyvillager_to_grow_up = server.comment("time for a baby villager to grow up in seconds (game default: 1200)")
                    .defineInRange("values.villager_baby", 600, 10, 1199);

            Animal_breeding_cooldown = server.comment("cooldown between having a baby and be able to mate again in seconds (default: 300)")
                    .defineInRange("values.animal_CD", 150, 10, 299);

            Ageable_breeding_cooldown = server.comment("cooldown between having a baby and be able to mate again in seconds (default: 300)")
                    .defineInRange("values.ageable_CD", 150, 10, 299);

            Baby_animal_to_grow_up = server.comment("time for a baby to grow up in seconds (default: 1200)")
                    .defineInRange("values.animal_baby", 600, 10, 1199);

            Baby_ageable_to_grow_up = server.comment("time for a baby to grow up in seconds (default: 1200)")
                    .defineInRange("values.ageable_baby", 600, 10, 1199);

            Animalchanger_on = server.comment("affect any animal in game (may affect modded entities) put on true to activate").define("values.animal_on", false);

            Ageablechanger_on = server.comment("larger version than the animal modifier in case you want to modify values of other breedable entitities (only useful for modded breedable entitites) put on true to activate").define("values.ageable_on", false);

            server.pop();

        }

    }



}
