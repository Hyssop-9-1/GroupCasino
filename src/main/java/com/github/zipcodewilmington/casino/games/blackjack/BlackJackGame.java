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
    public ArrayList<Card> dealerHit() {
        return dealerPlayer.addPlayerHand(blackJackDeck.deal(1));
    }

    @Override
    public void run() {

        boolean continueGame = true;

        while (continueGame)
        {
            double bet = console.getDoubleInput(blackJackPlayer.getAccountName() + " how much would you like to bet? ");
            blackJackPlayer.setCurrentBet(bet);

            setup(); viewTable(); viewPlayerTurn();



            String userTurn = console.getStringInput("Would you like to hit or stand? Press [h] to hit / [s] to stand ");
            checkPlayerWinCondition(userTurn);
            dealerPlay();

            int playerTotal = getPlayerHandValue();
            int dealerTotal = getDealerHandValue();

            if (decideWinner(playerTotal, dealerTotal)){
                console.println((blackJackPlayer.getCurrentBet() * 10) + " has been added to your account. ");
                blackJackPlayer.collectWinnings(blackJackPlayer.getCurrentBet() * 5);
            } else {
                blackJackPlayer.payToPlay(blackJackPlayer.getCurrentBet()); // Deduct the bet from the player's account
            }
//
//            if (blackJackPlayer.handTotal() > dealerPlayer.handTotal() && blackJackPlayer.handTotal() <= 21)
//            {
//                console.println("\nCongratulations " + blackJackPlayer.getAccountName() + ", you won, " +
//                        (blackJackPlayer.getCurrentBet() * 10) + " has been added to your account. ");
//                blackJackPlayer.collectWinnings((blackJackPlayer.getCurrentBet() * 10));
//                console.println("\n");
//            }
//            else if (dealerPlayer.handTotal() > blackJackPlayer.handTotal() && dealerPlayer.handTotal() <= 21)
//            {
//                console.println("\nYou are a sore loser KEKW " + blackJackPlayer.getCurrentBet() +
//                        " has been deducted from your account. ");
//                //take out the money here
//                blackJackPlayer.payToPlay(blackJackPlayer.getCurrentBet());
//                console.println("\n");
//            } else
//            {
//                System.out.println("got here at the end ");
//            }

            String userChoice = console.getStringInput("Hi " + blackJackPlayer.getAccountName() + " would you like to play again? [y] for yes / [n] for no ");
            continueGame = continuePlaying(userChoice);
        }
    }

    public boolean decideWinner(int playerTotal, int dealerTotal)
    {
        if (playerTotal > 21)
        {
            console.println("\nYou busted. Better luck next time!\n");
        }
        else if (playerTotal == 21)
        {
            console.println("\nCongratulations " + blackJackPlayer.getAccountName() + ", you got Blackjack!\n");
            return true;
        }
        else if (dealerTotal > 21)
        {
            console.println("\nThe dealer had a total of " + dealerTotal);
            console.println("The dealer busted. You win!\n");
            return true;
        }
        else if (playerTotal > dealerTotal)
        {
            console.println("\nCongratulations " + blackJackPlayer.getAccountName() + ", you won!\n");
            return true;
        }
        else if (dealerTotal > playerTotal)
        {
            console.println("\nThe dealer has a total of " + dealerTotal);
            console.println("You lost. Better luck next time!\n");
        }
        else
        {
            console.println("\nIt's a tie!\n");
        }
        return false;
    }


    public boolean checkPlayerWinCondition(String input)
    {
        //checks the string input from the user
        while (!input.equalsIgnoreCase("s"))
        {
            if (input.equalsIgnoreCase("h"))
            {
                //better way to display the values of player and dealer
                playerHit();
                //viewTable();
                viewPlayerTurn();
                if (getPlayerHandValue() >= 21)
                {
                    return false;
                }
            } else
            {
                console.getStringInput("Invalid input. Please enter [h] to hit / [s] to stand dummy \n");
            }
            //outside the loop keep asking the player for input
            // viewPlayerTurn();
            input = console.getStringInput("Would you like to hit or stand? Press [h] to hit / [s] to stand \n");
        }
        console.println("You stand: \n");
        return false;
    }

    public void dealerPlay() {
        while (dealerPlayer.handTotal() < 17 && dealerPlayer.handTotal() <= 21) {
            dealerHit();
        }
        //console.println("The Dealer has a total of " + getDealerHandValue());
        //viewDealerTable();
        //return dealerPlayer.handTotal();
    }



    public boolean continuePlaying(String userInput){
        if (userInput.equalsIgnoreCase("y")){
            return true;
        }
        return false;
    }

    public void viewPlayerTurn(){
        console.println("Your current hand value is: " + getPlayerHandValue());
        console.println(dealerPlayer.viewOneCardFromDealer());
    }

    public void viewTable(){
        console.println(blackJackPlayer.viewCard());
    }

    public void viewDealerTable(){
        console.println((dealerPlayer.fullReveal()));
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

        resetHands();

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
