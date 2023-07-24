package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame implements GameInterface {

    //private final String[] icons = { "","\u2B50", "\u26d4", "\u2705", "\u27a1","\u26d4","\u26d4"};
    private final String[] icons = { "","$", "7","#", "@","&"};//

    private final IOConsole console =  new IOConsole(AnsiColor.BLUE);
    Random rand = new Random();
    private int randNumber;
    private SlotsPlayer player;

    public SlotsGame() {

    }

    public SlotsGame(SlotsPlayer player){
        this.player = player;
    }



    public int generateRandomNum(){
        randNumber = rand.nextInt(icons.length -1 ) + 1;
        return randNumber;
    }

    public String spinAndBuildSlots() throws InterruptedException {
//        StringBuilder sb = new StringBuilder();
//        int counter = 0;
//
//        while (counter < 3){
//            String randomIcon = icons[generateRandomNum()];
//            //String randomIcon = icons[0];
//            console.print(randomIcon + " ");
//            sb.append(randomIcon + " ");
//            Thread.sleep(2000);
//            counter++;
//        }
//        return String.valueOf(sb);
//        SlotsGame game = new SlotsGame();
//        game.displaySlots();

        //"\uD83D\uDD34", "\uD83D\uDD37",
        System.out.println( "    ____  _       _      \n" +
                "   / ___|| | ___ | |_    \n" +
                "   \\___ \\| |/ _ \\| __| \n" +
                "    ___) | | (_) | |_     \n" +
                "   |____/|_|\\___/ \\__| \n");
        String slotsFormat = "%6s";
        int slotsConfirmed = 0;
        for(int i = 0; i < 11; i++) {
            for (int x = 3; slotsConfirmed < x; x--) {
                System.out.printf(slotsFormat, icons[generateRandomNum()]);
                Thread.sleep(300);
                System.out.print("\b");
            }
            for(int p = 0; p < 24 ; p++){ //8 * (3-slotsConfirmed)
                System.out.print("\b");
            }
            if(i == 10 && slotsConfirmed < 3){
                if(slotsConfirmed == 2){
                    slotsFormat = "     " + icons[generateRandomNum()] + slotsFormat;
                    slotsFormat = slotsFormat.replace("%6s", "");
                }
                else {
                    slotsFormat = "     " + icons[generateRandomNum()] + slotsFormat;
                    slotsConfirmed++;
                    i = 0;
                }
            }
        }
        return slotsFormat;
    }

    public boolean checkWinCondition(String spin) throws InterruptedException {
        spin = spin.replace("     ", "");
        //String[] arrSlot = spin.split("     ");

        //String arrSlot[] = {"a", "a", "a"};
        //checks each position of slot if we want to not hard code values I can come up with a solution
        //return arrSlot[0].equals(arrSlot[1]) && (arrSlot[0].equals(arrSlot[2]));
        return spin.charAt(0) == spin.charAt(1) && spin.charAt(0)==spin.charAt(2);
    }

    @Override
    public void run() {
        double bet = console.getDoubleInput(player.getAccountName() + " how much would you like to bet? ");
        player.setCurrentBet(bet);
        //bet
        do {
            try {
                for(int i = 0; i < 50; i++){console.println(" ");}
                //spins and sets the string
                player.setCurrentSlotCombination(spinAndBuildSlots());
                //checks the win condition of players current state of combinations
                console.println(player.getCurrentSlotCombination());
                if(checkWinCondition(player.getCurrentSlotCombination())){
                    console.println("\nCongratulations " + player.getAccountName() + ", you won, " +
                            (player.getCurrentBet() * 10) + " has been added to your account. ");
                    player.collectWinnings((player.getCurrentBet() * 10));
                    console.println("\n");
                } else {
                    console.println("\nYou are a sore loser KEKW " + player.getCurrentBet() +
                            " has been deducted from your account. ");
                    //take out the money here
                    player.payToPlay(player.getCurrentBet());
                    console.println("\n");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        //while the user chooses to spin the wheel (true) keep running through this loop
        } while (player.promptSpin());
    }

    @Override
    public void setup() {
    }

    @Override
    public void addPlayer(PlayerInterface player) {
        this.player = (SlotsPlayer) player;
    }

    @Override
    public void removePlayer() {
    }

    @Override
    public void checkWinCond() {

    }


}
