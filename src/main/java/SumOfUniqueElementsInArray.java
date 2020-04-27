import java.util.stream.IntStream;

public class SumOfUniqueElementsInArray {

    public static int sum(int[] arr) {
//        HashSet<Integer> hs = new HashSet<>();
//
//        Arrays.stream(arr).forEach(n -> hs.add(n));
//
//        return hs.stream().reduce((a, b) -> a + b).orElse(0);

        return IntStream.of(arr).distinct().sum();
    }
}
