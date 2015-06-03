package mergeIntervals;


import java.util.*;

/**
 * Created by adib on 6/2/15.
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        //Sort on the start of the interval.
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval int1, Interval int2) {
                return int1.start - int2.start;
            }
        });
        List<Interval> resultList = new ArrayList();
        int i = 1; //Start from the next sorted interval.
        if(intervals.size() > 0) {
            Interval currentInterval = intervals.get(0);
            while(currentInterval != null && i<=intervals.size()) {
                Interval nextInterval;
                if(i < intervals.size()){
                    nextInterval = intervals.get(i);
                    if(nextInterval.start >= currentInterval.start && nextInterval.start <= currentInterval.end) {
                        //nextInterval.start is inside the currentInterval start and end
                        if(nextInterval.end >= currentInterval.start && nextInterval.end <= currentInterval.end) {
                            //nextInterval.end is also inside the currentInterval start and end
                            //forget nextInterval as it is inside the currentInterval.currentInterval remains same.
                            i++;
                        } else {
                            //nextInterval.end is outside the currentInterval start and end
                            //make the currentInterval end as the nextInterval end. Forget about the currentInterval.end and nextInterval start
                            currentInterval.end = nextInterval.end;
                            i++;
                        }
                    } else {
                        //nextInterval.start is outside the currentInterval start and end
                        //Add the currentInterval to the resultList
                        //Make nextInterval as the currentInterval.
                        resultList.add(currentInterval);
                        currentInterval = nextInterval;
                        i++;
                    }
                } else {
                    //Last interval add it to the resultList.
                    resultList.add(currentInterval);
                    i++;
                }
            }
        }
        return resultList;
    }
}
