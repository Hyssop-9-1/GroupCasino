package com.github.zipcodewilmington.casino.games.war;


import com.github.zipcodewilmington.casino.CasinoAccount;
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

    }

    @Test
    public void testGetCurrentCard(){

    }

    @Test
    public void testAddPlayerHand(){

    }
    @Test
    public void testAddPoint(){

    }
}
