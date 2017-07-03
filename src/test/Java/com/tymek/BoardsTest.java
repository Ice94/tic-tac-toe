package com.tymek;

import com.tymek.board.TwoDimensionalBoard;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by bratek on 03.07.17.
 */
public class BoardsTest {
    @DataProvider(name = "sizesOfTable")
    public static Object[][] sizesOfTable(){
        return new Object[][]{
                {3,3},
                {4,4},
                {5,5},
                {5,3},
                {7,5}
        };
    }


    @Test(dataProvider = "sizesOfTable")
    public void createBoardWithGivenSizes(int horizontalLength, int verticalLength){
        TwoDimensionalBoard board = new TwoDimensionalBoard(horizontalLength, verticalLength);

        Boards boards = new Boards();
        boards.add(board);

        assertEquals(boards.getBoards().get(0).getBoard().size(), horizontalLength * verticalLength);
    }
}