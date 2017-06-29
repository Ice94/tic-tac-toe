package com.tymek.player;

/**
 * Created by Mateusz on 29.06.2017.
 */
public class Player {
    private String name;
    private String sign;

    public String getSign() {
        return sign;
    }

    public String getName() {
        return name;
    }

    public static class PlayerBuilder {
        Player player = new Player();

        public PlayerBuilder name(String name) {
            player.name = name;
            return this;
        }

        public PlayerBuilder setSign(String sign) {
            player.sign = " " + sign.substring(0, 1).toUpperCase() + " ";
            return this;
        }

        public Player build() {
            return player;
        }
    }
}
