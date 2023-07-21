package com.github.zipcodewilmington.casino.gametools;

import com.github.zipcodewilmington.utils.Rank;
import com.github.zipcodewilmington.utils.Suits;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    ArrayList<Card> cards = new ArrayList<>();

    public Deck(){
        for(Suits s: Suits.values()){
            for(Rank r: Rank.values()){
                cards.add(new Card(s, r));
            }
        }
    }
    public void shuffle(){
        Collections.shuffle(cards);
    }
    public void addCards(Card card){
        cards.add(card);
    }
    public void addCards(ArrayList<Card> cards){
        this.cards.addAll(cards);
    }
    public Card removeTopCard(){
        return cards.remove(0);
    }
    public void emptyDeck(){
        cards.removeAll(cards);
    }
    public ArrayList<Card> deal(int numToDeal){
        ArrayList<Card> dealtCards = new ArrayList<>();
        for(int i = 0; i < numToDeal; i++){
            dealtCards.add(cards.remove(0));
        }
        return dealtCards;
    }
    public int deckSize(){
        return cards.size();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
