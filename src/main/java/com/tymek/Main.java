package com.tymek;

import com.tymek.board.Board;
import com.tymek.exceptions.AlreadyTakenPositionException;
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

        Set<Player> players = new TreeSet<>();

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

//        players.put(playerOne.getName(), playerOne);
//        players.put(playerTwo.getName(), playerTwo);
        players.add(playerOne);
        players.add(playerTwo);
        PlayersScore.Instance.providePlayers(players);

        System.out.println("Set size of board");
        int boardSize = Integer.parseInt(scanner.nextLine());

        Board board = new Board(boardSize);

        System.out.println(board);

        System.out.println();

        Player currentPlayer = playerOne;

        while(true) {
            System.out.println(String.format("%s make move", currentPlayer.getName()));
            System.out.println(board);

            int position = -1;
            try {
                position = Integer.parseInt(scanner.nextLine());
                board.draw(currentPlayer.getSign(), position);
            } catch (AlreadyTakenPositionException e) {
                System.out.println("You can't overdraw position already taken!");
                position = Integer.parseInt(scanner.nextLine());
                board.draw(currentPlayer.getSign(), position);
            } catch (NumberFormatException e) {
                System.out.println("Position should be number");
                position = Integer.parseInt(scanner.nextLine());
            }


            //check winner
            if (WinUtil.winnerExists(playerOne, board)) {
                System.out.println(board);
                System.out.println(String.format("%s wins", currentPlayer.getName()));
                PlayersScore.Instance.addPoint(currentPlayer);
                PlayersScore.Instance.printScore();
                board.clear();
                //PlayersScore.Instance.showScore(players);
                System.out.println();
            }

            if (currentPlayer.getSign().equals(playerOne.getSign())) {
                currentPlayer = playerTwo;
            } else {
                currentPlayer = playerOne;
            }
            System.out.println();

        }

    }
}
