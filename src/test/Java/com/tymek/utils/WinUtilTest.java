package com.tymek.utils;

import com.tymek.board.Board;
import com.tymek.player.Player;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by bratek on 09.07.17.
 */

@Test
public class WinUtilTest {


    @DataProvider
    public static Object[][] verticalXHorizontalXSingXNeedToWin(){
            return new Object[][]{
                    {3,3," X ",3},
                    {3,5," X ",3},
                    {5,5," X ",4},
                    {30,30," X ", 20}
            };
    }

    @Test(dataProvider = "verticalXHorizontalXSingXNeedToWin")
    public void shouldReturnTrueIfWinnerIsOnHorizontalLine(int vertical, int horizontal, String sing,
                                                           int winningSequenceNumber){

        Board board = new Board(horizontal, vertical);
        Player player = new Player.PlayerBuilder()
                .setSign(sing)
                .build();

        for(int i = 0; i <= winningSequenceNumber; i++){
            board.get(i).setSign(player.getSign());
        }



        assertTrue(WinUtil.winnerExists(player, board, winningSequenceNumber));
    }
}