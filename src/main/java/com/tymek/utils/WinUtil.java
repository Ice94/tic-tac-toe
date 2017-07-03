package com.tymek.utils;

import com.tymek.board.TwoDimensionalBoard;
import com.tymek.player.HumanPlayer;

/**
 * Created by Mateusz on 29.06.2017.
 */
public class WinUtil {
//    public static boolean winnerExists(HumanPlayer humanPlayer, TwoDimensionalBoard twoDimensionalBoard, int winningSequenceNumber) {
//        //return checkHorizontal(humanPlayer.getSign(), twoDimensionalBoard) /*|| checkVertical(humanPlayer.getSign(), twoDimensionalBoard) || checkDiagonal(humanPlayer.getSign(), twoDimensionalBoard) || checkAntiDiagonal(humanPlayer.getSign(), twoDimensionalBoard)*/;
//        return checkHorizontal(humanPlayer.getSign(), twoDimensionalBoard, winningSequenceNumber) || checkVertical(humanPlayer.getSign(), twoDimensionalBoard, winningSequenceNumber);
//    }
//
//    private static boolean checkAntiDiagonal(String playerSign, TwoDimensionalBoard twoDimensionalBoard, int winningSequenceNumber) {
//        int tmp = 0;
//        for (int i = twoDimensionalBoard.getBoardSize(); i < twoDimensionalBoard.size(); i += twoDimensionalBoard.getBoardSize() - 1) {
//            if (i == twoDimensionalBoard.getBoardSize()) tmp = 0;
//            if (twoDimensionalBoard.get(i).getSign().equals(playerSign)) tmp++;
//            if (tmp == twoDimensionalBoard.getBoardSize()) {
//
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private static boolean checkDiagonal(String playerSign, TwoDimensionalBoard twoDimensionalBoard, int winningSequenceNumber) {
//        int tmp = 0;
//        for (int i = 0; i < twoDimensionalBoard.size(); i += twoDimensionalBoard.getBoardSize() + 1) {
//            if (i == twoDimensionalBoard.getBoardSize()) tmp = 0;
//            if (twoDimensionalBoard.get(i).getSign().equals(playerSign)) tmp++;
//            if (tmp == twoDimensionalBoard.getBoardSize()) {
//
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private static boolean checkVertical(String playerSign, TwoDimensionalBoard twoDimensionalBoard, int winningSequenceNumber) {
//        int tmp = 0;
//
//        for (int i = 0; i < twoDimensionalBoard.size(); i += twoDimensionalBoard.getBoardWidth()) {
//
//            if (playerSign.equals(twoDimensionalBoard.get(i).getSign())) {
//                tmp ++;
//            } else {
//                tmp = 0;
//            }
//            if (tmp == winningSequenceNumber) return true;
//        }
//
//        return false;
//    }
//
//    private static boolean checkHorizontal(String playerSign, TwoDimensionalBoard twoDimensionalBoard, int winningSequenceNumber) {
//
//        int tmp = 0;
//        for (int i = 0; i < twoDimensionalBoard.size(); i++) {
//
//            if (playerSign.equals(twoDimensionalBoard.get(i).getSign())) {
//                tmp ++;
//            } else {
//                tmp = 0;
//            }
//            if (tmp == winningSequenceNumber) return true;
//        }
//
//        return false;
//
//    }
}
