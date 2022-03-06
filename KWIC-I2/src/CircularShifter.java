/*Kameron Jusseaume
CIS 532-01 Assignment 1
Implementation 2 - Circular Shifter
*/
import java.util.ArrayList;
import java.util.HashMap;

public class CircularShifter {
  private ArrayList<ArrayList<String>> shiftedStrings = new ArrayList<ArrayList<String>>();

  private void generateAllStrings(ArrayList<HashMap> listOfStringHashMaps) {

    // ArrayList to store all the circular shifter lineHashMapings
    for (int n = 0; n < listOfStringHashMaps.size(); n++) {
      ArrayList<String> currentStringArr = new ArrayList<String>();

      // Get the list of strings from the list of lines from the input
      HashMap lineHashMap = listOfStringHashMaps.get(n);

      //get the individual words in the hashmap
      ArrayList<HashMap> wordsList = (ArrayList<HashMap>) lineHashMap.get("words");

      for (int i = 0; i < wordsList.size(); i++) {
        String currentString = "";

        ArrayList<HashMap> shifted = rightShifter(wordsList);
        String firstWord = (String) shifted.get(0).get("text");

        /*Ignore the circular shifted lineHashMaping if it is not "interesting"*/
        if (
          firstWord.equalsIgnoreCase("is") ||
          firstWord.equalsIgnoreCase("the") ||
          firstWord.equalsIgnoreCase("of") ||
          firstWord.equalsIgnoreCase("and") ||
          firstWord.equalsIgnoreCase("as") ||
          firstWord.equalsIgnoreCase("a") ||
          firstWord.equalsIgnoreCase("after") ||
          firstWord.equalsIgnoreCase("are")
        ) {
          continue;
        } else {
          //add the currentstring to the running list
          for (int q = 0; q < shifted.size(); q++) {
            currentString += shifted.get(q).get("text").toString() + " ";
          }
          currentString.substring(0, shifted.size());
        }
        currentStringArr.add(currentString);
      }
      shiftedStrings.add(currentStringArr); // store the Arraylist of one line in the main ArrayList
    }
  }

  /*Used to get a specified line from the list of circular shifted inputs*/
  public CircularShifter shiftLines(LineStorage lineStorage) {
    ArrayList<HashMap> listOfHashmaps = lineStorage.getLines();
    generateAllStrings(listOfHashmaps);
    return this;
  }

  public ArrayList<ArrayList<String>> getAllLines() {
    return shiftedStrings;
  }

  /* Move the first element to the last position */
  private ArrayList<HashMap> rightShifter(ArrayList<HashMap> input) {
    HashMap tempStr = input.get(0);
    for (int j = 0; j < input.size() - 1; j++) {
      input.set(j, input.get(j + 1));
    }
    input.set(input.size() - 1, tempStr);
    return input;
  }
}
