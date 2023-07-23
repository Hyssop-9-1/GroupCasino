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
        int numOfAces = 0;
        for (Card c: playerHand.getCards()){
            if (c.rank.getAbbreviation().equals("A"))
            {
                numOfAces++;
            }
            total += c.rank.getBlackJackValue();
        }
        if (numOfAces > 0)
        {
            if ((total + 11) <= 21 )
            {
                total += 11;
            }
            else
            {
                total += 1;
            }
        }
        return total;
    }
}
