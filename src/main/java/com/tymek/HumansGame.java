package com.tymek;

import com.tymek.board.TwoDimensionalBoard;
import com.tymek.player.HumanPlayer;

import java.util.List;

/**
 * Created by bratek on 03.07.17.
 */
public class HumansGame implements Game {

    private Players players;

    private Boards boards;

    public HumansGame() {
        this.players = new Players();
        this.boards = new Boards();
    }

    @Override
    public Players getPlayers() {
        return players;
    }

    @Override
    public Boards getBoards() {
        return boards;
    }

    @Override
    public void createPlayers() {
     // TODO: ask about data.

        HumanPlayer humanPlayer1 = new HumanPlayer();
        HumanPlayer humanPlayer2 = new HumanPlayer();

        players.add(humanPlayer1);
        players.add(humanPlayer2);
    }

    @Override
    public void createBoards() {
        // TODO: ask about sizes.

        TwoDimensionalBoard board1 = new TwoDimensionalBoard(3,3);
        TwoDimensionalBoard board2 = new TwoDimensionalBoard(7,7);
        TwoDimensionalBoard board3 = new TwoDimensionalBoard(9,9);

        boards.add(board1);
        boards.add(board2);
        boards.add(board3);
    }
}
