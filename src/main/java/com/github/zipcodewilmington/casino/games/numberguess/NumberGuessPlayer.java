package com.github.zipcodewilmington.casino.games.numberguess;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GamblingPlayer;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessPlayer extends GamblingPlayer {

    int currentGuess;

    public NumberGuessPlayer(CasinoAccount acct) {
        super(acct);
    }

    public void setCurrentGuess(int currentGuess){
        this.currentGuess = currentGuess;
    }

    public int getCurrentGuess(){
        return currentGuess;
    }

}