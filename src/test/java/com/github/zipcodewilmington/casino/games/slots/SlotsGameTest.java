package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.CasinoAccount;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertTrue;

public class SlotsGameTest {

    @Test
    public void testSlotsGameConstructor() {
        // Create a test SlotsPlayer instance
        CasinoAccount account = new CasinoAccount("Manny", "Benji", 100.00);
        SlotsPlayer player = new SlotsPlayer(account);
        SlotsGame game = new SlotsGame(player);

        // Perform assertions to check if the SlotsGame was initialized correctly
        assertNotNull(game); // Check if the instance is not null
    }

    @Test
    void testGenerateRandomNum() {
        SlotsGame game = new SlotsGame();

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

    @Test
    void testCheckWinCondition() throws InterruptedException {
        CasinoAccount account = new CasinoAccount("Manny", "Benji", 100.00);
        SlotsPlayer player = new SlotsPlayer(account);
        SlotsGame game = new SlotsGame(player);

        boolean expected = true;

        String arrSlot = "a a a";
        boolean actual = game.checkWinCondition(arrSlot);


        assertEquals(expected, actual);
    }




}
