package com.java.day4;

public class SnakeLadder {
  final static byte OPTION_NO_PLAY = 0;
  final static byte OPTION_SNAKE = 1;
  final static byte OPTION_LADDER = 2;

  public static void main(String[] args) throws InterruptedException {
    byte position = 0;
    boolean flag = false;
    System.out.println("The starting position of the player is " + position);

    while (position < 100) {
      byte dieRollNum = (byte) ((Math.random() * 10) % 6 + 1);
      System.out.println("the die shows " + dieRollNum);

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
          position += dieRollNum;
          flag = true;
          if (position > 100) position = 100;
          System.out.println("Yay! Ladder. off we go to position " + position + " :) \n");
          break;
      }
      Thread.sleep(30);
    }

  }

}
