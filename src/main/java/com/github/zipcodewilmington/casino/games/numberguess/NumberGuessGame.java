package com.github.zipcodewilmington.casino.games.numberguess;

import com.github.zipcodewilmington.casino.Game;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.List;
import java.util.Random;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessGame extends Game {
    Random rand = new Random();
    int randNumber; //= Integer.MAX_VALUE;

    public NumberGuessGame(List<PlayerInterface> players) {
        super(players);
    }

    public int generateRandomNum(){
        randNumber = rand.nextInt(10)+1;
        return randNumber;
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