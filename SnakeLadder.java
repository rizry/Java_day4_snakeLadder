package com.java.day4;

public class SnakeLadder {
  public static void main(String[] ar) throws InterruptedException {

    Player p1 = new Player("Ken");
    Player p2 = new Player("Mark");
    Player p3 = new Player("John");
    Player p4 = new Player("Henry");
    Player[] players = {p1, p2, p3, p4};

    new GamePlay(players);
  }
}

class GamePlay {
  final static byte OPTION_NO_PLAY = 0;
  final static byte OPTION_SNAKE = 1;
  final static byte OPTION_LADDER = 2;
  static Player[] players;
  Player currentPlayer;
  short dieRollTimes = 0;

  GamePlay(Player[] players) throws InterruptedException {
    GamePlay.players = players;
    currentPlayer = players[0];

    startGame();
  }

  void startGame() throws InterruptedException {
    System.out.println("game is starting now.");

    do {
      byte dieRollNum = (byte) ((Math.random() * 10) % 6 + 1);
      dieRollTimes++;
      System.out.println("#" + dieRollTimes + " the die shows " + dieRollNum);

      byte playOption = (byte) ((Math.random() * 10) % 3);

      switch (playOption) {

        case OPTION_NO_PLAY:
          System.out.println(currentPlayer.name + "'s not playing. staying at " + currentPlayer.position + "\n");
          switchPlayer();
          break;

        case OPTION_SNAKE:
          currentPlayer.position -= dieRollNum;
          if (currentPlayer.position <= 0) {
            currentPlayer.position = 0;
            if (currentPlayer.flag) {
              currentPlayer.flag = false;
              System.out.println("stepped on snake and " + currentPlayer.name + "'s right back where " + currentPlayer.name
                + " started. but " + currentPlayer.name + " wont give up\n");
              switchPlayer();
              continue;
            }
          }
          System.out
          .println("Aww. " + currentPlayer.name + " stepped on snake. going back to " + currentPlayer.position + " :( \n");
          switchPlayer();
          break;

        case OPTION_LADDER:
          currentPlayer.flag = true;
          if (currentPlayer.position + dieRollNum <= 100) {
            currentPlayer.position += dieRollNum;

            System.out
            .println("Yay! Ladder. off " + currentPlayer.name + " goes to position " + currentPlayer.position + " :) \n");
            continue;
          }
          System.out.println("welp. guess " + currentPlayer.name + " will just stay at " + currentPlayer.position + " until "
            + currentPlayer.name + " gets " + (100 - currentPlayer.position) + "\n");
          break;
        }
      Thread.sleep(10);

    } while (currentPlayer.position < 100);

    System.out.println("whew! it took " + dieRollTimes + " die rolls in total and " + currentPlayer.name + " finally won");
  }

  void switchPlayer() {
    for (Player p : players) System.out.print(p.name + "'s at position " + p.position + ". ");
       
    for (byte i = 0; i < players.length; i++) {
      if (currentPlayer == players[i]) {
        if (i == players.length - 1) i = -1;
        currentPlayer = players[i + 1];
        break;
      }
    }

    System.out.println("\n" + currentPlayer.name + "'s turn now \n");
  }
}

class Player {
  String name;
  boolean flag = false;
  byte position = 0;

  Player(String name) {
    this.name = name;
  }
}