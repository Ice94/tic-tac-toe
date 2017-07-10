package com.tymek.player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Mateusz on 30.06.2017.
 */
public enum PlayersScore {
    Instance;

    public Map<String, Integer> players = new HashMap<>();
    private int gamesCounter;

    public boolean minimumGamesEncountered() {
        return gamesCounter == 3;
    }

    public void providePlayers(List<Player> players) {
        for (Player player : players) {
            this.players.put(player.getName(), 0);
        }
    }

    public void printScore() {
        System.out.println("Amount of games played: " + gamesCounter);
        System.out.println(players);
    }

    public void addPointWhenWin(Player currentPlayer) {
        gamesCounter++;
        int currentScore = players.get(currentPlayer.getName());
        players.replace(currentPlayer.getName(), currentScore + 3);
    }

    public void addPointWhenDraw(Player player) {
        gamesCounter++;
        int currentScore = players.get(player.getName());
        players.replace(player.getName(), currentScore + 1);
    }
}

