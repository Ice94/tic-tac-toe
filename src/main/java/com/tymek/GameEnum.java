package com.tymek;

/**
 * Created by tymek on 30.06.17.
 */
public enum GameEnum{
    Instance;

//    private List<HumanPlayer> humanPlayers = new ArrayList<>();
//    private TwoDimensionalBoard twoDimensionalBoard;
//    private HumanPlayer currentHumanPlayer;
//
//    private int winningSequenceNumber = 3;
//
//    public void start() {
//
//        setup();
//
//        currentHumanPlayer = humanPlayers.get(0);
//
//        while (true) {
//            System.out.println(String.format("%s make move", currentHumanPlayer.getName()));
//            System.out.println(twoDimensionalBoard);
//
//            //
//            draw();
//
//            //check winner only horizontal/vertical O(n)
//            if (WinUtil.winnerExists(currentHumanPlayer, twoDimensionalBoard, winningSequenceNumber)) {
//                System.out.println(twoDimensionalBoard);
//                System.out.println(String.format("%s wins", currentHumanPlayer.getName()));
//
//                PlayersScore.Instance.addPoint(currentHumanPlayer);
//                PlayersScore.Instance.printScore();
//
//                if (!wantContinue()) break;
//                twoDimensionalBoard.clear();
//
//            }
//
//            currentHumanPlayer = humanPlayers.stream()
//                    .filter(data -> currentHumanPlayer.getPosition() != data.getPosition())
//                    .findAny()
//                    .get();
//
//            System.out.println();
//
//        }
//    }
//
//    private void draw() {
//        int position;
//        Scanner scanner = new Scanner(System.in);
//
//        try {
//            position = Integer.parseInt(scanner.nextLine());
//            twoDimensionalBoard.draw(currentHumanPlayer.getSign(), position);
//        } catch (AlreadyTakenPositionException e) {
//            System.out.println("You can't overdraw position already taken!");
//            position = Integer.parseInt(scanner.nextLine());
//            twoDimensionalBoard.draw(currentHumanPlayer.getSign(), position);
//
//        } catch (DrawBesideBoardException e) {
//            System.out.println("You can't draw beside twoDimensionalBoard's border!");
//            position = Integer.parseInt(scanner.nextLine());
//            twoDimensionalBoard.draw(currentHumanPlayer.getSign(), position);
//
//        } catch (NumberFormatException e) {
//            System.out.println("Position should be number");
//            position = Integer.parseInt(scanner.nextLine());
//            twoDimensionalBoard.draw(currentHumanPlayer.getSign(), position);
//        }
//    }
//
//    private void setup() {
//        playerCreation(humanPlayers);
//        playerCreation(humanPlayers);
//        PlayersScore.Instance.providePlayers(humanPlayers);
//
//        boardCreation();
//    }
//
//    private void playerCreation(List<HumanPlayer> humanPlayers) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println(String.format("HumanPlayer %d set your addName: ", humanPlayers.size() + 1));
//        String name = scanner.nextLine();
//        System.out.println(String.format("HumanPlayer %d set your sign: ", humanPlayers.size() + 1));
//        String sign = scanner.nextLine();
//
//        HumanPlayer humanPlayer = new HumanPlayer.PlayerBuilder()
//                .addName(name)
//                .addSign(sign)
//                .addPositionOrder(humanPlayers.size() + 1)
//                .build();
//
//        humanPlayers.add(humanPlayer);
//    }
//
//    private void boardCreation() {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Set height of the twoDimensionalBoard");
//        int boardHeight = Integer.parseInt(scanner.nextLine());
//        System.out.println("Set width of the twoDimensionalBoard");
//        int boardWidth = Integer.parseInt(scanner.nextLine());
//
//        this.twoDimensionalBoard = new TwoDimensionalBoard(boardHeight, boardWidth);
//
//        System.out.println(twoDimensionalBoard);
//
//        System.out.println();
//    }
//
//    private boolean wantContinue() {
//        if (PlayersScore.Instance.minimumGamesEncountered()) {
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Continue? y/n");
//
//            switch (scanner.nextLine()) {
//                case ("y"):
//                    return true;
//                case ("n"):
//                    return false;
//                default:
//                    System.out.println("Nya-a. Only y/n");
//                    wantContinue();
//            }
//        }
//        return true;
//    }
}
