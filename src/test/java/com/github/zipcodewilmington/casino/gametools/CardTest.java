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

    @Test
    void testCardDisplay(){
        Card card = new Card(Suits.HEARTS, Rank.ACE);

        String actual = card.cardDisplay();
        String expected = ".------.\n" +
                "|A   _ |\n" +
                "|( \\/ )|\n" +
                "| \\  / |\n" +
                "|  \\/A |\n" +
                "`------'\n";

        assertEquals(actual, expected);
    }
    @Test
    void testCardDisplay2(){
        Card card = new Card(Suits.DIAMONDS, Rank.SEVEN);

        String actual = card.cardDisplay();
        String expected = ".-------.\n" +
                "|7  /\\  |\n" +
                "|  /  \\ |\n" +
                "|  \\  / |\n" +
                "|   \\/7 |\n" +
                "`-------' \n";

        assertEquals(actual, expected);
    }
    @Test
    void testCardDisplay3(){
        Card card = new Card(Suits.SPADES, Rank.TWO);

        String actual = card.cardDisplay();
        String expected = ".------.\n" +
                "|2 _   |\n" +
                "| ( )  |\n" +
                "|(_x_) |\n" +
                "|  Y 2 |\n" +
                "`------'\n";

        assertEquals(actual, expected);
    }
    @Test
    void testCardDisplay4(){
        Card card = new Card(Suits.CLUBS, Rank.KING);

        String actual = card.cardDisplay();
        String expected = ".------.\n" +
                "|K ,   |\n" +
                "| / \\  |\n" +
                "|(_,_) |\n" +
                "|  I K |\n" +
                "`------'\n";

        assertEquals(actual, expected);
    }
}