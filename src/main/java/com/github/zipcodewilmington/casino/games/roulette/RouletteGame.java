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
    private static final int MIN_BET = 50 ;
    private static final int MAX_BET = 200;
    String[] wheel;
    ArrayList < RoulettePlayer > players = new ArrayList<>();
    IOConsole console = new  IOConsole();
    private static int playerBalance;
/*
    things you can bet on 1-36 that gives them 100 times of whatever they bet
    or you can bet on a color which is 50/50 double your bets
    bet between 1-9 or 10-18 or 19-27 or 28-36 that will get you four times whatever you get
 */

    public RouletteGame(){
        System.out.println("Welcome to the Roulette Game!");
        final int[] RED_NUMBERS = { 1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36 };
        final int[] BLACK_NUMBERS = { 2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35 };
        final int MAX_BET = 200;
        final int MIN_BET = 50;

        int playerBalance = 1000;
        final Scanner scanner = new Scanner(System.in);
        final Random random = new Random();

    }

    public Integer spinWheel() {
        System.out.println("Lets Play The Game");

        while (playerBalance > 0) {
            System.out.println("Your balance: $" + playerBalance);
            int betAmount = getValidBetAmount();
            int betType = getValidBetType();
            int winningNumber = spinRoulette();
            displayResult(winningNumber, betAmount, betType);
        }
        int index;
        return null;
    }

    private void displayResult(int winningNumber, int betAmount, int betType) {
        System.out.println("Game over. You are out of balance.");
    }

    private static int getValidBetAmount() {
        int betAmount;
        do {
            System.out.print("Enter your bet amount (between " + MIN_BET + " and " + MAX_BET + "): ");
            Random scanner = null;
            betAmount = scanner.nextInt();
        } while (betAmount < MIN_BET || betAmount > MAX_BET || betAmount > playerBalance);

        return betAmount;
    }


    private int spinRoulette() {
        int betType;
        do {
            System.out.println("Select your bet type:");
            System.out.println("1. Bet on a number (payout 35:1)");
            System.out.println("2. Bet on red (payout 1:1)");
            System.out.println("3. Bet on black (payout 1:1)");
            Random scanner = null;
            betType = scanner.nextInt();
        } while (betType < 1 || betType > 3);

        return betType;
    }



    private int getValidBetType() {
        int chosenNumber = getValidChosenNumber();
        int winningNumber = 21;
        int betAmount = 50;
        if (chosenNumber == winningNumber) {
            int winnings = betAmount * 35;
            playerBalance += winnings;
            System.out.println("Congratulations! You won $" + winnings);
        } else {
            playerBalance -= 950;
            System.out.println("Sorry, you lost $" + betAmount);
        }

        return 0;
    }

    private int getValidChosenNumber() {
        byte winningNumber;
        winningNumber = 5;
        int betAmount = 200;
        if (winningNumber == 21 || winningNumber == 21 || isBlack(winningNumber)) {
            playerBalance += betAmount;
            System.out.println("Congratulations! You won $" + betAmount);
        } else {
            playerBalance -= 800;
            System.out.println("Sorry, you lost $" + betAmount);
        }

        return 0;
    }

    private boolean isBlack(byte winningNumber) {
        
        


        return false;
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
