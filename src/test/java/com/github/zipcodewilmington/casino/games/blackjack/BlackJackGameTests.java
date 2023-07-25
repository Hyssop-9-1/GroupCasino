package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BlackJackGameTests {

    @Test
    void testPlayerBust(){
        //given
        BlackJackGame game = new BlackJackGame();
        boolean expected = false;

        int player = 30;
        int dealer = 9;


        assertEquals(expected, game.decideWinner(player, dealer));
    }

    @Test
    void testPlayerBlackJack(){
        //given
        BlackJackGame game = new BlackJackGame();
        game.addPlayer(new BlackJackPlayer(new CasinoAccount(null, null)));
        boolean expected = true;

        int player1 = 21;
        int dealer = 9;


        assertEquals(expected, game.decideWinner(player1, dealer));
    }

    @Test
    void testDealerBust(){
        //given
        BlackJackGame game = new BlackJackGame();
        game.addPlayer(new BlackJackPlayer(new CasinoAccount(null, null)));
        boolean expected = true;

        int player = 19;
        int dealer = 30;


        assertEquals(expected, game.decideWinner(player, dealer));
    }

    @Test
    void testPlayerWin(){
        //given
        BlackJackGame game = new BlackJackGame();
        game.addPlayer(new BlackJackPlayer(new CasinoAccount(null, null)));

        boolean expected = true;

        int player = 19;
        int dealer = 8;


        assertEquals(expected, game.decideWinner(player, dealer));
    }

    @Test
    void testDealerWin(){
        //given
        BlackJackGame game = new BlackJackGame();
        game.addPlayer(new BlackJackPlayer(new CasinoAccount(null, null)));

        boolean expected = false;

        int player = 3;
        int dealer = 8;


        assertEquals(expected, game.decideWinner(player, dealer));
    }

    @Test
    void testTie(){
        //given
        BlackJackGame game = new BlackJackGame();
        game.addPlayer(new BlackJackPlayer(new CasinoAccount(null, null)));

        boolean expected = false;

        int player = 8;
        int dealer = 8;


        assertEquals(expected, game.decideWinner(player, dealer));
    }

    @Test
    void testContinuePlayingYes(){
        //given
        BlackJackGame game = new BlackJackGame();

        boolean expected = true;


        assertEquals(expected, game.continuePlaying("y"));
    }
    @Test
    void testContinuePlayingNo(){
        //given
        BlackJackGame game = new BlackJackGame();

        boolean expected = false;


        assertEquals(expected, game.continuePlaying("n"));
    }
}
