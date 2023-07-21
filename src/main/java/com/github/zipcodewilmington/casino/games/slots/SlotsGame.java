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

    private final String[] icons = {"", "APPLE", "7", "$", "BAR", ">_<"};
    private final IOConsole console =  new IOConsole(AnsiColor.BLUE);
    Random rand = new Random();
    private int randNumber;
    private SlotsPlayer player;

    public SlotsGame() {

    }

    public SlotsGame(SlotsPlayer player){
        this.player = player;
    }

    public static void main(String[] args) {

        new SlotsGame().run();
    }

    public int generateRandomNum(){
        randNumber = rand.nextInt(5)+1;
        return randNumber;
    }

    public String spinAndBuildSlots() throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        String completedSlots = "";

        while (counter < 3){
            String randomIcon = icons[generateRandomNum()];
            console.print(randomIcon + " ");
            //completedSlots += randomIcon;
            sb.append(randomIcon);
            sb.append(" ");
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
        //CasinoAccount account = new CasinoAccount("manny", "1");
        //SlotsPlayer player = new SlotsPlayer(account);
        //SlotsGame game = new SlotsGame();
//        while (player.promptSpin() != false) {
//            //take out the money here player.paytoPlay
//            String result = game.spinAndBuildSlots();
//            if(game.checkWinCondition(result) == true){
//                System.out.println("You won");
//            } else {
//
//                System.out.println(result);
//                System.out.println("You lost");
//            }
//        }
        CasinoAccount account = new CasinoAccount("Manny", "1", 100.00);
        SlotsPlayer player = new SlotsPlayer(account);

        //bet
        do {
            //Sets current bet
            double bet = console.getDoubleInput(player.getAccountName() + " how much would you like to bet? ");
            player.setCurrentBet(bet);

            //take out the money here
            player.payToPlay(bet);

            //try catch after the player spins the slots and saves the current combination at that instance
            try {
                player.setCurrentSlotCombination(spinAndBuildSlots());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            //checks the win condition of players current state of combinations
            try {
                if(checkWinCondition(player.getCurrentSlotCombination())){
                    console.println("Congratulations " + player.getAccountName() + ", you won, " +
                            (player.getCurrentBet() * 10) + " has been added to your account. ");
                    player.collectWinnings((player.getCurrentBet() * 10));
                    console.println("\n");
                } else {
                    console.println("\nYou are a sore loser KEKW " + player.getCurrentBet() +
                            "has been deducted from your account. ");
                    console.println("\n");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        //while the user chooses to spin the wheel (true) keep running through this loop
        } while (player.promptSpin());

        //runningTotal() when player wins add bet amount to running total
        //cashout ends the game and a adds winnings to account balance
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
