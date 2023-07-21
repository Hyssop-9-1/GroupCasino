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

        String expected = "TWO of SPADES";
        String actual = player.getTopCard().toString();
//        Assert.assertEquals(expected, actual);
        System.out.println(actual);
    }

    @Test
    public void testGetCurrentCard(){
        Deck deck = new Deck();
        String expected = "THREE of SPADES";
        deck.removeTopCard();
        deck.removeTopCard(); //remove the first and second cards
//        String actual =


    }

    @Test
    public void testAddPlayerHand(){

    }
    @Test
    public void testAddPoint(){

    }
}
