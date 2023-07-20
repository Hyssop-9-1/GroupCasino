package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GamblingPlayer;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsPlayer extends GamblingPlayer {
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);


    public SlotsPlayer(CasinoAccount acct) {
        super(acct);
    }

    public boolean promptSpin() {

        String userChoice = console.getStringInput("Would you like to spin the wheel? type [y] for yes / [n] for no ");

        if (userChoice.equals("y")) {
            return true;
        }
        if (userChoice.equals("n")) {
            return false;
        }
        return false;
    }
}