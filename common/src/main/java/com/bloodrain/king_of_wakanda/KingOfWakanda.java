package com.bloodrain.king_of_wakanda;

import com.bloodrain.king_of_wakanda.items.ModItems;

public class KingOfWakanda {

    public static final String MOD_ID = "king_of_wakanda";

    public static void init() {
       ModItems.ITEMS.register();
       ModItems.init();
    }
}
