package com.tymek;

import com.tymek.board.Board;
import com.tymek.board.BoardField;
import com.tymek.exceptions.AlreadyTakenPositionException;
import com.tymek.exceptions.DrawBesideBoardException;
import com.tymek.player.Player;
import com.tymek.player.PlayersScore;
import com.tymek.utils.WinUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by tymek on 30.06.17.
 */
public enum Game {
    Instance;

    private List<Player> players = new ArrayList<>();
    Board board;
    private Player currentPlayer;
    private Messenger messenger = new UIMessenger(System.out);


    private int winningSequenceNumber = 3;

    public void start() {

        setup();

        currentPlayer = players.get(0);

        while (true) {
            messenger.printMessage(String.format("%s make move", currentPlayer.getName()));
            messenger.printMessage(board.toString());

            if (WinUtil.winnerExists(currentPlayer, board, winningSequenceNumber, draw())) {
                messenger.printMessage(board.toString());
                messenger.printMessage(String.format("%s wins", currentPlayer.getName()));

                PlayersScore.Instance.addPointWhenWin(currentPlayer);
                PlayersScore.Instance.printScore();


            board.clear();
            }

            if(boardFull(board)){
                PlayersScore.Instance.addPointWhenDraw(currentPlayer);
            }

            if (!wantContinue()) break;

            currentPlayer = players.stream()
                    .filter(data -> currentPlayer.getPosition() != data.getPosition())
                    .findAny()
                    .get();

            System.out.println();

        }
    }

    private boolean boardFull(Board board) {
        int i = 0;
        for(BoardField field : board){
            if(field.getSign().equals(Integer.toString(i))){
                return false;
            }
        }
        return true;
    }

    int draw() {
        int position;
        Scanner scanner = new Scanner(System.in);

        try {
            position = Integer.parseInt(scanner.nextLine());
            board.draw(currentPlayer.getSign(), position);

        } catch (AlreadyTakenPositionException e) {
            messenger.printMessage("You can't overdraw position already taken!");
            position = Integer.parseInt(scanner.nextLine());
            board.draw(currentPlayer.getSign(), position);

        } catch (DrawBesideBoardException e) {
            messenger.printMessage("You can't draw beside board's border!");
            position = Integer.parseInt(scanner.nextLine());
            board.draw(currentPlayer.getSign(), position);

        } catch (NumberFormatException e) {
            messenger.printMessage("Position should be number");
            position = Integer.parseInt(scanner.nextLine());
            board.draw(currentPlayer.getSign(), position);
        }
        return position;
    }

    private void setup() {
        playerCreation(players);
        playerCreation(players);
        PlayersScore.Instance.providePlayers(players);

        messenger.printMessage("Number of characters needed to win?");
        Scanner scanner = new Scanner(System.in);
        winningSequenceNumber = Integer.parseInt(scanner.nextLine());

        boardCreation();
    }

    private void playerCreation(List<Player> players) {
        Scanner scanner = new Scanner(System.in);

        messenger.printMessage(String.format("Player %d set your name: ", players.size() + 1));
        String name = scanner.nextLine();
        messenger.printMessage(String.format("Player %d set your sign: ", players.size() + 1));
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

        messenger.printMessage("Set height of the board");
        int boardHeight = Integer.parseInt(scanner.nextLine());
        messenger.printMessage("Set width of the board");
        int boardWidth = Integer.parseInt(scanner.nextLine());

        this.board = new Board(boardHeight, boardWidth);

        System.out.println(board);

        System.out.println();
    }

    private boolean wantContinue() {

            Scanner scanner = new Scanner(System.in);
           messenger.printMessage("Continue? y/n");

            switch (scanner.nextLine()) {
                case ("y"):
                    return true;
                case ("n"):
                    return false;
                default:
                    messenger.printMessage("Nya-a. Only y/n");
                    wantContinue();

        }
        return true;
    }
}
