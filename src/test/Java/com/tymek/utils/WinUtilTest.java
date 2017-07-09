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
                    {3,3,"X",3},
                    {3,5,"X",3},
                    {5,5,"X",4},
                    {30,30,"X", 20}
            };
    }

    @Test(dataProvider = "verticalXHorizontalXSingXNeedToWin")
    public void shouldReturnTrueIfWinnerIsOnHorizontalLine(int width, int height, String sing,
                                                           int winningSequenceNumber){

        Board board = new Board(height, width);
        Player player = new Player.PlayerBuilder()
                .setSign(sing)
                .build();

        for(int i = 0; i < winningSequenceNumber; i++){
            board.get(i).setSign(player.getSign());
        }

        assertTrue(WinUtil.winnerExists(player, board, winningSequenceNumber, 0));
    }

    @Test(dataProvider = "verticalXHorizontalXSingXNeedToWin")
    public void shouldReturnTrueIfWinnerIsOnVerticalLine(int width, int height, String sing,
                                                         int winningSequenceNumber){
        Board board = new Board(height, width);
        Player player = new Player.PlayerBuilder()
                .setSign(sing)
                .build();

        for (int i = 0; i < height * width; i = i + width){
            board.get(i).setSign(player.getSign());
        }

        assertTrue(WinUtil.winnerExists(player, board, winningSequenceNumber, 0));
    }

    @DataProvider
    public static Object[][] verticalXHorizontalXSingXPositionXNeedToWin(){
        return new Object[][]{
                {3,3,"X",3,0},
                {4,4,"X",3,1},
                {30,30,"X",10,4},
                {4,4,"X",3,1},
                {5,5,"X",3,2}
        } ;
    }

    @Test(dataProvider = "verticalXHorizontalXSingXPositionXNeedToWin")
    public void shouldReturnTrueIfWinnerIsOnDiagonalLineFromFirstLine(int width,
                                                                      int height,
                                                                      String sign,
                                                                      int winningSequenceNumber,
                                                                      int position){
        Board board = new Board(height, width);
        Player player = new Player.PlayerBuilder()
                .setSign(sign)
                .build();

        for(int i = position; i < height * width; i = i + width + 1){
            board.get(i).setSign(player.getSign());
        }
        assertTrue(WinUtil.winnerExists(player, board, winningSequenceNumber, position));
    }

    @DataProvider
    public static Object[][] verticalXHorizontalXSignXPosition(){
        return new Object[][]{
                {3,3,"X",3,4}
        };
    }

    @Test(dataProvider = "verticalXHorizontalXSignXPosition")
    public void shouldReturnTrueIfWinnerIsOnDiagonal(int width,
                                                     int height,
                                                     String sign,
                                                     int winningSequenceNumber,
                                                     int position){
        Board board = new Board(height, width);
        Player player = new Player.PlayerBuilder()
                .setSign(sign)
                .build();
        board.get(0).setSign(player.getSign());
        board.get(4).setSign(player.getSign());
        board.get(8).setSign(player.getSign());

        assertTrue(WinUtil.winnerExists(player, board, winningSequenceNumber, position));
    }


    @DataProvider
    public static Object[][] widthXheightXSignWinningNumberPosition(){
        return new Object[][]{
                {5,5,"X",5,4},
                {5,5,"X",5,8},
                {5,5,"X",4,16}
        };
    }

    @Test(dataProvider = "widthXheightXSignWinningNumberPosition")
    public void shouldReturnTrueIfWinnerIsOnAntiDiagonal(int width,
                                                         int height,
                                                         String sign,
                                                         int winningSequenceNumber,
                                                         int position){
        Board board = new Board(height, width);
        Player player = new Player.PlayerBuilder()
                .setSign(sign)
                .build();

        for(int i = width * height - width; i > 0; i = i - (width - 1)){
            board.get(i).setSign(player.getSign());
        }

        assertTrue(WinUtil.winnerExists(player, board, winningSequenceNumber, position));
    }
}