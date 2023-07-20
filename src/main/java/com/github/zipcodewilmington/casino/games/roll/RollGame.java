package com.github.zipcodewilmington.casino.games.roll;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.gametools.Dice;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.ArrayList;

public class RollGame implements GameInterface {

    ArrayList<RollPlayer> players = new ArrayList<>();
    IOConsole console = new IOConsole();
    Dice dice;
    @Override
    public void run() {
        boolean cont = true;
        do {
            for (RollPlayer p : players) {
                String question = p.getAccountName() + ", how many dice would you like to roll? ";
                p.setCurrentBet(console.getIntegerInput(question));
                console.println("hi");
                dice = new Dice((int) p.getCurrentBet());
                for (RollPlayer player : players) {
                    player.setCurrentRoll(dice.rollAndSum());
                    console.println(player.getAccountName() + " rolled a " + player.getCurrentRoll());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                checkWinCond();
            }
            if(console.getStringInput("Play again? y/n").equalsIgnoreCase("n")){
                cont = false;
            }
        }while(cont);
    }

    @Override
    public void setup() {

    }

    @Override
    public void addPlayer(PlayerInterface player) {
        players.add((RollPlayer) player);
    }

    @Override
    public void removePlayer() {

    }

    @Override
    public void checkWinCond() {
        int indexOfHighest = 0;
        int hold = 0;
        int indexOfLowest = 0;
        for(RollPlayer p: players){
            if(p.getCurrentRoll() > hold){
                hold = p.getCurrentRoll();
                indexOfHighest = players.indexOf(p);
            }
        }
        for(RollPlayer p: players){
            if(p.getCurrentRoll()< hold){
                hold = p.getCurrentRoll();
                indexOfLowest = players.indexOf(p);
            }
        }
        int moneyToTransfer = players.get(indexOfHighest).getCurrentRoll() - players.get(indexOfLowest).getCurrentRoll();
        console.println(players.get(indexOfLowest).getAccountName()+ " owes "
                + players.get(indexOfHighest).getAccountName()+ " $" + moneyToTransfer);
        players.get(indexOfLowest).payToPlay(moneyToTransfer);
        players.get(indexOfHighest).collectWinnings(moneyToTransfer);
    }

}
