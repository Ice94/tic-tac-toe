package com.tymek;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by bratek on 03.07.17.
 */
@Test
public class HumansGameTest {

    private Game game;

    @BeforeTest
    public void prepare(){
        game = new HumansGame();
    }

    @Test
    public void createTwoPlayersWithGivenValues(){
        game.createPlayers();

        assertEquals(game.getPlayers().getPlayers().size(), 2);
    }

}