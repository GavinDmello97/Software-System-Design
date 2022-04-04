public class MergeSort extends DivConqTemplate {

  protected boolean isSimple(Problem p) {
    return (((MergeSortDS) p).getFirst() >= ((MergeSortDS) p).getLast());
  }

  protected Solution simplySolve(Problem p) {
    return (Solution) p;
  }

  protected Problem[] decompose(Problem p) {
    int first = ((MergeSortDS) p).getFirst();
    int last = ((MergeSortDS) p).getLast();
    int[] a = ((MergeSortDS) p).getArr();

    Problem[] ps = new MergeSortDS[2];
    int mid = (int) ((last - first) / 2);
    int n1 = mid + 1;
    int n2 = last - first - mid;
    int L[] = new int[n1];
    int R[] = new int[n2];

    for (int i = 0; i < n1; i++) {
      L[i] = a[i];
    }
    for (int j = 0; j < n2; j++) {
      R[j] = a[mid + 1 + j];
    }

    ps[0] = new MergeSortDS(L, first, mid + first);
    ps[1] = new MergeSortDS(R, mid + 1 + first, last);
    return ps;
  }

  protected Solution combine(Solution[] ss) {
    int[] L = ((MergeSortDS) ss[0]).getArr();
    int[] R = ((MergeSortDS) ss[1]).getArr();
    int newFirst = ((MergeSortDS) ss[0]).getFirst();
    int newLast = ((MergeSortDS) ss[1]).getLast();
    int[] mergedArr = new int[newLast - newFirst + 1];
    int i = 0, j = 0, k = 0;

    while (i < L.length && j < R.length) {
      if (L[i] <= R[j]) {
        mergedArr[k++] = L[i++];
      } else {
        mergedArr[k++] = R[j++];
      }
    }

    while (i < L.length) {
      mergedArr[k++] = L[i++];
    }

    while (j < R.length) {
      mergedArr[k++] = R[j++];
    }

    return (Solution) new MergeSortDS(mergedArr, newFirst, newLast);
  }
}
