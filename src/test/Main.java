import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author tony.chenjy
 * @date 2019-03-08
 */
public class Main {
    /**
     * @param seqA: the list of intervals
     * @param seqB: the list of intervals
     * @return: the time periods
     */
    public List<Interval> timeIntersection(List<Interval> seqA, List<Interval> seqB) {
        // Write your code here

        List<Interval> list = new ArrayList<>(seqA.size() + seqB.size());
        int indexA = 0, indexB = 0;
        while (indexA < seqA.size() && indexB < seqB.size()) {
            if (seqA.get(indexA).start < seqB.get(indexB).start) {
                list.add(seqA.get(indexA++));
            } else {
                list.add(seqB.get(indexB++));
            }
        }
        while (indexA < seqA.size()) {
            list.add(seqA.get(indexA++));
        }
        while (indexB < seqB.size()) {
            list.add(seqB.get(indexB++));
        }

        List<Interval> mergeList = new ArrayList<>();
        for (Interval item : list) {

        }

        return null;
    }

    // Definition of Interval:
    public class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
