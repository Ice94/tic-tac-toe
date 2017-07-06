package com.tymek;

import com.tymek.player.HumanPlayer;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.InputMismatchException;

import static org.testng.Assert.*;

/**
 * Created by bratek on 03.07.17.
 */
@Test
public class PlayersTest {

    @DataProvider(name = "correctNamesAndSigns")
    public static Object[][] correctNamesAndSigns() {
        return new Object[][]{
                {"Mateusz", GameSign.O},
                {"Karol", GameSign.X},
                {"Kamil", GameSign.O}
        };
    }

    @Test(dataProvider = "correctNamesAndSigns")
    public void testCreationOfPlayerWithGivenNameAndSign(String name, GameSign sign) {
        HumanPlayer humanPlayer = new HumanPlayer(name, sign);

        Players players = new Players();
        players.add(humanPlayer);

        assertTrue(players.getPlayers().contains(humanPlayer));
    }

    @DataProvider(name = "incorrectNames")
    public static Object[][] incorrectNames() {
        return new Object[][]{
                {"Mateusz 12", ""},
                {"asdqwe12**", ""}
        };
    }

    @Test(dataProvider = "incorrectNames", expectedExceptions = InputMismatchException.class)
    public void shouldThrowExceptionIfNamesIsNotValid(String name, String string2) {
        Players players = new Players();
        HumanPlayer humanPlayer = new HumanPlayer(name, GameSign.E);
        players.add(humanPlayer);
    }
}