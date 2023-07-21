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
            for(int i = 0; i < 50; i++){console.println("");}
            for (RollPlayer p : players) {
                String question = p.getAccountName() + ", how many dice would you like to roll? ";
                p.setCurrentBet(console.getIntegerInput(question));
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

    public RollPlayer getHighestRoll(ArrayList<RollPlayer> players){
        int indexOfHighest = 0;
        int hold = 0;

        for(RollPlayer p: players){
            if(p.getCurrentRoll() > hold){
                hold = p.getCurrentRoll();
                indexOfHighest = players.indexOf(p);
            }
        }
        return players.get(indexOfHighest);
    }
    public RollPlayer getLowestRoll(ArrayList<RollPlayer> players){
        int hold = 0;
        int indexOfLowest = 0;
        for(RollPlayer p: players){
            if(p.getCurrentRoll()< hold){
                hold = p.getCurrentRoll();
                indexOfLowest = players.indexOf(p);
            }
        }
        return players.get(indexOfLowest);
    }


    @Override
    public void checkWinCond() {
        RollPlayer highest = getHighestRoll(players);
        RollPlayer lowest = getLowestRoll(players);
        int moneyToTransfer = highest.getCurrentRoll() - lowest.getCurrentRoll();
        console.println(lowest.getAccountName()+ " owes "
                + highest.getAccountName()+ " $" + moneyToTransfer);
        lowest.payToPlay(moneyToTransfer);
        highest.collectWinnings(moneyToTransfer);
    }

}
