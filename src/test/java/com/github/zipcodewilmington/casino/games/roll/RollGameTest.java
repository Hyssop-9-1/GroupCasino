package com.github.zipcodewilmington.casino.games.roll;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RollGameTest {

    @Test
    void addPlayer() {
        RollGame game = new RollGame();
        RollPlayer player = new RollPlayer(null);

        int expected = 0;
        int actual = game.players.size();
        assertEquals(expected, actual);

        expected = 1;
        game.addPlayer(player);
        actual = game.players.size();
        assertEquals(expected, actual);
    }

    @Test
    void testGetHighestRoll() {
        RollGame game = new RollGame();
        RollPlayer player = new RollPlayer(null);
        RollPlayer player1 = new RollPlayer(null);
        RollPlayer player2 = new RollPlayer(null);
        ArrayList<RollPlayer> players = new ArrayList<>();

        player.setCurrentRoll(1);player1.setCurrentRoll(2);player2.setCurrentRoll(3);
        players.add(player);players.add(player1);players.add(player2);

        RollPlayer actual = game.getHighestRoll(players);
        assertEquals(player2, actual);

    }
    @Test
    void testGetHighestRoll1() {
        RollGame game = new RollGame();
        RollPlayer player = new RollPlayer(null);
        RollPlayer player1 = new RollPlayer(null);
        RollPlayer player2 = new RollPlayer(null);
        ArrayList<RollPlayer> players = new ArrayList<>();

        player.setCurrentRoll(1);player1.setCurrentRoll(4);player2.setCurrentRoll(3);
        players.add(player);players.add(player1);players.add(player2);

        RollPlayer actual = game.getHighestRoll(players);
        assertEquals(player1, actual);
    }
    @Test
    void testGetHighestRoll2() {
        RollGame game = new RollGame();
        RollPlayer player = new RollPlayer(null);
        RollPlayer player1 = new RollPlayer(null);
        RollPlayer player2 = new RollPlayer(null);
        ArrayList<RollPlayer> players = new ArrayList<>();

        player.setCurrentRoll(100);player1.setCurrentRoll(2);player2.setCurrentRoll(3);
        players.add(player);players.add(player1);players.add(player2);

        RollPlayer actual = game.getHighestRoll(players);
        assertEquals(player, actual);
    }
    @Test
    void testGetHighestRoll3() {
        RollGame game = new RollGame();
        RollPlayer player = new RollPlayer(null);
        RollPlayer player1 = new RollPlayer(null);
        RollPlayer player2 = new RollPlayer(null);
        ArrayList<RollPlayer> players = new ArrayList<>();

        player.setCurrentRoll(2);player1.setCurrentRoll(2);player2.setCurrentRoll(0);
        players.add(player);players.add(player1);players.add(player2);

        RollPlayer actual = game.getHighestRoll(players);
        assertEquals(player, actual);
    }


    @Test
    void testGetLowestRoll() {
        RollGame game = new RollGame();
        RollPlayer player = new RollPlayer(null);
        RollPlayer player1 = new RollPlayer(null);
        RollPlayer player2 = new RollPlayer(null);
        ArrayList<RollPlayer> players = new ArrayList<>();

        player.setCurrentRoll(1);player1.setCurrentRoll(2);player2.setCurrentRoll(3);
        players.add(player);players.add(player1);players.add(player2);

        RollPlayer actual = game.getLowestRoll(players);
        assertEquals(player, actual);
    }
    @Test
    void testGetLowestRoll1() {
        RollGame game = new RollGame();
        RollPlayer player = new RollPlayer(null);
        RollPlayer player1 = new RollPlayer(null);
        RollPlayer player2 = new RollPlayer(null);
        ArrayList<RollPlayer> players = new ArrayList<>();

        player.setCurrentRoll(100);player1.setCurrentRoll(90);player2.setCurrentRoll(3);
        players.add(player);players.add(player1);players.add(player2);

        RollPlayer actual = game.getLowestRoll(players);
        assertEquals(player2, actual);
    }
    @Test
    void testGetLowestRoll2() {
        RollGame game = new RollGame();
        RollPlayer player = new RollPlayer(null);
        RollPlayer player1 = new RollPlayer(null);
        RollPlayer player2 = new RollPlayer(null);
        ArrayList<RollPlayer> players = new ArrayList<>();

        player.setCurrentRoll(123);player1.setCurrentRoll(133);player2.setCurrentRoll(12);
        players.add(player);players.add(player1);players.add(player2);

        RollPlayer actual = game.getLowestRoll(players);
        assertEquals(player2, actual);
    }
    @Test
    void testGetLowestRoll3() {
        RollGame game = new RollGame();
        RollPlayer player = new RollPlayer(null);
        RollPlayer player1 = new RollPlayer(null);
        RollPlayer player2 = new RollPlayer(null);
        ArrayList<RollPlayer> players = new ArrayList<>();

        player.setCurrentRoll(1);player1.setCurrentRoll(-1);player2.setCurrentRoll(3);
        players.add(player);players.add(player1);players.add(player2);

        RollPlayer actual = game.getLowestRoll(players);
        assertEquals(player1, actual);
    }

    @Test
    void testCont(){
        RollGame game = new RollGame();
        String yesNo = "y";

        assertTrue(game.cont(yesNo));

    }
    @Test
    void testCont2(){
        RollGame game = new RollGame();
        String yesNo = "n";

        assertFalse(game.cont(yesNo));
    }
}