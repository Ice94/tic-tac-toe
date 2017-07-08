package com.tymek.player;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.testng.Assert.*;

/**
 * Created by bratek on 07.07.17.
 */
@Test
public class PlayersScoreTest {


    @DataProvider
    public static Object[][] playersName(){
        return new Object[][]{
                {"Janek", "Alek"},
                {"Arko", "Darko"},
                {"Siemko", "Wojbor"}
        };
    }

    @Test(dataProvider = "playersName")
    public void shouldContainPlayerNameAndPlayerScoreZero(String name1, String name2){
        Player player1 = new Player.PlayerBuilder()
                .name(name1)
                .build();
        Player player2 = new Player.PlayerBuilder()
                .name(name2)
                .build();
        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);


        PlayersScore.Instance.providePlayers(players);

        assertTrue(PlayersScore.Instance.players.containsKey(player1.getName()));
        assertTrue(PlayersScore.Instance.players.containsKey(player2.getName()));
    }

    @DataProvider
    public static Object[][] namesAndPoints(){
        return new Object[][]{
                {"Mateusz",1},
                {"Kasujsz",1},
                {"Timon",1}
        };
    }

    @Test(dataProvider = "namesAndPoints")
    public void shouldAddPoint(String name, int points){
        Player player = new Player.PlayerBuilder()
                .name(name)
                .build();

        List<Player> players = new ArrayList<>();
        players.add(player);

        PlayersScore.Instance.providePlayers(players);
        PlayersScore.Instance.addPoint(player);

        assertEquals(Optional.ofNullable(PlayersScore.Instance.players.get(player.getName())),
                Optional.ofNullable(points));
    }
}