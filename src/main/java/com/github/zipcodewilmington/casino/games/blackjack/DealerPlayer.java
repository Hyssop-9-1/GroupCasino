package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GamblingPlayer;
import com.github.zipcodewilmington.casino.gametools.Card;
import com.github.zipcodewilmington.casino.gametools.Deck;

import java.util.ArrayList;

public class DealerPlayer extends GamblingPlayer {
    Deck dealerHand = new Deck();

    public DealerPlayer(CasinoAccount acct) {
        super(acct);
        this.dealerHand.emptyDeck();
    }


    public ArrayList<Card> addPlayerHand(ArrayList<Card> cards){
        dealerHand.addCards(cards);
        return cards;
    }

    public String viewOneCardFromDealer(){
        return ("The dealer is currently showing one card which is the " + dealerHand.getCards().get(0).toString() + ". The dealer's current hand value is " + dealerHand.getCards().get(0).rank.getBlackJackValue());

    }

    public String fullReveal(){
        StringBuilder sb = new StringBuilder();
        for (Card c: dealerHand.getCards()){
            sb.append("The dealer had " + c.toString() + "\n");
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
        int numOfAces = 0;
        for (Card c: dealerHand.getCards()){
            if (c.rank.getAbbreviation().equals("A"))
            {
                numOfAces++;
            }
            //adds one to the hand total no matter what
            total += c.rank.getBlackJackValue();
        }
        //if hand total with ace is less than 21 add 10 since we already added one in the loop earlier
        if (numOfAces > 0)
        {
            if ((total + 11) <= 21 )
            {
                total += 10;
            }
        }
        return total;
    }
}
