package com.tymek;

import com.tymek.board.Board;
import com.tymek.player.Player;
import com.tymek.utils.WinUtil;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Mateusz on 29.06.2017.
 */
public class Main {
    public static void main(String[] args) {

        HashMap<String, Player> players = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Player One set your name: ");
        String name = scanner.nextLine();
        System.out.println("Player One set your Sign");
        String sign = scanner.nextLine();



        Player playerOne = new Player.PlayerBuilder()
                .name(name)
                .setSign(sign)
                .build();

        System.out.println("Player Two set your name: ");
        name = scanner.nextLine();
        System.out.println(String.format("%s please, set your Sign", name));
        sign = scanner.nextLine();
        if (sign.equals(playerOne.getSign())) {
            System.out.println("You can't have same sign as previous player");
        }

        Player playerTwo = new Player.PlayerBuilder()
                .name(name)
                .setSign(sign)
                .build();

        players.put(playerOne.getName(), playerOne);
        players.put(playerTwo.getName(), playerTwo);

        System.out.println("Set size of board");
        int boardSize = Integer.parseInt(scanner.nextLine());

        Board board = new Board(boardSize);

        System.out.println(board);

        System.out.println();

        Player currentPlayer = playerOne;

        while(true) {
            System.out.println(String.format("%s make move", currentPlayer.getName()));
            int position = Integer.parseInt(scanner.nextLine());
            board.draw(currentPlayer.getSign(), position);
            System.out.println(board);

            //check winner
            if (WinUtil.winnerExists(playerOne, board)) {
                System.out.println(String.format("%s wins", currentPlayer.getName()));
                break;
            }

            if (currentPlayer.getSign().equals(playerOne.getSign())) {
                currentPlayer = playerTwo;
            } else {
                currentPlayer = playerOne;
            }


//            System.out.println("Player O make move");
//            position = Integer.parseInt(scanner.nextLine());
//            board.draw(CIRCLE, position);
//            System.out.println(board);

        }

    }
}
