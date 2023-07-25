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

    public boolean decideWinner(int playerTotal, int dealerTotal) {
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
            console.println("Your hand value was: " + getPlayerHandValue() + "\n");
            console.println(dealerPlayer.fullReveal());
            console.println("\nThe dealer had a total of " + dealerTotal);
            console.println("The dealer busted. You win!\n");
            return true;
        }
        else if (playerTotal > dealerTotal)
        {
            console.println("Your hand value was: " + getPlayerHandValue() + "\n");
            console.println(dealerPlayer.fullReveal());
            console.println("\nThe dealer's hand value was: " + dealerTotal);
            console.println("\nCongratulations " + blackJackPlayer.getAccountName() + ", you won!\n");
            return true;
        }
        else if (dealerTotal > playerTotal)
        {
            console.println("Your hand value was: " + getPlayerHandValue() + "\n");
            console.println(dealerPlayer.fullReveal());
            console.println("\nThe dealer has a total of " + dealerTotal);
            console.println("You lost. Better luck next time!\n");
        }
        else
        {
            console.println("Your hand value was: " + getPlayerHandValue() + "\n");
            console.println(dealerPlayer.fullReveal());
            console.println("The dealer's hand value was: " + dealerTotal);
            console.println("\nIt's a tie!\n");
        }
        return false;
    }

    public boolean playerGameplayLoop(String input) {
        //checks the string input from the user
        while (!input.equalsIgnoreCase("s"))
        {
            if (input.equalsIgnoreCase("h"))
            {
                //better way to display the values of player and dealer
                playerHit();
                viewTable();
                viewPlayerTurn();
                if (getPlayerHandValue() >= 21)
                {
                    //busts exit out of loop
                    return false;
                }
            }
            else
            {
                console.println("\nInvalid input.");
            }
            //outside the loop keep asking the player for input
            // viewPlayerTurn();
            input = console.getStringInput("\nWould you like to hit or stand? Press [h] to hit / [s] to stand \n");
        }
        viewTable();
        console.println("You stand: \n");
        return false;
    }

    //dealers turn to try and beat the player used 17 as a hard cap because it was doing some weird stuff errors like index out of bounds and adding all the cards in the deck to dealer hand
    public void dealerPlay() {
        while (dealerPlayer.handTotal() < 17 && dealerPlayer.handTotal() <= 21) {
            dealerHit();
        }
    }

    public boolean continuePlaying(String userInput) {
        while (!userInput.equalsIgnoreCase("y"))
        {
            if (userInput.equalsIgnoreCase("n")){
                return false;
            }
            userInput = console.getStringInput("\nInvalid input: please type [y] to keep playing / [n] to stop playing");
        }
        return true;
    }

    //player turn shows the player their hand total and the dealer hand total showing one card
    public void viewPlayerTurn(){
        console.println("Your current hand value is: " + getPlayerHandValue());
        console.println(dealerPlayer.viewOneCardFromDealer());
    }

    //tells the player all the cards they have in the form of "Rank of Suit"
    public void viewTable(){
        console.println(blackJackPlayer.viewCard());
    }

    //calls method in DealerPlayer class to show all the cards the dealer has
    public void viewDealerTable(){
        console.println((dealerPlayer.fullReveal()));
    }

    public Integer getPlayerHandValue(){
        return blackJackPlayer.handTotal();
    }

    public Integer getDealerHandValue(){
        return dealerPlayer.handTotal();
    }

    //empty both the dealer and players hands putting total hand values back at zero
    public void resetHands(){
        blackJackPlayer.playerHand.emptyDeck();
        dealerPlayer.dealerHand.emptyDeck();
    }

    @Override
    public void run() {

        boolean continueGame = true;

        while (continueGame)
        {
            double bet = console.getDoubleInput(blackJackPlayer.getAccountName() + " how much would you like to bet? ");
            blackJackPlayer.setCurrentBet(bet);

            setup(); viewTable(); viewPlayerTurn();

            //console.println(dealerPlayer.fullReveal());

            String userTurn = console.getStringInput("\nWould you like to hit or stand? Press [h] to hit / [s] to stand ");
            playerGameplayLoop(userTurn);
            dealerPlay();

            //overcooked this part of the game, next time try to break it into smaller pieces, trying to do too much at the same time checking for different scenarios at the same time
            //as well as trying to compare values at the same time when the dealer hasnt had a turn yet, also you tried to simplify too hard to the dealer winning or the player winning but you didnt account
            //that there are different ways for the dealer and player to win
            //take in value from POINT A then take in value from POINT B then pass those down in a method where you are free to overcook it,
            //lastly you overcooked so hard that the methods like playerGamePlayLoop dealerPlay and decideWinner all had overlapping functionality that made it hard to debug where you were in the code
            //try and write single RESPONSIBILITY methods
            if (decideWinner(getPlayerHandValue(), getDealerHandValue())){
                console.println((blackJackPlayer.getCurrentBet() * 5) + " has been added to your account. ");
                blackJackPlayer.collectWinnings(blackJackPlayer.getCurrentBet() * 5);
            } else {
                blackJackPlayer.payToPlay(blackJackPlayer.getCurrentBet()); // Deduct the bet from the player's account
            }

            String userChoice = console.getStringInput("Hi " + blackJackPlayer.getAccountName() + " would you like to play again? [y] for yes / [n] for no ");
            continueGame = continuePlaying(userChoice);
        }
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
