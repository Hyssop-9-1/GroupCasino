package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.gametools.Card;
import com.github.zipcodewilmington.casino.gametools.Deck;
import com.github.zipcodewilmington.utils.Rank;
import com.github.zipcodewilmington.utils.Suits;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

public class BlackJackPlayerTests {

    //ask about how to instantiate player hand for tests
    @Test
    void testAceValueChecker(){
        CasinoAccount account = new CasinoAccount("Manny", "Benji");
        BlackJackPlayer player = new BlackJackPlayer(account);
        player.playerHand.addCards(new Card(Suits.DIAMONDS, Rank.ACE));
        int expected = 11;

         int actual = player.handTotal();

        assertEquals(expected, actual);
    }

    @Test
    void testHandTotal(){
        CasinoAccount account = new CasinoAccount("Manny", "Benji");
        BlackJackPlayer player = new BlackJackPlayer(account);
        player.playerHand.emptyDeck();
        player.playerHand.addCards(new Card(Suits.DIAMONDS, Rank.EIGHT));
        int expected = 8;

        int actual = player.handTotal();

        assertEquals(expected, actual);
    }

    @Test
    void testViewCard(){
        CasinoAccount account = new CasinoAccount("Manny", "Benji");
        BlackJackPlayer player = new BlackJackPlayer(account);
        player.playerHand.emptyDeck();
        player.playerHand.addCards(new Card(Suits.DIAMONDS, Rank.EIGHT));

        String expected = "You have the EIGHT of DIAMONDS\n" +
                ".-------.\n" +
                "|8  /\\  |\n" +
                "|  /  \\ |\n" +
                "|  \\  / |\n" +
                "|   \\/8 |\n" +
                "`-------' \n";
        String actual = player.viewCard();

        assertEquals(expected, actual);
    }

//    @Test
//    void addPlayerHand(){
//        CasinoAccount account = new CasinoAccount("Manny", "Benji");
//        BlackJackPlayer player = new BlackJackPlayer(account);
//        player.playerHand.emptyDeck();
//
//        ArrayList<Card> expected =  new ArrayList<>();
//        expected.add(new Card(Suits.SPADES, Rank.ACE));
//        player.playerHand.addCards(new Card(Suits.SPADES, Rank.ACE));
//
//
//        //when
//        ArrayList<Card> actual =  new ArrayList<>();
//        actual.add(new Card(Suits.SPADES, Rank.ACE));
//        player.playerHand.addCards(actual);
//
//    }
}
