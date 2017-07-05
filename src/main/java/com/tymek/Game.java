package com.tymek;

import java.util.List;
import java.util.Map;

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

    /**
     * Creating three boards.
     * */
    void createBoards();

    /**
     * Returning boards.
     * @see Boards
     * @return boards object.
     * */
    Boards getBoards();

    /**
     * Set player's game sign at the board.
     * @param player current player.
     * @param position which was choosen by player.
     * @param round number of round.
     * */
    void playerMove(Player player, Integer position, int round);

    Map<Integer, GameSign> getBoardForRound(int round);

    Player getPlayerNumber(int playerNumber);
}
