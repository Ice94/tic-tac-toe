package com.tymek.board;

import com.tymek.exceptions.AlreadyTakenPositionException;
import com.tymek.exceptions.DrawBesideBoardException;
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

    @DataProvider
    public static Object[][] heightXWidthTakenPosition() {
        return new Object[][] {
            {3,3,6},
            {4,5,19},
            {3,7,15}
        };
    }

    @DataProvider
    public static Object[][] heightXWidthOutOfBoundPosition(){
        return new Object[][]{
                {3,3,10},
                {3,6,20},
                {5,5,30}
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
    public void newBoardShouldBeFilled(int height, int width) {
        // given - when
        Board board = new Board(height, width);

        // then
        int i =0;
        for (BoardField field : board) {
            assertEquals(field.getFieldNumber(), i);
            i++;
        }
    }

    @Test(dataProvider = "heightXWidthTakenPosition", expectedExceptions = AlreadyTakenPositionException.class)
    public void shouldThrownExceptionWhenCurrentTileIsTaken(int height, int width, int position)
    {
        // given
        Board board = new Board(height, width);
        board.get(position).setSign(String.valueOf(position+1));
        board.draw(String.valueOf(position),position);
    }

    @Test(dataProvider = "heightXWidthOutOfBoundPosition", expectedExceptions = DrawBesideBoardException.class)
    public void shouldThrownExceptionWhenPositionIsOutOfBoard(int height, int width, int position){
        Board board = new Board(height, width);
        board.draw(String.valueOf(position), position);
    }

}