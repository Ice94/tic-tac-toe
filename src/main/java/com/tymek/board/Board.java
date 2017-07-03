package com.tymek.board;

import java.util.Map;

/**
 *
 * @author Mateusz Bratek
 */
public interface Board {
    Map<Integer, String> getBoard();
    int getHorizontalLength();
    int getVerticalLength();
}
