/*
Gavin D'mello
CIS 532-01 Assignment 1
Implementation 1 -  Keyboard Input for multiple lines 
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Input {

  /* Reads the file and passes each read line to the Line Storage */
  /* Supports Lazy Reading */
  public void readFile(LineStorage lineStorage) {
    BufferedReader bReader = null;
    try {
      String currentLine;
      bReader = new BufferedReader(new FileReader("Input.txt"));
      int i = 0;
      System.out.println("\n**Lines from Input file**");
      while ((currentLine = bReader.readLine()) != null) {
        if (currentLine.length() > 0) {
          System.out.println(currentLine);
          lineStorage.appendNewLine(currentLine, i); // pass line to Line Storage
          i++;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (bReader != null) bReader.close();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
  }
}
