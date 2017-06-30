package com.tymek;

import com.tymek.board.Board;
import com.tymek.exceptions.AlreadyTakenPositionException;
import com.tymek.exceptions.BoardException;
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

    private List<Player> players = new ArrayList<>();
    private Board board;
    private Player currentPlayer;
    private int winningSequenceNumber = 3;

    public void start() {

        setup();

        currentPlayer = players.get(0);

        while (true) {
            System.out.println(String.format("%s make move", currentPlayer.getName()));
            System.out.println(board);


            //
            draw();

            //check winner only horizontal/vertical O(n)
            if (WinUtil.winnerExists(currentPlayer, board, winningSequenceNumber)) {
                System.out.println(board);
                System.out.println(String.format("%s wins", currentPlayer.getName()));

                PlayersScore.Instance.addPoint(currentPlayer);
                PlayersScore.Instance.printScore();

                if (!wantContinue()) break;
                board.clear();

            }

            currentPlayer = players.stream()
                    .filter(data -> currentPlayer.getPosition() != data.getPosition())
                    .findAny()
                    .get();

            System.out.println();

        }
    }

    private void draw() {
        int position;
        Scanner scanner = new Scanner(System.in);

        try {
            position = Integer.parseInt(scanner.nextLine());
            board.draw(currentPlayer.getSign(), position);
        } catch (AlreadyTakenPositionException e) {
            System.out.println("You can't overdraw position already taken!");
            position = Integer.parseInt(scanner.nextLine());
            board.draw(currentPlayer.getSign(), position);

        } catch (DrawBesideBoardException e) {
            System.out.println("You can't draw beside board's border!");
            position = Integer.parseInt(scanner.nextLine());
            board.draw(currentPlayer.getSign(), position);

        } catch (NumberFormatException e) {
            System.out.println("Position should be number");
            position = Integer.parseInt(scanner.nextLine());
            board.draw(currentPlayer.getSign(), position);
        }
    }

    private void setup() {
        playerCreation(players);
        playerCreation(players);
        PlayersScore.Instance.providePlayers(players);

        boardCreation();
    }

    private void playerCreation(List<Player> players) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(String.format("Player %d set your name: ", players.size() + 1));
        String name = scanner.nextLine();
        System.out.println(String.format("Player %d set your sign: ", players.size() + 1));
        String sign = scanner.nextLine();

        Player player = new Player.PlayerBuilder()
                .name(name)
                .setSign(sign)
                .positionOrder(players.size() + 1)
                .build();

        players.add(player);
    }

    private void boardCreation() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Set size of board");
        int boardHeight = Integer.parseInt(scanner.nextLine());
        int boardWidth = Integer.parseInt(scanner.nextLine());

        this.board = new Board(boardHeight, boardWidth);

        System.out.println(board);

        System.out.println();
    }

    private boolean wantContinue() {
        if (PlayersScore.Instance.minimumGamesEncountered()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Continue? y/n");

            switch (scanner.nextLine()) {
                case ("y"):
                    return true;
                case ("n"):
                    return false;
                default:
                    System.out.println("Nya-a. Only y/n");
                    wantContinue();
            }
        }
        return true;
    }
}
