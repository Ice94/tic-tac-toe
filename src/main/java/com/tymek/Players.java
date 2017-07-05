package com.tymek;


import javax.lang.model.SourceVersion;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

/**
 * Created by bratek on 03.07.17.
 */
public class Players {

    List<Player> players;


    public Players() {
        this.players = new ArrayList<>();
    }

    public List<Player> getPlayers() {
        return players;
    }

    void add(Player player) {
        if(!SourceVersion.isName(player.getName())){
            throw new InputMismatchException();
        }
        players.add(player);
    }
}
