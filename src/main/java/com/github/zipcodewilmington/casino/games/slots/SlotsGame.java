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

    private final String[] icons = { " ", "APPLE", "7", "$", "BAR", ">_<"};
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
        StringBuilder sb = new StringBuilder();
        int counter = 0;

        while (counter < 3){
            String randomIcon = icons[generateRandomNum()];
            //String randomIcon = icons[0];
            console.print(randomIcon + " ");
            sb.append(randomIcon + " ");
            Thread.sleep(2000);
            counter++;
        }
        return String.valueOf(sb);
    }

    public boolean checkWinCondition(String spin) throws InterruptedException {
        String[] arrSlot = spin.split(" ");
        //String arrSlot[] = {"a", "a", "a"};
        //checks each position of slot if we want to not hard code values I can come up with a solution
        return arrSlot[0].equals(arrSlot[1]) && (arrSlot[0].equals(arrSlot[2]));
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

    public String displaySlots(){
        String slotsFormatted =
                                "    ____  _       _      \n" +
                                "   / ___|| | ___ | |_    \n" +
                                "   \\___ \\| |/ _ \\| __| \n" +
                                "    ___) | | (_) | |_     \n" +
                                "   |____/|_|\\___/ \\__| \n" +
                                "  ┌─────┐ ┌─────┐ ┌─────┐\n" +
                                "  │     │ │     │ │     │\n" +
                                "  │  %s │ │ %3s │ │ %5s │\n" +
                                "  │     │ │     │ │     │\n" +
                                "  └─────┘ └─────┘ └─────┘\n";

        System.out.println(slotsFormatted);
        return "no u";
    }


    public static void main(String[] args) throws InterruptedException{
//        SlotsGame game = new SlotsGame();
//        game.displaySlots();

        String[] icon = {"\u2B50", "\u26d4", "\u2705", "\u27a1"};
        //"\uD83D\uDD34", "\uD83D\uDD37",
        for(String s : icon){
            System.out.print(s);
            Thread.sleep(500);
            System.out.print("\b");
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 15; i++){

        }
    }

}
