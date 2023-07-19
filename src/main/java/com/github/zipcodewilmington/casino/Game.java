package com.github.zipcodewilmington.casino;

import java.util.List;

public abstract class Game implements GameInterface {
    List<PlayerInterface> players;

    public Game(List<PlayerInterface> players){
        this.players.addAll(players);
    }

    public abstract void run();
    public abstract void setup();
}
