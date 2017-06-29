package com.tymek.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Created by Mateusz on 29.06.2017.
 */
public class BoardMap {

    private List<BoardField> board;
    private int boardSize;

    public BoardMap(int boardSize) {
        board = new ArrayList<>(boardSize * boardSize);
        this.boardSize = boardSize;
        fillBoard();
    }

    private void fillBoard() {
        IntStream.range(0, this.boardSize * this.boardSize)
                .boxed()
                .forEach(data -> board.add(new BoardField(data)));
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        int counter = 0;
        for (BoardField boardField : board) {
            stringBuilder.append(boardField);
            counter++;

            if (counter == boardSize) {
                //stringBuilder.append(System.getProperty("line.separator"));
                stringBuilder.append("\n");
                counter = 0;
            }
        }

        return stringBuilder.toString();

    }
}
