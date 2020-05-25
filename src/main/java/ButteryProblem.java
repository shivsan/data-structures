public class ButteryProblem {

    private int counter = 0;

    public int getNoOfWays(String str, int n, int k, int x) {
        if (str.length() == n)
            return 1;

        counter++;

        int noOfWays = 0;

        for (int i = 1; i <= k; i++) {
            if (str.length() == 0 || (str.charAt(str.length() - 1) - 48) != i || i == x)
                noOfWays += getNoOfWays(str + i, n, k, x);
        }

        return noOfWays;
    }

    public int getNoOfWaysDP(int n, int k) {
        int subrendum = k - 1;
        int noOfWaysForNMinus1 = k;
        int noOfWaysForN = k;

        for (int i = 2; i <= n; i++) {
            noOfWaysForN = noOfWaysForNMinus1 * k - subrendum;
            subrendum = noOfWaysForNMinus1 * (k - 1) - subrendum;
            noOfWaysForNMinus1 = noOfWaysForN;
        }

        return noOfWaysForN;
    }
}
