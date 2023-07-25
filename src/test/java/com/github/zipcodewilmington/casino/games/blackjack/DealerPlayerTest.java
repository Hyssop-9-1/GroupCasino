package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.gametools.Card;
import com.github.zipcodewilmington.utils.Rank;
import com.github.zipcodewilmington.utils.Suits;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DealerPlayerTest {

    @Test
    void testAceValueChecker(){
        CasinoAccount account = new CasinoAccount("Manny", "Benji");
        DealerPlayer dealer = new DealerPlayer(account);
        dealer.dealerHand.addCards(new Card(Suits.DIAMONDS, Rank.ACE));
        int expected = 11;

        int actual = dealer.handTotal();

        assertEquals(expected, actual);
    }

    @Test
    void testHandTotal(){
        CasinoAccount account = new CasinoAccount("Manny", "Benji");
        DealerPlayer dealer = new DealerPlayer(account);
        dealer.dealerHand.emptyDeck();
        dealer.dealerHand.addCards(new Card(Suits.DIAMONDS, Rank.JACK));

        int expected = 10;

        int actual = dealer.handTotal();

        assertEquals(expected, actual);
    }

    @Test
    void testFullReveal(){
        CasinoAccount account = new CasinoAccount("Manny", "Benji");
        DealerPlayer dealerPlayer = new DealerPlayer(account);
        dealerPlayer.dealerHand.emptyDeck();
        dealerPlayer.dealerHand.addCards(new Card(Suits.DIAMONDS, Rank.EIGHT));

        String expected = "The dealer had EIGHT of DIAMONDS\n";
        String actual = dealerPlayer.fullReveal();

        assertEquals(expected, actual);
    }

    @Test
    void testViewOneCardFromDealer(){
        CasinoAccount account = new CasinoAccount("Manny", "Benji");
        DealerPlayer dealerPlayer = new DealerPlayer(account);
        dealerPlayer.dealerHand.emptyDeck();
        dealerPlayer.dealerHand.addCards(new Card(Suits.DIAMONDS, Rank.JACK));

        String expected = "The dealer is currently showing one card which is the JACK of DIAMONDS. The dealer's current hand value is 10";
        String actual = dealerPlayer.viewOneCardFromDealer();

        assertEquals(expected, actual);
    }
}
