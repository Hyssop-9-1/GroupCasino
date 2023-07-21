package com.github.zipcodewilmington.casino.games.roll;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GamblingPlayer;

public class RollPlayer extends GamblingPlayer {
    int currentRoll;

    public RollPlayer(CasinoAccount acct) {
        super(acct);
    }

    public int getCurrentRoll() {
        return currentRoll;
    }

    public void setCurrentRoll(int currentRoll) {
        this.currentRoll = currentRoll;
    }
}
