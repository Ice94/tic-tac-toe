package com.tymek;

import com.tymek.board.Board;
import com.tymek.board.TwoDimensionalBoard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bratek on 03.07.17.
 */
public class Boards {

    private List<Board> boards;

    public Boards() {
        boards = new ArrayList<>();
    }

    public List<Board> getBoards() {
        return boards;
    }

    public void add(Board board) {
        boards.add(board);
    }
}
