/*
Gavin D'mello
CIS 532-01 Assignment 1
Implementation 1 -  Main Controller 
*/

import java.util.ArrayList;

public class App {

  public static void displayOutput(ArrayList<String> resultArray) {
    System.out.println("\n**Results**");
    for (int i = 0; i < resultArray.size(); i++) {
      System.out.println("Line " + (i + 1) + ": " + resultArray.get(i));
    }
    System.out.println("\n");
  }

  public static void main(String[] args) throws Exception {
    System.out.println("\nKWIC Implementation 1");
    /* Getting input from user */
    String[] input = new Input().keyboard();

    /* Passing input from user to Circular Shifter */
    ArrayList<ArrayList<String>> circularShiftResult = new CircularShifter()
    .generateAllStrings(input);

    /* 
      Passing list of generated string by circular shifter to Alphabetizer 
      to sort the lines alphabetically
    */
    ArrayList<String> alphabetizerResult = new Alphabetizer()
    .alphabetize(circularShiftResult);

    /* Print all the sorted lines */
    displayOutput(alphabetizerResult);
    // Atefeh save "alphabetizerResult in file then read it from file"
  }
}
