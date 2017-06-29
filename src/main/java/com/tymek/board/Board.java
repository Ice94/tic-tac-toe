package com.tymek.board;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by Mateusz on 29.06.2017.
 */
public class Board {

    private List<BoardField> board;
    private int boardSize;

    public Board(int boardSize) {
        board = new ArrayList<>(boardSize * boardSize);
        this.boardSize = boardSize;
        fillBoard();
    }

    private void fillBoard() {
        IntStream.range(0, this.boardSize * this.boardSize)
                .boxed()
                .forEach(data -> board.add(new BoardField(data)));
    }

    public int size() {
        return board.size();
    }

    public BoardField get(int position) {
        return board.get(position);
    }

    public void draw(String sign, int position) {
        board.get(position).setSign(sign);
    }

    public List<BoardField> getBoard() {
        return Collections.unmodifiableList(board);
    }

    public int getBoardSize() {
        return boardSize;
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
