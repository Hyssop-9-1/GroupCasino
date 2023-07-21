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


    private BlackJackPlayer userPlayer;
    private DealerPlayer dealerPlayer;

    public static void main(String[] args) {

        new BlackJackGame().run();
    }
    @Override
    public void run() {

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
    }

    @Override
    public void setup() {

    }

    @Override
    public void addPlayer(PlayerInterface player) {

    }

    @Override
    public void removePlayer() {

    }

    @Override
    public void checkWinCond() {

    }
}
