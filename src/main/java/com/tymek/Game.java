package com.tymek;

import java.util.List;

/**
 * Created by bratek on 03.07.17.
 * Main interface of this Tic Tac Toe game.
 *
 * @author Mateusz Bratek
 */
public interface Game {
    /**
     * Creating two players for game.
     * */
    void createPlayers();


    /**
     * Returning Players.
     * @see Players
     * @return players object.
     * */
    Players getPlayers();

}
