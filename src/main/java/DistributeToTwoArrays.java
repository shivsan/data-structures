import java.util.ArrayList;
import java.util.List;
public class DistributeToTwoArrays {
    public static void sort(List<Integer> arr) {
        List<Integer> a;
        List<Integer> b = new ArrayList<>();

        a = arr;

        while (true) {
            List<Integer> biggerArray = a, smallerArray = b;

            if (sumOfList(b) > sumOfList(a)) {
                biggerArray = b;
                smallerArray = a;
            }

            Integer biggestNumberInBiggerArrayLesserThanDifference = getBiggestNUmberInBiggerArrayLesserThanDifferenceWithMinimalDifference(biggerArray, smallerArray);
            if (biggestNumberInBiggerArrayLesserThanDifference == 0)
                break;

            biggerArray.remove(biggestNumberInBiggerArrayLesserThanDifference);
            smallerArray.add(biggestNumberInBiggerArrayLesserThanDifference);
        }

        System.out.println(String.format("a is %s", a));
        System.out.println(String.format("a is %s", b));
    }

    private static int sumOfList(List<Integer> arr) {
        return arr.stream().reduce((sum, a) -> sum + a).orElse(0);
    }

    private static Integer getBiggestNUmberInBiggerArrayLesserThanDifferenceWithMinimalDifference(List<Integer> biggerArray, List<Integer> smallerArray) {
        int diff = sumOfList(biggerArray) - sumOfList(smallerArray);

        Integer optimalInteger = 0;
        int minimalDiff = diff;

        for (int i = 0; i < biggerArray.size(); i++) {
            if (biggerArray.get(i) < diff) {
                if (minimalDiff > Math.abs(sumOfList(biggerArray) - sumOfList(smallerArray) - 2 * biggerArray.get(i))) {
                    minimalDiff = Math.abs(sumOfList(biggerArray) - sumOfList(smallerArray) - 2 * biggerArray.get(i));
                    optimalInteger = biggerArray.get(i);
                }
            }
        }

        return optimalInteger;
    }
}
