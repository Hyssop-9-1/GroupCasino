package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.roll.RollPlayer;
import com.github.zipcodewilmington.casino.games.war.WarPlayer;
import com.github.zipcodewilmington.casino.gametools.Deck;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.ArrayList;

public class BlackJackGame implements GameInterface {

    private final IOConsole console = new IOConsole(AnsiColor.BLUE);

    Deck blackJackDeck;


    ArrayList<BlackJackPlayer> userPlayer = new ArrayList<>();

    CasinoAccount dealeraccount = new CasinoAccount("dealer", "benji", 1000.00);
    DealerPlayer dealerPlayer = new DealerPlayer(dealeraccount);

    public static void main(String[] args) {

        new BlackJackGame().run();

    }
    public void playerHit(){
        userPlayer.addPlayerHand(blackJackDeck.deal(1));
        console.println(String.valueOf(userPlayer.handTotal()));

    }
    @Override
    public void run() {

        Deck blackJackDeck = new Deck();
        blackJackDeck.shuffle();
        CasinoAccount playeraccount = new CasinoAccount("Manny", "benji", 1000.00);
        CasinoAccount dealeraccount = new CasinoAccount("dealer", "benji", 1000.00);
        BlackJackPlayer player = new BlackJackPlayer(playeraccount);
        DealerPlayer dealer = new DealerPlayer(dealeraccount);


        String userChoice = console.getStringInput("Would you like to hit or stay ? ");

        if (userChoice.equalsIgnoreCase("hit")){
            playerHit();
            player.handTotal();
        }
//        console.println(String.valueOf(player.addPlayerHand(blackJackDeck.deal(2))));
//        System.out.println(dealer.addPlayerHand(blackJackDeck.deal(2)));
//        System.out.println(player.handTotal());
//        console.println(String.valueOf(player.addPlayerHand(blackJackDeck.deal(1))));
//        System.out.println(player.handTotal());
//
//        console.println(String.valueOf(dealer.addPlayerHand(blackJackDeck.deal(2))));
//        System.out.println(dealer.handTotal());
    }

    @Override
    public void setup() {

    }

    @Override
    public void addPlayer(PlayerInterface player) {
        userPlayer.add((BlackJackPlayer) player);

    }

    @Override
    public void removePlayer() {

    }

    @Override
    public void checkWinCond() {

    }
}
