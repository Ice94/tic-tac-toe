package com.tymek;

import com.tymek.player.HumanPlayer;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by bratek on 03.07.17.
 */
@Test
public class PlayersTest {

    @DataProvider(name = "correctNamesAndSigns")
    public static Object[][] correctNamesAndSigns() {
        return new Object[][]{
                {"Mateusz", "X"},
                {"Karol", "O"},
                {"Kamil", "X"}
        };
    }

    @Test(dataProvider = "correctNamesAndSigns")
    public void testCreationOfPlayerWithGivenNameAndSign(String name, String sign) {
        HumanPlayer humanPlayer = new HumanPlayer.PlayerBuilder()
                .addName(name)
                .addSign(sign)
                .build();

        Players players = new Players();
        players.add(humanPlayer);

        assertTrue(players.getPlayers().contains(humanPlayer));
    }
}