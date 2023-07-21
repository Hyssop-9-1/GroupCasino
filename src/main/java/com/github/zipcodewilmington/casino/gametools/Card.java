package com.github.zipcodewilmington.casino.gametools;

import com.github.zipcodewilmington.utils.Rank;
import com.github.zipcodewilmington.utils.Suits;

public class Card {
    Suits suit;
    Rank rank;

    public Card(Suits suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }

    public Suits getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public int getValue(){
        return rank.ordinal()+2; ///MAYBE??!
    }

//    public int getBlackJackValue(){
//
//    }

    //add toString
}

