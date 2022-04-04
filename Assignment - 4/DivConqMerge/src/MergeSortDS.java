public class MergeSortDS implements Problem, Solution {

  public MergeSortDS(int[] arr, int first, int last) {
    this.arr = arr;
    this.first = first;
    this.last = last;
  }

  public int[] getArr() {
    return arr;
  }

  public int getFirst() {
    return first;
  }

  public int getLast() {
    return last;
  }

  private int[] arr;
  private int first, last;
}
