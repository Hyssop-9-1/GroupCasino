package com.github.zipcodewilmington.casino.games.numberguess;

import com.github.zipcodewilmington.casino.PlayerInterface;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class NumberGuessGameTest {


    @Test
    void testGenerateRandomNum() {
        ArrayList<PlayerInterface> players = new ArrayList<>();
        NumberGuessGame game = new NumberGuessGame(players);

        int[] yield = new int[11];
        for (int i = 0; i < 1000; i++) {
            int num = game.generateRandomNum();
            assertTrue("Illegal number generated " + num, num > 0 && num <= 10);
            yield[num] += 1;
        }
        for (int j = 1; j <= 10; j++) {
            assertTrue("You never generate the num " + j , yield[j] > 0);
        }
    }

    @Test
    void testSetPlayerGuessTest(){


    }

}