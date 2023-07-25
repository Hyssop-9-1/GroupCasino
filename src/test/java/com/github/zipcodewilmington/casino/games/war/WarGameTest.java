package com.github.zipcodewilmington.casino.games.war;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.gametools.Deck;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class WarGameTest {

    @Test
    public void testFlipCards(){
        WarGame game = new WarGame();
        Deck deck = new Deck();
        WarPlayer player = new WarPlayer(new CasinoAccount(null, null));
        player.addPlayerHand(deck.deal(10));


        //player.playerHand.emptyDeck();
        game.flipCards( player, 5);
        int actual = player.playerHand.deckSize();
        Assert.assertEquals(5, actual);
        }

    }

