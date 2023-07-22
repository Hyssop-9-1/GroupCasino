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
        Deck playerHand = new Deck();
        playerHand.emptyDeck();
        playerHand.addCards(new Card(Suits.DIAMONDS, Rank.ACE));
        CasinoAccount account = new CasinoAccount("Manny", "Benji");
        BlackJackPlayer player = new BlackJackPlayer(account);

        int expected = 11;

        int actual = player.handTotal() + 1;
        int tempTotal = actual;
        for (Card c: playerHand.getCards()){
            if (c.rank.getAbbreviation().equals("A"))
            {
                if ((tempTotal + 11) <= 21 ){
                    actual += 11;
                    break;
                } else
                {
                    actual += c.rank.getBlackJackValue();
                    break;
                }
            }
            actual += c.rank.getBlackJackValue();
        };
        assertEquals(expected, actual);
    }

    @Test
    void testHandTotal(){
        Deck playerHand = new Deck();
        playerHand.emptyDeck();
        playerHand.addCards(new Card(Suits.DIAMONDS, Rank.EIGHT));
        CasinoAccount account = new CasinoAccount("Manny", "Benji");
        BlackJackPlayer player = new BlackJackPlayer(account);

        int expected = 8;

        int actual = player.handTotal();
        int tempTotal = actual;
        for (Card c: playerHand.getCards()){
            if (c.rank.getAbbreviation().equals("A"))
            {
                if ((tempTotal + 11) > 21 ){
                    actual += c.rank.getBlackJackValue();
                    break;
                } else
                {
                    actual += 11;
                    break;
                }
            }
            actual += c.rank.getBlackJackValue();
        };
        assertEquals(expected, actual);
    }
}
