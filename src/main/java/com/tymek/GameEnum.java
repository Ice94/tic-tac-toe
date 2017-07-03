package com.tymek;

import com.tymek.board.Board;
import com.tymek.exceptions.AlreadyTakenPositionException;
import com.tymek.exceptions.DrawBesideBoardException;
import com.tymek.player.HumanPlayer;
import com.tymek.player.PlayersScore;
import com.tymek.utils.WinUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by tymek on 30.06.17.
 */
public enum GameEnum{
    Instance;

    private List<HumanPlayer> humanPlayers = new ArrayList<>();
    private Board board;
    private HumanPlayer currentHumanPlayer;

    private int winningSequenceNumber = 3;

    public void start() {

        setup();

        currentHumanPlayer = humanPlayers.get(0);

        while (true) {
            System.out.println(String.format("%s make move", currentHumanPlayer.getName()));
            System.out.println(board);

            //
            draw();

            //check winner only horizontal/vertical O(n)
            if (WinUtil.winnerExists(currentHumanPlayer, board, winningSequenceNumber)) {
                System.out.println(board);
                System.out.println(String.format("%s wins", currentHumanPlayer.getName()));

                PlayersScore.Instance.addPoint(currentHumanPlayer);
                PlayersScore.Instance.printScore();

                if (!wantContinue()) break;
                board.clear();

            }

            currentHumanPlayer = humanPlayers.stream()
                    .filter(data -> currentHumanPlayer.getPosition() != data.getPosition())
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
            board.draw(currentHumanPlayer.getSign(), position);
        } catch (AlreadyTakenPositionException e) {
            System.out.println("You can't overdraw position already taken!");
            position = Integer.parseInt(scanner.nextLine());
            board.draw(currentHumanPlayer.getSign(), position);

        } catch (DrawBesideBoardException e) {
            System.out.println("You can't draw beside board's border!");
            position = Integer.parseInt(scanner.nextLine());
            board.draw(currentHumanPlayer.getSign(), position);

        } catch (NumberFormatException e) {
            System.out.println("Position should be number");
            position = Integer.parseInt(scanner.nextLine());
            board.draw(currentHumanPlayer.getSign(), position);
        }
    }

    private void setup() {
        playerCreation(humanPlayers);
        playerCreation(humanPlayers);
        PlayersScore.Instance.providePlayers(humanPlayers);

        boardCreation();
    }

    private void playerCreation(List<HumanPlayer> humanPlayers) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(String.format("HumanPlayer %d set your addName: ", humanPlayers.size() + 1));
        String name = scanner.nextLine();
        System.out.println(String.format("HumanPlayer %d set your sign: ", humanPlayers.size() + 1));
        String sign = scanner.nextLine();

        HumanPlayer humanPlayer = new HumanPlayer.PlayerBuilder()
                .addName(name)
                .addSign(sign)
                .addPositionOrder(humanPlayers.size() + 1)
                .build();

        humanPlayers.add(humanPlayer);
    }

    private void boardCreation() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Set height of the board");
        int boardHeight = Integer.parseInt(scanner.nextLine());
        System.out.println("Set width of the board");
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
