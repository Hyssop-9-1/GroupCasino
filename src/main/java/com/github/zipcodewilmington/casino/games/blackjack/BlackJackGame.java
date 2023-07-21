package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
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
    public void playerHit(){
        blackJackPlayer.addPlayerHand(blackJackDeck.deal(1));
        console.println(String.valueOf(blackJackPlayer.handTotal()));

    }
    @Override
    public void run() {

        setup();
        Deck blackJackDeck = new Deck();
        blackJackDeck.shuffle();
        viewTable();
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
    @Override
    public void setup() {
        blackJackDeck = new Deck();
        blackJackDeck.shuffle();

        console.println(String.valueOf(blackJackPlayer.addPlayerHand(blackJackDeck.deal(2))));
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
