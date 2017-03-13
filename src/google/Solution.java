package google;

/**
 * Created by adib on 10/18/16.
 */
public class Solution {
//    When drawing a timeseries graph, you sometimes want to "smooth out" the line. Instead of plotting the Y-value of each data point, you want to plot the average of the last N Y-values. Your task is to design a class to handle the computation of a moving average. The number N of values to average is called the "window".
//
//
//    Example:  N = 3
//            1 ,2 ,3 ,4 ,5 ,6, 7, 8, 9 ,10

    public interface Smoothing {
        public void windowSize(int n);
        public double runningAverage(double n);
    }

    public class SmoothingImpl implements Smoothing {
        //private Deque<Double> queue;
        private Double[] store;
        private int runningPtr;
        private double runningSum = 0;
        private int windowSizeLimit = 0;

        public void windowSize(int windowSizeLimit) {
            this.windowSizeLimit = windowSizeLimit;
            store = new Double[windowSizeLimit];
            runningPtr = 0;
        }

        // 1 [] -> [1] runningSum = 1 return = 1
// 2 [1] -> [1, 2] runningSum = 3 return = 3/2
// 3 [1,2] -> [1, 2, 3] runningSum = 6 return 6/3 = 2
// 4 [1, 2, 3] -> [2, 3, 4]  runningSum = 9 return 9/3 = 3
        public double runningAverage(double n) {
            if (runningPtr == windowSizeLimit - 1) {
                //Remove the first element in the queue.
                runningPtr = 0;
            }
            if (store[runningPtr] != null ) {
                runningSum -= store[runningPtr];
            }
            store[runningPtr] = n;
            runningPtr++;
            runningSum += n;
            return runningSum/queue.size();
        }
    }

}
