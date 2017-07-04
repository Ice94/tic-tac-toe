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
                {"Mateusz", GameSign.O_PLAYER},
                {"Karol", GameSign.X_PLAYER},
                {"Kamil", GameSign.O_PLAYER}
        };
    }

    @Test(dataProvider = "correctNamesAndSigns")
    public void testCreationOfPlayerWithGivenNameAndSign(String name, GameSign sign) {
        HumanPlayer humanPlayer = new HumanPlayer.PlayerBuilder()
                .addName(name)
                .addSign(sign)
                .build();

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
        HumanPlayer humanPlayer = new HumanPlayer.PlayerBuilder()
                .addName(name)
                .build();
    }
}