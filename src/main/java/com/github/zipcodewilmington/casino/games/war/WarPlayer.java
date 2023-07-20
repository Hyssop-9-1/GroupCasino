package com.github.zipcodewilmington.casino.games.war;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GamblingPlayer;
import com.github.zipcodewilmington.casino.gametools.Card;
import com.github.zipcodewilmington.casino.gametools.Deck;

public class WarPlayer extends GamblingPlayer {

    Deck playerHand;
    Integer playerPoints;
    Card currentCard;

    public WarPlayer(CasinoAccount acct) {
        super(acct);
    }

    public Card getTopCard(){
        return null;
    }
}
