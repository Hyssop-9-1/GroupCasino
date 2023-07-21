package com.github.zipcodewilmington.casino.games.roulette;


import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.IOConsole;

import java.io.IOException;
import java.util.ArrayList;

public class RouletteGame implements GameInterface {
    String[] wheel;
    ArrayList < RoulettePlayer > players = new ArrayList<>();
    IOConsole console = new  IOConsole();
/*
    things you can bet on 1-36 that gives them 100 times of whatever they bet
    or you can bet on a color which is 50/50 double your bets
    bet between 1-9 or 10-18 or 19-27 or 28-36 that will get you four times whatever you get
 */

    public RouletteGame(){

    }

    public Integer spinWheel() {
        int index;
        return null;
    }

    public Boolean checkWinCond(PlayerInterface player) {
        boolean winCond = false;
        return winCond;
    }

    public Integer calculateWinnings(PlayerInterface player) {
        int winningAmount;
        return null;
    }


    /**
     *
     */
    public static void main(String[] args) {
        new RouletteGame().run();
    }
    @Override
    public void run() {
        capturePlayerKey();



    }

    @Override
    public void setup() {


    }

    @Override
    public void addPlayer(PlayerInterface player) {
        this.players.add((RoulettePlayer)player);
    }

    @Override
    public void removePlayer() {

    }

    @Override
    public void checkWinCond() {

    }
    public int capturePlayerKey(){
        String question ="press 1: to bet on a number\n" +
                            "press 2: to bet on a color\n" +
                            "press 3: to bet odd or even";
        return console.getIntegerInput(question);

    }


}
