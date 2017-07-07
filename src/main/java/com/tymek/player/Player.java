package com.tymek.player;

/**
 * Created by Mateusz on 29.06.2017.
 */
public class Player implements Comparable<Player> {
    private String name;
    private String sign;
    private int positionOrder;

    public String getSign() {
        return sign;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return positionOrder;
    }

    public static class PlayerBuilder {
        Player player = new Player();

        public PlayerBuilder positionOrder(int positionOrder) {
            player.positionOrder = positionOrder;
            return this;
        }

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

    @Override
    public int compareTo(Player o) {
        return this.name.compareTo(o.getName());
    }

}
