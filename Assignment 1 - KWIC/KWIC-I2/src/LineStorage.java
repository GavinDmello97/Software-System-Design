/*
Gavin D'mello
CIS 532-01 Assignment 1
Implementation 1 -  Line Storage  
*/

import java.util.ArrayList;
import java.util.HashMap;

public class LineStorage {
  private static ArrayList<HashMap> lines = new ArrayList<HashMap>();

  public static ArrayList<HashMap> getLines() {
    return lines;
  }

  /* Receives the string/line and the index of the line in the input file */
  public void appendNewLine(String line, int index) {
    //add new Dictionary/HashMap to the
    lines.add(stringToObjectConverter(line, index));
  }

  /* Converts input line into an LineObject with additional parameters */
  private HashMap stringToObjectConverter(String input, int index) {
    HashMap lineDictionary = new HashMap<>();
    lineDictionary.put("id", String.valueOf(index));
    lineDictionary.put("text", input);
    lineDictionary.put("word_count", getWordCount(input));
    lineDictionary.put("words", getWordList(input, index));

    return lineDictionary;
  }

  /* Calculates word count in a line */
  private int getWordCount(String input) {
    return input.split(" ").length;
  }

  /* Converts an input line into an Array of word objects */
  private ArrayList<HashMap> getWordList(String input, int index) {
    ArrayList<HashMap> result = new ArrayList<HashMap>();
    String[] wordArray = input.split(" ");
    for (int i = 0; i < wordArray.length; i++) {
      HashMap wordDictionary = new HashMap<>();
      wordDictionary.put("id", String.valueOf(i));
      wordDictionary.put("line_id", String.valueOf(index));
      wordDictionary.put("text", wordArray[i]);
      result.add(wordDictionary);
    }

    return result;
  }
}
