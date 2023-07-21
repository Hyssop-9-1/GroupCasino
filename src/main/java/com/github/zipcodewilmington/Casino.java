package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessGame;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessPlayer;
import com.github.zipcodewilmington.casino.games.roll.RollGame;
import com.github.zipcodewilmington.casino.games.roll.RollPlayer;
import com.github.zipcodewilmington.casino.games.slots.SlotsGame;
import com.github.zipcodewilmington.casino.games.slots.SlotsPlayer;
import com.github.zipcodewilmington.casino.games.war.WarGame;
import com.github.zipcodewilmington.casino.games.war.WarPlayer;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by leon on 7/21/2020.
 */
public class Casino implements Runnable {
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);
    CasinoAccountManager casinoAccountManager = new CasinoAccountManager();

    @Override
    public void run() {
        String arcadeDashBoardInput;
        try {
            casinoAccountManager.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        do {
            arcadeDashBoardInput = getArcadeDashboardInput();
            if ("select-game".equals(arcadeDashBoardInput)) {
                String accountName = console.getStringInput("Enter your account name:");
                String accountPassword = console.getStringInput("Enter your account password:");
                CasinoAccount casinoAccount = casinoAccountManager.getAccount(accountName, accountPassword);
                boolean isValidLogin = casinoAccount != null;
                if (isValidLogin) {
                    String gameSelectionInput = getGameSelectionInput().toUpperCase();
                    if (gameSelectionInput.equals("SLOTS")) {
                        SlotsPlayer player = new SlotsPlayer(casinoAccount);
                        SlotsGame game = new SlotsGame();
                        game.addPlayer(player);
                        game.run();
                    } else if (gameSelectionInput.equals("NUMBERGUESS")) {
                        NumberGuessPlayer account = new NumberGuessPlayer(casinoAccount);
                        NumberGuessGame game = new NumberGuessGame();
                        game.addPlayer(account);
                        game.run();
                    } else if (gameSelectionInput.equalsIgnoreCase("war")){
                        WarPlayer account = new WarPlayer(casinoAccount);
                        WarGame game = new WarGame();
                        game.addPlayer(account);
                        game.run();
                    } else if(gameSelectionInput.equalsIgnoreCase("ROLL")){
                        RollPlayer player = new RollPlayer(casinoAccount);
                        RollGame game = new RollGame();
                        game.addPlayer(player);
                        int hold = console.getIntegerInput("This game requires 2 players, input a number for how many more people would like to play:");
                        for(int i = 0; i < hold; i++){
                            RollPlayer player1 = new RollPlayer(login());
                            game.addPlayer(player1);
                        }
                        game.run();
                    } else {
                        // TODO - implement better exception handling
                        String errorMessage = "[ %s ] is an invalid game selection";
                        throw new RuntimeException(String.format(errorMessage, gameSelectionInput));
                    }
                } else {
                    // TODO - implement better exception handling
                    String errorMessage = "No account found with name of [ %s ] and password of [ %s ]";
                    throw new RuntimeException(String.format(errorMessage, accountPassword, accountName));
                }
            } else if ("create-account".equals(arcadeDashBoardInput)) {
                console.println("Welcome to the account-creation screen.");
                String accountName = console.getStringInput("Enter your account name:");
                String accountPassword = console.getStringInput("Enter your account password:");
                CasinoAccount newAccount = casinoAccountManager.createAccount(accountName, accountPassword);
                casinoAccountManager.registerAccount(newAccount);
            }
        } while (!"logout".equals(arcadeDashBoardInput));
        try {
            casinoAccountManager.save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getArcadeDashboardInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the Arcade Dashboard!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t[ create-account ], [ select-game ], [ logout ] ")
                .toString());
    }

    private String getGameSelectionInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the Game Selection Dashboard!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t[ SLOTS ], [ NUMBERGUESS ], [ WAR ], [ ROLL ]")
                .toString());
    }
    /*
    private void play(Object gameObject, Object playerObject) {
        GameInterface game = (GameInterface)gameObject;
        PlayerInterface player = (PlayerInterface)playerObject;
        //game.add(player);
        game.run();
    }

     */

    private CasinoAccount login(){
        CasinoAccount account;
        do {
            String accountName = console.getStringInput("Enter your account name:");
            String accountPassword = console.getStringInput("Enter your account password:");
            account = casinoAccountManager.getAccount(accountName, accountPassword);
        }while(account == null);
        return account;
    }
    private void createAccount(){
        console.println("Welcome to the account-creation screen.");
        String accountName = console.getStringInput("Enter your account name:");
        String accountPassword = console.getStringInput("Enter your account password:");
        CasinoAccount newAccount = casinoAccountManager.createAccount(accountName, accountPassword);
        casinoAccountManager.registerAccount(newAccount);
    }
}
