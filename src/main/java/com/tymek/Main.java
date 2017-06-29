package com.tymek;

import com.tymek.board.BoardField;
import com.tymek.board.BoardMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mateusz on 29.06.2017.
 */
public class Main {
    public static void main(String[] args) {



        int boardSize = 5;

        BoardMap board = new BoardMap(boardSize);

        System.out.println(board);

    }
}
