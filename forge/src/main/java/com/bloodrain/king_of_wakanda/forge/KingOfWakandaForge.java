package com.bloodrain.king_of_wakanda.forge;

import com.bloodrain.king_of_wakanda.KingOfWakanda;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.threetag.palladiumcore.forge.PalladiumCoreForge;

@Mod(KingOfWakanda.MOD_ID)
public class KingOfWakandaForge {

    public KingOfWakandaForge() {
        // Submit our event bus to let PalladiumCore register our content on the right time
        PalladiumCoreForge.registerModEventBus(KingOfWakanda.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        KingOfWakanda.init();
    }
}
