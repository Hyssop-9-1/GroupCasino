package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GamblingPlayer;
import com.github.zipcodewilmington.casino.gametools.Card;
import com.github.zipcodewilmington.casino.gametools.Deck;

import java.util.ArrayList;

public class DealerPlayer extends GamblingPlayer {
    Deck dealerHand = new Deck();
    Card currentCard;
    public DealerPlayer(CasinoAccount acct) {
        super(acct);
        this.dealerHand.emptyDeck();
    }


    public ArrayList<Card> addPlayerHand(ArrayList<Card> cards){
        dealerHand.addCards(cards);
        return cards;
    }

    public Card getTopCard(){

        return currentCard = dealerHand.removeTopCard();
    }

    public Integer handTotal(){
        int total = 0;
        for (Card c: dealerHand.getCards()){
            if (c.getValue() > 10) {
                total += 10;
            } else {
                total += c.getValue();
            }
        }
        return total;
    }


}
