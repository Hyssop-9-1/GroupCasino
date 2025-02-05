package com.github.zipcodewilmington.casino;

/**
 * Created by leon on 7/21/2020.
 */
public interface GameInterface extends Runnable {
    /**
     * specifies how the game will run
     */
    void run();

    /**
     *
     */
    void setup();
    void addPlayer(PlayerInterface player);
    void removePlayer();
    void checkWinCond();
}
