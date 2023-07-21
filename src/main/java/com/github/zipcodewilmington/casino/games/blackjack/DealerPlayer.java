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

    public String viewCard(){
        StringBuilder sb = new StringBuilder();
//        for (Card c: dealerHand.getCards()){
//            sb.append(" have the " + c.toString() + "\n");
//        }
        return ("The dealer currently is showing one card with a value of: " + dealerHand.getCards().get(0));
                //String.valueOf(sb);
    }

    //method to make sure the dealer values line up with the correct total
    public String viewCard1(){
        StringBuilder sb = new StringBuilder();
        for (Card c: dealerHand.getCards()){
            sb.append("The dealer has " + c.toString() + "\n");
        }

        return String.valueOf(sb);
    }

    //method to make sure the dealer values line up with the correct total
//    public String viewCard1(){
//        StringBuilder sb = new StringBuilder();
//        for (Card c: dealerHand.getCards()){
//            sb.append("The dealer has " + c.toString() + "\n");
//        }
//
//        return String.valueOf(sb);
//    }

    public Integer handTotal(){
        int total = 0;
        for (Card c: dealerHand.getCards()){
            total += c.rank.getBlackJackValue();
//            if (c.getValue() > 10) {
//                total += 10;
//            } else {
//                total += c.getValue();
//            }
        }
        return total;
    }


}
