package com.github.zipcodewilmington.casino.games.war;


import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.gametools.Deck;
import org.junit.Assert;
import org.junit.Test;

public class WarPlayerTest {

    @Test
    public void testConstructor(){
        CasinoAccount acct = new CasinoAccount(null, null);
        WarPlayer player = new WarPlayer(acct);

        CasinoAccount actual = player.getArcadeAccount();

        Assert.assertEquals(acct, actual);
    }

    @Test
    public void testGetTopCard(){
        CasinoAccount acct = new CasinoAccount(null, null);
        WarPlayer player = new WarPlayer(acct);
        Deck deck = new Deck();
        player.addPlayerHand(deck.deal(52));


        String expected = "TWO of SPADES";
        String actual = player.getTopCard().toString();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testGetCurrentCard(){
        CasinoAccount acct = new CasinoAccount(null, null);
        WarPlayer player = new WarPlayer(acct);
        Deck deck = new Deck();
        player.addPlayerHand(deck.deal(52));

        String expected = "THREE of SPADES";
        player.getTopCard();
        player.getTopCard(); //remove the first and second cards
        String actual = player.getCurrentCard().toString();

        Assert.assertEquals(expected, actual);


    }

    @Test
    public void testAddPlayerHand(){
        CasinoAccount acct = new CasinoAccount(null, null);
        WarPlayer player = new WarPlayer(acct);
        Deck deck = new Deck();
        player.addPlayerHand(deck.deal(52));

        int expected = 52;
        int actual = player.playerHand.deckSize();

        Assert.assertEquals(expected, actual);

    }
    @Test
    public void testAddPoint(){
        CasinoAccount acct = new CasinoAccount(null, null);
        WarPlayer player = new WarPlayer(acct);

        int points = player.getPlayerPoints();
        int expected = points + 1;

        player.addPoints(1);
        int actual = player.getPlayerPoints();

        Assert.assertEquals(expected, actual);


    }
}
