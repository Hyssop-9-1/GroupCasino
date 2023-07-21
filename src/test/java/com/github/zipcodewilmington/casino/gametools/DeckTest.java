package com.github.zipcodewilmington.casino.gametools;

import com.github.zipcodewilmington.utils.Rank;
import com.github.zipcodewilmington.utils.Suits;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    void shuffle() {
        Deck deck = new Deck();
        Deck deck1 = new Deck();
        deck.shuffle();

        Card c1 = deck.cards.remove(0);
        Card c2 = deck1.cards.remove(0);


        assertNotEquals(c1.toString(), c2.toString());

    }

    @Test
    void addCards() {
        Deck deck = new Deck();
        Card c1 = new Card(Suits.CLUBS, Rank.ACE);

        int expected = 53;
        deck.addCards(c1);
        int actual = deck.deckSize();

        assertEquals(expected, actual);
    }

    @Test
    void testAddCards() {
        Deck deck = new Deck();
        Card c1 = new Card(Suits.CLUBS, Rank.ACE);
        ArrayList<Card> cardsList = new ArrayList();
        cardsList.add(c1);
        cardsList.add(c1);
        cardsList.add(c1);

        int expected = 55;
        deck.addCards(cardsList);
        int actual = deck.deckSize();

        assertEquals(expected, actual);
    }

    @Test
    void removeTopCard() {
        Deck deck = new Deck();
        deck.removeTopCard();

        int expected = 51;
        int actual = deck.deckSize();

        assertEquals(expected, actual);
    }

    @Test
    void emptyDeck() {
        Deck deck = new Deck();
        deck.emptyDeck();

        int expected = 0;
        int actual = deck.deckSize();

        assertEquals(expected, actual);
    }

    @Test
    void deal() {
        Deck deck = new Deck();
        Deck deck1 = new Deck();
        deck1.emptyDeck();
        deck1.addCards(deck.deal(26));

        int expected = deck1.deckSize();
        int actual = deck.deckSize();

        assertEquals(expected, actual);
    }

    @Test
    void size() {
        Deck deck = new Deck();
        Deck deck1 = new Deck();
        deck1.emptyDeck();
        deck1.addCards(deck.deal(26));

        int expected = deck1.deckSize();
        int actual = deck.deckSize();

        assertEquals(expected, actual);
    }
}