/*
Gavin D'mello
CIS 532-01 Assignment 1
Implementation 1 -  Circular Shifter for multiple input lines 
*/

import java.util.ArrayList;

public class CircularShifter {

  public ArrayList<ArrayList<String>> generateAllStrings(String[] stringArr) {
    // ArrayList to store all the circular shifter strings
    ArrayList<ArrayList<String>> shiftedStrings = new ArrayList<ArrayList<String>>();

    for (var p = 0; p < stringArr.length; p++) {
      ArrayList<String> currentStringArr = new ArrayList<String>();
      String string = stringArr[p];
      String[] input = string.split(" ");
      for (int i = 0; i < input.length; i++) {
        String[] shifted = rightShifter(input);
        currentStringArr.add(String.join(" ", shifted)); // Storing all shifted sentences of a single input line.
      }
      shiftedStrings.add(currentStringArr); // store the Arraylist of one line in the main ArrayList
    }
    return shiftedStrings;
  }

  /* Move the first element to the last position */
  private String[] rightShifter(String[] input) {
    String tempStr = input[0];
    for (int j = 0; j < input.length - 1; j++) {
      input[j] = input[j + 1];
    }
    input[input.length - 1] = tempStr;
    return input;
  }
}
