package com.tymek;

import com.tymek.board.Board;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
        if(!isBoardValid(board)){
            throw new InputMismatchException();
        }
        boards.add(board);
    }

    private boolean isBoardValid(Board board) {
        return board.getHorizontalLength() > 2 && board.getVerticalLength() > 2;
    }
}
