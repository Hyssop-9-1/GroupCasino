package com.github.zipcodewilmington.casino.gametools;

import java.util.Random;

public class Dice {
    Random rand = new Random();
    int numOfDice;

    public Dice(int numOfDice){
        this.numOfDice = numOfDice;
    }

    public int rollAndSum(){
        int rounds = rand.nextInt(100);
        int hold = 0;
        while (rounds>0){
            hold = rand.nextInt(numOfDice)+1;
        }
        return hold;
    }

    public int getNumOfDice() {
        return numOfDice;
    }
}
