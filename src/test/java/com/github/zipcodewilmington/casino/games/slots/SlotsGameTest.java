package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessGame;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class SlotsGameTest {

    @Test
    void testGenerateRandomNum() {
        ArrayList<PlayerInterface> players = new ArrayList<>();
        SlotsGame game = new SlotsGame(players);

        int[] yield = new int[6];
        for (int i = 0; i < 1000; i++) {
            int num = game.generateRandomNum();
            assertTrue("Illegal number generated " + num, num > 0 && num <= 5);
            yield[num] += 1;
        }
        for (int j = 1; j <= 5; j++) {
            assertTrue("You never generate the num " + j , yield[j] >= 0);
        }
    }

}
