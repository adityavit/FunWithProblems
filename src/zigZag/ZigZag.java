package zigZag;

/**
 * Created by adib on 7/22/15.
 */
public class ZigZag {
    int longestZigZag(int[] sequence) {
        if(sequence.length == 1)
            return 1;
        int count;
        if(sequence.length == 2)
            return 2;
        count = 2;
        boolean positive = (sequence[1] - sequence[0] > 0)?true:false;
        for(int i = 2; i < sequence.length ; i++) {
            if(sequence[i] - sequence[i-1] > 0 && !positive) {
                count++;
                positive = true;
            }
            if(sequence[i] - sequence[i-1] < 0 && positive) {
                count++;
                positive = false;
            }
        }
        return count;
    }
}
