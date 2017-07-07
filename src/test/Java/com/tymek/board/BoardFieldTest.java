package com.tymek.board;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by bratek on 07.07.17.
 */
@Test
public class BoardFieldTest {

    @DataProvider
    public static Object[][] positionLessThanTen() {
        return new Object[][] {
            {1,"01 "},
            {2,"02 "},
            {3,"03 "},
            {4,"04 "},
            {5,"05 "},
            {6,"06 "},
            {7,"07 "},
            {8,"08 "},
            {9,"09 "},
            {0,"00 "}
        };
    }

    @DataProvider
    public static Object[][] sizesOfBoards() {
        return new Object[][] {
            {3,3},
            {5,6},
            {7,8}
        };
    }

    @Test(dataProvider = "positionLessThanTen")
    public void shouldAddZeroAndSpaceIfValueIsLessThanTen(int position, String stringRepresentationOfPosition)
    {
        // given
        BoardField boardField = new BoardField(position);
        // when

        // then
        assertEquals(boardField.toString(), stringRepresentationOfPosition);
    }

    @Test(dataProvider = "sizesOfBoards")
    public void shouldReturnPositionAndSpaceIfGivenValueIsGreaterThanNine(int verical, int horzontal)
    {
        Board board = new Board(verical, horzontal);
        // given

        // when

        // then
        int i = 0;
        for(BoardField field : board){
            if(field.getFieldNumber() > 9) {
                assertEquals(field.toString(), String.valueOf(i) + " ");
            }
            i++;
        }
    }
}