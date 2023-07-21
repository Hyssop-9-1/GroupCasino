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


    @Test
    void testAceValueChecker(){
        Deck playerHand = new Deck();
        playerHand.emptyDeck();
        playerHand.addCards(new Card(Suits.DIAMONDS, Rank.ACE));

        int expected = 11;

        int total = 5;
        int tempTotal = total;
        for (Card c: playerHand.getCards()){
            if (c.rank.getAbbreviation().equals("A"))
            {
                if ((tempTotal += 11) > 21 ){
                    total += c.rank.getBlackJackValue();
                } else {
                    total += 11;
                    break;
                }
            }
            total += c.rank.getBlackJackValue();
        };

        assertEquals(expected, total);
    }
}
