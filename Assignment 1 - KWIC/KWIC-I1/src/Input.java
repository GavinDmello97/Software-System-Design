/*
Atefeh Rahmani
CIS 532-01 Assignment 1
Implementation 1 -  Keyboard Input for multiple lines 
*/

import java.util.*;

public class Input {

  public String[] keyboard() {
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Enter the number of lines:  ");
    int length = keyboard.nextInt();
    String[] inputArray = new String[length];
    keyboard.nextLine();

    for (var i = 0; i < length; i++) {
      System.out.print("Enter line" + (i + 1) + ": ");
      inputArray[i] = keyboard.nextLine();
    }
    return inputArray;
  }
}
