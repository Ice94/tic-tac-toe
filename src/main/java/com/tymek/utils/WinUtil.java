package com.tymek.utils;

import com.tymek.board.Board;
import com.tymek.board.BoardField;
import com.tymek.player.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mateusz on 29.06.2017.
 */
public class WinUtil {
    public static boolean winnerExists(Player player, Board board, int winningSequenceNumber, int position) {
        //return checkHorizontal(player.getSign(), board) /*|| checkVertical(player.getSign(), board) || checkDiagonal(player.getSign(), board) || checkAntiDiagonal(player.getSign(), board)*/;
        return checkHorizontal(player.getSign(), board, winningSequenceNumber)
                || checkVertical(player.getSign(), board, winningSequenceNumber)
                || checkDiagonal(player.getSign(), board, winningSequenceNumber, position)
                || checkAntiDiagonal(player.getSign(), board, winningSequenceNumber, position);
    }

    private static boolean checkAntiDiagonal(String playerSign, Board board, int winningSequenceNumber, int positon) {
        int tmp = 0;
        for (int i = positon; i < board.size(); i = i + board.getBoardWidth() - 1) {
            if (board.get(i).getSign().equals(playerSign)){
                tmp++;
            }
            if(winningSequenceNumber == tmp){
                return true;
            }
        }
        for (int i = positon - board.getBoardWidth() + 1; i > 0; i = i - (board.getBoardWidth() - 1)) {
            if (board.get(i).getSign().equals(playerSign)){
                tmp++;
            }
            if(winningSequenceNumber == tmp){
                return true;
            }
        }
        return false;
    }

    private static boolean checkDiagonal(String playerSign, Board board, int winningSequenceNumber, int position) {
        int tmp = 0;
        for (int i = position; i <= board.size(); i = i + board.getBoardWidth() + 1) {
            if (board.get(i).getSign().equals(playerSign)){
//                 && ((i / board.getBoardWidth()) == ((i - (board.getBoardWidth() + 1) - 1)/board.getBoardWidth()) + 1)
                if(i < board.getBoardWidth()) {
                    tmp++;
                }else {
                    if(nextRow(board, i)){
                        tmp++;
                    }
                }
            }
            if(winningSequenceNumber == tmp){
                return true;
            }
        }
        for (int i = position - board.getBoardWidth() - 1; i >= 0; i = i - board.getBoardWidth() - 1) {
            if (board.get(i).getSign().equals(playerSign)){
                tmp++;
            }
            if(winningSequenceNumber == tmp){
                return true;
            }
        }
        return false;
    }

    private static boolean nextRow(Board board, int i) {
        return (i / board.getBoardWidth()) == ((i - (board.getBoardWidth() + 1) - 1)/board.getBoardWidth()) + 1;
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
