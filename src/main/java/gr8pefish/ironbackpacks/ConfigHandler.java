package gr8pefish.ironbackpacks;

import gr8pefish.ironbackpacks.ConfigHandler;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = IronBackpacks.MODID, name = IronBackpacks.MODID + "/" + IronBackpacks.MODID)
@Mod.EventBusSubscriber(modid = IronBackpacks.MODID)
public class ConfigHandler {

    public static Upgrades upgrades = new Upgrades();
    public static Handholding handholding = new Handholding();
    public static BackpackSizes sizes = new BackpackSizes();

    //Add config reloading
    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(IronBackpacks.MODID)) {
            ConfigManager.sync(event.getModID(), Config.Type.INSTANCE); // Sync config values
        }
    }

    public static class Handholding {
        @Config.RangeInt(min = 1)
        @Config.Comment({"The maximum depth that can be used for Nesting Upgrades", "This restriction is here to protect against stupidly large NBT sizes."})
        public int maxNests = 1;
    }

    public static class Upgrades {
        @Config.Comment({ "Enables the Damage Bar upgrade" })
        public boolean enableDamageBar = true;

        @Config.Comment({ "Enables the Latch upgrade" })
        public boolean enablePackLatch = true;

        @Config.Comment({ "Enables the Extra Upgrade upgrade" })
        public boolean enableExtraUpgrade = true;

        @Config.Comment({ "Enables the Everlasting upgrade" })
        public boolean enableEverlasting = true;
    }

    public static class BackpackSizes {
        @Config.RangeInt(min = 1, max = 7)
        @Config.Comment({ "Number of Lines of the Basic Backpack"} )
        public int sizeLineBasic = 1;

        @Config.RangeInt(min = 1, max = 7)
        @Config.Comment({ "Number of Lines of the Iron Backpack"} )
        public int sizeLineIronStorage = 2;

        @Config.RangeInt(min = 1, max = 7)
        @Config.Comment({ "Number of Lines of the Gold Backpack"} )
        public int sizeLineGoldStorage = 3;

        @Config.RangeInt(min = 1, max = 7)
        @Config.Comment({ "Number of Lines of the Diamond Backpack"} )
        public int sizeLineDiamondStorage = 4;

        @Config.RangeInt(min = 1, max = 17)
        @Config.Comment({ "Number of Columns of the Basic Backpack"} )
        public int sizeColumnBasic = 6;

        @Config.RangeInt(min = 1, max = 17)
        @Config.Comment({ "Number of Columns of the Iron Backpack"} )
        public int sizeColumnIronStorage = 8;

        @Config.RangeInt(min = 1, max = 17)
        @Config.Comment({ "Number of Columns of the Gold Backpack"} )
        public int sizeColumnGoldStorage = 9;

        @Config.RangeInt(min = 1, max = 17)
        @Config.Comment({ "Number of Columns of the Diamond Backpack"} )
        public int sizeColumnDiamondStorage = 12;


    }

}
