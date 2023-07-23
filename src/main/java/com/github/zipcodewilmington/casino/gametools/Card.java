package com.github.zipcodewilmington.casino.gametools;

import com.github.zipcodewilmington.utils.Rank;
import com.github.zipcodewilmington.utils.Suits;

public class Card {
    Suits suit;
    public Rank rank;



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



    //add toString
    @Override
    public String toString() {
        return  rank + " of " + suit;
    }
    public String cardDisplay(){
        StringBuilder sb = new StringBuilder();
        switch(suit.ordinal()){
            case 0: sb.append(String.format(".------.\n|%-2s_   |\n| ( )  |\n|(_x_) |\n|  Y %-2s|\n`------'\n", rank.getAbbreviation(), rank.getAbbreviation()));
                    break;
            case 1: sb.append(String.format(".------.\n|%-2s  _ |\n|( \\/ )|\n| \\  / |\n|  \\/%-2s|\n`------'\n", rank.getAbbreviation(),rank.getAbbreviation()));
                    break;
            case 2: sb.append(String.format(".-------.\n|%-2s /\\  |\n|  /  \\ |\n|  \\  / |\n|   \\/%-2s|\n`-------' \n", rank.getAbbreviation(), rank.getAbbreviation()));
                    break;
            case 3: sb.append(String.format(".------.\n|%-2s,   |\n| / \\  |\n|(_,_) |\n|  I %-2s|\n`------'\n", rank.getAbbreviation(), rank.getAbbreviation()));
                    break;
        }
      return sb.toString();
    }

//     .--`----.  .-------.  .------.  .------.
//     |A_  _ |  | A /\  |  |A _   |  |A .   |
//     |( \/ )|  |  /  \ |  | ( )  |  | / \  |
//     | \  / |  |  \  / |  |(_x_) |  |(_,_) |
//     |  \/ A|  |   \/ A|  |  Y  A|  |  I  A|
//     `------'  `-------'  `------'  `------'


}

