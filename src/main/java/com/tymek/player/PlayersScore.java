package com.tymek.player;

import javafx.scene.effect.SepiaTone;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Mateusz on 30.06.2017.
 */
public enum PlayersScore {
    Instance;

    private Map<String, Integer> players = new HashMap<>();

    public void providePlayers(Set<Player> players) {
        for (Player player : players) {
            this.players.put(player.getName(), 0);
        }
    }

    public void printScore() {
        System.out.println(players);
    }

    public void addPoint(Player currentPlayer) {
        int currentScore = players.get(currentPlayer.getName());
        players.replace(currentPlayer.getName(), currentScore + 1);
    }
}

