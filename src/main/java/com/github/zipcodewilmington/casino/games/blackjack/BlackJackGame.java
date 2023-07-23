package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.gametools.Deck;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;


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
<<<<<<< HEAD


    }
    public void playerHit(){
        blackJackPlayer.addPlayerHand(blackJackDeck.deal(1));
        console.println(String.valueOf(blackJackPlayer.handTotal()));

=======
>>>>>>> bfc8276 (blackjack so far)
    }
    @Override
    public void run() {

<<<<<<< HEAD
        setup();
        viewTable();
        viewDealerTable();

        console.print("Your hand total is " + getPlayerHandValue());
        console.println("Your hand total is " + getDealerHandValue());
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
=======
        Deck blackJackDeck = new Deck();
        blackJackDeck.shuffle();
        CasinoAccount playeraccount = new CasinoAccount("Manny", "benji", 1000.00);
        CasinoAccount dealeraccount = new CasinoAccount("dealer", "benji", 1000.00);
        BlackJackPlayer player = new BlackJackPlayer(playeraccount);
        DealerPlayer dealer = new DealerPlayer(dealeraccount);

        Deck playerHand = player.playerHand;
        System.out.println(player.addPlayerHand(blackJackDeck.deal(2)));
        System.out.println(dealer.addPlayerHand(blackJackDeck.deal(2)));
        System.out.println(player.playerHandValue);
        //System.out.println(player.getCurrentCard().getBlackJackValue());
        //console.println(player.addPlayerHand(blackJackDeck.deal(2)));
>>>>>>> bfc8276 (blackjack so far)
    }

    @Override
    public void setup() {
<<<<<<< HEAD
        blackJackDeck = new Deck();
        blackJackDeck.shuffle();

        blackJackPlayer.addPlayerHand(blackJackDeck.deal(2));
        dealerPlayer.addPlayerHand(blackJackDeck.deal(2));
=======

>>>>>>> bfc8276 (blackjack so far)
    }

    @Override
    public void addPlayer(PlayerInterface player) {
<<<<<<< HEAD
       this.blackJackPlayer = (BlackJackPlayer) player;
=======

>>>>>>> bfc8276 (blackjack so far)
    }

    @Override
    public void removePlayer() {

    }

    @Override
    public void checkWinCond() {

    }
}
