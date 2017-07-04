package com.tymek.board;

import java.util.Map;

/**
 * Interface of board.
 * @author Mateusz Bratek
 */
public interface Board {
    /**
     * Returns board.
     * @return map of integers with strings.
     * */
    Map<Integer, String> getBoard();

    /**
     * Returns horizontal length of the board.
     * @return Horizontal length of the board.
     * */
    int getHorizontalLength();

    /**
     * Returns vertical length of the board.
     * @return vertical length of the board.
     * */
    int getVerticalLength();
}
