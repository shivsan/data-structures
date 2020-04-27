public class NumberOfDigits {
    /*
    10 = 2 * 1 + 9
    100 = 3 * 1 + 90 * 2 + 9
    1000 = 4 * 1 + 3 * 900 + 90 * 2 + 9 * 1
    */
    public static int getNumberOfDigits(int n) {
        if (Math.log10(n + 1) % 1 == 0) {
            int numberOfDigits = 0;
            int exp = 0;

            while (n > Math.pow(10, exp)) {
                numberOfDigits += Math.pow(10, exp) * 9 * (exp + 1);
                exp++;
            }

            return numberOfDigits;
        } else {
            int powerOfTenLesserThanN = (int) Math.log10(n);
            return (int) ((n - Math.pow(10, powerOfTenLesserThanN) + 1) * (powerOfTenLesserThanN + 1) + getNumberOfDigits((int) (Math.pow(10, powerOfTenLesserThanN) - 1)));
        }
    }
}
