/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param seqA: the list of intervals
     * @param seqB: the list of intervals
     * @return: the time periods
     */
    public List<Interval> timeIntersection(List<Interval> seqA, List<Interval> seqB) {
        // Write your code here
        if (seqA == null || seqB == null || seqA.isEmpty() || seqB.isEmpty()) {
            return new ArrayList<Interval>();
        }

        List<Interval> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < seqA.size() && j < seqB.size()) {
            Interval a = seqA.get(i);
            Interval b = seqB.get(j);
            if (a.end <= b.start) {
                i++;
            } else if (b.end <= a.start) {
                j++;
            } else {
                list.add(new Interval(Math.max(a.start, b.start), Math.min(a.end, b.end)));
                if (a.end == b.end) {
                    i++;
                    j++;
                } else if (a.end > b.end) {
                    j++;
                } else {
                    i++;
                }
            }
        }
        return list;
    }
}