package com.tymek.utils;

import com.tymek.board.Board;
import com.tymek.player.HumanPlayer;

/**
 * Created by Mateusz on 29.06.2017.
 */
public class WinUtil {
    public static boolean winnerExists(HumanPlayer humanPlayer, Board board, int winningSequenceNumber) {
        //return checkHorizontal(humanPlayer.getSign(), board) /*|| checkVertical(humanPlayer.getSign(), board) || checkDiagonal(humanPlayer.getSign(), board) || checkAntiDiagonal(humanPlayer.getSign(), board)*/;
        return checkHorizontal(humanPlayer.getSign(), board, winningSequenceNumber) || checkVertical(humanPlayer.getSign(), board, winningSequenceNumber);
    }

    private static boolean checkAntiDiagonal(String playerSign, Board board, int winningSequenceNumber) {
        int tmp = 0;
        for (int i = board.getBoardSize(); i < board.size(); i += board.getBoardSize() - 1) {
            if (i == board.getBoardSize()) tmp = 0;
            if (board.get(i).getSign().equals(playerSign)) tmp++;
            if (tmp == board.getBoardSize()) {

                return true;
            }
        }
        return false;
    }

    private static boolean checkDiagonal(String playerSign, Board board, int winningSequenceNumber) {
        int tmp = 0;
        for (int i = 0; i < board.size(); i += board.getBoardSize() + 1) {
            if (i == board.getBoardSize()) tmp = 0;
            if (board.get(i).getSign().equals(playerSign)) tmp++;
            if (tmp == board.getBoardSize()) {

                return true;
            }
        }
        return false;
    }

    private static boolean checkVertical(String playerSign, Board board, int winningSequenceNumber) {
        int tmp = 0;

        for (int i = 0; i < board.size(); i += board.getBoardWidth()) {

            if (playerSign.equals(board.get(i).getSign())) {
                tmp ++;
            } else {
                tmp = 0;
            }
            if (tmp == winningSequenceNumber) return true;
        }

        return false;
    }

    private static boolean checkHorizontal(String playerSign, Board board, int winningSequenceNumber) {

        int tmp = 0;
        for (int i = 0; i < board.size(); i++) {

            if (playerSign.equals(board.get(i).getSign())) {
                tmp ++;
            } else {
                tmp = 0;
            }
            if (tmp == winningSequenceNumber) return true;
        }

        return false;

    }
}
