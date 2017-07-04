package com.tymek.player;

import com.tymek.GameSign;
import com.tymek.Player;

import javax.lang.model.SourceVersion;
import java.util.InputMismatchException;

/**
 * Created by Mateusz on 29.06.2017.
 */
public class HumanPlayer implements  Player {
    private String name;
    private GameSign sign;

    public String getName() {
        return name;
    }

    public static class PlayerBuilder {
        HumanPlayer humanPlayer = new HumanPlayer();

        public PlayerBuilder addName(String name) {
            if(!SourceVersion.isName(name)){
                throw new InputMismatchException();
            }
            humanPlayer.name = name;
            return this;
        }

        public PlayerBuilder addSign(GameSign sign) {
            humanPlayer.sign = sign;
            return this;
        }

        public HumanPlayer build() {
            return humanPlayer;
        }
    }

}
