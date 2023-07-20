package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Game;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame extends Game {
    public SlotsGame(List<PlayerInterface> players) {
        super(players);
    }

    private String icons[] = {"", "APPLE", "7", "$", "BAR", ">_<"};
    IOConsole console =  new IOConsole(AnsiColor.BLUE);
    Random rand = new Random();
    private int randNumber;

    public static void main(String[] args) throws InterruptedException {
        CasinoAccount account = new CasinoAccount("manny", "1");
        SlotsPlayer player = new SlotsPlayer(account);
        ArrayList<PlayerInterface> players = new ArrayList<>();
        SlotsGame game = new SlotsGame(players);


        //bet
        while (player.promptSpin() != false) {
            //take out the money here player.paytoPlay
            String result = game.spinAndBuildSlots();
            if(game.checkWinCondition(result) == true){
                System.out.println("You won");
            } else {

                System.out.println(result);
                System.out.println("You lost");
            }
        }
        //runningTotal() when player wins add bet amount to running total
        //cashout ends the game and a adds winnings to account balance
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
            System.out.println(randomIcon);
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

        //checks each position of slot if we want to not hard code values I can come up with a solution
        if (arrSlot[0].equals(arrSlot[1]) && (arrSlot[0].equals(arrSlot[2]))){
            return true;
        }return false;
    }

    @Override
    public void run() {

    }

    @Override
    public void setup() {

    }

    @Override
    public boolean checkWinCond(PlayerInterface... player) {
        return false;
    }
}
