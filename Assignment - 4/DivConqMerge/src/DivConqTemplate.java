public abstract class DivConqTemplate {

  public final Solution solve(Problem p) {
    Problem[] pp;
    if (isSimple(p)) {
      return simplySolve(p);
    } else {
      pp = decompose(p);
    }
    Solution[] sol = new Solution[pp.length];
    for (int i = 0; i < pp.length; i++) {
      sol[i] = solve(pp[i]);
    }
    return combine(sol);
  }

  protected abstract boolean isSimple(Problem p);

  protected abstract Solution simplySolve(Problem p);

  protected abstract Problem[] decompose(Problem p);

  protected abstract Solution combine(Solution[] ss);
}
