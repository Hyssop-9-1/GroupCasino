package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SlotsPlayerTest {
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);
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

//    @Test
//    void testPromptSpin(){
//        CasinoAccount account = new CasinoAccount("Manny", "Benji", 100.00);
//        SlotsPlayer player = new SlotsPlayer(account);
//
//        boolean expected = true;
//        String actual = console.getStringInput("Would you like to spin the wheel again? Type [y] for yes / [n] for no: ");
//        boolean actualactual;
//        if (actual.equalsIgnoreCase("y")) {
//            actualactual = true;
//        }
//        if (actual.equalsIgnoreCase("n")) {
//            actualactual = false;
//        }
//        actualactual = false;
//
//
//        assertEquals(expected, actualactual);
//    }

    @Test
    void testSetCurrentCombination() throws InterruptedException {

        CasinoAccount account = new CasinoAccount("Manny", "Montales", 10.00);
        SlotsPlayer player = new SlotsPlayer(account);
        SlotsGame game = new SlotsGame(player);

        String expected = "7 7 7";
        player.setCurrentSlotCombination("7 7 7");
        String actual = player.getCurrentSlotCombination();

        assertEquals(expected, actual);
    }

    @Test
    void testGetCurrentCombination() {
        CasinoAccount account = new CasinoAccount("Manny", "Benji", 100.00);
        SlotsPlayer player = new SlotsPlayer(account);
        SlotsGame game = new SlotsGame();

        String expected = "7 7 7";
        player.setCurrentSlotCombination("7 7 7");
        String actual = player.getCurrentSlotCombination();

        assertEquals(expected, actual);
    }

}
