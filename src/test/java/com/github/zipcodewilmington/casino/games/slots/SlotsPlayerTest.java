package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SlotsPlayerTest {
    @Test
    void testConstructor(){
        CasinoAccount account = new CasinoAccount("Manny", "TopG", 100.00);
        SlotsPlayer player = new SlotsPlayer(account);

        CasinoAccount actual = player.getArcadeAccount();

        assertEquals(account, actual);
    }

    @Test
    void testGetCurrentBet() {
        CasinoAccount account = new CasinoAccount("Manny", "Benji", 100.00);
        SlotsPlayer player = new SlotsPlayer(account);

        double expected = 20.0;
        player.setCurrentBet(20.0);
        double actual = player.getCurrentBet();

        assertEquals(expected, actual);
    }

    @Test
    void testSetCurrentBet() {
        CasinoAccount account = new CasinoAccount("Manny", "Benji", 100.00);
        SlotsPlayer player = new SlotsPlayer(account);

        double expected = 20.0;
        player.setCurrentBet(20.0);
        double actual = player.getCurrentBet();

        assertEquals(expected, actual);
    }

    @Test
    void testPromptSpin(){
        CasinoAccount account = new CasinoAccount("Manny", "Benji", 100.00);
        SlotsPlayer player = new SlotsPlayer(account);

        boolean expected = true;
        boolean actual = player.promptSpin();

        assertEquals(expected, actual);
    }
}
