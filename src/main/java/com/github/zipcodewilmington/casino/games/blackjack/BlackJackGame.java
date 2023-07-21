package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.gametools.Card;
import com.github.zipcodewilmington.casino.gametools.Deck;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.ArrayList;

public class BlackJackGame implements GameInterface {

    private final IOConsole console = new IOConsole(AnsiColor.BLUE);

    Deck blackJackDeck;
    //private BlackJackPlayer blackJackPlayer;
    private boolean continueGame = false;
    private boolean playerTurn = true;
    public BlackJackGame(){

    }

//    public BlackJackGame(BlackJackPlayer player){
//        this.blackJackPlayer = player;
//    }


    CasinoAccount playerAccount = new CasinoAccount("manny", "benji", 1000.00);
    BlackJackPlayer blackJackPlayer = new BlackJackPlayer(playerAccount);
    CasinoAccount dealerAccount = new CasinoAccount("dealer", "benji", 1000.00);
    DealerPlayer dealerPlayer = new DealerPlayer(dealerAccount);

    public static void main(String[] args) {
        new BlackJackGame().run();
    }

    public ArrayList<Card> playerHit(){
        return blackJackPlayer.addPlayerHand(blackJackDeck.deal(1));
    }

    public boolean userTurn(String userTurn){

        if (userTurn.equalsIgnoreCase("h")){
            return continueGame = true;
        }
        if (userTurn.equalsIgnoreCase("s")){
            return continueGame = false;
        }
        return false;
    }
    @Override
    public void run() {

        //boolean playerTurn = true;
        boolean continueGame = true;
        //boolean playerTurn = true;

//        do {
//            setup();
//            while (playerTurn) {
//                String userTurn = console.getStringInput("Would you like to hit or stand? Press [h] to hit / [s] to stand ");
//                playerTurn = userTurn(userTurn);
//            }
//
//
//
//
//            //End game flow or continue playing
//            String userChoice = console.getStringInput("Hi " + blackJackPlayer.getAccountName() + " would you like to play again? [y] for yes / [n] for no ");
//            continueGame = continuePlaying(userChoice);
//        } while (continueGame);

        while (continueGame){
            setup();
            while (this.playerTurn != false){

                String userTurn = console.getStringInput("Would you like to hit or stand? Press [h] to hit / [s] to stand ");
                playerTurn = userTurn(userTurn);
            }
            String userChoice = console.getStringInput("Hi " + blackJackPlayer.getAccountName() + " would you like to play again? [y] for yes / [n] for no ");
            continueGame = continuePlaying(userChoice);
        }

//        viewTable();
//        viewDealerTable();
        //console.print("Your hand total is " + getPlayerHandValue());

//        playerHit();
//        viewTable();

        //console.print("Your hand total is " + getPlayerHandValue());

        //console.println("\nThe dealer hand total is " + getDealerHandValue());
        //console.println(String.valueOf(blackJackPlayer.handTotal()));
//        CasinoAccount playeraccount = new CasinoAccount("Manny", "benji", 1000.00);
//        CasinoAccount dealeraccount = new CasinoAccount("dealer", "benji", 1000.00);
//        BlackJackPlayer player = new BlackJackPlayer(playeraccount);
//        DealerPlayer dealer = new DealerPlayer(dealeraccount);


//        String userChoice = console.getStringInput("Would you like to hit or stay ? ");
//        if (userChoice.equalsIgnoreCase("hit")){
//            playerHit();
//            console.println(String.valueOf(blackJackPlayer.handTotal()));
//
//            blackJackPlayer.handTotal();
//        }
//        console.println(String.valueOf(player.addPlayerHand(blackJackDeck.deal(2))));
//        System.out.println(dealer.addPlayerHand(blackJackDeck.deal(2)));
//        System.out.println(player.handTotal());
//        console.println(String.valueOf(player.addPlayerHand(blackJackDeck.deal(1))));
//        System.out.println(player.handTotal());
//
//        console.println(String.valueOf(dealer.addPlayerHand(blackJackDeck.deal(2))));
//        System.out.println(dealer.handTotal());
    }



    public boolean continuePlaying(String userInput){
        if (userInput.equalsIgnoreCase("y")){
            return continueGame = true;
        }
        if (userInput.equalsIgnoreCase("n")){
            return continueGame = false;
        }
        return false;
    }

    public void viewTable(){
        console.println(blackJackPlayer.viewCard());
    }

    public void viewDealerTable(){
        console.println((dealerPlayer.viewCard1()));
    }


    public Integer getPlayerHandValue(){
        return blackJackPlayer.handTotal();
    }

    public Integer getDealerHandValue(){
        return dealerPlayer.handTotal();
    }

    @Override
    public void setup() {
        blackJackDeck = new Deck();
        blackJackDeck.shuffle();

        blackJackPlayer.addPlayerHand(blackJackDeck.deal(2));
        dealerPlayer.addPlayerHand(blackJackDeck.deal(2));
    }

    @Override
    public void addPlayer(PlayerInterface player) {
       this.blackJackPlayer = (BlackJackPlayer) player;
    }

    @Override
    public void removePlayer() {

    }

    @Override
    public void checkWinCond() {
    }
}
