package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GamblingPlayer;
import com.github.zipcodewilmington.casino.gametools.Card;
import com.github.zipcodewilmington.casino.gametools.Deck;

import java.util.ArrayList;

public class BlackJackPlayer extends GamblingPlayer {

    Deck playerHand = new Deck();

    Card currentCard;
<<<<<<< HEAD
=======
    ArrayList<Card> playerHandValue = new ArrayList<>();
>>>>>>> bfc8276 (blackjack so far)

    public BlackJackPlayer(CasinoAccount acct) {
        super(acct);
        this.playerHand.emptyDeck();
    }

    public ArrayList<Card> addPlayerHand(ArrayList<Card> cards){
<<<<<<< HEAD
         playerHand.addCards(cards);
        return cards;
    }
    public String viewCard(){
        StringBuilder sb = new StringBuilder();
        for (Card c: playerHand.getCards()){
            sb.append("You have the " + c.toString() + "\n");
        }

        return String.valueOf(sb);
    }

    public Integer handTotal(){
        int total = 0;
        for (Card c: playerHand.getCards()){
            total += c.rank.getBlackJackValue();
//            if (c.getValue() > 10) {
//                total += 10;
//            } else {
//                total += c.getValue();
//            }
        }

        return total;
    }
=======
         playerHand.addCards(cards) = cards;
        return cards;
    }

    public Card getTopCard(){

        return currentCard = playerHand.removeTopCard();
    }

//    public Card getCurrentCard(){
//
//        for(Deck c: playerHand){
//
//        }
//        return; }
>>>>>>> bfc8276 (blackjack so far)
}
