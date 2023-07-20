package com.github.zipcodewilmington.casino.games.war;


import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.gametools.Card;
import com.github.zipcodewilmington.casino.gametools.Deck;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;


public class WarGame implements GameInterface {
    private final IOConsole console = new IOConsole(AnsiColor.CYAN);
    Deck warDeck = new Deck();
    int gamePoints = 0;

//    private List<WarPlayer> players = new ArrayList<>();
//    public WarGame(List<WarPlayer> players) { this.players.addAll(players);}
    private WarPlayer player;
    private WarPlayer dealer = new WarPlayer(new CasinoAccount("Dealer",null));

    public WarGame() {

    }

    public void compareCards(Card playerCard, Card dealerCard){

        switch (Integer.compare(playerCard.getValue(), dealerCard.getValue())){
            case -1: //Dealer Wins
                System.out.println("Dealer wins the hand.");
                dealer.addPoints(gamePoints);
                break;
            case 1: //Player Wins
                System.out.println(player.getAccountName()+ "wins the hand!");
                player.addPoints(gamePoints);
                break;
            case 0: //War!!
                System.out.println("Go to war!");
                break;
        }
        gamePoints=0;
    }
    public void flipCards(WarPlayer player, int numCards){
        int i =1;
        do  {
            player.getTopCard();
            gamePoints += 1;
            i++;
        } while (i<=numCards);
        System.out.println(player.getAccountName()+ " Card: "+player.getCurrentCard().getRank()+ " of "+player.getCurrentCard().getSuit());

    }

    @Override
    public void run() {
        setup();
        while (player.playerHand.deckSize() > 0){
            String input = console.getStringInput(player.getAccountName()+", press [P] to play a card.");
                if(input.equals("P")){
                    flipCards(player,1);
                    flipCards(dealer, 1);

                }



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
