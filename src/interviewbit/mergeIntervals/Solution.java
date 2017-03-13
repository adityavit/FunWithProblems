package interviewbit.mergeIntervals;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/merge-intervals/
 * Created by adib on 8/21/16.
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> listInterval =  new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            listInterval.add(newInterval);
            return listInterval;
        }
        Interval mergedInterval = new Interval();
        int i;
        boolean startSet = false;
        //find the start of the interval
        for ( i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (newInterval.start <= interval.end) {
                //new interval starts before this interval.
                if (newInterval.start < interval.start) {
                    //Either it can be less than the start.
                    mergedInterval.start = newInterval.start;
                } else {
                    mergedInterval.start = interval.start;
                }
                startSet = true;
                break;
            }  else {
                listInterval.add(interval);
            }
        }
        if (!startSet) {
            //If the new Interval is out of the bounds of the intervals on the end.
            listInterval.add(newInterval);
            return listInterval;
        }
        //Find the end of the interval
        for ( int j = i ; j < intervals.size(); j++) {
            Interval interval = intervals.get(j);
            if (newInterval.end <= interval.end) {
                if (newInterval.end < interval.start) {
                    // ends before start of this interval
                    if (mergedInterval.end == 0) {
                        //dont add it again.
                        mergedInterval.end = newInterval.end;
                        listInterval.add(mergedInterval);
                    }
                    listInterval.add(interval);
                } else {
                    mergedInterval.end = interval.end;
                    listInterval.add(mergedInterval);
                }
            }
            // If it greater move to the next interval to look for the rest of the intervals.
        }
        // If the new interval takes the whole list.
        if (mergedInterval.end == 0) {
            mergedInterval.end = newInterval.end;
            listInterval.add(mergedInterval);
        }
        return listInterval;
    }
}
