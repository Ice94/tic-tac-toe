package com.tymek.player;

import com.tymek.Player;

import javax.lang.model.SourceVersion;
import java.util.InputMismatchException;

/**
 * Created by Mateusz on 29.06.2017.
 */
public class HumanPlayer implements Comparable<HumanPlayer>, Player {
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
        HumanPlayer humanPlayer = new HumanPlayer();

        public PlayerBuilder addPositionOrder(int positionOrder) {
            humanPlayer.positionOrder = positionOrder;
            return this;
        }

        public PlayerBuilder addName(String name) {
            if(!SourceVersion.isName(name)){
                throw new InputMismatchException();
            }
            humanPlayer.name = name;
            return this;
        }

        public PlayerBuilder addSign(String sign) {
            humanPlayer.sign = " " + sign.substring(0, 1).toUpperCase() + " ";
            return this;
        }

        public HumanPlayer build() {
            return humanPlayer;
        }
    }

    @Override
    public int compareTo(HumanPlayer o) {
        return this.name.compareTo(o.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HumanPlayer humanPlayer = (HumanPlayer) o;

        if (name != null ? !name.equals(humanPlayer.name) : humanPlayer.name != null) return false;
        return sign != null ? sign.equals(humanPlayer.sign) : humanPlayer.sign == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (sign != null ? sign.hashCode() : 0);
        return result;
    }
}
