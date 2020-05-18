import java.util.List;

public class ThrottlingGateway {
    public int droppedRequests(List<Integer> requestTimes) {
        final int[] integerRequestTimes = requestTimes.stream().mapToInt(i -> i).toArray();
        Window oneSecondWindow = new Window(3, 1, 0, integerRequestTimes);
        Window tenSecondWindow = new Window(20, 10, 0, integerRequestTimes);
        Window sixtySecondWindow = new Window(60, 60, 0, integerRequestTimes);
        int droppedCount = 0;

        for (int i = 0; i < requestTimes.size(); i++) {
            boolean shouldDropRequest = false;
            oneSecondWindow.moveAndServe();
            tenSecondWindow.moveAndServe();
            sixtySecondWindow.moveAndServe();

            if (!oneSecondWindow.hadServedCurrentRequest() || !tenSecondWindow.hadServedCurrentRequest() || !sixtySecondWindow.hadServedCurrentRequest()) {
                shouldDropRequest = true;
            }

            if (shouldDropRequest)
                droppedCount++;
        }

        return droppedCount;
    }

    class Window {
        int startValue;
        int currValue;
        int maxRequests;
        int size;
        int startIndex;
        int currIndex;
        int noOfRequests;
        int[] requests;

        public Window(int maxRequests, int size, int startIndex, int[] requests) {
            this.requests = requests;
            this.maxRequests = maxRequests;
            this.size = size;
            this.currIndex = -1;
            this.startIndex = startIndex;
            this.startValue = this.currValue = requests[startIndex];
            noOfRequests = 0;
        }

        public boolean hadServedCurrentRequest() {
            return (noOfRequests) <= maxRequests;
        }

        public boolean shouldServeCurrentRequest() {
            return currIndex < requests.length;
        }

        public boolean moveAndServe() {
            if (shouldServeCurrentRequest()) {
                currIndex++;
                noOfRequests++;

                if (size == 1) {
                    while (requests[currIndex] > requests[startIndex]) {
                        startIndex++;
                        noOfRequests--;
                    }
                } else
                    while (requests[currIndex] >= requests[startIndex] && requests[currIndex] - requests[startIndex] > size - 1) {
                        startIndex++;
                        noOfRequests--;
                    }
            }

            return hadServedCurrentRequest();
        }
    }
}
