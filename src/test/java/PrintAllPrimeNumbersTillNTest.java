import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class PrintAllPrimeNumbersTillNTest {

    @Test
    public void getAllPrimeNumbersTillN() {
        final List<Integer> primeNumbersTill100 = PrintAllPrimeNumbersTillN.sieveOfEratosthenes(100);
        assertThat(primeNumbersTill100, is(Arrays.stream(new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97}).boxed().collect(Collectors.toList())));
    }

    @Test
    public void isPrime() {
        assertTrue(PrintAllPrimeNumbersTillN.isPrime(5, Stream.of(2,3).collect(Collectors.toList())));
        assertTrue(PrintAllPrimeNumbersTillN.isPrime(2, new LinkedList<>()));
        assertFalse(PrintAllPrimeNumbersTillN.isPrime(6, Stream.of(2,3).collect(Collectors.toList())));
    }
}