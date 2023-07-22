package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GamblingPlayer;
import com.github.zipcodewilmington.casino.gametools.Card;
import com.github.zipcodewilmington.casino.gametools.Deck;

import java.util.ArrayList;

public class BlackJackPlayer extends GamblingPlayer {

    Deck playerHand = new Deck();

    public BlackJackPlayer(CasinoAccount acct) {
        super(acct);
        this.playerHand.emptyDeck();
    }

    public ArrayList<Card> addPlayerHand(ArrayList<Card> cards){
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
        int tempTotal = total;
        for (Card c: playerHand.getCards()){
            if (c.rank.getAbbreviation().equals("A"))
            {
                if ((tempTotal + 11) <= 21 ){
                    total += 11;
                    break;
                } else
                {
                    total += c.rank.getBlackJackValue();
                    break;
                }
            }
            total += c.rank.getBlackJackValue();
        }
        return total;
    }
}
