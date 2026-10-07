package com.bloodrain.king_of_wakanda.fabric;

import com.bloodrain.king_of_wakanda.KingOfWakanda;
import net.fabricmc.api.ModInitializer;

public class KingOfWakandaFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        KingOfWakanda.init();
    }

}
