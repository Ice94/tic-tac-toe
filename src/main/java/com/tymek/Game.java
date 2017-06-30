package com.tymek;

import com.tymek.board.Board;
import com.tymek.exceptions.AlreadyTakenPositionException;
import com.tymek.exceptions.DrawBesideBoardException;
import com.tymek.player.Player;
import com.tymek.player.PlayersScore;
import com.tymek.utils.WinUtil;

import java.util.*;

/**
 * Created by tymek on 30.06.17.
 */
public enum Game {
    Instance;

    List<Player> players = new ArrayList<>();
    Board board;

    public void start() {

        setup();

        Scanner scanner = new Scanner(System.in);

        Player currentPlayer = players.stream()
                .filter(data -> data.getPosition() == 1)
                .findFirst()
                .get();

        while(true) {
            System.out.println(String.format("%s make move", currentPlayer.getName()));
            System.out.println(board);

            int position;
            try {
                position = Integer.parseInt(scanner.nextLine());
                board.draw(currentPlayer.getSign(), position);
            } catch (AlreadyTakenPositionException e) {
                System.out.println("You can't overdraw position already taken!");
                position = Integer.parseInt(scanner.nextLine());
                board.draw(currentPlayer.getSign(), position);
            } catch (DrawBesideBoardException e) {
                position = Integer.parseInt(scanner.nextLine());
                board.draw(currentPlayer.getSign(), position);
            } catch (NumberFormatException e) {
                System.out.println("Position should be number");
                position = Integer.parseInt(scanner.nextLine());
                board.draw(currentPlayer.getSign(), position);
            }


            //check winner
            if (WinUtil.winnerExists(currentPlayer, board)) {
                System.out.println(board);
                System.out.println(String.format("%s wins", currentPlayer.getName()));
                PlayersScore.Instance.addPoint(currentPlayer);
                PlayersScore.Instance.printScore();
                board.clear();

            }

            if (currentPlayer.getSign().equals(players.get(0).getSign())) {
                currentPlayer = players.get(1);
            } else {
                currentPlayer = players.get(0);
            }
            System.out.println();

        }
    }

    private void setup() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Player One set your name: ");
        String name = scanner.nextLine();
        System.out.println("Player One set your Sign");
        String sign = scanner.nextLine();

        Player playerOne = new Player.PlayerBuilder()
                .name(name)
                .setSign(sign)
                .positionOrder(1)
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
                .positionOrder(2)
                .build();

        players.add(playerOne);
        players.add(playerTwo);

        PlayersScore.Instance.providePlayers(players);

        System.out.println("Set size of board");
        int boardSize = Integer.parseInt(scanner.nextLine());

        this.board = new Board(boardSize);

        System.out.println(board);

        System.out.println();

    }
}
