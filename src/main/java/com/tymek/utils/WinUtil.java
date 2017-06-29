package com.tymek.utils;

import com.tymek.board.Board;
import com.tymek.board.BoardField;
import com.tymek.player.Player;

import java.util.ArrayList;

/**
 * Created by Mateusz on 29.06.2017.
 */
public class WinUtil {
    public static boolean winnerExists(Player player, Board board) {
        return checkHorizontal(player.getSign(), board) || checkVertical(player.getSign(), board) || checkDiagonal(player.getSign(), board) || checkAntiDiagonal(player.getSign(), board);
    }

    private static boolean checkAntiDiagonal(String playerSign, Board board) {
        int tmp = 0;
        for (int i = board.getBoardSize(); i < board.size(); i += board.getBoardSize() - 1) {
            if (tmp == board.size()) tmp = 0;
            if (board.get(i).getSign().equals(playerSign)) tmp++;
            if (tmp == board.getBoardSize()) {

                return true;
            }
        }
        return false;
    }

    private static boolean checkDiagonal(String playerSign, Board board) {
        int tmp = 0;
        for (int i = 0; i < board.size(); i += board.getBoardSize() + 1) {
            if (tmp == board.size()) tmp = 0;
            if (board.get(i).getSign().equals(playerSign)) tmp++;
            if (tmp == board.getBoardSize()) {

                return true;
            }
        }
        return false;
    }

    private static boolean checkVertical(String playerSign, Board board) {
        int tmp = 0;
        for (int i = 0; i < board.getBoardSize(); i += board.getBoardSize()) {
            if (tmp == board.size()) tmp = 0;
            if (board.get(i).getSign().equals(playerSign)) tmp++;
            if (tmp == board.getBoardSize()) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkHorizontal(String playerSign, Board board) {
        int tmp = 0;
        for (int i = 0; i < board.size(); i++) {
            if (tmp == board.size()) tmp = 0;
            if (board.get(i).getSign().equals(playerSign)) tmp++;
            if (tmp == board.getBoardSize()) {
                return true;
            }
        }
        return false;
    }
}
