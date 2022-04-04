/* Problem and solution structure and a class to obtain the first index, last index and the arrayy itself */
public class MergeSortDS implements Problem, Solution {

  // Constructor
  public MergeSortDS(int[] arr, int first, int last) {
    this.arr = arr;
    this.first = first;
    this.last = last;
  }

  // Returns the array in the Problem/Solution
  public int[] getArr() {
    return arr;
  }

  // Returns the first index in the Problem/Solution
  public int getFirst() {
    return first;
  }

  // Returns the last index in the Problem/Solution

  public int getLast() {
    return last;
  }

  private int[] arr;
  private int first, last;
}
