package com.github.zipcodewilmington.casino.gametools;

import com.github.zipcodewilmington.utils.Rank;
import com.github.zipcodewilmington.utils.Suits;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void getSuit() {
        Card card = new Card(Suits.HEARTS, Rank.ACE);

        Suits actual = card.getSuit();
        Suits expected = Suits.HEARTS;

        assertEquals(actual, expected);

    }

    @Test
    void getRank() {
        Card card = new Card(Suits.HEARTS, Rank.ACE);

        Rank actual = card.getRank();
        Rank expected = Rank.ACE;


        assertEquals(actual, expected);
    }

    @Test
    void getValue() {
        Card card = new Card(Suits.HEARTS, Rank.ACE);

        int actual = card.getValue();
        int expected = 14;

        assertEquals(actual, expected);

    }

    @Test
    void testToString() {
        Card card = new Card(Suits.HEARTS, Rank.ACE);


        String actual = card.toString();
        String expected = "ACE of HEARTS";


        assertEquals(actual, expected);
    }
}