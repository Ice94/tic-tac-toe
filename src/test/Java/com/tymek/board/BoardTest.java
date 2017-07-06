package com.tymek.board;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by bratek on 06.07.17.
 */
@Test
public class BoardTest {

    @DataProvider
    public static Object[][] heightXWidthEqualsSize() {
        return new Object[][] {
            {3,3,9},
            {5,7,35},
            {3,4,12}
        };
    }

    @DataProvider
    public static Object[][] boardFilledWithNumbers() {
        return new Object[][] {
            {3,3},
            {4,5},
            {6,6}
        };
    }

    @Test(dataProvider = "heightXWidthEqualsSize")
    public void sizeOfBoardFromParams(int height, int width, int size) {
        // given - when
        Board board = new Board(height,width);

        // then
        assertEquals(board.size(), size);
    }


    @Test(dataProvider = "boardFilledWithNumbers")
    public void newBoardShouldBeFilled(int h, int w) {
        // given - when
        Board board = new Board(h, w);

        // then
        int i =0;
        for (BoardField field : board) {
            assertEquals(field.getFieldNumber(), i);
            i++;
        }
    }
}