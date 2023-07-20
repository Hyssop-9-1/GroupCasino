package com.github.zipcodewilmington.casino.games.roll;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RollPlayerTest {

    @Test
    void getCurrentRoll() {
        RollPlayer player = new RollPlayer(null);
        player.setCurrentRoll(12);

        int actual = player.getCurrentRoll();
        int expected = 12;

        assertEquals(expected, actual);
    }

    @Test
    void setCurrentRoll() {
        RollPlayer player = new RollPlayer(null);
        player.setCurrentRoll(54);

        int actual = player.getCurrentRoll();
        int expected = 54;

        assertEquals(expected, actual);
    }
}