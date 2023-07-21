package com.github.zipcodewilmington.casino.games.war;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GamblingPlayer;
import com.github.zipcodewilmington.casino.gametools.Card;
import com.github.zipcodewilmington.casino.gametools.Deck;

import java.util.ArrayList;

public class WarPlayer extends GamblingPlayer {

    Deck playerHand= new Deck();
    Integer playerPoints=0;
    Card currentCard;

    public WarPlayer(CasinoAccount acct) {
        super(acct);
        playerHand.emptyDeck();

    }

    public Card getTopCard(){

        return currentCard = playerHand.removeTopCard();
    }

    public Card getCurrentCard(){

        return currentCard;}

    public void addPlayerHand(ArrayList<Card> cards){
        playerHand.addCards(cards);
    }
    public Integer getPlayerPoints(){
        return playerPoints;
    }
    public void addPoints(int points){
        playerPoints += points;
    }
}
