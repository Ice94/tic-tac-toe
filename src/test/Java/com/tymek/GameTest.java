package com.tymek;

import com.tymek.board.Board;
import com.tymek.board.TwoDimensionalBoard;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

import static org.testng.Assert.assertEquals;

/**
 * Created by bratek on 03.07.17.
 */
public class GameTest {

    private static final int NUMBER_OF_PLAYERS = 2;
    private static final int PLAYER_NUMBER = 0;
    public static final int NUMBER_OF_BOARDS = 3;
    private Game game;

    @BeforeTest
    public void prepare(){
        game = new HumansGame();
    }

    @DataProvider(name = "playerMoves")
    public static Object[][] getPlayerMoves(){
        return new Object[][]{
                {1,0},
                {2,1},
                {3,2},
                {20,2}
        };
    }

    @Test
    public void createTwoPlayers(){
        game.createPlayers();

        assertEquals(getNumberOfPlayers(), NUMBER_OF_PLAYERS);
    }

    @Test
    public void createThreeBoard(){
        game.createBoards();

        assertEquals(getNumberOfBoards(), NUMBER_OF_BOARDS);
    }

    @Test(dataProvider = "playerMoves")
    public void currentPlayerMove(int position, int round){
        game.createPlayers();
        game.createBoards();
        game.playerMove(game.getPlayerNumber(PLAYER_NUMBER), position,round);

        assertEquals(game.getBoardForRound(round).get(position), game.getPlayerNumber(PLAYER_NUMBER).getSign());
    }




    private int getNumberOfBoards() {
        return game.getBoards().getBoards().size();
    }

    private int getNumberOfPlayers() {
        return game.getPlayers().getPlayers().size();
    }


}