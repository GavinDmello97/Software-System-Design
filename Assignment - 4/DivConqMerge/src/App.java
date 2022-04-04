public class App {

  public static void main(String[] args) throws Exception {
    int[] arr = new int[] { 24, 12, 13, 4, 92, 0, 8, 10 };
    System.out.print("\nUnsorted list: ");

    for (int p = 0; p < arr.length; p++) {
      System.out.print(arr[p] + " ");
    }
    int first = 0;
    int last = arr.length - 1;
    MergeSortDS msds = new MergeSortDS(arr, first, last);

    DivConqTemplate quick = new MergeSort();
    Solution solution = quick.solve(msds);
    System.out.print("\n\nSorted list: ");
    for (int q = 0; q < ((MergeSortDS) solution).getArr().length; q++) {
      System.out.print(((MergeSortDS) solution).getArr()[q] + " ");
    }
    System.out.println("\n");
  }
}
