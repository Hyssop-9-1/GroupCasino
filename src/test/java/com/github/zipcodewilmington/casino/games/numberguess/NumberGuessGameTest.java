package com.github.zipcodewilmington.casino.games.numberguess;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class NumberGuessGameTest {


    @Test
    void testGenerateRandomNum() {

        NumberGuessPlayer player = new NumberGuessPlayer(null);
        NumberGuessGame game = new NumberGuessGame();
        game.addPlayer(player);



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
    void testWinCondition(){
        NumberGuessGame game = new NumberGuessGame();
        game.randNumber = 10;
        NumberGuessPlayer player = new NumberGuessPlayer(null);
        player.setCurrentGuess(10);

        assertTrue(game.checkWinCond(player));
    }
    @Test
    void testWinCondition2(){
        NumberGuessGame game = new NumberGuessGame();
        game.randNumber = 100;
        NumberGuessPlayer player = new NumberGuessPlayer(null);
        player.setCurrentGuess(100);

        assertTrue(game.checkWinCond(player));
    }
    @Test
    void testWinCondition3(){
        NumberGuessGame game = new NumberGuessGame();
        game.randNumber = 10000;
        NumberGuessPlayer player = new NumberGuessPlayer(null);
        player.setCurrentGuess(10000);

        assertTrue(game.checkWinCond(player));
    }

    @Test
    void testSetup(){
        NumberGuessGame game = new NumberGuessGame();

        int expected = 0;
        assertEquals(expected, game.randNumber);

        game.setup();

        assertTrue(game.randNumber>0);

    }

}