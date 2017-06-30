package com.tymek;

import com.tymek.board.Board;
import com.tymek.exceptions.AlreadyTakenPositionException;
import com.tymek.exceptions.DrawBesideBoardException;
import com.tymek.player.Player;
import com.tymek.player.PlayersScore;
import com.tymek.utils.WinUtil;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Mateusz on 29.06.2017.
 */
public class Main {
    public static void main(String[] args) {

        Game.Instance.start();


    }
}
