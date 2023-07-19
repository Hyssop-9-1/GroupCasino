package com.github.zipcodewilmington.casino.games.numberguess;

import com.github.zipcodewilmington.casino.CasinoAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberGuessPlayerTest {

    @Test
    void testConstructor(){
        CasinoAccount account = new CasinoAccount("Taylor", "Myers", 10.00);
        NumberGuessPlayer player = new NumberGuessPlayer(account);

        CasinoAccount actual = player.getArcadeAccount();

        assertEquals(actual, account);
    }

    @Test
    void testSetCurrentBet(){
        CasinoAccount account = new CasinoAccount("Taylor", "Myers", 10.00);
        NumberGuessPlayer player = new NumberGuessPlayer(account);

        double expected = 10.0;
        player.setCurrentBet(10.0);
        double actual = player.getCurrentBet();

        assertEquals(actual, expected);
    }

    @Test
    void testGetCurrentBet(){
        CasinoAccount account = new CasinoAccount("Taylor", "Myers", 10.00);
        NumberGuessPlayer player = new NumberGuessPlayer(account);

        double expected = 20.0;
        player.setCurrentBet(20.0);
        double actual = player.getCurrentBet();

        assertEquals(actual, expected);
    }

    @Test
    void testCollectWinnings(){
        CasinoAccount account = new CasinoAccount("Taylor", "Myers", 10.00);
        NumberGuessPlayer player = new NumberGuessPlayer(account);

        double expected = 20.00;
        player.collectWinnings(10.0);
        double actual = account.getAccountBalance();

        assertEquals(actual, expected);

    }

    @Test
    void testPayToPlay(){
        CasinoAccount account = new CasinoAccount("Taylor", "Myers", 10.00);
        NumberGuessPlayer player = new NumberGuessPlayer(account);

        double expected = 0.00;
        player.payToPlay(10.0);
        double actual = account.getAccountBalance();

        assertEquals(actual, expected);

    }

    @Test
    void testSetCurrentGuess(){

        CasinoAccount account = new CasinoAccount("Taylor", "Myers", 10.00);
        NumberGuessPlayer player = new NumberGuessPlayer(account);

        double expected = 10;
        player.setCurrentGuess(10);
        double actual = player.getCurrentGuess();

        assertEquals(expected, actual);
    }
    @Test
    void testGetCurrentGuess(){

        CasinoAccount account = new CasinoAccount("Taylor", "Myers", 10.00);
        NumberGuessPlayer player = new NumberGuessPlayer(account);

        double expected = 20;
        player.setCurrentGuess(20);
        double actual = player.getCurrentGuess();

        assertEquals(expected, actual);
    }

}