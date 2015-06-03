https://leetcode.com/problems/merge-intervals/

Given a collection of intervals, merge all overlapping intervals.

For example,

Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].

Complexity of the algorithm is O(nlogn) + O(n) = O(nlogn)

This looks like not difficult problem if solved in O(nlogn) solution.

Can be thought of the calendar application. Where there are many reservation of the day some merging in the person calendar
and then idea would be to merge them into one so that a new entry can be added to the solution.

Checking the internet looks like that is the best solution.

Idea is simple if the nextInterval is between currentInterval.start and currentInterval.end then forget about the nextInterval
as in it can be ignored. Else in the case when nextInterval start is inside  the currentInterval but the end is outside then replace
the currentInterval.end to the nextInterval.end.

If the nextInterval is completely outside the currentInterval then just add currentInterval and make nextInterval as currentInterval.

The core of the program is to sort the intervals based on the start index. In java use Comparator class.

Collections.sort() has a signature like.
```Java
Collections.sort(List<T> list, Comparator<? super T> c)
```

Comparator is an Interface with only one function

```Java
int compare(T o1, T o2)
```
Returns a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.

```Java
 Collections.sort(intervals, new Comparator<Interval>(){
    public int compare(Interval int1, Interval int2) {
        return int1.start - int2.start;
    }
});
```