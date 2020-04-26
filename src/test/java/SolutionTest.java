import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigInteger;

@RunWith(JUnit4.class)
public class SolutionTest {

    @Test
    public void should() {
        final BigInteger[] bigIntegers = solution.multiplyComplex(new BigInteger[]{new BigInteger("10"), new BigInteger("10")},
                new BigInteger[]{new BigInteger("10"), new BigInteger("10")});

        System.out.println(bigIntegers[0].toString() + bigIntegers[1].toString());
    }
}