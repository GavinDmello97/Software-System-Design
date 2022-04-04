/* Abstract interface for the Divide and Conquer algorithm */
public abstract class DivConqTemplate {

  /* Recursive function to divide the problem into smaller problems and combine the sub problems at one */
  public final Solution solve(Problem p) {
    Problem[] pp; // Variable to hold the subproblems (if any)
    if (isSimple(p)) { // check if there is only one element in the list
      return simplySolve(p); // return the solution for list with one element
    } else {
      pp = decompose(p); // decomposes the Problem into 2 subproblems
    }
    Solution[] sol = new Solution[pp.length]; // used to store the solutions for each subbroblem
    for (int i = 0; i < pp.length; i++) {
      sol[i] = solve(pp[i]);
    }
    return combine(sol); // sorting and merging the 2 subproblems at each level of recurrsion
  }

  protected abstract boolean isSimple(Problem p);

  protected abstract Solution simplySolve(Problem p);

  protected abstract Problem[] decompose(Problem p);

  protected abstract Solution combine(Solution[] sol);
}
