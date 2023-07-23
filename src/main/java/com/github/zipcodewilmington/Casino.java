package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.*;
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
//import sun.util.logging.resources.logging;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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
            do {
                arcadeDashBoardInput = getArcadeDashboardInput();
                if ("select-game".equals(arcadeDashBoardInput)) {
                    CasinoAccount casinoAccount = login();
                    String gameSelectionInput = getGameSelectionInput().toUpperCase();
                    if (gameSelectionInput.equals("SLOTS")) {
                        playSinglePlayer(new SlotsGame(),new SlotsPlayer(casinoAccount)); ;
                    } else if (gameSelectionInput.equals("NUMBERGUESS")) {
                        NumberGuessGame numGame = new NumberGuessGame();
                        numGame.addPlayer(new NumberGuessPlayer(casinoAccount));
                        if(console.getStringInput("Add another player? y/n:").equalsIgnoreCase("y")){
                            numGame.addPlayer(new NumberGuessPlayer(login()));
                        }
                        numGame.run();
                    } else if (gameSelectionInput.equalsIgnoreCase("war")) {
                        playSinglePlayer(new WarGame(), new WarPlayer(casinoAccount));
                    } else if (gameSelectionInput.equalsIgnoreCase("ROLL")) {
                        RollGame game = new RollGame();
                        game.addPlayer(new RollPlayer(casinoAccount));
                        int hold = console.getIntegerInput("This game requires 2 players, input a number for how many more people would like to play:");
                        for(int i = 0; i < hold; i++){
                            game.addPlayer(new RollPlayer(login()));
                        }
                        game.run();
                    } else {
                        // TODO - implement better exception handling
                        String errorMessage = "[ %s ] is an invalid game selection";
                        throw new RuntimeException(String.format(errorMessage, gameSelectionInput));
                    }
                } else if ("create-account".equals(arcadeDashBoardInput)) {
                    createAccount();
                }
            } while (!"logout".equalsIgnoreCase(arcadeDashBoardInput));
            casinoAccountManager.save();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private String getArcadeDashboardInput() {
        return console.getStringInput(new StringBuilder()
                //Colossal https://ascii-generator.site/t/
                .append("888       888          888                                              888             \n" +
                        "888   o   888          888                                              888             \n" +
                        "888  d8b  888          888                                              888             \n" +
                        "888 d888b 888  .d88b.  888  .d8888b  .d88b.  88888b.d88b.   .d88b.      888888  .d88b.  \n" +
                        "888d88888b888 d8P  Y8b 888 d88P\"    d88\"\"88b 888 \"888 \"88b d8P  Y8b     888    d88\"\"88b \n" +
                        "88888P Y88888 88888888 888 888      888  888 888  888  888 88888888     888    888  888 \n" +
                        "8888P   Y8888 Y8b.     888 Y88b.    Y88..88P 888  888  888 Y8b.         Y88b.  Y88..88P \n" +
                        "888P     Y888  \"Y8888  888  \"Y8888P  \"Y88P\"  888  888  888  \"Y8888       \"Y888  \"Y88P\"  \n" +
                        "                                                                                        \n")
                .append("88888888888 888                   888    888                                                   .d8888b.                    d8b                   \n" +
                        "    888     888                   888    888                                                  d88P  Y88b                   Y8P                   \n" +
                        "    888     888                   888    888                                                  888    888                                         \n" +
                        "    888     88888b.   .d88b.      8888888888 888  888 .d8888b  .d8888b   .d88b.  88888b.      888         8888b.  .d8888b  888 88888b.   .d88b.  \n" +
                        "    888     888 \"88b d8P  Y8b     888    888 888  888 88K      88K      d88\"\"88b 888 \"88b     888            \"88b 88K      888 888 \"88b d88\"\"88b \n" +
                        "    888     888  888 88888888     888    888 888  888 \"Y8888b. \"Y8888b. 888  888 888  888     888    888 .d888888 \"Y8888b. 888 888  888 888  888 \n" +
                        "    888     888  888 Y8b.         888    888 Y88b 888      X88      X88 Y88..88P 888 d88P     Y88b  d88P 888  888      X88 888 888  888 Y88..88P \n" +
                        "    888     888  888  \"Y8888      888    888  \"Y88888  88888P'  88888P'  \"Y88P\"  88888P\"       \"Y8888P\"  \"Y888888  88888P' 888 888  888  \"Y88P\"  \n" +
                        "                                                  888                            888                                                             \n" +
                        "                                             Y8b d88P                            888                                                             \n" +
                        "                                              \"Y88P\"                             888                                                             \n")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t[ create-account ], [ select-game ], [ logout ] \n")
                .toString());
    }

    private String getGameSelectionInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the Game Selection Dashboard!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t[ SLOTS ], [ NUMBERGUESS ], [ WAR ], [ ROLL ]")
                .toString());
    }

    private void playSinglePlayer(Object gameObject, Object playerObject){
        GameInterface game = (GameInterface) gameObject;
        game.addPlayer((PlayerInterface) playerObject);
        game.run();
    }

    
    private CasinoAccount login() {
        CasinoAccount account;
        String errorMessage = "No account found with name of [ %s ] and password of [ %s ]";
        int loginAttempts = 0;
        do {
            String accountName = console.getStringInput("Enter your account name:");
            String accountPassword = console.getStringInput("Enter your account password:");
            account = casinoAccountManager.getAccount(accountName, accountPassword);
            loginAttempts++;
            if (account == null) {
                console.println(String.format(errorMessage, accountName, accountPassword));
                if (loginAttempts % 3 == 0) {
                    String output = console.getStringInput("Failed login 3 times in a row: C - create an account | R - retry login | ");
                    if (output.equalsIgnoreCase("c")) {
                        for (int i = 0; i < 50; i++){
                            console.println(" ");
                        }
                        createAccount();
                    }
                }
            }
        }while(account == null) ;
        return account;
    }
    private void createAccount(){
        console.println("Welcome to the account-creation screen.");
        String accountName = console.getStringInput("Enter your account name:");
        String accountPassword = console.getStringInput("Enter your account password:");
        CasinoAccount newAccount = casinoAccountManager.createAccount(accountName, accountPassword);
        casinoAccountManager.registerAccount(newAccount);
        console.println("Account successfully created for " + accountName + " returning to login screen.");

    }


}

