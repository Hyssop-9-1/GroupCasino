package com.github.zipcodewilmington.casino.games.roulette;


import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GamblingPlayer;

public class RoulettePlayer extends GamblingPlayer {
    int currentBetKey;

    public int getCurrentBetKey() {
        return currentBetKey;
    }

    public void setCurrentBetKey(int currentBetKey) {
        this.currentBetKey = currentBetKey;
    }

    public RoulettePlayer(CasinoAccount acct) {
        super(acct);

    }



}
