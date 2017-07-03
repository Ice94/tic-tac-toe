package com.tymek;

import com.tymek.player.HumanPlayer;

import java.util.List;

/**
 * Created by bratek on 03.07.17.
 */
public class HumansGame implements Game {

    private Players players;

    public HumansGame() {
        this.players = new Players();
    }

    public Players getPlayers() {
        return players;
    }

    @Override
    public void createPlayers() {
        HumanPlayer humanPlayer1 = new HumanPlayer();
        HumanPlayer humanPlayer2 = new HumanPlayer();

        players.add(humanPlayer1);
        players.add(humanPlayer2);
    }
}
