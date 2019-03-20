
public class Solution {
    /**
     * @param seqA: The seqA
     * @param seqB: The seqB
     * @return: The answer
     */
    public List<Interval> timeIntersection(List<Interval> seqA, List<Interval> seqB) {
        // Write your code here
        int [] visit = new int[1000001];
        for(int i = 0; i < 1000001; i++) {
            visit[i] = 0;
        }
        for(int i = 0; i < seqA.size(); i++) {
            for(int j = seqA.get(i).start; j <= seqA.get(i).end; j++) {
                visit[j] ++;
            }
        }
        for(int i = 0; i < seqB.size(); i++) {
            for(int j = seqB.get(i).start; j <= seqB.get(i).end; j++) {
                visit[j] ++;
            }
        }
        List<Interval> ans = new ArrayList<>();
        for(int i = 0; i < 1000001; i++) {
            if(visit[i] >= 2) {
                int x = i;
                int y = i;
                while(y + 1 < 1000001 && visit[y + 1] >= 2) {
                    y++;
                }
                ans.add(new Interval(x, y));
                i = y + 1;
            }
        }
        return ans;
    }
}