package com.tymek.player;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by bratek on 07.07.17.
 */
@Test
public class PlayerTest {

    
    @DataProvider
    public static Object[][] listOfNames() {
        return new Object[][] {
            {"Basia"},
            {"Stasia"},
            {"Asia"}
        };
    }

    @DataProvider
    public static Object[][] listOfNamesAndPosition() {
        return new Object[][] {
            {"Basia",1},
            {"Stasia",2},
            {"Asia",0}
        };
    }

    @DataProvider
    public static Object[][] listOfNamesPositionsAndSigns() {
        return new Object[][] {
            {"Basia",1,"X"},
            {"Stasia",2,"X"},
            {"Asia",0,"X"}
        };
    }

    @Test(dataProvider = "listOfNames")
    public void shouldReturnNameWhenBuildPlayerWithName(String name)
    {
        // given - when
        Player player = new Player.PlayerBuilder()
                .name(name)
                .build();
        // then
        assertEquals(player.getName(), name);
    }

    @Test(dataProvider = "listOfNamesAndPosition")
    public void shouldReturnNameAndPositionWhenBuildPlayerWithNameAndPosition(String name, int position){
        Player player = new Player.PlayerBuilder()
                .name(name)
                .positionOrder(position)
                .build();

        assertEquals(player.getName(), name);
        assertEquals(player.getPosition(), position);
    }

    @Test(dataProvider = "listOfNamesPositionsAndSigns")
    public void shouldReturnFullAllDataFromPlayer(String name, int position, String sing)
    {
        // given
        Player player = new Player.PlayerBuilder()
                .name(name)
                .positionOrder(position)
                .setSign(sing)
                .build();
        // when

        // then
        assertEquals(player.getName(), name);
        assertEquals(player.getPosition(), position);
        assertEquals(player.getSign(), " " + sing + " ");
    }


}