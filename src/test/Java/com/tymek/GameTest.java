package com.tymek;

import com.tymek.board.Board;
import com.tymek.board.BoardField;
import com.tymek.player.Player;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

/**
 * Created by bratek on 10.07.17.
 */
public class GameTest {



    @Test
    public void testSwapPlayer() throws Exception {

        Game.Instance.players = new ArrayList<>();
        Player player1 = new Player.PlayerBuilder()
                .positionOrder(1)
                .build();
        Player player2 = new Player.PlayerBuilder()
                .positionOrder(2)
                .build();
        Game.Instance.currentPlayer = player1;
        Game.Instance.players.add(player1);
        Game.Instance.players.add(player2);

        Game.Instance.currentPlayer = Game.Instance.swapPlayer();

        assertTrue(Game.Instance.currentPlayer.equals(player2));
    }


    @DataProvider
    public static Object[][] fullBoardData() {
        return new Object[][] {
            {3,3,"X"},
            {10,10,"X"},
            {15,10,"X"}
        };
    }

    @Test(dataProvider = "fullBoardData")
    public void shouldReturnTrueIfBoardIsFull(int width, int height, String sign){
        Game.Instance.board = new Board(width, height);

        Player player = new Player.PlayerBuilder()
                .setSign(sign)
                .build();

        for(BoardField field : Game.Instance.board){
            field.setSign(player.getSign());
        }

        assertTrue(Game.Instance.boardFull(Game.Instance.board));
    }
}