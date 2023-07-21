package com.github.zipcodewilmington.casino.games.roulette;


import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.IOConsole;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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
        System.out.println("Welcome to the Roulette Game!");
        final int[] RED_NUMBERS = { 1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36 };
        final int[] BLACK_NUMBERS = { 2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35 };
        final int MAX_BET = 1000;
        final int MIN_BET = 1;

        int playerBalance = 1000;
        final Scanner scanner = new Scanner(System.in);
        final Random random = new Random();

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
