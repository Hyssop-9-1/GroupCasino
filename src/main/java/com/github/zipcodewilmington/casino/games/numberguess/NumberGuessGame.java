package com.github.zipcodewilmington.casino.games.numberguess;

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
public class NumberGuessGame implements GameInterface {
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);
    Random rand = new Random();
    int randNumber; //= Integer.MAX_VALUE;
    private List<NumberGuessPlayer> players = new ArrayList<>();


    public NumberGuessGame(List<NumberGuessPlayer> players) {
        this.players.addAll(players);
    }
    public NumberGuessGame(){

    }

    public int generateRandomNum(){
        randNumber = rand.nextInt(10)+1;
        return randNumber;
    }

    public void setPlayerGuess(){
        int hold = 0;
           for(NumberGuessPlayer p: this.players){
               do {
                   hold = console.getIntegerInput(p.getAccountName() + ", input a guess between 1-10");
               }while(hold<1 || hold>10);
                p.setCurrentGuess(hold);
           }
    }

    @Override
    public void run() {
        boolean cont = true;
        do {
            setup();
            for (NumberGuessPlayer p : players) {
                double bet = console.getDoubleInput("How much would you like to bet?");
                if (bet != 0) {
                    p.setCurrentBet(bet);
                }
            }
            setPlayerGuess();
            checkWinCond();
            String yesNo = console.getStringInput("Would you like to play another round? y/n ");
            if(yesNo.equalsIgnoreCase("n")){
                cont = false;
            }
        }while(cont);

    }

    @Override
    public void setup() {
        generateRandomNum();
    }

    @Override
    public void addPlayer(PlayerInterface player) {
        players.add((NumberGuessPlayer) player);
    }

    @Override
    public void removePlayer() {

    }

    @Override
    public void checkWinCond() {
        for(NumberGuessPlayer p : players){
            if(p.getCurrentGuess() == randNumber){
                console.println("You have guessed correctly! $" + (p.getCurrentBet() * 10) + " has been added to your account." );
                p.collectWinnings((p.getCurrentBet() * 10));
            }
            else{
                console.println("You guessed incorrectly $" + p.getCurrentBet() + " has been deducted from your account." );
                p.payToPlay(p.getCurrentBet());
            }
        }
    }


}