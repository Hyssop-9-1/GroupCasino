package com.github.zipcodewilmington.casino.games.war;


import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.gametools.Card;
import com.github.zipcodewilmington.casino.gametools.Deck;

import java.util.ArrayList;
import java.util.List;


public class WarGame implements GameInterface {

    Deck warDeck = new Deck();
    int gamePoints = 0;

//    private List<WarPlayer> players = new ArrayList<>();
//    public WarGame(List<WarPlayer> players) { this.players.addAll(players);}
    private WarPlayer player;
    private WarPlayer dealer = new WarPlayer(null);

    public WarGame() {

    }

    public void compareCards(Card playerCard, Card dealerCard){

    }

    @Override
    public void run() {
        setup();
        while (player.playerHand.deckSize() > 0){
            player.getTopCard();
            dealer.getTopCard();
            gamePoints += 2;




        }checkWinCond();

    }
    @Override
    public void setup() { //shuffle and deal
        warDeck.shuffle();
        //deal cards...
        player.addPlayerHand(warDeck.deal(26));
        dealer.addPlayerHand(warDeck.deal(26));
    }



    @Override
    public void addPlayer(PlayerInterface player) {
        this.player = (WarPlayer) player;

    }

    @Override
    public void removePlayer() {

    }

    @Override
    public void checkWinCond() {
        if (player.getPlayerPoints() > dealer.getPlayerPoints()){
            System.out.println(player.getAccountName()+ "wins!");
        } else {
            System.out.println("Dealer wins.");
        }
    }
}
