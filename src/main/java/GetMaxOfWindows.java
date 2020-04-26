import java.util.ArrayList;
import java.util.List;

public class GetMaxOfWindows {
    public List<Integer> getMaxOfAllWindows(int[] arr, int windowSize) {
        List<Integer> maxOfWindows = new ArrayList<>();

        if( arr == null || arr.length == 0 || windowSize <= 0)
            return maxOfWindows;

        if(arr.length < windowSize) {
            maxOfWindows.add(findMax(arr, 0, arr.length - 1));
            return maxOfWindows;
        }

        for(int i = 0; i< arr.length - windowSize - 1; i++) {
            maxOfWindows.add(findMax(arr, i, i + windowSize));
        }

        return maxOfWindows;
    }

    private int findMax(int[] arr, int startIndex, int endIndex) {
        int max = arr[startIndex];

        for(int i = startIndex; i<=endIndex; i++) {
            if(max < arr[i])
                max = arr[i];
        }

        return max;
    }
}