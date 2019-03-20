//这题属于背包问题中有依赖的背包，每个礼盒是主件， 每个礼盒所对应的商品就是他的附件，有依赖的背包的解法是把每一组主件和附件的集合中附件跑一遍01背包即可, 这样就把问题转化为了分组背包
public class Solution {
    /**
     * @param n: The number of gift box
     * @param m: The number of goods
     * @param k: The money you have
     * @param val: The value of each item
     * @param cost: The cost of each item
     * @param belong: The item you need to buy before
     * @return: Return the max value.
     */
    public int getAns(int n, int m, int k, int[] val, int[] cost, int[] belong) {
        // Write your code here
        List<ArrayList<Integer>> link = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            link.add(new ArrayList<Integer>());
        }
        for (int i = n; i < belong.length; i++) {
            link.get(belong[i]).add(i);
        }
        int[] dp = new int[k + 1];
        int[] tmp = new int[k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                tmp[j] = dp[j];
            }
            for (int j = 0; j < link.get(i).size(); j++) {
                int idx = link.get(i).get(j);
                for (int t = k; t >= cost[idx]; t--) {
                    tmp[t] = Math.max(tmp[t], tmp[t - cost[idx]] + val[idx]);
                }
            }
            for (int j = cost[i]; j <= k; j++) {
                dp[j] = Math.max(dp[j], tmp[j - cost[i]] + val[i]);
            }
        }
        int ans = 0;
        for (int i = 0; i <= k; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}