package mergeIntervals;

/**
 * Created by adib on 6/2/15.
 */
public class Interval {
    int start;
    int end;

    Interval() { start = 0; end = 0; }

    Interval(int s, int e) { start = s; end = e; }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Interval interval = (Interval) o;

        if (end != interval.end) return false;
        if (start != interval.start) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = start;
        result = 31 * result + end;
        return result;
    }
}
