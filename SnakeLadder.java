package com.java.day4;

public class SnakeLadder {
  final static byte OPTION_NO_PLAY = 0;
  final static byte OPTION_SNAKE = 1;
  final static byte OPTION_LADDER = 2;

  public static void main(String[] args) throws InterruptedException {
    byte position = 0;
    boolean flag = false;
    short dieRollTimes = 0;
    System.out.println("The starting position of the player is " + position);

    while (position < 100) {
      byte dieRollNum = (byte) ((Math.random() * 10) % 6 + 1);
      dieRollTimes++;
      System.out.println("#" + dieRollTimes + " the die shows " + dieRollNum);

      byte playOption = (byte) ((Math.random() * 10) % 3);

      switch (playOption) {

        case OPTION_NO_PLAY:
          System.out.println("The player not playing. staying at " + position + "\n");
          break;

        case OPTION_SNAKE:
          position -= dieRollNum;
          if (position <= 0) {
            position = 0;
            if (flag) {
              flag = false;
              System.out.println("stepped on snake and we're right back where we started. but we wont give up\n");
              continue;
            }
          }
          System.out.println("Aww. stepped on snake. going back to " + position + " :( \n");
          break;

        case OPTION_LADDER:
          flag = true;
          if (position + dieRollNum <= 100) {
            position += dieRollNum;

            System.out.println("Yay! Ladder. off we go to position " + position + " :) \n");
            continue;
          }
          System.out.println("welp. guess we'll just stay at " + position + " until we get " + (100 - position) + "\n");
          break;

      }
      Thread.sleep(10);
    }
    System.out.println("whew! it took " + dieRollTimes + " die rolls to finally win");

  }
}
