package com.tymek.player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mateusz on 30.06.2017.
 */
public enum PlayersScore {
    Instance;

    private Map<String, Integer> players = new HashMap<>();
    private int gamesCounter;

    public boolean minimumGamesEncountered() {
        return gamesCounter == 3;
    }

    public void providePlayers(List<HumanPlayer> humanPlayers) {
        for (HumanPlayer humanPlayer : humanPlayers) {
            this.players.put(humanPlayer.getName(), 0);
        }
    }

    public void printScore() {
        System.out.println("Amount of games played: " + gamesCounter);
        System.out.println(players);
    }

    public void addPoint(HumanPlayer currentHumanPlayer) {
        gamesCounter++;
        int currentScore = players.get(currentHumanPlayer.getName());
        players.replace(currentHumanPlayer.getName(), currentScore + 1);
    }
}

