public class MergeSort extends DivConqTemplate {

  /* Checks if there is only one element in the list. Returns boolean */
  protected boolean isSimple(Problem p) {
    return (((MergeSortDS) p).getFirst() >= ((MergeSortDS) p).getLast());
  }

  /* Fetches the Problem instance and returns the p as a cast of Solution */
  protected Solution simplySolve(Problem p) {
    return (Solution) p;
  }

  /* 
    Decomposes the Problem into two halves using midpoint 
    and returns both the subproblems in a Problems array
  */
  protected Problem[] decompose(Problem p) {
    int first = ((MergeSortDS) p).getFirst();
    int last = ((MergeSortDS) p).getLast();
    int[] a = ((MergeSortDS) p).getArr();

    Problem[] ps = new MergeSortDS[2]; // Problem Array of type MergeSortDS of size 2
    int mid = (int) ((last - first) / 2);
    int n1 = mid + 1;
    int n2 = last - first - mid;
    int L[] = new int[n1]; // temporary arrays to hold first subproblem's list
    int R[] = new int[n2]; // temporary arrays to hold second subproblem's list

    /* Loading elements in L and R */
    for (int i = 0; i < n1; i++) {
      L[i] = a[i];
    }
    for (int j = 0; j < n2; j++) {
      R[j] = a[mid + 1 + j];
    }

    /* adding the subProblems in the Problem[] ps */
    ps[0] = new MergeSortDS(L, first, mid + first);
    ps[1] = new MergeSortDS(R, mid + 1 + first, last);

    /* Returning Problem[] containing two subproblems */
    return ps;
  }

  protected Solution combine(Solution[] ss) {
    int[] L = ((MergeSortDS) ss[0]).getArr();
    int[] R = ((MergeSortDS) ss[1]).getArr();
    int newFirst = ((MergeSortDS) ss[0]).getFirst();
    int newLast = ((MergeSortDS) ss[1]).getLast();
    int[] mergedArr = new int[newLast - newFirst + 1]; // to store the sorted list
    int i = 0, j = 0, k = 0;

    /* Merging using pointers */
    while (i < L.length && j < R.length) {
      if (L[i] <= R[j]) {
        mergedArr[k++] = L[i++];
      } else {
        mergedArr[k++] = R[j++];
      }
    }
    /* adding the leftovers in the L array to mergeArr */
    while (i < L.length) {
      mergedArr[k++] = L[i++];
    }

    /* adding the leftovers in the R array to mergeArr */
    while (j < R.length) {
      mergedArr[k++] = R[j++];
    }

    /* Return merged sorted solution */
    return (Solution) new MergeSortDS(mergedArr, newFirst, newLast);
  }
}
