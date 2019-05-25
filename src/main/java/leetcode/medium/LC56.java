package leetcode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by 44399 on 2019/1/30
 *
 * @author 44399
 */
public class LC56 {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(0, 2));
        intervals.add(new Interval(3, 5));
        List<Interval> merged = new LC56().merge(intervals);
        System.out.println(1);
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return new ArrayList<>();
        }
        intervals.sort(Comparator.comparingInt(i -> i.start));
        for (int i = 0; i < intervals.size() - 1; i++) {
            if (intervals.get(i).end >= intervals.get(i + 1).start) {
                intervals.get(i).end = intervals.get(i).end > intervals.get(i + 1).end ? intervals.get(i).end : intervals.get(i + 1).end;
                intervals.remove(i + 1);
                i--;
            }
        }
        return intervals;
    }
}

class Interval {
    int start;
    int end;

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}