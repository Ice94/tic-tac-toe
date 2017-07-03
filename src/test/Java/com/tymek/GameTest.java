package com.tymek;

import com.tymek.board.Board;
import com.tymek.board.TwoDimensionalBoard;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by bratek on 03.07.17.
 */
public class GameTest {

    private static final int NUMBER_OF_PLAYERS = 2;
    private Game game;

    @BeforeTest
    public void prepare(){
        game = new HumansGame();
    }

    @Test
    public void createTwoPlayers(){
        game.createPlayers();

        assertEquals(getNumberOfPlayers(), NUMBER_OF_PLAYERS);
    }

    @Test
    public void createThreeBoard(){
        game.createBoards();

        assertEquals(game.getBoards().getBoards().size(),3);
    }

    private int getNumberOfPlayers() {
        return game.getPlayers().getPlayers().size();
    }


}