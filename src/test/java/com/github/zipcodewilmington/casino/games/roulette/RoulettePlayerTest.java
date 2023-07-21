package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.CasinoAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoulettePlayerTest {

    @Test
    void getCurrentBetKey() {
        CasinoAccount account = new CasinoAccount("Dave","1234");
        RoulettePlayer player = new RoulettePlayer(account);
        player.setCurrentBetKey(50);
        int actual = player.getCurrentBetKey();
        int expected = 50;

        assertEquals(expected,actual);
    }

    @Test
    void setCurrentBetKey() {
        CasinoAccount account = new CasinoAccount("Dave","1234");
        RoulettePlayer player = new RoulettePlayer(account);
        player.setCurrentBetKey(77);
        int actual = player.getCurrentBetKey();
        int expected = 77;

        assertEquals(expected,actual);
    }
}