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
    public ArrayList<Card> playerHit() {
        return blackJackPlayer.addPlayerHand(blackJackDeck.deal(1));
    }
    public boolean userTurn(String userTurn){

        while (true)
        if (userTurn.equalsIgnoreCase("h")){
            return true;
        } else if (userTurn.equalsIgnoreCase("s")){
            return false;
        } else {
            userTurn = console.getStringInput("Invalid input. Please enter [h] to hit / [s] to stand dummy ");
        }
    }
    @Override
    public void run() {

        boolean continueGame = true;

        while (continueGame){
            boolean playerTurn = true;

            setup(); viewTable(); viewPlayerTurn();

            while (playerTurn)
            {
                String userTurn = console.getStringInput("Would you like to hit or stand? Press [h] to hit / [s] to stand ");
                playerHit();

                if (getPlayerHandValue() < 21 && userTurn(userTurn) == true)
                {
                        viewTable();
                        viewPlayerTurn();

                } else
                {
                    console.println("You busted boy ");
                    break;
                }
            }

            String userChoice = console.getStringInput("Hi " + blackJackPlayer.getAccountName() + " would you like to play again? [y] for yes / [n] for no ");
            continueGame = continuePlaying(userChoice);
            resetHands();
        }
    }



    public boolean continuePlaying(String userInput){
        if (userInput.equalsIgnoreCase("y")){
            return true;
        }
        if (userInput.equalsIgnoreCase("n")){
            return false;
        }
        return false;
    }

    public void viewPlayerTurn(){
        console.println("Your current hand value is: " + getPlayerHandValue());
        console.println("The Dealer is showing one card and the current value is: " + getDealerHandValue());
    }
    public void viewTable(){
        console.println(blackJackPlayer.viewCard());
    }

    public void viewDealerTable(){
        console.println((dealerPlayer.viewCard()));
    }


    public Integer getPlayerHandValue(){
        return blackJackPlayer.handTotal();
    }

    public Integer getDealerHandValue(){
        return dealerPlayer.handTotal();
    }

    public void resetHands(){
        blackJackPlayer.playerHand.emptyDeck();
        dealerPlayer.dealerHand.emptyDeck();
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
