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

    public HumanPlayer(String name, GameSign sign) {
        this.name = name;
        this.sign = sign;
    }

    public String getName() {
        return name;
    }

    public GameSign getSign() {
        return sign;
    }
}
