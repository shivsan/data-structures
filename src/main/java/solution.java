import java.math.BigInteger;
import java.util.*;

public class solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        List<BigInteger[]> results = new ArrayList<>();

        while (t > 0) {
            int n = scanner.nextInt();
            scanner.nextLine();
            List<BigInteger[]> numbers = new ArrayList<>();

            while (n > 0) {
                final String s = scanner.nextLine();
                BigInteger[] numbersStr = Arrays.stream(s.split(" ")).map(BigInteger::new).toArray(size -> new BigInteger[size]);
                numbers.add(new BigInteger[]{numbersStr[0], numbersStr[1]});
                n--;
            }

            final Optional<BigInteger[]> result = numbers
                    .stream()
                    .reduce((a, b) -> multiplyComplex(a, b));
            t--;

            results.add(result.get());
        }

        results.stream().forEach(r -> System.out.println(r[0] + " " + r[1]));
    }

    public static BigInteger[] multiplyComplex(BigInteger[] c1, BigInteger[] c2) {
        return new BigInteger[]{c1[0].multiply(c2[0]).subtract(c1[1].multiply(c2[1])),
                                c1[1].multiply(c2[0]).add(c2[1].multiply(c1[0]))};
    }
}
