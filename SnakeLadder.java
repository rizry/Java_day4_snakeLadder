package com.java.day4;

public class SnakeLadder {

  public static void main(String[] args) {
    byte position = 0;
    System.out.println("The starting position of the player is " + position);

    byte dieRollNum = (byte) ((Math.random() * 10) % 6 + 1);
    System.out.println("the die shows " + dieRollNum);

  }
}
