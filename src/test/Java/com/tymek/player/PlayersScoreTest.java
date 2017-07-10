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
    public static Object[][] namesAndPointsWhenWin(){
        return new Object[][]{
                {"Mateusz",3},
                {"Kasujsz",3},
                {"Timon",3}
        };
    }

    @Test(dataProvider = "namesAndPointsWhenWin")
    public void shouldAddPointWhenWin(String name, int points){
        Player player = new Player.PlayerBuilder()
                .name(name)
                .build();

        List<Player> players = new ArrayList<>();
        players.add(player);

        PlayersScore.Instance.providePlayers(players);
        PlayersScore.Instance.addPointWhenWin(player);

        assertEquals(Optional.ofNullable(PlayersScore.Instance.players.get(player.getName())),
                Optional.ofNullable(points));
    }

    @DataProvider
    public static Object[][] namesAndPointsWhenDraw() {
        return new Object[][] {
            {"Mat", 1},
            {"Kat:",1},
            {"Rak",1}
        };
    }

    @Test(dataProvider = "namesAndPointsWhenDraw")
    public void shouldAddOnePointWhenDraw(String name, int point)
    {
        // given
        Player player = new Player.PlayerBuilder()
                .name(name)
                .build();
        // when
        List<Player> players = new ArrayList<>();
        players.add(player);

        PlayersScore.Instance.providePlayers(players);
        PlayersScore.Instance.addPointWhenDraw(player);
        // then
        assertEquals(Optional.ofNullable(PlayersScore.Instance.players.get(player.getName())),
                Optional.ofNullable(point));
    }
}