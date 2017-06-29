package com.tymek;

import com.tymek.board.Board;

import java.util.Scanner;

/**
 * Created by Mateusz on 29.06.2017.
 */
public class Main {
    public static void main(String[] args) {

        int boardSize = 5;

        Board board = new Board(boardSize);

        System.out.println(board);

        System.out.println();

        Scanner scanner = new Scanner(System.in);

        String CROSS = " X ";
        String CIRCLE = " O";

        boolean winnerExists = false;
        while(true) {
            System.out.println("Player X make move");
            int position = Integer.parseInt(scanner.nextLine());
            board.draw(CROSS, position);
            System.out.println(board);

            //check winner

            int tmp = 0;
            for (int i = 0; i < board.size(); i++) {
                if (tmp == board.size()) tmp = 0;
                if (board.get(i).getSign().equals(CROSS)) tmp ++;
                if (tmp == boardSize) {

                    winnerExists = true;
                    break;
                }
            }

            tmp = 0;
            for (int i = 0; i < boardSize; i += boardSize) {
                if (tmp == board.size()) tmp = 0;
                if (board.get(i).getSign().equals(CROSS)) tmp ++;
                if (tmp == boardSize) {

                    winnerExists = true;
                    break;
                }
            }

            tmp = 0;
            for (int i = 0; i < board.size(); i += boardSize + 1) {
                if (tmp == board.size()) tmp = 0;
                if (board.get(i).getSign().equals(CROSS)) tmp ++;
                if (tmp == boardSize) {

                    winnerExists = true;
                    break;
                }
            }

            tmp = 0;
            for (int i = boardSize; i < board.size(); i += boardSize - 1) {
                if (tmp == board.size()) tmp = 0;
                if (board.get(i).getSign().equals(CROSS)) tmp ++;
                if (tmp == boardSize) {

                    winnerExists = true;
                    break;
                }
            }

            if (winnerExists) {
                System.out.println("Player X wins");
                break;
            }

//            System.out.println("Player O make move");
//            position = Integer.parseInt(scanner.nextLine());
//            board.draw(CIRCLE, position);
//            System.out.println(board);

        }

    }
}
