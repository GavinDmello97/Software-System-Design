import java.util.ArrayList;

//https://www.programcreek.com/2010/10/sort-content-in-a-file/

// import java.util.Collections;

public class Alphabetizer {

  public ArrayList<String> alphabetize(
    ArrayList<ArrayList<String>> listOfLinesList
  ) {

    // Hold the result of the alphabetizer
    ArrayList<String> result = new ArrayList<String>();
    for (int p = 0; p < listOfLinesList.size(); p++) {
      ArrayList load = listOfLinesList.get(p);
      for (int q = 0; q < load.size(); q++) {
        for (int r = q + 1; r < load.size(); r++) {
          // Compare strings to eachother in order to alphabetize, also taking into account the case
          if (
            load
              .get(q)
              .toString()
              .toLowerCase()
              .compareTo(load.get(r).toString().toLowerCase()) >
            0
          ) {
            String temp = (String) load.get(q);
            load.set(q, load.get(r));
            load.set(r, temp);
          }
        }
      }

      //Add the alphabetized strings to the result
      for (int s = 0; s < load.size(); s++) {
        result.add((String) load.get(s));
      }
    }

    return result;
  }
}
