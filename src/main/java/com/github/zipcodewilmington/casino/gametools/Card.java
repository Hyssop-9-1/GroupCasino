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



    //add toString
    @Override
    public String toString() {
        return  rank + " of " + suit;
    }
//    public String cardDisplay(){
//      // return cardDisplay[suit.ordinal()][rank.ordinal()];
//    }



//     .--`----.  .-------.  .------.  .------.
//     |A_  _ |  | A /\  |  |A _   |  |A .   |
//     |( \/ )|  |  /  \ |  | ( )  |  | / \  |
//     | \  / |  |  \  / |  |(_x_) |  |(_,_) |
//     |  \/ A|  |   \/ A|  |  Y  A|  |  I  A|
//     `------'  `-------'  `------'  `------'

//    public static void main(String[] args) {
//        Card card = new Card(Suits.HEARTS,Rank.QUEEN );
//        //System.out.println(String.format(".------.\n|%-2s_   |\n| ( )  |\n|(_x_) |\n|  Y %-2s|\n`------'\n", "1", "1")); //clubs
//        //System.out.println(String.format(".------.\n|%-2s  _ |\n|( \\/ )|\n| \\  / |\n|  \\/%-2s|\n`------'\n", "10","10"));//hearts
//        //System.out.println(String.format(".-------.\n|%-2s /\\  |\n|  /  \\ |\n|  \\  / |\n|   \\/%-2s|\n`-------' \n", "10", "10"));
//        System.out.println(String.format(".------.\n|%-2s,   |\n| / \\  |\n|(_,_) |\n|  I %-2s|\n`------'", "1", "1"));
//        //System.out.println(card.rank.getAbbreviation());
//    }
}

