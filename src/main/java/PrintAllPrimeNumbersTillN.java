import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PrintAllPrimeNumbersTillN {
    public static List<Integer> sieveOfEratosthenes(int n) {
        final List<Integer> primeNumbersTillN = new ArrayList<>();

        IntStream.range(2, n)
                .filter(i -> isPrime(i, primeNumbersTillN))
                .forEach(p -> primeNumbersTillN.add(p));

        return primeNumbersTillN;
    }

    static boolean isPrime(int n, List<Integer> primeNumbers) {
        return !primeNumbers.stream().anyMatch(p -> n % p == 0);
    }
}
