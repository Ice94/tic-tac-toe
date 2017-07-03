package com.tymek;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by bratek on 03.07.17.
 */
public class GameTest {

    private Game game;

    @BeforeTest
    public void prepare(){
        game = new HumansGame();
    }



    // TODO: Just to not forget about the this test.
    @Test
    public void testCreatingPlayers(){


    }

}